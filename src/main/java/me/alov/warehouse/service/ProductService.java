package me.alov.warehouse.service;

import me.alov.warehouse.domain.Product;
import me.alov.warehouse.model.dto.ProductDto;
import me.alov.warehouse.repository.ProductRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DozerBeanMapper mapper;

    public ProductDto createProduct(ProductDto dto) {
        Product product = new Product();
        product.setArticle(dto.getArticle());
        product.setName(dto.getName());
        productRepository.save(product);
        return mapper.map(product, ProductDto.class);
    }

    public Product searchByArticle(Long article) {
        return productRepository.getProductByArticle(article);
    }

    public Product viewProduct(Long id) {
        return productRepository.getReferenceById(id);
    }

    public List<Product> getProductsByNames(List<String> names) {
        return productRepository.getAllByNameIn(names);
    }

    public List<Product> viewAllProduct() {
        return productRepository.findAll();
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
