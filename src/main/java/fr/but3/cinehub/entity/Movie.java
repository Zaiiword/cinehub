package fr.but3.cinehub.entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer duration;
    private double rating;
    private String directors;
    private String actors;
    private String synopsis;
    private String trailer;
    private String poster;
    private String genres;
    private Date released;
    private String productionCountry;
    @Column(name = "imdb_id")
    private String imdbId;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

}