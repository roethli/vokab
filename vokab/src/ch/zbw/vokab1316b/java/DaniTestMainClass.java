package ch.zbw.vokab1316b.java;

public class DaniTestMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VokabLogic testlogic = new VokabLogic();
		testlogic.addCard("Hallo", "Hello", 1);
		testlogic.addCard("Deine Mutter", "your mother", 1);
		testlogic.showCardSolution("Hallo");
		testlogic.showCardSolution("Deine Mutter");
		testlogic.showCardFrontside("Hello");
		
		
		
	}

}
