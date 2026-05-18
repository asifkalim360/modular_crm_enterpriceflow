package com.crm.modules.ticket.service;

import com.crm.modules.ticket.dto.CreateTicketRequest;
import com.crm.modules.ticket.dto.TicketResponse;

import java.util.List;

public interface TicketService {

    public TicketResponse createTicket(CreateTicketRequest request);

    public List<TicketResponse> getAllTicket();

    public TicketResponse getTicketById(Long id);

}
