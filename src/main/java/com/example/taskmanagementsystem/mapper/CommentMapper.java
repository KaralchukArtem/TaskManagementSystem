package com.example.taskmanagementsystem.mapper;

import com.example.taskmanagementsystem.dto.comment.CreateCommentDTO;
import com.example.taskmanagementsystem.dto.comment.ViewCommentDTO;
import com.example.taskmanagementsystem.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface CommentMapper {
    ViewCommentDTO CommentEntityToViewDTO (Comment comment);
    List<ViewCommentDTO> CommentEntityToViewDTOList (List<Comment> comment);

    Comment CreateCommentDTOToEntity (CreateCommentDTO comment);
}
