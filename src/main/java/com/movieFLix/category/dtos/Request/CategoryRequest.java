package com.movieFLix.dtos.Request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name) {
}
