package com.movieFLix.Streaming;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingJpaRepository extends JpaRepository<EntityJpaStreaming, Long> {
}