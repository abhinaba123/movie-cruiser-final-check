package com.cognizant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Movie;
import com.cognizant.service.MovieService;
import com.cognizant.util.DateUtil;

@SpringBootApplication
public class MovieCruiserApplication {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	private static MovieService movieService;
	
	@Autowired
	public void setMovieService(MovieService movieService)
	{
		this.movieService = movieService;
	}
	
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(MovieCruiserApplication.class, args);
		
	
		System.out.println("Hello WOrld");
	
		testMovieListAdmin();
		testMovieListCustomer();
		testGetMovieById();
		testModifyMovie();
		
	}
	
	public static void testMovieListAdmin()
	{
		LOGGER.info("Start");
		List<Movie> list = movieService.getMovieListAdmin();
		LOGGER.debug("Movie Admin List {}",list);
		LOGGER.info("End");
	}
	public static void testMovieListCustomer()
	{
		LOGGER.info("Start");
		List<Movie> listcus = movieService.getMovieListCustomer();
		LOGGER.debug("Movie Customer List {}",listcus);
		LOGGER.info("End");
	}
	
	public static void testGetMovieById()
	{
		LOGGER.info("Start");
		Movie movie = movieService.getMovieById(3);
		LOGGER.debug("Movie{}",movie);
		LOGGER.info("End");
	}
	
	public static void testModifyMovie()
	{
		LOGGER.info("Start");
		Movie m = new Movie(3,"The Wolverine", "$3,187,463,944",true, 
				DateUtil.convertToDate("07/07/2019"),
				"Superhero", true);
		
		movieService.modifyMovie(m);
		List<Movie> movies = movieService.getMovieListAdmin();
		LOGGER.debug("All Movies{}",movies);
		LOGGER.info("End");
	}

}
