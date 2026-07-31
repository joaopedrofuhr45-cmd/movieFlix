package com.movieFlix.movie.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        BigDecimal rating,
        List<Long> categories,
        List<Long> streamings
) {}