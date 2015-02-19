package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import java.io.File;
import ch.zbw.vokab1316b.java.VokabList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * This class implements exporting Vocubalary-Lists stored in an arraylist to a file encoded and serialized as XML.
 * For marshalling JAXB is used. 
 * 
 * @author Habib Ben Abdelbaki, ZbW
 * @version 1.0 19.02.2015
 */

public class Exporter {
	/**
	 * Exports Vocabulary objects to a file
	 * 
	 * @param file instance of <a href="http://docs.oracle.com/javase/7/docs/api/java/io/File.html">File</a> 
	 * @param arraylist containing Vocabulary objects
	 */

	public void exportToFile(ArrayList<Vocabulary> arrList, File file) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(VokabList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			VokabList vl = new VokabList();
			vl.setVocabularylist(arrList);
			
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(vl, file);
			jaxbMarshaller.marshal(vl, System.out);

		}
		catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
