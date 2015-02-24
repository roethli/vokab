package ch.zbw.vokab1316b.java;

import ch.zbw.vokab1316b.java.Card;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Sole purpose of this class is to act as a sort of wrapper for a vocabulary list. 
 * Since we need to have a single and unique root element when marshalling to XML, 
 * this class acts as one.
 * 
 * @author Habib Ben Abdelbaki, ZbW
 * @version 1.0 19.02.2015
 */


@XmlRootElement
public class List {

	private ArrayList<Card> vocabularylist; // Arraylist for the words

	public List() {
		
	}

	@XmlElement
	public ArrayList<Card> getVocabularylist() {
		return vocabularylist;
	}

	public void setVocabularylist(ArrayList<Card> vocabularylist) {
		this.vocabularylist = vocabularylist;
	}
}