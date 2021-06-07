package com.example.Project.movie;

import com.example.Project.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id", updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "genre", nullable = false, columnDefinition = "TEXT")
    private String genre;

    @Column(name = "director", nullable = false, columnDefinition = "TEXT")
    private String director;

    @Column(name = "release_date", nullable = false)
    private long release_date;

    @Column(name = "rating", nullable = false)
    private long rating;

    @Column(name = "poster", nullable = false, columnDefinition = "TEXT")
    private String poster;

//    @ManyToMany(mappedBy = "favorites")
//    Set<User> users;

    public Movie() {}

    public Movie(long id, String name, String genre, String director, long release_date, long rating, String poster) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.release_date = release_date;
        this.rating = rating;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public long getRelease_date() {
        return release_date;
    }

    public void setRelease_date(long release_date) {
        this.release_date = release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
