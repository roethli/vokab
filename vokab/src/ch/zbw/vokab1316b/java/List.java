package ch.zbw.vokab1316b.java;

import ch.zbw.vokab1316b.java.Card;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Einziger Sinn und Zweck dieser Klasse ist es eine Vocabulary-Liste zu wrappen.
 * Dies ist nötig, da wir beim Marshalling nach XML ein einziges und eindeutiges
 * Root-Element haben müssen.
 * 
 * @author Habib Ben Abdelbaki, ZbW
 * @version 1.0 19.02.2015
 */


@XmlRootElement
public class List {

	private ArrayList<Card> vocabularylist; // Arraylist für die Karten

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
