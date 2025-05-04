package com.subhani.kavishkajaybackend.service;

import com.subhani.kavishkajaybackend.dto.UserDetailDto;
import com.subhani.kavishkajaybackend.dto.UserDto;
import com.subhani.kavishkajaybackend.entity.User;
import com.subhani.kavishkajaybackend.mapper.UserMapper;
import com.subhani.kavishkajaybackend.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<UserDto> getAllCustomers() {
        List<User> users = userRepo.findByRole("customer");
        return userMapper.toDtoList(users);
    }

    public UserDetailDto getUserDetails(int id) {
        // Logic to fetch user by email from the repository
       Optional<User> user = userRepo.findById(id);
        System.out.println(user);

        if (user.isPresent()) {


            return userMapper.toDetailsDto(user.get());
        } else {
            throw new RuntimeException("User not found ");
        }
   }


    @Transactional
    public UserDto updateUser(int userId, UserDetailDto userDetailsDto) {
        // Fetch existing user
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update only editable fields
        userMapper.updateUserFromDto(userDetailsDto, existingUser);

        // Save the updated user
        User updatedUser = userRepo.save(existingUser);

        // Return updated user as DTO
        return userMapper.toDto(updatedUser);
    }

}




//    public List<MeetingDTO> getAllMeetings(int customerId) {
//        // Fetch meetings for the given customer ID
//        List<Meeting> meetings = meetingRepository.findByCustomerId(customerId);
//
//        // Convert each Meeting entity into MeetingDTO
//        return meetings.stream()
//                .map(meeting -> new MeetingDTO(meeting))  // Assumes MeetingDTO has a constructor
//                .collect(Collectors.toList());
//   }

