package com.cognizant.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MovieRepository;
import com.cognizant.dao.MovieDao;
import com.cognizant.model.Movie;

@Service
public class MovieService {
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	MovieRepository movieRepository;
	

	@Transactional
	public List<Movie> getMovieListAdmin()
	{
		
		/* List<Movie> movies = movieDao.getMovieListAdmin();
		 
		 for(Movie m :movies)
		 {
			 movieRepository.save(m);
		 }*/
		 
		 List<Movie> list = movieRepository.findAll();
		 return list;
		
	}
	
	
	@Transactional
	public List<Movie> getMovieListCustomer()
	{
		return movieRepository.findByActiveAndDateOfLaunchBefore(true, new Date());
	}

	
	@Transactional
	public Movie getMovieById(long i) {
		
		return movieRepository.findById(i).get();
		
	}

	
	@Transactional
	public void modifyMovie(Movie m) {
		Movie movie = movieRepository.findById(m.getId()).get();
		
		movie.setTitle(m.getTitle());
		movie.setHasTeaser(m.isHasTeaser());
		movie.setGenre(m.getGenre());
		movie.setDateOfLaunch(m.getDateOfLaunch());
		movie.setBoxOffice(m.getBoxOffice());
		movie.setActive(m.isActive());
		
		movieRepository.save(movie);
		
	}

}
