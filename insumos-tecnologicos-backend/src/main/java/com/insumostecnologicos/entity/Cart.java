package com.insumostecnologicos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Cart.
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "CARRITO")
public class Cart implements Serializable {
    @Id
    @NotNull
    @Column(name = "CARRITO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "cart")
    @Column(name = "PRODUCTOS")
    private Set<ProductInOrder> products = new HashSet<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", products=" + products +
                '}';
    }

    /**
     * Instantiates a new Cart.
     *
     * @param user the user
     */
    public Cart(User user) {
        this.user = user;
    }

}
