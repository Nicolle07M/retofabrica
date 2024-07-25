package com.example.retofabrica.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class userDto {
    private Long idUser;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private Long phone;
    private String password;
    private Boolean status;
}
