package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import ch.zbw.vokab1316b.java.Card;
import ch.zbw.vokab1316b.java.List;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Diese Klasse implementiert das Importieren von Vocabulary-Listen aus einer Datei, welche als XML kodierte,
 * serialisierte Vocabulary-Objekte enthält.
 * Für die Deserialisierung wird JAXB verwendet.
 *
 * @author Habib Ben Abdelbaki, ZbW
 * @version 1.0 19.02.2015
 */

public class Importer {
	/**
	 * Importiert Vocabulary-Objekte aus einer Datei
	 * 
	 * @param Datei-Instanz der Klasse <a href="http://docs.oracle.com/javase/7/docs/api/java/io/File.html">File</a> 
	 * @return ArrayList, welche Vocabulary-Objekte enthält
	 */
	public ArrayList<Card> importFromFile(File file) {
		List vl = new List();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(List.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			vl = (List) jaxbUnmarshaller.unmarshal(file);
			System.out.println(vl.getVocabularylist().get(0).getBack());
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}

		return vl.getVocabularylist();
	}

}
