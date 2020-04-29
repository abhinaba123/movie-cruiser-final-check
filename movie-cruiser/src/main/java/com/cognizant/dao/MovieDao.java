package com.cognizant.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.model.Movie;


@Component
public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(Movie movie);

	public Movie getMovie(long movieId);
}
