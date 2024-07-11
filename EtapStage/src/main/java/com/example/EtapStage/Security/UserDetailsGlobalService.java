package com.example.EtapStage.Security;

import com.example.EtapStage.Entity.User;
import com.example.EtapStage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsGlobalService implements UserDetailsService {
    @Autowired
    UserRepository ur;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=ur.findByEmail(username);
        if (user==null){
            System.out.println("Not fouuuuuuuns");

            throw new UsernameNotFoundException("User Not Found"+username) ;
        } else if (user.getEmail().equals("saif@gmail.com")&& user.getPassword().equals("saif1234")) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getRoles());

        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getRoles());
    }
}
