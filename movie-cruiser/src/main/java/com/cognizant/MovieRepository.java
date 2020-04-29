package com.cognizant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Movie;



@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

	public List<Movie> findByActiveAndDateOfLaunchBefore(Boolean x,java.util.Date date);
}
