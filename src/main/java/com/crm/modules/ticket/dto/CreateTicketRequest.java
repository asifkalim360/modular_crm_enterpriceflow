package com.crm.modules.ticket.dto;

import com.crm.modules.ticket.entity.TicketPriority;
import lombok.Data;

@Data
public class CreateTicketRequest
{
    private String title;

    private String description;

    private TicketPriority priority;

    private Long customerId;
}
