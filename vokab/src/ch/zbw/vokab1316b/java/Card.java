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
public class Card {

	// variabe frontside of a voc. card
	private String front;
	// variable backside of a voc. card
	private String back;
	// variable category of a voc. card
	private int category;
	private String langFront;
	private String langBack;
	private int faults;
	private int successful;

	/*
	 * constructor with no parameter needed for XML-marshalling
	 */
	public Card() {

	}

	public Card(String front, String back, int category, String langFront,
			String langBack) {
		// declare variable frontside
		this.front = front;
		// declare variable backside
		this.back = back;
		// declare variable category
		this.category = category;
		this.langBack = langBack;
		this.langFront = langFront;
		this.faults = 0;
		this.successful = 0;
	}

	@XmlElement
	public int getFaults() {
		return faults;
	}

	public void setFaults() {
		int temp_CardFaults = this.faults;
		this.faults = temp_CardFaults + 1;
	}

	@XmlElement
	public int getSuccessful() {
		return successful;
	}

	public void setSuccessful() {
		int temp_CardSuccess = this.successful;
		this.successful = temp_CardSuccess + 1;
	}

	/*
	 * @return frontside String of a vocabulary card
	 */
	@XmlElement
	public String getFront() {
		return front;
	}

	/*
	 * set frontside String of a vocabulary card
	 */

	public void setFront(String front) {
		this.front = front;
	}

	/*
	 * @return String of a vocabulary card
	 */
	@XmlElement
	public String getBack() {
		return back;
	}

	/*
	 * set backside String of a vocabulary card
	 */
	public void setBack(String back) {
		this.back = back;
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

	public String getLangFront() {
		return langFront;
	}

	public void setLangFront(String langFront) {
		this.langFront = langFront;
	}

	public String getLangBack() {
		return langBack;
	}

	public void setLangBack(String langBack) {
		this.langBack = langBack;
	}
	
	

}
