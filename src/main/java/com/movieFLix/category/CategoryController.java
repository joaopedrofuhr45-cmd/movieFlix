package com.movieFLix.category;

import com.movieFLix.category.mapper.CategoryMapper;
import com.movieFLix.category.dtos.Request.CategoryRequest;
import com.movieFLix.category.dtos.Response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movieFlix/Category")
@RequiredArgsConstructor
public class CategoryController {
    private CategoryService categoryService;


    @GetMapping("/movieFLix/Category")
    public ResponseEntity<List<CategoryResponse>> getALLCategories() {
        List<CategoryResponse> categories = categoryService.findAlLCategories().stream().map(CategoryMapper::toCategoryResponse).toList();
        return ResponseEntity.ok(categories);
    }


    @PostMapping("/movieFlix/Category")
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
        CategoryEntityJpa categoryEntityJpa = CategoryMapper.toCategoryEntityJpa(request);
        CategoryEntityJpa savedCategory = categoryService.createCategory(categoryEntityJpa);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));


    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
       return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

