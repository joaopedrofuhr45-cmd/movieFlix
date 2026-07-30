package com.movieFlix.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntityJpa, Long> {
    //public List<CategoryEntityJpa>  findAlLCategories();
}
