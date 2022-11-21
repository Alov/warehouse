package me.alov.warehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    @NotNull(message = "Field [name] should not be null")
    @NotEmpty(message = "Field [name] should not be empty")
    private String name;
    @NotNull(message = "Field [article] should not be null")
    @Min(value = 1L, message = "Field [article] should be greater that 0")
    private Long article;
    private BigDecimal lastSellingPrice;
    private BigDecimal lastAdmissionPrice;
}
