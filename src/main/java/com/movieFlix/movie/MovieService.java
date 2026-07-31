package com.movieFlix.movie;

import com.movieFlix.movie.dto.request.MovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieEntityJpa saved(MovieRequest movieRequest){

    }

}
