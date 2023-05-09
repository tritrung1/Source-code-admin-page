package com.training.repository;

import com.training.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class Login {
    @Autowired
    private EntityManager entityManager;

    public Account findUserAccount(String accountName) {
        try{
            String sql = "SELECT e FROM Account e WHERE e.accountName = :accountName";
            Query query = entityManager.createQuery(sql, Account.class);
            query.setParameter("accountName", accountName);

            return (Account)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<String> getRoleNames(Long id) {
        String sql = "SELECT e.role.roleName FROM Account e WHERE e.id =:id";
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

//    public List<String> getRoleNames(Long id) {
//        String sql = "SELECT e.role.roleName FROM AccountRole e WHERE e.account.id =:id";
//        Query query = this.entityManager.createQuery(sql, String.class);
//        query.setParameter("id", id);
//
//        return query.getResultList();
//    }
}
