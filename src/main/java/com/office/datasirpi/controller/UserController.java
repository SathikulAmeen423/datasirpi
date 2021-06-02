package com.office.datasirpi.controller;

import com.office.datasirpi.data.builder.UserBuilder;
import com.office.datasirpi.data.entity.User;
import com.office.datasirpi.data.request.UserRequest;
import com.office.datasirpi.data.response.UserResponse;
import com.office.datasirpi.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserBuilder userBuilder;

    @GetMapping("")
    public List<UserResponse> list() {
        return userBuilder.userResponses(userService.listAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(userBuilder.getUser(userService.getUser(id)), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody UserRequest userRequest) {
        userService.saveUser(userBuilder.addUser(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserRequest userRequest, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            userService.saveUser(userBuilder.updateUser(existUser, userRequest));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
