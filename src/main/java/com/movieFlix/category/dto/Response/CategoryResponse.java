package com.movieFlix.category.dto.Response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
