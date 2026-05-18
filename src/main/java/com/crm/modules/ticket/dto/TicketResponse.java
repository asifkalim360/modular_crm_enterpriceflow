package com.crm.modules.ticket.dto;

import com.crm.modules.ticket.entity.TicketPriority;
import com.crm.modules.ticket.entity.TicketStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;
    private String customerName;
    private String assignedUserName;

}
