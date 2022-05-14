package com.user.datarepository;

import com.user.datamodels.SignUpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<SignUpModel,Integer> {
    SignUpModel findByEmailAndPassword(String email, String password);

    List<SignUpModel> findByEmail(String email);
}
