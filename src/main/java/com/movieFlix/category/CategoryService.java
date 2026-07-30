package com.movieFlix.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<CategoryEntityJpa> findAlLCategories(){
       return categoryRepository.findAll();
    }

    public CategoryEntityJpa createCategory(CategoryEntityJpa category){
        return categoryRepository.save(category);
    }

    public Optional<CategoryEntityJpa> findById(Long id){
        return categoryRepository.findById(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }



}
