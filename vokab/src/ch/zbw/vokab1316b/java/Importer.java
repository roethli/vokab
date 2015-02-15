package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import ch.zbw.vokab1316b.java.Vocabulary;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Importer {

	public ArrayList<Vocabulary> importFromFile(File file) {
		try {

			// File file = new File("file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Vocabulary.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Vocabulary voc = (Vocabulary) jaxbUnmarshaller.unmarshal(file);
			System.out.println(voc.getFrontside() + " " + voc.getBackside());

		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

}
