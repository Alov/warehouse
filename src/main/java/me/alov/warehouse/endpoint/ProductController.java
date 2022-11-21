package me.alov.warehouse.endpoint;

import me.alov.warehouse.domain.Product;
import me.alov.warehouse.model.api.ApiResponse;
import me.alov.warehouse.model.dto.ProductDto;
import me.alov.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ApiResponse<ProductDto> create(@Validated @RequestBody ProductDto dto) {
        ProductDto product = productService.createProduct(dto);
        return ApiResponse.ok(product);
    }

    @GetMapping
    public ApiResponse<List<Product>> getAll() {
        return ApiResponse.ok(productService.viewAllProduct());
    }
}
