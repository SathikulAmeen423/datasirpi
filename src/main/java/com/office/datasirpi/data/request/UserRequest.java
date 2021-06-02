package com.office.datasirpi.data.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class UserRequest {

    private String firstName;
    private String lastName;
}
