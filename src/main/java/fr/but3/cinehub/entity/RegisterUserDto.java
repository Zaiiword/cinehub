package fr.but3.cinehub.entity;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String name;
    private String firstName;
    private String mail;
    private String language;
    private String password;
    private String role;

}