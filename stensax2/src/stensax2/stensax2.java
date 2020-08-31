package stensax2;

import java.util.Random;
import java.util.Scanner;

public class stensax2 {

	private static final int sten = 1; // deklaration av Globala variabler som alla metoder kan anv�nda
	private static final int sax = 2;
	private static final int pase = 3;

	static int uScore = 0;
	static int cScore = 0;

	public static void main(String[] args) {

		boolean gameTrue = true;

		while (gameTrue) {
			System.out.println(":::::STEN SAX P�SE:::::");
			System.out.println("V�lj din motst�ndare Dator: Knappa D");
			System.out.println("V�lj din motst�ndare Player2: Knappa P");

			Scanner input = new Scanner(System.in);
			char knapp = input.next().charAt(0); // Scanner att skanna f�rsta alfabet p� plats 0

			switch (knapp) {

			case 'd': // case d n�r anv�ndaren v�ljer att spela med datorn

				System.out.println("DU HAR VALT ATT SPELA MOT DATORN");

				int i;
				for (i = 1; i <= 3; i++) {
					System.out.println("\n" + "V�lj Sten: 1");
					System.out.println("V�lj Sax:  2");
					System.out.println("V�lj P�se: 3");

					Scanner in0 = new Scanner(System.in);
					int userInput0 = in0.nextInt();
					if (userInput0 > 3 || userInput0 < 1) // Om anv�ndaren knapper fel siffra d� avbryts loop och visas
															// slutliga po�ng
					{
						System.out.print("Invalid input SORRY!!");
						break;
					}

					System.out.println("Du valde:" + userInput0);

					Random randc = new Random();
					int computer = randc.nextInt(3) + 1; // Datorn v�ljer fr�n 0 d�rf�r l�gger jag +1
					System.out.println("Dator valde:" + computer);

					tavling(computer, userInput0); // Anv�nder metod tavling f�r att framkalla slutliga resultat
				}

				System.out.println("\n" + "DINA PO�NG: " + uScore);
				System.out.println("\n" + "DATORN�S PO�NG: " + cScore);
				if (uScore > cScore) {
					System.out.println("\n" + "::::DU VANN! GRATTIS!::::");
				} else if (uScore == cScore) {
					System.out.println("\n" + "\t" + "::::INGEN VINNARE!::::"); // Slutliga j�mf�relse av po�ng och
																				// resultat visning
				} else {
					System.out.println("\n" + "\t" + "::::DATORN VANN!::::");
				}
				gameTrue = false;
				break;

			case 'p': // case P n�r anv�ndaren v�ljer att spela med en annan spelare

				System.out.println("DU HAR VALT ATT SPELA MOT PLAYER2");

				int j;
				for (j = 1; j <= 3; j++) { // Loop f�r att spela 3 g�nger
					System.out.println("\n" + "V�lj Sten: 1");
					System.out.println("V�lj Sax:  2");
					System.out.println("V�lj P�se: 3");

					Scanner in1 = new Scanner(System.in);
					int userInput1 = in1.nextInt();
					if (userInput1 > 3 || userInput1 < 1) // Om anv�ndaren knapper fel siffra d� avbryts loop och visas
															// slutliga po�ng
					{
						System.out.print("Invalid input SORRY!!");
						break;
					}
					System.out.println("Player1 valde:" + userInput1);

					Scanner in2 = new Scanner(System.in);
					int userInput2 = in2.nextInt();
					if (userInput2 > 3 || userInput2 < 1) // Inmatning fr�n Player 2
					{
						System.out.print("Invalid input SORRY!!");
						break;
					}

					System.out.println("Player2 valde:" + userInput2);

					tavling(userInput2, userInput1);
				}
				System.out.println("\n" + "PLAYER1 PO�NG: " + uScore);
				System.out.println("\n" + "PLAYER2 PO�NG: " + cScore);
				if (uScore > cScore) {
					System.out.println("\n" + "::::PLAYE 1 VANN! GRATTIS!::::");
				} else if (uScore == cScore) {
					System.out.println("\n" + "\t" + "::::INGEN VINNARE!::::"); // Slutliga j�mf�relse av po�ng och
																				// resultat visning
				} else {
					System.out.println("\n" + "\t" + "::::PLAYER 2 VANN! GRATTIS!::::");
				}

				gameTrue = false;
				break;

			default: {
				System.out.println("V�lj r�tt igen"); // default case : Om anv�ndaren kanpper fel bokstav loopen b�rjar
														// om tills anv�ndaren knappar r�tt bokstav
				gameTrue = true;

			}
			}
		}

	}

	public static void tavling(int computer, int userInput) { // metod f�r att avg�ra resultat av knappval i spelet
		if (computer == userInput) {

			cScore = 0; // Om anv�ndaren och dator/player v�ljer lika po�ng f�r b�da stannar p� 0
			uScore = 0;

		} else if ((userInput == sten && computer == sax) || (userInput == sax && computer == pase)
				|| (userInput == pase && computer == sten)) { // alla scenario n�r anv�ndaren vinner och anv�ndarens
																// po�ng h�js

			uScore++;
		} else { // om datorn/player2 har r�tt d� h�js upp bara datorn's po�ng

			cScore++;
		}
	}

}
