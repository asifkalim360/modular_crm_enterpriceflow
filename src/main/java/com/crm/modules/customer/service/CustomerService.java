package com.crm.modules.customer.service;

import com.crm.modules.customer.dto.CreateCustomerRequest;
import com.crm.modules.customer.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    public CustomerResponse createCustomer(CreateCustomerRequest request);

    public List<CustomerResponse> getAllCustomer();

    public CustomerResponse getCustomerById(Long id);

}
