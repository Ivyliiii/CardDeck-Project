package JavaCW;

import java.util.Scanner;

public class DeckTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deck deck = new Deck(52);
		while (true) {
			System.out.println("Type 'sort', 'shuffle', 'first', 'random', or 'quit'");
			String choice = in.next();
			switch (choice) {
			case ("sort"):
				deck.sort();
				System.out.println(deck);
				break;
			case("shuffle"):
				deck.shuffle();
				System.out.println(deck);
				break;
			case("first"): 
				System.out.println("Enter how many cards you want from the top");
				int n = in.nextInt();
				for (card c: deck.getFirstN(n))
					System.out.print(c);
				break;
			case("random"):
				System.out.println(deck.getRandom());
				break;
			case("quit"):
				return;
			}
		}
	}
}
