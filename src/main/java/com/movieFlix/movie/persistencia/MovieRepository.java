package com.movieFlix.movie.persistencia;

import com.movieFlix.category.CategoryEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntityJpa, Long> {
    @Query("SELECT m FROM MovieEntityJpa m JOIN m.categories c WHERE c.id = :categoryId")
    List<MovieEntityJpa> findByCategoryId(@Param("categoryId") Long categoryId);
}
