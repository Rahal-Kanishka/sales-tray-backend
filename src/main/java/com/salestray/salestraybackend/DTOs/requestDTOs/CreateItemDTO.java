package com.salestray.salestraybackend.DTOs.requestDTOs;

import com.salestray.salestraybackend.DTOs.BasicDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class CreateItemDTO implements BasicDTO {
    private Long id;
    private Long categoryId;
    private String name;
    private String code;
    private Integer packingSize;
    private Date updatedOn;
    private Long updatedBy;
}
