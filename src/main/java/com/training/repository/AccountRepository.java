package com.training.repository;

import com.training.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>, CrudRepository<Account, Long> {
//    @Modifying
//    @Query(value = "SELECT e FROM Account e WHERE e.accountName = :accountName",nativeQuery = true)
//    public Account findUserAccount(String accountName);
//
//    @Modifying
//    @Query(value = "SELECT r.role_name FROM role r inner join account a WHERE r.role_ids  = a.role_id  AND a.account_name = :accountName ",nativeQuery = true)
//    public String getRoleNames(String accountName);

    }
