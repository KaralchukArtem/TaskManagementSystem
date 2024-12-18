package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.dto.comment.CreateCommentDTO;
import com.example.taskmanagementsystem.dto.comment.ViewCommentDTO;
import com.example.taskmanagementsystem.entities.Comment;
import com.example.taskmanagementsystem.entities.Task;
import com.example.taskmanagementsystem.entities.User;
import com.example.taskmanagementsystem.mapper.CommentMapper;
import com.example.taskmanagementsystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private TaskService taskService;

    public List<ViewCommentDTO> findByTaskId(int id) {
        List<Comment> comments = commentRepository.findByTaskId(id);
        return commentMapper.CommentEntityToViewDTOList(comments);
    }

    public ViewCommentDTO createComment(CreateCommentDTO createCommentDTO, Optional<User> user) {
        Comment comment = commentMapper.CreateCommentDTOToEntity(createCommentDTO);
        Task task = taskService.getTask(createCommentDTO.getTask_id());
        comment.setCommentator(user.get().getLogin());
        comment.setTask(task);
        commentRepository.save(comment);
        return commentMapper.CommentEntityToViewDTO(comment);
    }
}
