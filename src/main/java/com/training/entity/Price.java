package com.training.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Price")
public class Price extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "price_uuid")
    private String priceUuid;

    @NotEmpty
    @Column(name = "product_code")
    private String productCode;

    @NotEmpty
    @Column(name = "price")
    private Double price;

    @NotEmpty
    @Column(name = "discount")
    private Integer discount;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
