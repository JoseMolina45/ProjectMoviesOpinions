/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mali.movies.repository;

import com.mali.movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jose Maria
 */
public interface MovieRepository extends JpaRepository<Movie, Long>{
    
}
