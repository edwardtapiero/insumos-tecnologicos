package com.insumostecnologicos.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * The type Product info.
 */
@Entity
@Data
@DynamicUpdate
@Table(name = "PRODUCTO_INFO")
public class ProductInfo implements Serializable {
    @Id
    @Column(name = "PRODUCTO_ID")
    private String productId;

    @NotNull
    @Column(name = "PRODUCTO_NOMBRE")
    private String productName;

    @NotNull
    @Column(name = "PRODUCTO_PRECIO")
    private BigInteger productPrice;

    @NotNull
    @Min(0)
    @Column(name = "PRODUCTO_STOCK")
    private Integer productStock;

    @Column(name = "PRODUCTO_DESCRIPCION")
    private String productDescription;

    @Column(name = "PRODUCTO_IMAGEN")
    private String productIcon;

    @ColumnDefault("0")
    @Column(name = "PRODUCTO_ESTADO")
    private Integer productStatus;

    @ColumnDefault("0")
    @Column(name = "CATEGORIA_PRODUCTO")
    private Integer categoryType;

    @CreationTimestamp
    @Column(name = "FECHA_CREACION")
    private Date createTime;
    @UpdateTimestamp
    @Column(name = "ULTIMA_ACTUALIZACION")
    private Date updateTime;

    /**
     * Instantiates a new Product info.
     */
    public ProductInfo() {
    }
}
