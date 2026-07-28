package com.movieFLix.category.mapper;
import com.movieFLix.category.CategoryEntityJpa;
import com.movieFLix.category.dtos.Request.CategoryRequest;

import com.movieFLix.category.dtos.Response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static CategoryEntityJpa toCategoryEntityJpa(CategoryRequest request){
        return CategoryEntityJpa
                .builder()
                .name(request.name())
                .build();
    }


    public static CategoryResponse toCategoryResponse(CategoryEntityJpa response){
        return  CategoryResponse
                .builder()
                .id(response.getId())
                .name(response.getName())
                .build();
    }

}
