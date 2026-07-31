package com.movieFlix.movie;

import com.movieFlix.movie.dto.request.MovieRequest;
import com.movieFlix.movie.dto.response.MovieResponse;
import com.movieFlix.movie.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movieFlix/Movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("movieFlix/movie/salvar")
    public ResponseEntity<MovieResponse> Create(@RequestBody MovieRequest movieRequest){
        MovieEntityJpa movieEntityJpa = MovieMapper.toEntityJpa(movieRequest);
        MovieEntityJpa saved = movieService.saved(movieEntityJpa);
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toResponse(saved));
    }













}
