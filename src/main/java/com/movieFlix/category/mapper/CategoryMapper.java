package com.movieFlix.category.mapper;
import com.movieFlix.category.CategoryEntityJpa;
import com.movieFlix.category.dtos.Request.CategoryRequest;

import com.movieFlix.category.dtos.Response.CategoryResponse;
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
