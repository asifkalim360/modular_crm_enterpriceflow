package com.crm.modules.deal.service.impl;

import com.crm.modules.deal.dto.CreateDealRequest;
import com.crm.modules.deal.dto.DealResponse;
import com.crm.modules.deal.entity.Deal;
import com.crm.modules.deal.entity.DealStage;
import com.crm.modules.deal.repository.DealRepository;
import com.crm.modules.deal.service.DealService;
import com.crm.modules.lead.entity.Lead;
import com.crm.modules.lead.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final LeadRepository leadRepository;

    // CREATE DEAL.
    @Override
    public DealResponse createDeal(CreateDealRequest request) {

        // FIND LEAD.
        Lead lead = leadRepository.findById(request.getLeadId()).orElseThrow(() -> new RuntimeException("Lead not found"));

        // CREATE DEAL.
        Deal deal = Deal.builder()
                .title(request.getTitle())
                .amount(request.getAmount())
                .stage(DealStage.PROSPECT)
                .lead(lead)
                .build();

        Deal savedDeal = dealRepository.save(deal);
        return entityToResponse(savedDeal);
    }

    // ENTITY → DTO
    private DealResponse entityToResponse(Deal deal) {

        return DealResponse.builder()
                .id(deal.getId())
                .title(deal.getTitle())
                .amount(deal.getAmount())
                .stage(deal.getStage())
                .leadName(deal.getLead() != null
                        ? deal.getLead().getName()
                        : null )
                .build();
    }

    // GET ALL DEALS
    @Override
    public List<DealResponse> getAllDeal() {
        return dealRepository.findAll()
                .stream()
                .map(this :: entityToResponse)
                .toList();
    }

    // GET DEAL WITH ID BASE.
    @Override
    public DealResponse getDealById(Long id) {
        Deal deal = dealRepository.findById(id).orElseThrow(() -> new RuntimeException("Deal not found"));

        return entityToResponse(deal);
    }
}
