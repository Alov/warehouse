package me.alov.warehouse.repository;

import me.alov.warehouse.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Warehouse getByName(String name);
}
