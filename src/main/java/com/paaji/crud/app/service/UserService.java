package com.paaji.crud.app.service;

import com.paaji.crud.app.entity.User;
import com.paaji.crud.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository theUserRepository;

    public List<User> getAllUsers() {
        return theUserRepository.findAll();
    }

    public User addNewUser(User theUserToBeAdded) {
        return theUserRepository.save(theUserToBeAdded);
    }

    public User updateExistingUserById(Integer userId, User userToBeUpdated) {
        User existingUser = theUserRepository.findById(userId).get();
        existingUser.setName(userToBeUpdated.getName());
        existingUser.setNickName(userToBeUpdated.getNickName());
        return theUserRepository.save(existingUser);
    }

    public void deleteUserById(Integer userId) {
        theUserRepository.deleteById(userId);
    }
}
