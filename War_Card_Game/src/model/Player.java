package model;

import java.io.Serializable;

public class Player implements Serializable  {
	private Deck deck;
	private int score;
	private String name;
	private boolean dealWinner;
	private boolean gameWinner;
	
	public Player(String name){
		setScore (0);
		this.name=name;
		deck = new Deck();
		setDealWinner(false);
		setGameWinner(false);
	}

	public Player (Deck deck){
		this.deck=deck;
		
	}
	
	public void addDeck(Deck deck){
	this.deck =deck;
	System.out.println("Player1: "+deck.toString()+" size:"+deck.getCardsLeft());
	System.out.println("Player2: "+deck.toString()+" size:"+deck.getCardsLeft());
	}
	

	public void addtoDeck(Card card){
		System.out.println(this.getName() + "'s deck added:" +card.getValue());
	this.deck.addCard(card);
	}
	
	public void clearDeck()
	{
		this.deck = new Deck();
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public boolean isGameWinner() {
		return gameWinner;
	}

	public void setGameWinner(boolean gameWinner) {
		this.gameWinner = gameWinner;
	}

	public boolean isDealWinner() {
		return dealWinner;
	}

	public void setDealWinner(boolean dealWinner) {
		this.dealWinner = dealWinner;
	}



	
	
	
	
	
}
