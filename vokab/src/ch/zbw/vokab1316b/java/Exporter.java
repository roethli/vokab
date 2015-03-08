package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import java.io.File;
import ch.zbw.vokab1316b.java.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Diese Klasse implementiert das Exportieren von Vocabulary-Listen, welche als ArrayList übergeben werden.
 * Die einzelnen Vocabulary-Objekte werden serialisiert, in XML kodiert und in eine Datei gespeichert.
 * Für das Marshalling wird JAXB verwendet.
 *
 * @author Habib Ben Abdelbaki, ZbW
 * @version 1.0 19.02.2015
 */

public class Exporter {
	/**
	 * Exportiert Vocabulary-Objekte aus einer Datei
	 * 
	 * @param Datei-Instanz der Klasse <a href="http://docs.oracle.com/javase/7/docs/api/java/io/File.html">File</a> 
	 * @param ArrayList, welche Vocabulary-Objekte enthält
	 */

	public void exportToFile(ArrayList<Card> arrList, File file) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(List.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			List vl = new List();
			vl.setCard(arrList);

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(vl, file);
			jaxbMarshaller.marshal(vl, System.out);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
