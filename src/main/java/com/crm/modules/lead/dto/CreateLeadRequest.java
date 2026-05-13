package com.crm.modules.lead.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateLeadRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Invalid email")
    private String email;

    private String phone;

    private String company;

}
