package com.example.taskmanagementsystem.mapper;


import com.example.taskmanagementsystem.domain.RegistrationUserDto;
import com.example.taskmanagementsystem.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface UserMapper {
    User DtoToEntity(RegistrationUserDto user);
}