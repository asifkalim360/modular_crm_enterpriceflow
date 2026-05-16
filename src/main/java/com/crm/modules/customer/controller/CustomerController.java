package com.crm.modules.customer.controller;

import com.crm.modules.customer.dto.CreateCustomerRequest;
import com.crm.modules.customer.dto.CustomerResponse;
import com.crm.modules.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // CREATE CUSTOMER
    @PostMapping
    public CustomerResponse createCustomer(
            @Valid @RequestBody CreateCustomerRequest request
    ) {

        return customerService.createCustomer(request);
    }

    // GET ALL CUSTOMERS
    @GetMapping
    public List<CustomerResponse> getAllCustomers() {

        return customerService.getAllCustomer();
    }

    // GET CUSTOMER BY ID
    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(
            @PathVariable Long id
    ) {

        return customerService.getCustomerById(id);
    }
}