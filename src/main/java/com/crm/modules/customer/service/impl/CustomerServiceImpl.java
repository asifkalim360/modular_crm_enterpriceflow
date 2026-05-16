package com.crm.modules.customer.service.impl;

import com.crm.modules.customer.dto.CreateCustomerRequest;
import com.crm.modules.customer.dto.CustomerResponse;
import com.crm.modules.customer.entity.Customer;
import com.crm.modules.customer.repository.CustomerRepository;
import com.crm.modules.customer.service.CustomerService;
import com.crm.modules.deal.entity.Deal;
import com.crm.modules.deal.entity.DealStage;
import com.crm.modules.deal.repository.DealRepository;
import com.crm.modules.lead.entity.Lead;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  final CustomerRepository customerRepository;
    private final DealRepository dealRepository;

    //CREATE CUSTOMER
    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        // FIND DEAL.
        Deal deal = dealRepository.findById(request.getDealId()).orElseThrow(() -> new RuntimeException("Deal Not Found"));

        // Only WON deals can become customers.
        if(deal.getStage() != DealStage.WON)
        {
            throw new RuntimeException("Customer can only be created from WON deals");
        }

        // Fetch Lea from deal.
        Lead lead = deal.getLead();

        // Create customer.
        Customer customer = Customer.builder()
                .name(lead.getName())
                .email(lead.getEmail())
                .phone(lead.getPhone())
                .company(lead.getCompany())
                .deal(deal)
                .build();
        Customer savedCustomer = customerRepository.save(customer);
        return mapToResponse(savedCustomer);
    }

    // ENTITY → DTO
    private CustomerResponse mapToResponse( Customer customer)
    {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .company(customer.getCompany())
                .dealTitle(
                        customer.getDeal() != null
                                ? customer.getDeal().getTitle()
                                : null
                )
                .build();
    }

    // GET ALL CUSTOMER.
    @Override
    public List<CustomerResponse> getAllCustomer() {

        return customerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }

    // GET CUSTOMER BY ID.
    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("customer not found"));
        return mapToResponse(customer);
    }
}
