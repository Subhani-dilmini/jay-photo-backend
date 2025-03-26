package com.subhani.kavishkajaybackend.service;

import com.subhani.kavishkajaybackend.dto.UserDto;
import com.subhani.kavishkajaybackend.entity.User;
import com.subhani.kavishkajaybackend.mapper.UserMapper;
import com.subhani.kavishkajaybackend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return userMapper.toDtoList(users);
    }

}



//
//    public List<MeetingDTO> getAllMeetings(int customerId) {
//        // Fetch meetings for the given customer ID
//        List<Meeting> meetings = meetingRepository.findByCustomerId(customerId);
//
//        // Convert each Meeting entity into MeetingDTO
//        return meetings.stream()
//                .map(meeting -> new MeetingDTO(meeting))  // Assumes MeetingDTO has a constructor
//                .collect(Collectors.toList());
//    }

