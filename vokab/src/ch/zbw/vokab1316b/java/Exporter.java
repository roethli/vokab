package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import ch.zbw.vokab1316b.java.Vocabulary;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class Exporter {
	
	public void exportToFile(ArrayList<Vocabulary> arrList) {
		Vocabulary v = new Vocabulary("Book", "Buch", 3); 
		
		try {
			 JAXBContext jaxbContext = JAXBContext.newInstance(Vocabulary.class);
			 Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
			 // output pretty printed
			 jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
			 //jaxbMarshaller.marshal(v, file);
			 jaxbMarshaller.marshal(v, System.out);
		 
		 }
		 catch (JAXBException e) {
			 e.printStackTrace();
		 }
		 
	}

}
