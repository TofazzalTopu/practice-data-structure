package com.example.practice.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private List<T> content;
    private int currentPage;
    private long totalItems;
    private int totalPages;

}
