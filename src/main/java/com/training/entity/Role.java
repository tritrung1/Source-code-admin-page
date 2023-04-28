package com.training.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Role")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "role_id")
    @GeneratedValue
    private UUID roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;
//=======
//    @Column(name = "role_id")
//    private UUID role_id;
//    @Column(name = "role_name")
//    private String role_name;
//    @Column(name = "created_date")
//    private String created_date;
//    @Column(name = "created_by")
//    private String created_by;
//    @Column(name = "modified_date")
//    private String modified_date;
//    @Column(name = "modified_by")
//    private String modified_by;
//>>>>>>> Stashed changes
}
