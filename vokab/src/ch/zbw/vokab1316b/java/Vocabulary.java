package ch.zbw.vokab1316b.java;

/*
 * 
 * @Author Daniel Röthlisberger ZbW
 * @Version 1.0 02.02.2015
 * 
 * 
 */

public class Vocabulary {
	
	//variabe frontside of a voc. card
	private String frontside;
	//variable backside of a voc. card
	private String backside;
	//variable category of a voc. card
	private int category;
	
	private int faults;
	private int sucesses;

	public Vocabulary(String frontside, String backside, int category) {
		//declare variable frontside
		this.frontside = frontside;
		//declare variable backside
		this.backside = backside;
		//declare variable category
		this.category = category;
		
		this.faults = 0;
		
		this.sucesses = 0;
	}

	public int getFaults() {
		return faults;
	}

	public void setFaults(int faults) {
		this.faults = faults;
	}

	public int getSucesses() {
		return sucesses;
	}

	public void setSucesses(int sucesses) {
		this.sucesses = sucesses;
	}

	/*
	 * @return frontside String of a vocabulary card
	 */
	public String getFrontside() {
		return frontside;
	}

	/*
	 * set frontside String of a vocabulary card
	 */

	public void setFrontside(String frontside) {
		this.frontside = frontside;
	}

	/*
	 * @return String of a vocabulary card
	 */
	public String getBackside() {
		return backside;
	}

	/*
	 * set backside String of a vocabulary card
	 */
	public void setBackside(String backside) {
		this.backside = backside;
	}

	/*
	 * @return int of the category of a vocabulary card
	 */
	public int getCategory() {
		return category;
	}

	/*
	 * set category of a vocabulary card
	 */
	public void setCategory(int category) {
		this.category = category;
	}

}
