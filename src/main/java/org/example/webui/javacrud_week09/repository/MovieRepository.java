package org.example.webui.javacrud_week09.repository;
import org.example.webui.javacrud_week09.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
