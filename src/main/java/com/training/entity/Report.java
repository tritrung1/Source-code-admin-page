package com.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")
public class Report implements Serializable {
=======
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Reports")
public class Report {
>>>>>>> Stashed changes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
<<<<<<< Updated upstream

    @Column(name = "report_id")
    @GeneratedValue
    private UUID reportId;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;
=======
    @Column(name = "report_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID report_id;
    @Column(name = "type")
    private String type;
    @Column(name = "order_id")
    private UUID order_id; //add relationship to order_id
    @Column(name = "account_id")
    private UUID account_id;// add relationship to account_id
    @Column(name = "created_date")
    private String created_date;
    @Column(name = "created_by")
    private String created_by;
    @Column(name = "modified_date")
    private String modified_date;
    @Column(name = "modified_by")
    private String modified_by;
>>>>>>> Stashed changes
}
