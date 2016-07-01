package eexpoforms.test;

import java.util.Date;
import java.util.List;

public class BlogPostEntity {
	
	
	public enum Status{
		draft, deleted, published, hided
	}
	
	public int id;
	public String title;
	public String content;
	public Date createDate;
	public Integer authorId;
	
	public Status meuStatus;
	public List<Integer> catList;
	public List<String> tagList;
	public boolean archived;
	
	
	

}
