package com.crm.modules.deal.service;

import com.crm.modules.deal.dto.CreateDealRequest;
import com.crm.modules.deal.dto.DealResponse;

import java.util.List;

public interface DealService {

    public DealResponse createDeal(CreateDealRequest request);

    public List<DealResponse> getAllDeal();

    public DealResponse getDealById(Long id);

}
