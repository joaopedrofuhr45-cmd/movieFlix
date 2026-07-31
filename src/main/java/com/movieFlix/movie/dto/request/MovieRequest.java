package com.movieFlix.movie.dto.request;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(String title, String descripition, LocalDate realeseDate, double rating, List<Long> category,
                           List<Long> streaming) {
}
