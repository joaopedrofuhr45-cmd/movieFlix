package com.movieFLix.Streaming;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private StreamingJpaRepository streamingJpaRepository;

    public List<EntityJpaStreaming> findAllStreamings() { return streamingJpaRepository.findAll(); }

    public EntityJpaStreaming createStreaming(EntityJpaStreaming streaming) { return streamingJpaRepository.save(streaming); }

    public Optional<EntityJpaStreaming> findById(Long id) { return streamingJpaRepository.findById(id); }

    public void deleteStreaming(Long id) { streamingJpaRepository.deleteById(id); }
}