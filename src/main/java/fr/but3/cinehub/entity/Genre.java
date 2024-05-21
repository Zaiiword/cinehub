package fr.but3.cinehub.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "genre")
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    @Override 
    public String toString() { 
        return "Genre{" + "id=" + id + ", name='" + name + '}'; 
    }




}
