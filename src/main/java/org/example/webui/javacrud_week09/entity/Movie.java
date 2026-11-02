package org.example.webui.javacrud_week09;

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
}
