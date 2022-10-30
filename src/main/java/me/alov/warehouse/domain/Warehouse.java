package me.alov.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "warehouse",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WarehouseProduct> products = new ArrayList<>();
}
