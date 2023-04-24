package com.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Import")
public class Import implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "import_quantity")
    private Integer importQuantity;

    @Column(name = "import_date")
    private Date importDate;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;
}
