package com.example.Project.user;

import com.example.Project.movie.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT", unique = true)
    private String name;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private  String password;

    @ManyToMany
    @JoinTable(name = "fav_movies", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<Movie> favorites;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Movie> getFavorites() {
        return favorites;
    }

    public void addFavorites(Movie film) {
        favorites.add(film);
    }
}
