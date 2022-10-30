package me.alov.warehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovingDto {

    private Long article;
    private Long warehouseFrom;
    private Long warehouseTo;
    private Integer count;
}
