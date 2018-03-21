package fr.pawo.partners.cdl.rest.controller;

import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppUser;
import fr.pawo.partners.cdl.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
public class UserController {

    @Autowired
    private AccountService userRepository;

    @GetMapping("/user")
    public List<AppUser> userList() {
        return userRepository.getAllUser();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody  AppUser user) {
         userRepository.saveUser(user);
    }

}
