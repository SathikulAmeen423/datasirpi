package com.office.datasirpi.data.builder;

import com.office.datasirpi.data.entity.User;
import com.office.datasirpi.data.request.UserRequest;
import com.office.datasirpi.data.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBuilder {

    public User addUser(UserRequest userRequest) {
        return User.builder().firstName(userRequest.getFirstName()).lastName(userRequest.getLastName()).build();
    }

    public User updateUser(User user, UserRequest userRequest) {
        return user.toBuilder().firstName(userRequest.getFirstName()).lastName(userRequest.getLastName()).build();
    }

    public List<UserResponse> userResponses(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        users.forEach(u -> userResponses.add(getUser(u)));
        return userResponses;
    }

    public UserResponse getUser(User user) {
        return UserResponse.builder().id(String.valueOf(user.getId())).firstName(user.getFirstName()).lastName(user.getLastName()).build();
    }

}
