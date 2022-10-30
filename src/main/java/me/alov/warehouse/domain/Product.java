package me.alov.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "article", unique = true, nullable = false)
    private Long article;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "last_selling_price")
    private BigDecimal lastSellingPrice;

    @Column(name = "last_admission_price")
    private BigDecimal lastAdmissionPrice;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WarehouseProduct> warehouses = new ArrayList<>();
}
