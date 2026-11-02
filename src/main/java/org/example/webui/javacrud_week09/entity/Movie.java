package org.example.webui.javacrud_week09.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 100)
    private String director;

    @Column(length = 50)
    private String genre;

    @Column
    private Integer releaseYear;

    @Column
    private Double rating;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Double getRating() {
        return rating;
    }
}
