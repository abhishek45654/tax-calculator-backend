package com.user.security;

import com.user.datamodels.SignUpModel;
import com.user.datarepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SignUpModel> a = userRepository.findByEmail(username);
        UserDetails user = new MyUserDetails(a.get(0));
        System.out.print(a.get(0));
        return user;
    }

}
