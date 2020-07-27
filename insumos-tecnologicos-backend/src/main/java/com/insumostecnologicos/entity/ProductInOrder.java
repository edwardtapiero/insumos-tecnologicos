package com.insumostecnologicos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The type Product in order.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "PRODUCTO_EN_PEDIDO")
public class ProductInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PEDIDO_ID")
    @JsonIgnore
    private OrderMain orderMain;

    @Column(name = "PRODUCTO_ID")
    @NotEmpty
    private String productId;

    @NotEmpty
    @Column(name = "PRODUCTO_NOMBRE")
    private String productName;

    @NotNull
    @Column(name = "PRODUCTO_DESCRIPCION")
    private String productDescription;

    @Column(name = "PRODUCTO_IMAGEN")
    private String productIcon;

    @NotNull
    @Column(name = "CATEGORIA")
    private Integer categoryType;

    @NotNull
    @Column(name = "PRODUCTO_PRECIO")
    private BigInteger productPrice;

    @Min(0)
    @Column(name = "PRODUCTO_STOCK")
    private Integer productStock;

    @Min(1)
    @Column(name = "CANTIDAD")
    private Integer count;


    /**
     * Instantiates a new Product in order.
     *
     * @param productInfo the product info
     * @param quantity    the quantity
     */
    public ProductInOrder(ProductInfo productInfo, Integer quantity) {
        this.productId = productInfo.getProductId();
        this.productName = productInfo.getProductName();
        this.productDescription = productInfo.getProductDescription();
        this.productIcon = productInfo.getProductIcon();
        this.categoryType = productInfo.getCategoryType();
        this.productPrice = productInfo.getProductPrice();
        this.productStock = productInfo.getProductStock();
        this.count = quantity;
    }

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", categoryType=" + categoryType +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductInOrder that = (ProductInOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productDescription, that.productDescription) &&
                Objects.equals(productIcon, that.productIcon) &&
                Objects.equals(categoryType, that.categoryType) &&
                Objects.equals(productPrice, that.productPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, productId, productName, productDescription, productIcon, categoryType, productPrice);
    }
}
