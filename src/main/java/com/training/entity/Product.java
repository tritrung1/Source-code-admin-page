package com.training.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "product_uuid")
    private String productUuid;

    @NotEmpty
    @Column(name = "product_image")
    private String productImage;

    @NotEmpty
    @Column(name = "product_name")
    private String productName;

    @NotEmpty
    @Column(name = "product_code")
    private String productCode;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotEmpty
    @Column(name = "price")
    private Double price;

    @NotEmpty
    @Column(name = "brand")
    private String brand;

    @NotEmpty
    @Column(name = "color")
    private String color;

    @NotEmpty
    @Column(name = "size")
    private String size;

    @NotNull
    @Column(name = "importQuantity")
    private Integer importQuantity;

    //many to one with table category
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    //one to one with table post
    @NotEmpty
    @OneToOne(mappedBy = "product")
    private Post post;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @NotEmpty
    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    @NotEmpty
    @OneToMany(mappedBy = "product")
    private List<News> news;
}
