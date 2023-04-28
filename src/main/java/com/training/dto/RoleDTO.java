package com.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {
    private Long id;
    private UUID roleId;
    private String roleName;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
//=======
//public class RoleDTO {
//    private Long id;
//    private UUID role_id;
//    private String role_name;
//    private String created_date;
//    private String created_by;
//    private String modified_date;
//    private String modified_by;
//>>>>>>> Stashed changes
}
