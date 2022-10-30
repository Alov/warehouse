package me.alov.warehouse.util;

import lombok.experimental.UtilityClass;
import me.alov.warehouse.model.dto.AdmissionDto;
import me.alov.warehouse.model.dto.SaleDto;

import java.math.BigDecimal;

@UtilityClass
public class InputValidator {

    public void validateAdmissionDto(AdmissionDto dto) {
        if (dto.getNumber() == null) {
            throw new IllegalArgumentException("Invalid input. Admission should have operation number");
        }
        if (dto.getWarehouseId() == null || dto.getWarehouseId() < 1) {
            throw new IllegalArgumentException("Invalid input. Admission should have valid warehouse identifier");
        }
        dto.getProductList().forEach(item -> {
            if (item.getArticle() == null) {
                throw new IllegalArgumentException("Invalid input. Empty product article");
            }
            if (item.getCount() <= 0) {
                throw new IllegalArgumentException("Invalid input. Product with article " + item.getArticle() + " should have valid count");
            }
            if (BigDecimal.ZERO.equals(item.getPrice())) {
                throw new IllegalArgumentException("Invalid input. Product with article " + item.getArticle() + " should have valid price");
            }
        });
    }

    public void validateSaleDto(SaleDto dto) {
        if (dto.getNumber() == null) {
            throw new IllegalArgumentException("Invalid input. Admission should have operation number");
        }
        if (dto.getWarehouseId() == null || dto.getWarehouseId() < 1) {
            throw new IllegalArgumentException("Invalid input. Admission should have valid warehouse identifier");
        }
        dto.getProductList().forEach(item -> {
            if (item.getArticle() == null) {
                throw new IllegalArgumentException("Invalid input. Empty product article");
            }
            if (item.getCount() <= 0) {
                throw new IllegalArgumentException("Invalid input. Product with article " + item.getArticle() + " should have valid count");
            }
            if (BigDecimal.ZERO.equals(item.getPrice())) {
                throw new IllegalArgumentException("Invalid input. Product with article " + item.getArticle() + " should have valid price");
            }
        });
    }
}
