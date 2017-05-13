package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Comment;
import domain.Movie;
import domain.services.MovieService;

@Path("/movies")
public class CommentResources{
	
	private MovieService db = new MovieService();
	
	@GET
	@Path("/{id}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public List <Comment> getComment(@PathParam("id") int id){
		
		Movie result = db.getMovieById(id);
		
		if(result == null){
			
			return null;
		}
		
		return result.getComments();
	}
	
	@POST
	@Path("/{id}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("id") int id, Comment comment){
		
		Movie result = db.getMovieById(id);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		
		if(result.getComments() == null){
			
			result.setComments(new ArrayList <Comment>());
		}
		
		comment.setId(++Comment.currentId);
		result.getComments().add(comment);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{idMovie}/comments/{idComment}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showCommentById(@PathParam("idMovie") int idMovie, @PathParam("idComment") int idComment){
		
		Comment result = db.getCommentById(idMovie, idComment);
		
		if(result == null) return Response.status(404).build();
		
		return Response.ok(result).build();
	}
	
	@DELETE
	@Path("/{idMovie}/comments/{idComment}")
	public Response deleteComment(@PathParam("idMovie") int idMovie, @PathParam("idComment") int idComment){
		
		Comment result = db.getCommentById(idMovie, idComment);
		
		if(result == null){
			
			return Response.status(404).build();
		}
		
		db.getMovieById(idMovie).getComments().remove(result);
		return Response.ok().build();
	}
}