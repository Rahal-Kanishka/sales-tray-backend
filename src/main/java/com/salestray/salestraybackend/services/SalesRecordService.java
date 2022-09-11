package com.salestray.salestraybackend.services;

import com.salestray.salestraybackend.DTOs.SalesOnlyDTO;
import com.salestray.salestraybackend.DTOs.SalesWithStockDetailsDTO;
import com.salestray.salestraybackend.DTOs.requestDTOs.CreateSalesRecordDTO;
import com.salestray.salestraybackend.entities.SalesRecord;
import com.salestray.salestraybackend.entities.SalesWithStockDetail;

public interface SalesRecordService {

    /**
     * Create Sales record using the DTO
     * @param createSalesRecordDTO
     * @return created SalesRecord object in the db
     */
    SalesWithStockDetail createSalesRecord(CreateSalesRecordDTO createSalesRecordDTO);

    /**
     * Update Sales record using the DTO
     * @param salesOnlyDTO
     * @return updated SalesRecord object in the db
     */
    SalesRecord updateSalesRecord(SalesOnlyDTO salesOnlyDTO);

    /**
     * Update Sales record using the DTO
     * @param salesRecordId record id to be deleted
     * @return result of the operation
     */
    Boolean deleteSalesRecord(Long salesRecordId);
}
