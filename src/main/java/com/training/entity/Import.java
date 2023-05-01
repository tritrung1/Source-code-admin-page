package com.training.entity;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Import")
public class Import extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "import_uuid")
    private String importUuid;

    @NotEmpty
    @Column(name = "product_code")
    private String productCode;

    @NotNull
    @Column(name = "import_quantity")
    private Integer importQuantity;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
