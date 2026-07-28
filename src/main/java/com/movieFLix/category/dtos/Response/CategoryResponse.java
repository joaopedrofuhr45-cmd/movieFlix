package com.movieFLix.category.dtos.Response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
