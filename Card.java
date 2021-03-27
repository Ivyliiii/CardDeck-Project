package JavaCW;


public class Card {
	private String suit;
	private int num;
	
	public Card(String suit, int num) {
		this.suit = suit;
		this.num = num;
	}
	
	public int getnum(){
		return num;
	}
	
	public String getsuit() {
		return suit;
	}
	
	public String toString() {
		return num + ", " + suit;
	}
	
}
