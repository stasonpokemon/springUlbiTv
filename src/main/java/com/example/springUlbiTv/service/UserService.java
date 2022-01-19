package com.example.springUlbiTv.service;

import com.example.springUlbiTv.entity.UserEntity;
import com.example.springUlbiTv.exception.UserAlreadyExistException;
import com.example.springUlbiTv.exception.UserNotFoundException;
import com.example.springUlbiTv.model.User;
import com.example.springUlbiTv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                throw new UserAlreadyExistException("Пользователь с таким именем существует");
            }
            return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
         if (user == null){
             throw new UserNotFoundException("Пользователь не найден");
         }

         return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
