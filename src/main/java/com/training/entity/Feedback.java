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
@Table(name = "feedbacks")
public class Feedback extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "feedback_uuid")
    private String feedbackUuid;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "opinion")
    private String opinion;

    @Column(name = "images")
    private String images;

    @Column(name = "active", columnDefinition = "tinyint(1) default 1")
    private Boolean active;

    @Column(name = "reply")
    private String reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

}
