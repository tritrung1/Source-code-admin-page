package com.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_uuid")
    private String categoryUuid;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(targetEntity = Product.class, mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;
}
