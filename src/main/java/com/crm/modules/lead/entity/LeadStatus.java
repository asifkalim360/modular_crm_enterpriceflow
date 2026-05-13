package com.crm.modules.lead.entity;

public enum LeadStatus {

    NEW,
    CONTACTED,
    QUALIFIED,
    CONVERTED,
    LOST

}
// Interview Point: Why Enum for Status?
//“Fixed business states ko manage karne ke liye enum best practice hai. because invalid values avoid hoti hain.”