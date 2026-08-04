package com.movieFlix.movie.persistencia;

import com.movieFlix.category.CategoryEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntityJpa, Long> {
    public List<MovieEntityJpa> findByCategories(List<CategoryEntityJpa> categoriesId);
}
