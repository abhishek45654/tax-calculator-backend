package com.user.datamodels;

import lombok.Data;

@Data
public class LoginResponseObject {
    private int userId;
    private String userName;
    private String email;
    private String password;
}
