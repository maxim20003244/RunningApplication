package com.rungroup.web.runninapplication.dto;

import com.rungroup.web.runninapplication.models.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Photo link should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;
    private List<EventDto> events;
    private UserEntity createdBy;
}
