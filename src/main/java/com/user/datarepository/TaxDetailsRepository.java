package com.user.datarepository;

import com.user.datamodels.TaxFormDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxDetailsRepository extends JpaRepository<TaxFormDetails,Integer> {

    @Query(value="select * from tax_details td where td.user_id=?",nativeQuery = true)
    List<TaxFormDetails> findByUserId(int UserId);
}
