package com.example.taskmanagementsystem.dto.priority;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Отображение приоритета ДТО")
public class ViewPriorityDTO {
    @Schema(description = "Уникальный идентификатор приоритета", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;
    @Schema(description = "Тип приоритета", example = "low", accessMode = Schema.AccessMode.READ_ONLY)
    private String type;
}
