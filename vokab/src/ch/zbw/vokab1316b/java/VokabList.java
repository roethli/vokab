package ch.zbw.vokab1316b.java;

import ch.zbw.vokab1316b.java.Vocabulary;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class VokabList {

	private ArrayList<Vocabulary> vocabularylist; // Arraylist for the words
	
	public VokabList() {
		
	}

	@XmlElement
	public ArrayList<Vocabulary> getVocabularylist() {
		return vocabularylist;
	}

	public void setVocabularylist(ArrayList<Vocabulary> vocabularylist) {
		this.vocabularylist = vocabularylist;
	}
}
