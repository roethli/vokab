package ch.zbw.vokab1316b.java;

public class DaniTestMainClass {

	public static void main(String[] args) {
		//Testclass for class VokabLogic
		
		VokabLogic testlogic = new VokabLogic();
		
		//Add card (Frontside, Backside, Category)
		testlogic.addCard("Hallo", "hello", 3);
		testlogic.addCard("Hund", "dog", 2);
		testlogic.addCard("Hund", "dog", 4);
		testlogic.addCard("Katze", "cat", 2);
		testlogic.addCard("Frosch", "frog", 3);
		testlogic.addCard("Mutter", "mother", 3);
		testlogic.addCard("Vater", "father", 1);
		testlogic.addCard("Stuhl", "Chair", 1);
	
		testlogic.addCard("Ja", "yes", 5);
	
		System.out.println(testlogic.cardLogicByRandom());
		
		
//		Show backside of Card "Hallo" and "Hund"
		
//		System.out.println(testlogic.showCardBackside("Hund"));
//		System.out.println(testlogic.showNextCard( "Nein"));
		//System.out.println(testlogic.showCardBackside("Hund"));
		
		
		//Show frontside of Card "Hello" and "Dog"
		//System.out.println(testlogic.showCardFrontside("hello"));
		//System.out.println(testlogic.showCardFrontside("dog"));
		
	}

}
