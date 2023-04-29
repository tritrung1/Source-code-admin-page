package com.training.entity;

import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "feedback")
    private List<Order> orders;

}
