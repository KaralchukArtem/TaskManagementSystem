package com.example.taskmanagementsystem.dto.task;

import com.example.taskmanagementsystem.entities.User;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Создание задачи ДТО")
public class CreateTaskDTO {
    @Schema(description = "Заголовок", example = "Задача номер 4", accessMode = Schema.AccessMode.WRITE_ONLY)
    private String title;
    @Schema(description = "Описание", example = "Задача должна быть вополнена", accessMode = Schema.AccessMode.WRITE_ONLY)
    private String description;
    @Schema(description = "Исполнитель", example = "Bob@gmail.com", accessMode = Schema.AccessMode.WRITE_ONLY)
    private String executor;
    @Hidden
    @Schema(description = "Автор", example = "", accessMode = Schema.AccessMode.READ_ONLY)
    private User author_id;
    @Schema(description = "Уникальный идентификатор статуса", example = "1", accessMode = Schema.AccessMode.WRITE_ONLY)
    private int status_id;
    @Schema(description = "Уникальный идентификатор приоритета", example = "1", accessMode = Schema.AccessMode.WRITE_ONLY)
    private int priority_id;

    public CreateTaskDTO() {

    }
}
