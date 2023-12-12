package tn.esprit.bibliotech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bibliotech.entities.client;
import tn.esprit.bibliotech.repositories.UserReposotory;

@Service
public class UserService {

    @Autowired
    private UserReposotory userReposotory;

    public client login(String username, String password) {
        client user = userReposotory.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public client getUser(long idUser) {
        return userReposotory.findById(idUser).get();
    }
}
