package stensax2;

import java.util.Random;
import java.util.Scanner;

public class stensax2 {

	private static final int sten = 1; // deklaration av Globala variabler som alla metoder kan använda
	private static final int sax = 2;
	private static final int pase = 3;

	static int uScore = 0;
	static int cScore = 0;

	public static void main(String[] args) {

		boolean gameTrue = true;

		while (gameTrue) {
			System.out.println(":::::STEN SAX PÅSE:::::");
			System.out.println("Välj din motståndare Dator: Knappa D");
			System.out.println("Välj din motståndare Player2: Knappa P");

			Scanner input = new Scanner(System.in);
			char knapp = input.next().charAt(0); // Scanner att skanna första alfabet på plats 0

			switch (knapp) {

			case 'd': // case d när användaren väljer att spela med datorn

				System.out.println("DU HAR VALT ATT SPELA MOT DATORN");

				int i;
				for (i = 1; i <= 3; i++) {
					System.out.println("\n" + "Välj Sten: 1");
					System.out.println("Välj Sax:  2");
					System.out.println("Välj Påse: 3");

					Scanner in0 = new Scanner(System.in);
					int userInput0 = in0.nextInt();
					if (userInput0 > 3 || userInput0 < 1) // Om användaren knapper fel siffra då avbryts loop och visas
															// slutliga poäng
					{
						System.out.print("Invalid input SORRY!!");
						break;
					}

					System.out.println("Du valde:" + userInput0);

					Random randc = new Random();
					int computer = randc.nextInt(3) + 1; // Datorn väljer från 0 därför lägger jag +1
					System.out.println("Dator valde:" + computer);

					tavling(computer, userInput0); // Använder metod tavling för att framkalla slutliga resultat
				}

				System.out.println("\n" + "DINA POÄNG: " + uScore);
				System.out.println("\n" + "DATORN´S POÄNG: " + cScore);
				if (uScore > cScore) {
					System.out.println("\n" + "::::DU VANN! GRATTIS!::::");
				} else if (uScore == cScore) {
					System.out.println("\n" + "\t" + "::::INGEN VINNARE!::::"); // Slutliga jämförelse av poäng och
																				// resultat visning
				} else {
					System.out.println("\n" + "\t" + "::::DATORN VANN!::::");
				}
				gameTrue = false;
				break;

			case 'p': // case P när användaren väljer att spela med en annan spelare

				System.out.println("DU HAR VALT ATT SPELA MOT PLAYER2");

				int j;
				for (j = 1; j <= 3; j++) { // Loop för att spela 3 gånger
					System.out.println("\n" + "Välj Sten: 1");
					System.out.println("Välj Sax:  2");
					System.out.println("Välj Påse: 3");

					Scanner in1 = new Scanner(System.in);
					int userInput1 = in1.nextInt();
					if (userInput1 > 3 || userInput1 < 1) // Om användaren knapper fel siffra då avbryts loop och visas
															// slutliga poäng
					{
						System.out.print("Invalid input SORRY!!");
						break;
					}
					System.out.println("Player1 valde:" + userInput1);

					Scanner in2 = new Scanner(System.in);
					int userInput2 = in2.nextInt();
					if (userInput2 > 3 || userInput2 < 1) // Inmatning från Player 2
					{
						System.out.print("Invalid input SORRY!!");
						break;
					}

					System.out.println("Player2 valde:" + userInput2);

					tavling(userInput2, userInput1);
				}
				System.out.println("\n" + "PLAYER1 POÄNG: " + uScore);
				System.out.println("\n" + "PLAYER2 POÄNG: " + cScore);
				if (uScore > cScore) {
					System.out.println("\n" + "::::PLAYE 1 VANN! GRATTIS!::::");
				} else if (uScore == cScore) {
					System.out.println("\n" + "\t" + "::::INGEN VINNARE!::::"); // Slutliga jämförelse av poäng och
																				// resultat visning
				} else {
					System.out.println("\n" + "\t" + "::::PLAYER 2 VANN! GRATTIS!::::");
				}

				gameTrue = false;
				break;

			default: {
				System.out.println("Välj rätt igen"); // default case : Om användaren kanpper fel bokstav loopen börjar
														// om tills användaren knappar rätt bokstav
				gameTrue = true;

			}
			}
		}

	}

	public static void tavling(int computer, int userInput) { // metod för att avgöra resultat av knappval i spelet
		if (computer == userInput) {

			cScore = 0; // Om användaren och dator/player väljer lika poäng för båda stannar på 0
			uScore = 0;

		} else if ((userInput == sten && computer == sax) || (userInput == sax && computer == pase)
				|| (userInput == pase && computer == sten)) { // alla scenario när användaren vinner och användarens
																// poäng höjs

			uScore++;
		} else { // om datorn/player2 har rätt då höjs upp bara datorn's poäng

			cScore++;
		}
	}

}
