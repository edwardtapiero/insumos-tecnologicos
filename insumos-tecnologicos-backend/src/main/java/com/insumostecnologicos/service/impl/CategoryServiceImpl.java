package com.insumostecnologicos.service.impl;


import com.insumostecnologicos.entity.ProductCategory;
import com.insumostecnologicos.enums.ResultEnum;
import com.insumostecnologicos.exception.MyException;
import com.insumostecnologicos.repository.ProductCategoryRepository;
import com.insumostecnologicos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Category service.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    /**
     * The Product category repository.
     */
    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> res = productCategoryRepository.findAllByOrderByCategoryType();
        return res;
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        ProductCategory res = productCategoryRepository.findByCategoryType(categoryType);
        if (res == null) throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
        return res;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> res = productCategoryRepository.findByCategoryTypeInOrderByCategoryTypeAsc(categoryTypeList);
        return res;
    }

    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }


}
