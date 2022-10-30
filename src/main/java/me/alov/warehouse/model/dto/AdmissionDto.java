package me.alov.warehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionDto {
    private Long number;
    private Long warehouseId;
    private List<OperationItemDto> productList;
}
