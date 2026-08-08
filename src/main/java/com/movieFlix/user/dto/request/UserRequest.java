package com.movieFlix.user.dto.request;

import lombok.Builder;

@Builder
public record UserRequest(String name, String email, String password) {
}
