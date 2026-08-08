package com.movieFlix.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

private final UserRepository userRepository;

    public UserEntityJpa register(UserEntityJpa userEntityJpa){
        return userRepository.save(userEntityJpa);
    }

}
