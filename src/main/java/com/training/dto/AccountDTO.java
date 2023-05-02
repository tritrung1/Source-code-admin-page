package com.training.dto;
import com.training.entity.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String accountUuid;

    @NotEmpty(message = "Field can't be empty!")
    private String accountImg;

    @NotEmpty(message = "Field can't be empty!")
    private String bannerImg;

    @NotNull(message = "Field can't be null!")
    private Long merchantId;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 5, message = "Field should have at least 5 characters")
    private String accountName;

    @NotEmpty(message = "Field can't be empty!")
    @Email(message = "Field must be a well-formed email address")
    private String accountEmail;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 10, message = "Field should have at least 10 characters")
    private String phone;

    @NotEmpty(message = "Field can't be empty!")
    private String address;

    @NotEmpty(message = "Field can't be empty!")
    private Boolean active;

    private Role role;

    private Order order;

    private List<Notification> notifications;

    private List<Product> products;

    private List<Report> reports;

}
