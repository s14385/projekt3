package domain.services;

import java.util.ArrayList;
import java.util.List;

import domain.Comment;
import domain.Movie;

public class MovieService{
	
	private static List <Movie> db = new ArrayList <Movie> ();
	private static int currentId = 1;
	
	public Movie getMovieById(int id){
		
		for(Movie movie : db){
			
			if(movie.getId() == id){
				
				return movie;
			}
		}
		
		return null;
	}
	
	public void addMovie(Movie movie){
		
		movie.setId(++currentId);
		db.add(movie);
	}
	
	public void updateMovie(Movie movie){
		
		for(Movie m : db){
			
			if(m.getId() == movie.getId()){
				
				m.setBoxOffice(movie.getBoxOffice());
				m.setProduction(movie.getProduction());
				m.setReleaseYear(movie.getReleaseYear());
				m.setTitle(movie.getTitle());
			}
		}
	}
	
	public void deleteMovie(Movie movie){
		
		db.remove(movie);
	}
	
	public List <Movie> getAllMovies(){
		
		return db;
	}
	
	public Comment getCommentById(int idMovie, int idComment){
		
		Movie movie = getMovieById(idMovie);
		
		if(movie == null) return null;
		
		for(Comment comment : movie.getComments()){
			
			if(comment.getId() == idComment) return comment;
		}
		
		return null;
	}
}