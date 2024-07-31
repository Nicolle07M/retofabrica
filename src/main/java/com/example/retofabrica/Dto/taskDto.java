package com.example.retofabrica.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class taskDto {

    private Long idTask;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
}
