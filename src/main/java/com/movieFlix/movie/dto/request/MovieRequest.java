package com.movieFlix.movie.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(String title,
                           String descripition,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
                           LocalDate realeseDate,
                           double rating,
                           List<Long> category,
                           List<Long> streaming) {
}
