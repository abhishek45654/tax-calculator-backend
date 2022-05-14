package com.user.datarepository;

import com.user.datamodels.ItemisedDeductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemisedDeductionRepository extends JpaRepository<ItemisedDeductions,Integer> {

    @Query(value =" select * from itemised_deductions it where it.user_id = ?",nativeQuery = true)
    List<ItemisedDeductions> findByUserId(int UserId);

    @Query(value = "select * from itemised_deductions it where it.form_id = ?",nativeQuery = true)
    ItemisedDeductions findByFormId(int id);
}
