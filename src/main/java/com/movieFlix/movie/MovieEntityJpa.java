package com.movieFlix.movie;

import com.movieFlix.Streaming.EntityJpaStreaming;
import com.movieFlix.category.CategoryEntityJpa;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movie")
public class MovieEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private BigDecimal rating;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "movie_category", joinColumns = @JoinColumn(name ="movie_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntityJpa> categories;

    @ManyToMany
    @JoinTable(name = "movie_streaming", joinColumns = @JoinColumn(name ="movie_id"), inverseJoinColumns = @JoinColumn(name = "streaming_id"))
    private List<EntityJpaStreaming> streamings;

}