package com.salestray.salestraybackend.DTOs.requestDTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateSalesRecordDTO {

    Long id;

    Long salesRecordId;

    Long stockRecordId;

    Long soldQuantity;

    Double soldPrice;

    Double discount;

    Long retailerId;

    Long saleTypeId;
}
