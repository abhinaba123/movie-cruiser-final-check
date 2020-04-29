package com.cognizant.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.model.Movie;
import com.cognizant.util.DateUtil;


@Component
public class MovieDaoCollectionImpl implements MovieDao{
	private static List<Movie> movieList;
	


	@Override
	public List<Movie> getMovieListAdmin() {
			
			if(movieList==null)
			{
			ApplicationContext ctx = new
	             ClassPathXmlApplicationContext("spring-config.xml");
			
			movieList = (List<Movie>) ctx.getBean("movies");
			}
			return movieList;

		
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> customerMovieList = new ArrayList<Movie>();

		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = movieList.get(i);
			if ((movie.getDateOfLaunch().equals(new Date()) 
					|| movie.getDateOfLaunch().before(new Date())) && movie.isActive()) {
				customerMovieList.add(movie);
			}
		}

		return customerMovieList;
	}

	@Override
	public void modifyMovie(Movie movie) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).equals(movie)) {
				movieList.set(i, movie);
				break;
			}
		}
	}

	@Override
	public Movie getMovie(long movieId) {
		Movie movie = null;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movie = movieList.get(i);
				break;
			}
		}
		return movie;
	}

}
