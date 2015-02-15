package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import java.io.File;
import ch.zbw.vokab1316b.java.Vocabulary;
import ch.zbw.vokab1316b.java.VokabList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Exporter {

	public void exportToFile(ArrayList<Vocabulary> arrList, File file) {
		Vocabulary voc = new Vocabulary("Book", "Buch", 3);

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
