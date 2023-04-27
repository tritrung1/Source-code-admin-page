package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {
    private Long id;
    private String accountImg;
    private String bannerImg;
    private UUID accountId;
    private Long merchantId;
    private String accountName;
    private String accountEmail;
    private Long roleId;
    private String phone;
    private String address;
    private Boolean active;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
