package com.salestray.salestraybackend.DTOs;

import java.util.Date;

public interface SalesOnlyDTO {

    Long getId();

    Long getSoldQuantity();

    Double getSoldPrice();

    Date getCreatedOn();

    Long getCreatedBy();

    Date getUpdatedOn();

    Long getUpdatedBy();

}
