package com.subhani.kavishkajaybackend.mapper;

import com.subhani.kavishkajaybackend.dto.UserDetailDto;
import com.subhani.kavishkajaybackend.dto.UserDto;
import com.subhani.kavishkajaybackend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);

    List<User> toEntityList(List<UserDto> userDtos);

    // Update an existing User entity with UserDetailsDto fields
    @Mapping(target = "id", ignore = true) // Keep existing ID
    @Mapping(target = "username", ignore = true) // Don't overwrite username
    @Mapping(target = "password", ignore = true) // Don't overwrite password
    @Mapping(target = "role", ignore = true) // Don't overwrite role
    void updateUserFromDto(UserDetailDto dto, @MappingTarget User user);


    UserDetailDto toDetailsDto(Optional<User> user); // New method for limited data
}
