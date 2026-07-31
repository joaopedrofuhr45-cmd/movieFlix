package com.movieFlix.movie.mapper;

import com.movieFlix.Streaming.EntityJpaStreaming;
import com.movieFlix.category.CategoryEntityJpa;
import com.movieFlix.movie.MovieEntityJpa;
import com.movieFlix.movie.dto.request.MovieRequest;
import com.movieFlix.movie.dto.response.MovieResponse;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;
@UtilityClass
public class MovieMapper {
    public MovieEntityJpa toEntityJpa(MovieRequest movieRequest) {
        List<CategoryEntityJpa> categories = movieRequest.category().stream().map(categoriesId -> CategoryEntityJpa.builder().id(categoriesId).build())
                .toList();

        List<EntityJpaStreaming> streaming = movieRequest.streaming().stream().map(streamingId -> EntityJpaStreaming.builder().id(streamingId).build())
                .toList();

        return MovieEntityJpa.builder()
                .title(movieRequest.title())
                .description(movieRequest.descripition())
                .releaseDate(movieRequest.realeseDate())
                .rating(BigDecimal.valueOf(movieRequest.rating()))
                .categories(categories)
                .streamings(streaming)
                .build();
    }



    public MovieResponse toResponse(MovieEntityJpa entity) {
        return MovieResponse.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .releaseDate(entity.getReleaseDate())
                .rating(entity.getRating() != null ? entity.getRating().doubleValue() : null)
                .categories(entity.getCategories().stream()
                        .map(CategoryEntityJpa::getId)
                        .toList())
                .streamings(entity.getStreamings().stream()
                        .map(EntityJpaStreaming::getId)
                        .toList())
                .build();
    }


}






