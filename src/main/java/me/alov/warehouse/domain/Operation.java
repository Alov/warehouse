package me.alov.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "operation_number")
    private Long operationNumber;

    @Column(name = "operation_type")
    private OperationType operationType;

    @Column(name = "warehouse_from")
    private Long warehouseFrom;

    @Column(name = "warehouse_to")
    private Long warehouseTo;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "count")
    private Integer count;
}
