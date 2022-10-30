package me.alov.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "WarehouseProduct")
@Table(name = "warehouse_product")
public class WarehouseProduct implements Serializable {

    @EmbeddedId
    private WarehouseProductId id = new WarehouseProductId();

    @MapsId("warehouseId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column
    private Integer count = 0;
}
