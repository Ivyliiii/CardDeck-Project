package JavaCW;
import java.util.Random;

public class Deck {
	private Card[] cards;
	Deck deck;
	
	public Deck(int n) {
		cards = new Card[n];
	}
	
	public void addCard(int index, String suit, int num) {
		
		cards[index] = new Card(suit, num);
	}
	
	public Card getRandom() {
		int rand = (int) (Math.random() * cards.length);
		return cards[rand];
	}
	
	public void shuffle() {
		for(int i = 0; i < cards.length; i++) {
			int rand = (int)(Math.random() * cards.length);
			Card temp = cards[rand];
			cards[rand] = cards[i];
			cards[i] = temp;
		}
	}
	
	public Card[] getFirstN(int n) {
		Card[] tempCards = new Card[n];
		for(int i = 0; i < n; i++) {
			tempCards[i] = cards[i];
		}
		return tempCards;
	}
	
	public String toString() {
		String out = "";
		for(Card c: cards) {
			if(c != null) {
				System.out.println(c.toString());
				out += c.toString();
				out += "  ";
			}
		}
		return out;
	}
	
	public int findSmallest() {
		int smallest = 100;
		for(int i = 0; i < cards.length; i++) {
			if(cards[i] != null) {
				if(cards[i].getnum() < smallest) {
					smallest = cards[i].getnum();
				}
			}
		}
		//System.out.println(smallest);
		return smallest;
	}
	
	public void sort() {
		Card[] tempCards = new Card[cards.length];
		for(int i = 0; i < cards.length; i++) {
			int smallest = findSmallest();
			for(int j = 0; j < cards.length; j++) {
				if(cards[j] != null) {
					if(cards[j].getnum() == smallest) {
						tempCards[i] = cards[j];
						cards[j] = null;
						break;
					}
				}
			}	
		}
		cards = tempCards;
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck(52);
		int count = 0;
		String[] suits = {"clubs", "hearts", "diamonds", "spades"};
		int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < suits.length; j++) {
				deck.addCard(count, suits[j], num[i]);
				count++;
			}
		}
		deck.shuffle();
		System.out.println(deck);
		System.out.println();
		deck.sort();
		System.out.println(deck);
		System.out.println();
		Card[] tempCards = deck.getFirstN(3);
		
		for(int i = 0; i < tempCards.length; i++) {
			System.out.println(tempCards[i]);
		}
		System.out.println();
		System.out.println(deck.getRandom());
	}
}
