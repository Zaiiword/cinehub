package fr.but3.cinehub.entity;

import java.util.Date;

import lombok.Data;

@Data
public class MovieSummary {
    private Long id;
    private String name;
    private String genres;
    private Date released;
    private String poster;
    private double rating;
}
