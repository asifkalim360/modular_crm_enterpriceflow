package com.crm.modules.customer.dto;

import com.crm.modules.customer.entity.Customer;
import lombok.Data;

@Data
public class CreateCustomerRequest {

    private Long dealId;

}

// WHY ONLY dealId? Because:
// Customer data already Lead + Deal me available hai
//Hum automatic customer create karenge. Enterprise systems me data duplication avoid karte hain ✅