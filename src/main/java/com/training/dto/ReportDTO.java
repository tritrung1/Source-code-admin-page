package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream

import java.io.Serializable;
import java.sql.Date;
=======
>>>>>>> Stashed changes
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< Updated upstream
public class ReportDTO implements Serializable {
    private Long id;
    private UUID reportId;
    private String reportType;
    private Long orderId;
    private Long accountId;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
=======
public class ReportDTO {
    private Long id;
    private UUID report_id;
    private String type;
    private UUID order_id;
    private UUID account_id;
    private String created_date;
    private String created_by;
    private String modified_date;
    private String modified_by;
>>>>>>> Stashed changes
}
