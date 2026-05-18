package com.crm.modules.activity.service;

import com.crm.modules.activity.dto.ActivityResponse;
import com.crm.modules.activity.dto.CreateActivityRequest;

import java.util.List;

public interface ActivityService {

    public ActivityResponse createActivity(CreateActivityRequest request);

    public List<ActivityResponse> getAllActivities();

    public ActivityResponse getActivityById(Long id);

    public ActivityResponse completeActivity(Long id);

}
