package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Movie;
import domain.services.MovieService;

@Path("/movies")
public class MovieResources{
	
	private MovieService db = new MovieService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Movie> showAllMovies(){
		
		return db.getAllMovies();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showMovieById(@PathParam("id") int id){
		
		Movie result = db.getMovieById(id);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddMovie(Movie movie){
		
		db.addMovie(movie);
		return Response.ok(movie.getId()).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateMovie(@PathParam("id") int id, Movie movie){
		
		Movie result = db.getMovieById(id);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		else{
			
			movie.setId(id);
			db.updateMovie(movie);
		}
		
		return Response.ok().build();
	}
}