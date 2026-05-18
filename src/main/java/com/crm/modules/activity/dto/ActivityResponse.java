package com.crm.modules.activity.dto;

import com.crm.modules.activity.entity.ActivityStatus;
import com.crm.modules.activity.entity.ActivityType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ActivityResponse {

    private Long id;
    private String title;
    private String description;
    private ActivityType type;
    private ActivityStatus status;
    private LocalDateTime dueDate;
    private String leadName;
    private String assignedUserName;
}
