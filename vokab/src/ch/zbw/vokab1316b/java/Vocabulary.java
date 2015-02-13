package ch.zbw.vokab1316b.java;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * 
 * @Author Daniel R�thlisberger ZbW
 * @Version 1.0 02.02.2015
 * 
 * 
 */

@XmlRootElement
public class Vocabulary {
	
	//variabe frontside of a voc. card
	private String frontside;
	//variable backside of a voc. card
	private String backside;
	//variable category of a voc. card
	private int category;
	
	private int cardFaults;
	private int cardSucesses;

	/*
	 * constructor with no parameter needed for XML-marshalling
	 */
	public Vocabulary() {
		
	}
	
	
	public Vocabulary(String frontside, String backside, int category) {
		//declare variable frontside
		this.frontside = frontside;
		//declare variable backside
		this.backside = backside;
		//declare variable category
		this.category = category;
		
		this.cardFaults = 0;		
		this.cardSucesses = 0;
	}

	@XmlElement
	public int getCardFaults() {
		return cardFaults;
	}

	public void setCardFaults() {
		int temp_CardFaults = this.cardFaults;
		this.cardFaults = temp_CardFaults+1;
	}
	@XmlElement
	public int getCardSucesses() {
		return cardSucesses;
	}

	public void setCardSucesses() {
		int temp_CardSuccess = this.cardSucesses;
		this.cardSucesses = temp_CardSuccess +1;
	}

	/*
	 * @return frontside String of a vocabulary card
	 */
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
