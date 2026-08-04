package com.movieFlix.movie;

import com.movieFlix.Streaming.EntityJpaStreaming;
import com.movieFlix.category.CategoryEntityJpa;
import com.movieFlix.movie.dto.request.MovieRequest;
import com.movieFlix.movie.dto.response.MovieResponse;
import com.movieFlix.movie.finders.FinderCategory;
import com.movieFlix.movie.finders.FinderStreaming;
import com.movieFlix.movie.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movieFlix/Movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final FinderCategory finderCategory;
    private final FinderStreaming finderStreaming;

    @PostMapping("saver")
    public ResponseEntity<MovieResponse> Create(@RequestBody MovieRequest movieRequest) {
        List<CategoryEntityJpa> categories = finderCategory.findAllById(movieRequest.category());
        List<EntityJpaStreaming> streamings = finderStreaming.findAllStreamingId(movieRequest.streaming());

        MovieEntityJpa movie = MovieMapper.toEntityJpa(movieRequest);
        movie.setCategories(categories);
        movie.setStreamings(streamings);

        MovieEntityJpa saved = movieService.saved(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toResponse(saved));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        return movieService.findByID(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toResponse(movie))).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(
            @PathVariable Long id,
            @RequestBody MovieRequest movieRequest) {
        MovieEntityJpa movieEntityJpa = MovieMapper.toEntityJpa(movieRequest);
        return movieService.update(id, movieEntityJpa)
                .map(MovieMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}










