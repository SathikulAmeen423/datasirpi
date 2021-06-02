package com.office.datasirpi.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;

}
