package com.example.taskmanagementsystem.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Отображение комментария ДТО")
public class ViewCommentDTO {
    @Schema(description = "Уникальный идентификатор комментария", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;
    @Schema(description = "Текст")
    private String text;
    @Schema(description = "Комментатор", example = "Bob@gmail.com", accessMode = Schema.AccessMode.READ_ONLY)
    private String commentator;
}
