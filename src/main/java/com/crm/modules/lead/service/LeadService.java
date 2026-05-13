package com.crm.modules.lead.service;

import com.crm.modules.lead.dto.CreateLeadRequest;
import com.crm.modules.lead.dto.LeadResponse;

import java.util.List;

public interface LeadService {

    LeadResponse createLead(CreateLeadRequest request);

    List<LeadResponse> getAllLeads();

    LeadResponse getLeadById(Long id);

    void deleteLead(Long id);

}
