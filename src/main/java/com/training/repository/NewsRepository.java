package com.training.repository;

import com.training.entity.News;
import com.training.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Long>, CrudRepository<News, Long> {
    @Modifying
    @Query(value = "select " +
            "n.id," +
            "n.account_id," +
            "p.import_quantity," +
            "o.sold_quantity," +
            "p.import_quantity - o.sold_quantity as storage_quantity," +
            "o.price," +
            "o.price * p.import_quantity as sales," +
            "n.sold_date" +
            "from news n" +
            "left join orders o on n.order_id = o.id" +
            "left join product p on o.product_id = p.id",nativeQuery = true)
    List<News> findBySoldDatePending();

    @Modifying
    @Query(value = "SELECT * FROM news n inner join account a WHERE n.account_name  = a.account_name AND n.account_name =:accountName ",nativeQuery = true)
    public List<News> findByAccount(String accountName);

}
