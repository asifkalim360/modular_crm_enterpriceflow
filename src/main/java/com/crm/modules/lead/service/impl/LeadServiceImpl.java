package com.crm.modules.lead.service.impl;

import com.crm.modules.lead.dto.CreateLeadRequest;
import com.crm.modules.lead.dto.LeadResponse;
import com.crm.modules.lead.entity.Lead;
import com.crm.modules.lead.entity.LeadStatus;
import com.crm.modules.lead.repository.LeadRepository;
import com.crm.modules.lead.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;

    // CREATE LEAD
    @Override
    public LeadResponse createLead(CreateLeadRequest request) {
        Lead lead = Lead.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .company(request.getCompany())
                .status(LeadStatus.NEW)
                .build();
        Lead savedLead = leadRepository.save(lead);

        return mapToResponse(savedLead);
    }

    // Entity to DTO conversion
    private LeadResponse mapToResponse(Lead savedLead) {
        return LeadResponse.builder()
                .id(savedLead.getId())
                .name(savedLead.getName())
                .email(savedLead.getEmail())
                .phone(savedLead.getPhone())
                .company(savedLead.getCompany())
                .status(savedLead.getStatus())
                .assignedUserName(savedLead.getAssignedUser() != null
                        ? savedLead.getAssignedUser().getName()
                        :null)
                .build();
    }

    // GET ALL LEADS
    @Override
    public List<LeadResponse> getAllLeads() {
        return leadRepository.findAll()
                .stream()
             // .map(lead -> mapToResponse(lead))
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public LeadResponse getLeadById(Long id) {
        Lead lead = leadRepository.findById(id).orElseThrow(() -> new RuntimeException("Lead not found"));
        return mapToResponse(lead);
    }

    @Override
    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}

//  Why mapping method separate banaya?
//“Code reusability aur clean architecture maintain karne ke liye.”
