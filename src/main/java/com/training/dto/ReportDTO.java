package com.training.dto;
import com.training.entity.Account;
import com.training.entity.Order;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String reportUuid;

    @NotEmpty(message = "Field can't be empty!")
    private String reportType;

    private Order order;

    private Account account;
}
