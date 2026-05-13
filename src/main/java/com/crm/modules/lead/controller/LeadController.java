package com.crm.modules.lead.controller;

import com.crm.modules.lead.dto.CreateLeadRequest;
import com.crm.modules.lead.dto.LeadResponse;
import com.crm.modules.lead.service.LeadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

    // CREATE LEAD
    @PostMapping
    public LeadResponse createLead(@Valid @RequestBody CreateLeadRequest request)
    {
        return leadService.createLead(request);
    }

    // GET ALL LEAD
    @GetMapping
    public List<LeadResponse> getAllLeads()
    {
        return leadService.getAllLeads();
    }

    // GET LEAD BY ID
    @GetMapping("/{id}")
    public LeadResponse getLeadById(@PathVariable Long id)
    {
        return leadService.getLeadById(id);
    }

    // DELETE LEAD
    @DeleteMapping("/{id}")
    public String deleteLead(@PathVariable Long id)
    {
        leadService.deleteLead(id);
        return "Lad deleted successfully";
    }

}
