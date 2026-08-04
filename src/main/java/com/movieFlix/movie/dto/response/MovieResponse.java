package com.movieFlix.movie.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        String title,
        String description,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
        LocalDate releaseDate,
        double rating,
        List<Long> categories,
        List<Long> streamings
) {}