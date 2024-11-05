package com.forum.userservice.service;

import com.forum.userservice.dto.ProfileDto;
import com.forum.userservice.entity.User;
import com.forum.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public ProfileDto getProfile(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? new ProfileDto(user) : null;
    }

    public boolean updateProfile(Long userId, ProfileDto profileDto) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setEmail(profileDto.getEmail());
            user.setPhoneNumber(profileDto.getPhoneNumber());
            user.setUsername(profileDto.getUsername());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
