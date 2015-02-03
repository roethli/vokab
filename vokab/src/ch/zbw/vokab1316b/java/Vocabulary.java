package ch.zbw.vokab1316b.java;

public class Vocabulary {

	private String frontside;
	private String backside;
	private int category;
	
	public Vocabulary(String frontside, String backside, int category) {
		
		this.frontside = frontside;
		this.backside = backside;
		this.category = category;
	}

	public String getFrontside() {
		return frontside;
	}

	public void setFrontside(String frontside) {
		this.frontside = frontside;
	}

	public String getBackside() {
		return backside;
	}

	public void setBackside(String backside) {
		this.backside = backside;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	
	
	
	
}
