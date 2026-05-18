package com.crm.modules.ticket.controller;

import com.crm.modules.ticket.dto.CreateTicketRequest;
import com.crm.modules.ticket.dto.TicketResponse;
import com.crm.modules.ticket.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    // CREATE TICKET
    @PostMapping
    public TicketResponse createTicket(@Valid @RequestBody CreateTicketRequest request)
    {
        return ticketService.createTicket(request);
    }

    // GET ALL TICKETS
    @GetMapping
    public List<TicketResponse> getAllTicket()
    {
        return ticketService.getAllTicket();
    }

    // GET TICKET BY ID
    @GetMapping("/{id}")
    public TicketResponse getTicketById(@PathVariable Long id)
    {
        return ticketService.getTicketById(id);
    }
}
