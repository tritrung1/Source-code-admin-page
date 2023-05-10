package com.training.entity;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_uuid")
    private String orderUuid;

    @Column(name = "order_code")
    private String orderCode;

    @OneToMany(mappedBy = "order")
    private List<Item> items;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "delivery_detail_id")
    private Long deliveryDetailId;

    @JoinColumn(name = "delivery_detail_id")
    private DeliveryDetail deliveryDetail;

    @Column(name = "order_status_id")
    private Long orderStatusId;

    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<Feedback> feedback;

}
