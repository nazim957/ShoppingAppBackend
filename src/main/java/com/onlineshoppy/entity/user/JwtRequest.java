package com.onlineshoppy.entity.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest {
    String usernameOrEmail;
    String password;

}
