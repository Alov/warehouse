package me.alov.warehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationItemDto {
    private Long article;
    private Integer count;
    private BigDecimal price;
}
