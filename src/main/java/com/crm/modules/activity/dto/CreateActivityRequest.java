package com.crm.modules.activity.dto;

import com.crm.modules.activity.entity.ActivityStatus;
import com.crm.modules.activity.entity.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateActivityRequest {

    private String title;
    private String description;
    private ActivityType type;
    private LocalDateTime dueDate;
    private Long leadId;

}
