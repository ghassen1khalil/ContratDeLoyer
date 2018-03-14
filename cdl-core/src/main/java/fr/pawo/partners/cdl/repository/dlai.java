package fr.pawo.partners.cdl.repository;

import fr.pawo.partners.cdl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class dlai {

    @Autowired
    private UserRepository  userRepository;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUser() {
        return userRepository.findAll();
    }
}

