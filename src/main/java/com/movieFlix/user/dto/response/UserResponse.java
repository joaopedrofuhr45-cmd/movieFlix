package com.movieFlix.user.dto.response;

import lombok.Builder;

@Builder
public record UserResponse(String name, String email)  {
}
