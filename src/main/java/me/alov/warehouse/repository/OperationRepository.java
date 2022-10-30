package me.alov.warehouse.repository;

import me.alov.warehouse.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> getAllByProductId(Long productId);
    List<Operation> getAllByWarehouseFromOrWarehouseTo(Long warehouseFrom, Long warehouseTo);

    @Query("SELECT o FROM Operation o where o.productId = ?1  AND (o.warehouseFrom = ?2 OR o.warehouseTo = ?2)")
    List<Operation> getAllByWarehouseAndProduct(Long productId, Long warehouseId);

    @Query("SELECT o FROM Operation o where (o.warehouseFrom = ?1 OR o.warehouseTo = ?1)")
    List<Operation> getAllByWarehouse(Long warehouseId);
}
