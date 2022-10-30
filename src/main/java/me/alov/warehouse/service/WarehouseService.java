package me.alov.warehouse.service;

import me.alov.warehouse.domain.Warehouse;
import me.alov.warehouse.model.dto.WarehouseDto;
import me.alov.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseDto create(String name) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        warehouseRepository.save(warehouse);
        return new WarehouseDto(warehouse.getId(), warehouse.getName());
    }

    public WarehouseDto findByName(String name) {
        Warehouse entity = warehouseRepository.getByName(name);
        return new WarehouseDto(entity.getId(), entity.getName());
    }

    public WarehouseDto getById(Long id) {
        Warehouse entity = warehouseRepository.getReferenceById(id);
        return new WarehouseDto(entity.getId(), entity.getName());
    }

    public List<WarehouseDto> getAll() {
        return warehouseRepository.findAll().stream()
                .map(entity ->  new WarehouseDto(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }
}
