package com.insumostecnologicos.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Product category.
 */
@Entity
@Data
@DynamicUpdate
@Table(name = "CATEGORIA_PRODUCTO")
public class ProductCategory implements Serializable {
    @Id
    @Column(name = "CATEGORIA_ID")
    @GeneratedValue
    private Integer categoryId;

    @Column(name = "CATEGORIA_NOMBRE")
    private String categoryName;

    @NaturalId
    @Column(name = "CATEGORIA_TIPO")
    private Integer categoryType;

    @Column(name = "FECHA_CREACION")
    private Date createTime;

    @Column(name = "ULTIMA_ACTUALIZACION")
    private Date updateTime;

    /**
     * Instantiates a new Product category.
     */
    public ProductCategory() {
    }

    /**
     * Instantiates a new Product category.
     *
     * @param categoryName the category name
     * @param categoryType the category type
     */
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
