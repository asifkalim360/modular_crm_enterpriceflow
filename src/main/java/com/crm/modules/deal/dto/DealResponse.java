package com.crm.modules.deal.dto;

import com.crm.modules.deal.entity.DealStage;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DealResponse {

    private Long id;

    private String title;

    private BigDecimal amount;

    private DealStage stage;

    private String leadName;

}
