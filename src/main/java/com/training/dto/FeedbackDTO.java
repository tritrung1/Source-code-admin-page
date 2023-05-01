package com.training.dto;

import com.training.entity.Customer;
import com.training.entity.Order;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FeedbackDTO extends DateAudit {

    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String feedbackUuid;

    @NotNull(message = "Field can't be null!")
    private Integer rating;

    @NotNull(message = "Field can't be null!")
    private String opinion;

    @NotNull(message = "Field can't be null!")
    private String images;

    @NotEmpty(message = "Field can't be empty!")
    private Boolean active;

    @NotEmpty(message = "Field can't be empty!")
    private String reply;

    private Customer customer;

    private Order order;

}
