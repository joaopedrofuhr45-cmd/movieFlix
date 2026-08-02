package com.movieFlix.movie;

import com.movieFlix.movie.dto.request.MovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieEntityJpa saved(MovieEntityJpa movieEntityJpa){
        return movieRepository.save(movieEntityJpa);
    }

    public List<MovieEntityJpa> getALL(){
        return movieRepository.findAll();
    }
}
