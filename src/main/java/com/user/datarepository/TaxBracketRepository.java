package com.user.datarepository;

import com.user.datamodels.TaxBracket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxBracketRepository extends JpaRepository<TaxBracket,Integer> {

    @Query(value = "select * from tax_bracket tb where tb.filler_status=?",nativeQuery = true)
    List<TaxBracket> findByFillerStatus(String status);
}
