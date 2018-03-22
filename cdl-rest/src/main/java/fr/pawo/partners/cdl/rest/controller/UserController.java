package fr.pawo.partners.cdl.rest.controller;

import fr.pawo.partners.cdl.business.service.AccountService;
import fr.pawo.partners.cdl.core.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class UserController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/user")
    public List<AppUser> userList() {
        return accountService.getAllUser();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody  AppUser user) {
        accountService.saveUser(user);
    }

    @PutMapping
    public void updateUser(){

    }
}
