package com.movieFlix.user.mapper;

import com.movieFlix.user.UserEntityJpa;
import com.movieFlix.user.dto.request.UserRequest;
import com.movieFlix.user.dto.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
public static UserEntityJpa toEntityJpa (UserRequest userRequest){
    return UserEntityJpa.builder()
            .name(userRequest.name())
            .email(userRequest.email())
            .password(userRequest.password())
            .build();
}

public static UserResponse toUserResponse(UserEntityJpa userEntityJpa){
    return UserResponse.builder()
            .name(userEntityJpa.getName())
            .email(userEntityJpa.getEmail())
            .build();
}

}
