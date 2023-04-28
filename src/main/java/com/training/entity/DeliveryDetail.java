package com.training.entity;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "delivery_details")
public class DeliveryDetail extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "delivery_detail_uuid")
    private String deliveryDetailUuid;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "shipping_unit")
    private String shippingUnit;

    @Column(name = "shipper_name")
    private String shipperName;

    @Column(name = "shipper_phone")
    private String shipperPhone;

    @Column(name = "shipper_address")
    private String shipperAddress;

    @OneToMany(mappedBy = "deliveryDetail")
    private List<Order> orders;

}
