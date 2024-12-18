package com.example.taskmanagementsystem.dto.status;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Отображение статуса ДТО")
public class ViewStatusDTO {
    @Schema(description = "Уникальный идентификатор приоритета", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;
    @Schema(description = "Тип статуса", example = "done", accessMode = Schema.AccessMode.READ_ONLY)
    private String type;
}
