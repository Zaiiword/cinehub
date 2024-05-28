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


/**
 * This class represents a genre in the movie database.
 * <p>
 * It is mapped to the "genre" table in the database.
 * Each genre has an ID and a name, and is associated with a list of movies.
 * </p>
 */
@Entity
@Data
@Table(name = "genre")
public class Genre {
    
    /**
     * The ID of the genre.
     * <p>
     * This is the primary key in the "genre" table.
     * It is automatically generated.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    /**
     * The name of the genre.
     */
    private String name;

    /**
     * The list of movies associated with this genre.
     * <p>
     * This is a many-to-many relationship.
     * The relationship is mapped by the "genres" field in the Movie class.
     * </p>
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    /**
     * Returns a string representation of the genre.
     *
     * @return a string representation of the genre
     */
    @Override 
    public String toString() { 
        return "Genre{" + "id=" + id + ", name='" + name + '}'; 
    }




}
