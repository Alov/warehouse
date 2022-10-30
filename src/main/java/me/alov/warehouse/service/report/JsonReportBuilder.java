package me.alov.warehouse.service.report;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.alov.warehouse.domain.Product;
import me.alov.warehouse.model.dto.ProductDto;
import me.alov.warehouse.model.report.ReportFormat;
import me.alov.warehouse.model.report.ReportType;
import me.alov.warehouse.service.ProductService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JsonReportBuilder implements ReportBuilder {

    @Autowired
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public boolean support(ReportFormat format) {
        return format == ReportFormat.JSON;
    }

    @Override
    public File build(List<String> filteredItems, ReportType type) {
        if (type == ReportType.FULL_PRODUCT_VIEW) {
            return buildFullProductReport(filteredItems);
        } else {
            return buildLefoversReport();
        }
    }

    private File buildLefoversReport() {
        return null;
    }

    private File buildFullProductReport(List<String> filtered) {
        List<ProductDto> allProducts;
        if (filtered.isEmpty()) {
            allProducts = productService.viewAllProduct().stream()
                    .map(entity -> mapper.map(entity, ProductDto.class))
                    .collect(Collectors.toList());
        } else {
            allProducts = productService.getProductsByNames(filtered).stream()
                    .map(entity -> mapper.map(entity, ProductDto.class))
                    .collect(Collectors.toList());;
        }
        String resultFileName = "./reports/full_product_review_" + LocalDate.now().toString();
        File file = new File(resultFileName);
        try {
            objectMapper.writeValue(file, allProducts);
        } catch (IOException e) {
            throw new RuntimeException("Can not save report to file: " + resultFileName);
        }
        return file;
    }
}
