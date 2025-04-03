package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.UserDetailDto;
import com.subhani.kavishkajaybackend.dto.UserDto;
import com.subhani.kavishkajaybackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

//    @GetMapping("/getUserDetails/{email}")
//    public ResponseEntity<UserDto> getUserDetails(@PathVariable String email) {
//        UserDetailDto userDetailDto = userService.getUserDetailsByEmail(email);
//        return ResponseEntity.ok(userDetailDto);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDto> getUserDetails(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserDetails(id));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDetailDto userDetailsDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDetailsDto));
    }
}
