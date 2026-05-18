package com.crm.modules.ticket.service.impl;

import com.crm.modules.customer.entity.Customer;
import com.crm.modules.customer.repository.CustomerRepository;
import com.crm.modules.ticket.dto.CreateTicketRequest;
import com.crm.modules.ticket.dto.TicketResponse;
import com.crm.modules.ticket.entity.Ticket;
import com.crm.modules.ticket.entity.TicketStatus;
import com.crm.modules.ticket.repository.TicketRepository;
import com.crm.modules.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceimpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;

    // CREATE TICKET
    @Override
    public TicketResponse createTicket(CreateTicketRequest request) {
        // FIND CUSTOMER
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        // CREATE TICKET
        Ticket ticket = Ticket.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .priority(request.getPriority())
                .status(TicketStatus.OPEN)
                .customer(customer)
                .build();
        Ticket savedTicket = ticketRepository.save(ticket);
        return entityToResponse(savedTicket);
    }

    // ENTITY -> DTO
    private TicketResponse entityToResponse(Ticket ticket)
    {
        return TicketResponse.builder()
                .id(ticket.getId())
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .status(ticket.getStatus())
                .priority(ticket.getPriority())
                .customerName(ticket.getCustomer() != null ? ticket.getCustomer().getName() : null)
                .assignedUserName(ticket.getAssignedUser() != null ? ticket.getAssignedUser().getName() : null)
                .build();
    }

    // GET ALL TICKETS
    @Override
    public List<TicketResponse> getAllTicket() {
        return ticketRepository.findAll()
                .stream()
                .map(this::entityToResponse)
                .toList();
    }

    // GET TICKET BY ID
    @Override
    public TicketResponse getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        return entityToResponse(ticket);
    }
}
