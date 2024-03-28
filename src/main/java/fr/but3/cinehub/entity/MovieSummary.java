package fr.but3.cinehub.entity;

import java.util.Date;

import lombok.Data;

@Data
public class MovieSummary {
    private Long id;
    private String name;
    private String directors;
    private String genres;
    private Date released;

}
