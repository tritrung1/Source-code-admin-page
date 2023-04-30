package com.training.dto;

import com.training.entity.Customer;
import com.training.entity.Order;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FeedbackDTO extends DateAudit {

    private Long id;

    private String feedbackUuid;

    private Integer rating;

    private String opinion;

    private String images;

    private Boolean active;

    private String reply;

    private Customer customer;

    private Order order;

}
