package com.movieFLix.Streaming;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private JpaRepositoryStreaming jpaRepositoryStreaming

    public List<EntityJpaStreaming> findAllStreamings() { return streamingRepository.findAll(); }

    public EntityJpaStreaming createStreaming(EntityJpaStreaming streaming) { return streamingRepository.save(streaming); }

    public Optional<EntityJpaStreaming> findById(Long id) { return streamingRepository.findById(id); }

    public void deleteStreaming(Long id) { streamingRepository.deleteById(id); }
}