package com.training.dto;

import com.training.entity.Account;
import com.training.entity.dateaudit.DateAudit;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends DateAudit {
    private Long id;

    @NotEmpty(message = "Field can't be empty!")
    private String roleUuid;

    @NotEmpty(message = "Field can't be empty!")
    @Size(min = 3, message = "Field should have at least 3 characters")
    private String roleName;

    private List<Account> accounts;
}
