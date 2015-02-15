package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import ch.zbw.vokab1316b.java.Vocabulary;
import ch.zbw.vokab1316b.java.VokabList;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Importer {

	public ArrayList<Vocabulary> importFromFile(File file) {
		VokabList vl = new VokabList();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(VokabList.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			vl = (VokabList) jaxbUnmarshaller.unmarshal(file);
			//System.out.println(vl.getVocabularylist().get(0).getBackside());
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}

		return vl.getVocabularylist();
	}

}
