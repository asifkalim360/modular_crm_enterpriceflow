package com.crm.modules.activity.service.impl;

import com.crm.modules.activity.dto.ActivityResponse;
import com.crm.modules.activity.dto.CreateActivityRequest;
import com.crm.modules.activity.entity.Activity;
import com.crm.modules.activity.entity.ActivityStatus;
import com.crm.modules.activity.repository.ActivityRepository;
import com.crm.modules.activity.service.ActivityService;
import com.crm.modules.lead.entity.Lead;
import com.crm.modules.lead.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl
        implements ActivityService {

    private final ActivityRepository activityRepository;
    private final LeadRepository leadRepository;

    // CREATE ACTIVITY
    @Override
    public ActivityResponse createActivity(CreateActivityRequest request)
    {
        // Find lead
        Lead lead = leadRepository.findById(request.getLeadId()).orElseThrow(() -> new RuntimeException("Lead not found"));

        // Create activity
        Activity activity = Activity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .type(request.getType())
                .status(ActivityStatus.PENDING)
                .dueDate(request.getDueDate())
                .lead(lead)
                .build();

        Activity savedActivity = activityRepository.save(activity);
        return entityToDto(savedActivity);
    }

    // GET ALL ACTIVITIES
    @Override
    public List<ActivityResponse> getAllActivities()
    {
        return activityRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // GET ACTIVITY BY ID
    @Override
    public ActivityResponse getActivityById(Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
        return entityToDto(activity);
    }

    // COMPLETE ACTIVITY
    @Override
    public ActivityResponse completeActivity(Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));

        activity.setStatus(ActivityStatus.COMPLETED);

        Activity updatedActivity = activityRepository.save(activity);
        return entityToDto(updatedActivity);
    }

    // ENTITY → DTO
    private ActivityResponse entityToDto(Activity activity)
    {
        return ActivityResponse.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .description(activity.getDescription())
                .type(activity.getType())
                .status(activity.getStatus())
                .dueDate(activity.getDueDate())
                .leadName(activity.getLead() != null ? activity.getLead().getName() : null)
                .assignedUserName(activity.getAssigneduser() != null ? activity.getAssigneduser().getName() : null)
                .build();
    }
}