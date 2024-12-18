package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.dto.comment.CreateCommentDTO;
import com.example.taskmanagementsystem.dto.comment.ViewCommentDTO;
import com.example.taskmanagementsystem.entities.User;
import com.example.taskmanagementsystem.service.CommentService;
import com.example.taskmanagementsystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@SecurityRequirement(name = "JWT")
@RequiredArgsConstructor
@Tag(name = "Комментарии", description = "Управление комментариев")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @Operation(summary = "Создание коментария")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ViewCommentDTO.class))
            })
    })
    @PostMapping("/create")
    public ResponseEntity<?> createNewComment(@RequestBody CreateCommentDTO createCommentDTO, Principal principal) {
        Optional<User> user = userService.findByEmail(principal.getName());
        ViewCommentDTO viewCommentDTO = commentService.createComment(createCommentDTO, user);
        return ResponseEntity.ok(viewCommentDTO);
    }
    @Operation(summary = "Отображение комментариев")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ViewCommentDTO.class))
            })
    })
    @GetMapping("/view")
    public ResponseEntity<?> viewCommentByTask(@RequestParam(value = "id", required = false) Integer id) {
        List<ViewCommentDTO> viewCommentDTO = commentService.findByTaskId(id);
        return ResponseEntity.ok(viewCommentDTO);
    }
}
