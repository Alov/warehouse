package me.alov.warehouse.endpoint;

import me.alov.warehouse.model.api.ApiResponse;
import me.alov.warehouse.model.dto.WarehouseDto;
import me.alov.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ApiResponse<WarehouseDto> create(@RequestBody WarehouseDto dto) {
        WarehouseDto warehouseDto = warehouseService.create(dto.getName());
        return ApiResponse.ok(warehouseDto);
    }

    @GetMapping("/all")
    public ApiResponse<List<WarehouseDto>> getAll() {
        List<WarehouseDto> all = warehouseService.getAll();
        return ApiResponse.ok(all);
    }

    @GetMapping("/{id}")
    public ApiResponse<WarehouseDto> getById(@RequestBody WarehouseDto dto) {
        return ApiResponse.ok(warehouseService.getById(dto.getId()));
    }

    @GetMapping
    public ApiResponse<WarehouseDto> findByName(@RequestParam String name) {
        return ApiResponse.ok(warehouseService.findByName(name));
    }
}
