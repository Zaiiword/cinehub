package fr.but3.cinehub.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MovieSummary {
    private Long id;
    private String name;
    private List<Genre> genres;
    private Date released;
    private String poster;
    private double rating;
}
