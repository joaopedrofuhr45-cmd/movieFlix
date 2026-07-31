package com.movieFlix.movie;

import com.movieFlix.movie.dto.request.MovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movieFlix/Movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("movieFlix/movie/salvar")
    public void saved(MovieRequest movieRequest){

    }


}
