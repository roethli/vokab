package ch.zbw.vokab1316b.java;

public class DaniTestMainClass {

	public static void main(String[] args) {
		//Testclass for class VokabLogic
		
		VokabLogic testlogic = new VokabLogic();
		
		//Add card (Frontside, Backside, Category)
		testlogic.addCard("Hallo", "hello", 1);
		testlogic.addCard("Hund", "dog", 1);
		testlogic.addCard("Nein", "no", 1);
		testlogic.addCard("Ja", "yes", 1);
		testlogic.moveCard("Hallo", true);
		System.out.println(testlogic.showNextCard(0));
		System.out.println(testlogic.showNextCard(1));
		System.out.println(testlogic.showNextCard(2));
		
/*		//Show backside of Card "Hallo" and "Hund"
		System.out.println(testlogic.showCardBackside("Hallo"));
		System.out.println(testlogic.showCardBackside("Hund"));
		
		
		//Show frontside of Card "Hello" and "Dog"
		System.out.println(testlogic.showCardFrontside("hello"));
		System.out.println(testlogic.showCardFrontside("dog"));*/
		
	}

}
