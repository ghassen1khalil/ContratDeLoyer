package fr.pawo.partners.cdl.controller;

import fr.pawo.partners.cdl.domain.AppUser;
import fr.pawo.partners.cdl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<AppUser> userList (){
        return this.userRepository.findAll();
    }

}
