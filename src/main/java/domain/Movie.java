package domain;

import java.util.List;

public class Movie{
	
	private int id;
	private String title;
	private String production;
	private int releaseYear;
	private int boxOffice;
	private List <Comment> comments;
	private List <Integer> rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getBoxOffice() {
		return boxOffice;
	}
	public void setBoxOffice(int boxOffice) {
		this.boxOffice = boxOffice;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public int AverageRating(){
		
		if(rating == null){
			
			return 0;
		}
		
		int avg = 0;
		
		for(int value : rating){
			
			avg += value;
		}
		
		avg /= rating.size();
		
		return avg;
	}
}