package com.crm.modules.deal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateDealRequest {

    private String title;

    private BigDecimal amount;

    private Long leadId;

}
