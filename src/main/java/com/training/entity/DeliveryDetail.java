package com.training.entity;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;

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

    @NotEmpty
    @Column(name = "delivery_detail_uuid")
    private String deliveryDetailUuid;

    @NotEmpty
    @Column(name = "delivery_date")
    private Date deliveryDate;

    @NotEmpty
    @Column(name = "shipping_unit")
    private String shippingUnit;

    @NotEmpty
    @Size(min = 5)
    @Column(name = "shipper_name")
    private String shipperName;

    @NotEmpty
    @Size(min = 10)
    @Column(name = "shipper_phone")
    private String shipperPhone;

    @NotEmpty
    @Column(name = "shipper_address")
    private String shipperAddress;

    @NotEmpty
    @OneToMany(mappedBy = "deliveryDetail")
    private List<Order> orders;

}
