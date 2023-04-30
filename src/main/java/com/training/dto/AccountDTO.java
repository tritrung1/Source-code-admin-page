package com.training.dto;
import com.training.entity.*;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

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

    private String accountUuid;

    private String accountImg;

    private String bannerImg;

    private Long merchantId;

    private String accountName;

    private String accountEmail;

    private String phone;

    private String address;

    private Boolean active;

    private Role role;

    private Order order;

    private List<Notification> notifications;

    private List<Product> products;

    private List<Report> reports;

    private List<News> news;
}
