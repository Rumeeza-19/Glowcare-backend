package com.glowcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glowcare.dto.UserDto;
import com.glowcare.entity.User;
import com.glowcare.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto register(UserDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setSkinType(dto.getSkinType());
        user.setConcerns(dto.getConcerns());
        user.setPreferences(dto.getPreferences());
        user.setWishlist(dto.getWishlist());

        User savedUser = userRepository.save(user);

        return convertToDto(savedUser);
    }

    public UserDto login(UserDto dto) {

        User user = userRepository.findByEmail(dto.getEmail()).orElse(null);

        if (user != null && user.getPassword().equals(dto.getPassword())) {
            return convertToDto(user);
        }

        return null;
    }

    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();

        for (User user : users) {
            result.add(convertToDto(user));
        }

        return result;
    }

    public UserDto getUserById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        return convertToDto(user);
    }

    public UserDto updateUser(Long id, UserDto dto) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setSkinType(dto.getSkinType());
        user.setConcerns(dto.getConcerns());
        user.setPreferences(dto.getPreferences());
        user.setWishlist(dto.getWishlist());

        User updatedUser = userRepository.save(user);

        return convertToDto(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDto convertToDto(User user) {

        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setSkinType(user.getSkinType());
        dto.setConcerns(user.getConcerns());
        dto.setPreferences(user.getPreferences());
        dto.setWishlist(user.getWishlist());

        return dto;
    }
}