package com.insumostecnologicos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Order main.
 */
@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
@Table(name = "PEDIDO")
public class OrderMain implements Serializable {
    private static final long serialVersionUID = -3819883511505235030L;

    @Id
    @NotNull
    @Column(name = "PEDIDO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "orderMain")
    @Column(name = "PRODUCTOS")
    private Set<ProductInOrder> products = new HashSet<>();

    @NotEmpty
    @Column(name = "EMAIL_CLIENTE")
    private String buyerEmail;

    @NotEmpty
    @Column(name = "NOMBRE_CLIENTE")
    private String buyerName;

    @NotEmpty
    @Column(name = "CELULAR_CLIENTE")
    private String buyerPhone;

    @NotEmpty
    @Column(name = "DIRECCION_CLIENTE")
    private String buyerAddress;

    @Column(name = "MONTO")
    private BigInteger orderAmount;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "ESTADO_PEDIDO")
    private Integer orderStatus;

    @CreationTimestamp
    @Column(name = "FECHA_CREACION")
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(name = "ULTIMA_ACTUALIZACION")
    private LocalDateTime updateTime;

    /**
     * Instantiates a new Order main.
     *
     * @param buyer the buyer
     */
    public OrderMain(User buyer) {
        this.buyerEmail = buyer.getEmail();
        this.buyerName = buyer.getName();
        this.buyerPhone = buyer.getPhone();
        this.buyerAddress = buyer.getAddress();
        this.orderAmount = buyer.getCart().getProducts().stream().map(item -> item.getProductPrice().multiply(new BigInteger(String.valueOf(item.getCount()))))
                .reduce(BigInteger::add)
                .orElse(new BigInteger(String.valueOf(0)));
        this.orderStatus = 0;

    }
}
