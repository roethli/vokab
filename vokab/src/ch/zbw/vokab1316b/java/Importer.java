package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import ch.zbw.vokab1316b.java.Card;
import ch.zbw.vokab1316b.java.List;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * This class implements importing Vocubalary-Lists as arraylist from a file containing marshalled Vocaulary objects encoded in XML.
 * For unmarshalling JAXB is used. 
 * 
 * @author Habib Ben Abdelbaki, ZbW
 * @version 1.0 19.02.2015
 */

public class Importer {
	/**
	 * Imports Vocabulary objects from a file
	 * 
	 * @param file instance of <a href="http://docs.oracle.com/javase/7/docs/api/java/io/File.html">File</a> 
	 * @return arraylist containing Vocabulary objects
	 */
	public ArrayList<Card> importFromFile(File file) {
		List vl = new List();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(List.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			vl = (List) jaxbUnmarshaller.unmarshal(file);
			//System.out.println(vl.getVocabularylist().get(0).getBackside());
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}

		return vl.getVocabularylist();
	}

}
