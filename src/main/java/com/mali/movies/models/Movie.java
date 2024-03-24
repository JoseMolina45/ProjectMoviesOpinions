
package com.mali.movies.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase de la Base de datos movies
 * @author Jose Maria
 */

// Mapeamos los elementos.
@Entity
@Table(name ="movies" )

public class Movie {
    @Id  //Clave primaria,
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //El valor de Id se autogenera.
    private Long id;
    private String title;
    private int year;
    private int votes;
    private double rating;
    
    @Column(name = "image") 
    private String imageUrl;
    
    // private String description;
    
// Metodos gettter y setter Id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

// Metodos gettter y setter title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Metodos gettter y setter year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

// Metodos gettter y setter votes 
    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

// Metodos gettter y setter rating
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

// Metodos gettter y setter image    
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
       
    
}
