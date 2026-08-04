package com.movieFlix.movie.finders;

import com.movieFlix.Streaming.EntityJpaStreaming;
import com.movieFlix.Streaming.StreamingJpaRepository;
import com.movieFlix.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FinderStreaming {

    private final StreamingJpaRepository streamingJpaRepository;

    public List<EntityJpaStreaming> findAllStreamingId (List<Long> id){
        return streamingJpaRepository.findAllById(id);
    }

}
