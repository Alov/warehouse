package me.alov.warehouse.endpoint;

import me.alov.warehouse.model.api.ApiResponse;
import me.alov.warehouse.model.dto.ProductDto;
import me.alov.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ApiResponse<ProductDto> create(@RequestBody ProductDto dto) {
        ProductDto product = productService.createProduct(dto);
        return ApiResponse.ok(product);
    }
}
