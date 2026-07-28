package com.movieFLix.dtos.Response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
