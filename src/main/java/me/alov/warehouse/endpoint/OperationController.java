package me.alov.warehouse.endpoint;

import me.alov.warehouse.model.dto.AdmissionDto;
import me.alov.warehouse.model.api.ApiResponse;
import me.alov.warehouse.model.dto.SaleDto;
import me.alov.warehouse.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping("/admission")
    public ApiResponse admission(@RequestBody AdmissionDto admissionDto) {
        operationService.admission(admissionDto);
        return ApiResponse.ok();
    }

    @PostMapping("/sale")
    public ApiResponse admission(@RequestBody SaleDto saleDto) {
        operationService.sale(saleDto);
        return ApiResponse.ok();
    }

}
