package com.example.taskmanagementsystem.mapper;


import com.example.taskmanagementsystem.dto.user.UserDTO;
import com.example.taskmanagementsystem.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface UserMapper {
    List<UserDTO> EntitytoViewDTOList(List<User> users);
}