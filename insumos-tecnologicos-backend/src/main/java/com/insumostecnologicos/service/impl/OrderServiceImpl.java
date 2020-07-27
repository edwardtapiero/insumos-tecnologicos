package com.insumostecnologicos.service.impl;


import com.insumostecnologicos.entity.OrderMain;
import com.insumostecnologicos.entity.ProductInOrder;
import com.insumostecnologicos.entity.ProductInfo;
import com.insumostecnologicos.enums.OrderStatusEnum;
import com.insumostecnologicos.enums.ResultEnum;
import com.insumostecnologicos.exception.MyException;
import com.insumostecnologicos.repository.OrderRepository;
import com.insumostecnologicos.repository.ProductInOrderRepository;
import com.insumostecnologicos.repository.ProductInfoRepository;
import com.insumostecnologicos.repository.UserRepository;
import com.insumostecnologicos.service.OrderService;
import com.insumostecnologicos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Order service.
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     * The Order repository.
     */
    @Autowired
    OrderRepository orderRepository;
    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;
    /**
     * The Product info repository.
     */
    @Autowired
    ProductInfoRepository productInfoRepository;
    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;
    /**
     * The Product in order repository.
     */
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    public Page<OrderMain> findAll(Pageable pageable) {
        return orderRepository.findAllByOrderByOrderStatusAscCreateTimeDesc(pageable);
    }

    @Override
    public Page<OrderMain> findByStatus(Integer status, Pageable pageable) {
        return orderRepository.findAllByOrderStatusOrderByCreateTimeDesc(status, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerEmail(String email, Pageable pageable) {
        return orderRepository.findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(email, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerPhone(String phone, Pageable pageable) {
        return orderRepository.findAllByBuyerPhoneOrderByOrderStatusAscCreateTimeDesc(phone, pageable);
    }

    @Override
    public OrderMain findOne(Long orderId) {
        OrderMain orderMain = orderRepository.findByOrderId(orderId);
        if (orderMain == null) {
            throw new MyException(ResultEnum.ORDER_NOT_FOUND);
        }
        return orderMain;
    }

    @Override
    @Transactional
    public OrderMain authorized(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if (!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusEnum.AUTHORIZED.getCode());
        orderRepository.save(orderMain);
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    @Transactional
    public OrderMain received(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        orderMain.setOrderStatus(OrderStatusEnum.RECEIVED.getCode());
        orderRepository.save(orderMain);
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    @Transactional
    public OrderMain cancel(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if (!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusEnum.REJECTED.getCode());
        orderRepository.save(orderMain);

        Iterable<ProductInOrder> products = orderMain.getProducts();
        for (ProductInOrder productInOrder : products) {
            ProductInfo productInfo = productInfoRepository.findByProductId(productInOrder.getProductId());
            if (productInfo != null) {
                productService.increaseStock(productInOrder.getProductId(), productInOrder.getCount());
            }
        }
        return orderRepository.findByOrderId(orderId);
    }
}
