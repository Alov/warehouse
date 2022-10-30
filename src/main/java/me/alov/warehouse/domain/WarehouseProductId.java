package me.alov.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseProductId implements Serializable {

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "product_id")
    private Long productId;
}
