package com.crm.modules.deal.controller;

import com.crm.modules.deal.dto.CreateDealRequest;
import com.crm.modules.deal.dto.DealResponse;
import com.crm.modules.deal.service.DealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deals")
@RequiredArgsConstructor
public class DealController {

    private final DealService dealService;

    // CREATE DEAL
    @PostMapping
    public DealResponse createDeal(@Valid @RequestBody CreateDealRequest request)
    {
        return dealService.createDeal(request);
    }

    // GET ALL DEALS
    @GetMapping
    public List<DealResponse> getAllDeal()
    {
        return dealService.getAllDeal();
    }

    // Get Deal BY ID.
    @GetMapping("/{id}")
    public DealResponse getDealById (@PathVariable Long id)
    {
        return dealService.getDealById(id);
    }

}
