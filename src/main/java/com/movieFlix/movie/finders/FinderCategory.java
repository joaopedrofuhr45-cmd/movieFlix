package com.movieFlix.movie.finders;

import com.movieFlix.category.CategoryEntityJpa;
import com.movieFlix.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class FinderCategory {

    private final CategoryRepository categoryRepository;

    public List<CategoryEntityJpa> findAllById(List<Long> ids) {
        return categoryRepository.findAllById(ids);
    }
}
