package com.movieFlix.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntityJpa, Long> {
}
