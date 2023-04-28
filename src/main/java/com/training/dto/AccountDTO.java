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
//=======
//public class AccountDTO {
//    private Long id;
//    private UUID account_id;
//    private Long merchant_id;
//    private UUID role_id;
//    private String name;
//    private String email;
//    private String phone;
//    private String address;
//    private String account_img;
//    private String banner_img;
//    private Boolean active;
//    private String created_date;
//    private String created_by;
//    private String modified_date;
//    private String modified_by;
//>>>>>>> Stashed changes
}
