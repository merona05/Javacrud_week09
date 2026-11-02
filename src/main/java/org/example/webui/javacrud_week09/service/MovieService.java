package org.example.webui.javacrud_week09.service;

import org.example.webui.javacrud_week09.dto.MovieRequest;
import org.example.webui.javacrud_week09.dto.MovieResponse;
import org.example.webui.javacrud_week09.entity.Movie;
import org.example.webui.javacrud_week09.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public MovieResponse createMovie(MovieRequest request){
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setRating(request.getRating());

        Movie savedMovie = movieRepository.save(movie);

        return new MovieResponse(savedMovie);
    }
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(MovieResponse::new)
                .toList();
    }

    public MovieResponse getMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));

        return new MovieResponse(movie);
    }

    public MovieResponse updateMovie(Long id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));

        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setRating(request.getRating());

        Movie updatedMovie = movieRepository.save(movie);

        return new MovieResponse(updatedMovie);
    }

    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Movie not found: " + id);
        }

        movieRepository.deleteById(id);
    }



}
