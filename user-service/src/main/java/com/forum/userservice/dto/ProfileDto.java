package com.forum.userservice.dto;

import com.forum.userservice.entity.User;
import lombok.*;

@Data
public class ProfileDto {
    private String username;
    private String email;
    private String phoneNumber;

    // Конструктор для создания DTO из сущности User
    public ProfileDto(User user) {
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.username = user.getUsername();
    }
}
