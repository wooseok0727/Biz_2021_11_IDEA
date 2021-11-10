package com.wooseok.readbook.models;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String userid;
    private String password;
    private String auth;
}
