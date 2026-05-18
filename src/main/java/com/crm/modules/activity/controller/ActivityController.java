package com.crm.modules.activity.controller;

import com.crm.modules.activity.dto.ActivityResponse;
import com.crm.modules.activity.dto.CreateActivityRequest;
import com.crm.modules.activity.service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    // CREATE ACTIVITY
    @PostMapping
    public ActivityResponse createActivity(@Valid @RequestBody CreateActivityRequest request)
    {
        return activityService.createActivity(request);
    }

    // GET ALL ACTIVITIES
    @GetMapping
    public List<ActivityResponse> getAllActivities()
    {
        return activityService.getAllActivities();
    }

    // GET ACTIVITY BY ID
    @GetMapping("/{id}")
    public ActivityResponse getActivityById(@PathVariable Long id)
    {
        return activityService.getActivityById(id);
    }

    // COMPLETE ACTIVITY
    @PutMapping("/{id}/complete")
    public ActivityResponse completeActivity(@PathVariable Long id)
    {
        return activityService.completeActivity(id);
    }
}
