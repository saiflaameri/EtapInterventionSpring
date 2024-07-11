package com.example.EtapStage.Controller;

import com.example.EtapStage.Entity.User;
import com.example.EtapStage.Security.WebSecurityConfig;
import com.example.EtapStage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    WebSecurityConfig ws;
    @Autowired
    UserService us;

    @GetMapping("/getall")
    public List<User> getall(){
        return us.getall();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        String encodedPassword = us.encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        us.add(user);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        us.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody User user,@PathVariable Long id){
        user.setId(id);
        us.update(user);
    }

}
