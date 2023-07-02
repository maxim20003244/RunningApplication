package com.rungroup.web.runninapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private long id;
    private String name;
    private String photoUrl;
    private String type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    private LocalDateTime createOn;

    private LocalDateTime updateTime;
}
