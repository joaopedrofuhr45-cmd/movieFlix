package com.movieFlix.movie;

import com.movieFlix.movie.dto.request.MovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieEntityJpa saved(MovieEntityJpa movieEntityJpa){
        return movieRepository.save(movieEntityJpa);
    }

    public Optional<MovieEntityJpa> findByID(Long id){
        return movieRepository.findById(id);
    }

    public Optional<MovieEntityJpa> update(Long id, MovieEntityJpa updateMovie){
        Optional<MovieEntityJpa> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
            MovieEntityJpa movie = optionalMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setId(updateMovie.getId());
            movie.setCategories(updateMovie.getCategories());
            movie.setCreatedAt(updateMovie.getCreatedAt());
            movie.setDescription(updateMovie.getDescription());
            movie.setRating(updateMovie.getRating());
            movie.setReleaseDate(updateMovie.getReleaseDate());
            movie.setStreamings(updateMovie.getStreamings());
            movie.setUpdatedAt(updateMovie.getUpdatedAt());
        }
        return optionalMovie;
    }
}
