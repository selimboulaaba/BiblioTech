package tn.esprit.bibliotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.bibliotech.entities.client;
import tn.esprit.bibliotech.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{username}/{password}")
    public client login(@PathVariable String username, @PathVariable String password) {
        return userService.login(username, password);
    }

    @GetMapping("/user/{idUser}")
    public client get(@PathVariable long idUser) {
        return userService.getUser(idUser);
    }

}
