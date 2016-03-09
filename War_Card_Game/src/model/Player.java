package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.Deck;

public class Player  extends Deck implements Serializable {
	private String player1;
	private String player2;
	ArrayList<Card>myCard;
	
	
	// default empty constructor
	public Player() {
		
		myCard =new ArrayList<Card>(52);
		
	}
	// constructor with names
	
	public Player(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	// getter and setter methods
	
	/**
	 * @return the player1
	 */
	public String getPlayer1() {
		return player1;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	public String getPlayer2() {
		return player2;
	}

	/**
	 * @param player2 the player2 to set
	 */
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
public void getCard(Card aCard){
	myCard.add(aCard);
}

public Card playCard()
{
	return myCard.remove(0);
}
	public int cardCount(){
		return myCard.size();
	}

}
