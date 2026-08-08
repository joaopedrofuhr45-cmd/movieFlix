package com.movieFlix.movie;

import com.movieFlix.Streaming.EntityJpaStreaming;
import com.movieFlix.category.CategoryEntityJpa;
import com.movieFlix.movie.dto.response.MovieResponse;
import com.movieFlix.movie.finders.FinderCategory;
import com.movieFlix.movie.finders.FinderStreaming;
import com.movieFlix.movie.persistencia.MovieEntityJpa;
import com.movieFlix.movie.persistencia.MovieRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final FinderCategory finderCategory;
    private final FinderStreaming finderStreaming;

    public MovieEntityJpa saved(MovieEntityJpa movieEntityJpa) {
        return movieRepository.save(movieEntityJpa);
    }

    public Optional<MovieEntityJpa> findByID(Long id) {
        return movieRepository.findById(id);
    }

    public Optional<MovieEntityJpa> update(Long id, MovieEntityJpa updateMovie) {
        Optional<MovieEntityJpa> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            MovieEntityJpa movie = optionalMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setRating(updateMovie.getRating());
            movie.setReleaseDate(updateMovie.getReleaseDate());
            List<Long> categoriesId = updateMovie.getCategories().stream().map(CategoryEntityJpa::getId).toList();
            List<Long> streamingIds = updateMovie.getStreamings().stream().map(EntityJpaStreaming::getId).toList();

            List<CategoryEntityJpa> categories = finderCategory.findAllById(categoriesId);
            List<EntityJpaStreaming> streamings = finderStreaming.findAllStreamingId(streamingIds);

            movie.setCategories(categories);
            movie.setStreamings(streamings);
        }
        return optionalMovie;
    }

    public List<MovieEntityJpa> findByCategories(Long categoryId){
        return movieRepository.findByCategoryId(categoryId);
    }



    public void  delete(Long id){
        movieRepository.deleteById(id);
    }

}
