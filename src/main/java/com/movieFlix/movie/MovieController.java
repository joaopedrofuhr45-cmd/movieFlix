package com.movieFlix.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movieFlix/Movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

}
