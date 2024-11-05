package com.forum.userservice.controller;

import com.forum.userservice.dto.ProfileDto;
import com.forum.userservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/profile")
public class UserController {

    @Autowired
    private ProfileService profileService;

    // Получение профиля
    @GetMapping
    public ResponseEntity<ProfileDto> getProfile(@RequestHeader("X-User-Id") String userId) {
        ProfileDto profile = profileService.getProfile(Long.parseLong(userId));
        return profile != null ? ResponseEntity.ok(profile) : ResponseEntity.notFound().build();
    }

    // Обновление профиля
    @PutMapping
    public ResponseEntity<String> updateProfile(@RequestBody ProfileDto profileDto, @RequestHeader("X-User-Id") String userId) {
        boolean isUpdated = profileService.updateProfile(Long.parseLong(userId), profileDto);
        return isUpdated ? ResponseEntity.ok("Profile updated successfully") : ResponseEntity.notFound().build();
    }
}
