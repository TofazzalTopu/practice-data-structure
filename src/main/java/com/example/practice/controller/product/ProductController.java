package com.example.practice.controller.product;

import com.example.practice.dto.product.PaginatedResponse;
import com.example.practice.dto.product.ProductDTO;
import com.example.practice.entity.Product;
import com.example.practice.service.product.ProductService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
//@Validated
public class ProductController {
    @Autowired
    private ProductService productService;

    private static final int MAX_PAGE_SIZE = 100;


    @GetMapping
    public ResponseEntity<PaginatedResponse<ProductDTO>> getProducts(
            @RequestParam(defaultValue = "1") @Min(1) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        size = Math.min(size, MAX_PAGE_SIZE);

        Sort.Direction direction = validateSortDirection(sortDir);
        sortBy = validateSortBy(sortBy);

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(direction, sortBy));
        Page<Product> productPage = productService.getAllProducts(pageable);

        PaginatedResponse<ProductDTO> response = convertToPaginatedResponse(productPage);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/process")
    private ResponseEntity<?> process(){
        productService.executorServiceExample();
        return ResponseEntity.ok("Success");
    }

    private Sort.Direction validateSortDirection(String sortDir) {
        try {
            return Sort.Direction.fromString(sortDir.toLowerCase());
        } catch (IllegalArgumentException e) {
            return Sort.Direction.ASC;
        }
    }

    private String validateSortBy(String sortBy) {
        if (!isFieldPresent(Product.class, sortBy)) {
            return "id";
        }
        return sortBy;
    }

    private boolean isFieldPresent(Class<?> clazz, String fieldName) {
        try {
            clazz.getDeclaredField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    private PaginatedResponse<ProductDTO> convertToPaginatedResponse(Page<Product> productPage) {
        List<ProductDTO> content = productPage.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        PaginatedResponse<ProductDTO> response = new PaginatedResponse<>();
        response.setContent(content);
        response.setCurrentPage(productPage.getNumber() + 1);
        response.setTotalItems(productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());
        return response;
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        return dto;
    }
}
