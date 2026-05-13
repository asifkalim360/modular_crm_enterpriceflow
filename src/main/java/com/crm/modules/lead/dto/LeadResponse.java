package com.crm.modules.lead.dto;

import com.crm.modules.lead.entity.LeadStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeadResponse {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String company;

    private LeadStatus status;

    private String assignedUserName;

}

// WHY RESPONSE DTO?
//“Entity directly expose nahi karte because unnecessary fields leak ho sakte hain.”
