package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Deck;
import model.Player;
import model.Card;
/**
 * Servlet implementation class War_Game
 */
@WebServlet(
		description = "A servlet to control our War card game", 
		urlPatterns = { "/War_Game", "/doBattle" 
	
       })
public class War_Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

public Player player1,player2 = null;
public Deck initialDeck;
private boolean isWar = false;
private boolean tieBreaker = false;

private Card player1CurrentCard, player2CurrentCard;
private Card p1WarCard1,p1WarCard2,p1WarCard3,p1WarCard4;
private Card p2WarCard1,p2WarCard2,p2WarCard3,p2WarCard4;

	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public War_Game() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{ 
      
    }
    	
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// creating the session	
				 HttpSession session = request.getSession();

		String url = null;
		if(player1==null)
			
		{ 
			
		//System.out.println("New game");
		// getting player name input 
		
		String player1name =request.getParameter("player1");
		String player2name = request.getParameter("player2");

		this.player1 = new Player(player1name);
		this.player2 = new Player(player2name);
		initialDeck = new Deck();
		deal();	
	}

		if(isWar)
		{
		//	System.out.println("Tie Breaker");
			url = "/TieBreak.jsp";
			playCard();
			//session.setAttribute("player1Card", player1CurrentCard);
			session.setAttribute("p1WarCard1", p1WarCard1);
			session.setAttribute("p1WarCard2", p1WarCard2);
			session.setAttribute("p1WarCard3", p1WarCard3);
			session.setAttribute("p1WarCard4", p1WarCard4);
			
			//session.setAttribute("player2Card", player2CurrentCard);
			session.setAttribute("p2WarCard1", p2WarCard1);
			session.setAttribute("p2WarCard2", p2WarCard2);
			session.setAttribute("p2WarCard3", p2WarCard3);
			session.setAttribute("p2WarCard4", p2WarCard4);
			
			isWar = false;
		}
		else

		{
			//System.out.println("Normal game");
		if(this.player1.isWinner() || this.player2.isWinner())
		{
			//System.out.println("Play Again");
			deal();
		}
		else
		{
			//System.out.println("Continue current game");
			
		}
		
		// play cards
		//System.out.println("Player not null");
		if(this.player1.getDeck().getCardsLeft() == 0 )
		{
		//	System.out.println("P2 won");
			this.player2.setWinner(true);
			url = "/Final.jsp";
			session.setAttribute("winner", this.player2.getName());
		}
		else if( this.player2.getDeck().getCardsLeft() ==0 ){
			//System.out.println("P1 won");
			this.player1.setWinner(true);
			url = "/Final.jsp";
			session.setAttribute("winner", this.player1.getName());
		}
		else{
			//System.out.println("continue..");
			playCard();
			url="/Battle.jsp";
		}
	
		}
		
		// setting the session attribute 
		session.setAttribute("player1Name", this.player1.getName());
		session.setAttribute("player1Score", this.player1.getScore());
			//System.out.println(this.player1.getName()+ ":"+player1CurrentCard);
			session.setAttribute("player1Card", player1CurrentCard);
		
		
	
		session.setAttribute("player2Name", this.player2.getName());
		session.setAttribute("player2Score", this.player2.getScore());
			//System.out.println(this.player2.getName()+":"+player2CurrentCard);
			session.setAttribute("player2Card", player2CurrentCard);
		
	

		 // send control to the next component 
       RequestDispatcher dispatcher = request.getRequestDispatcher(url); 
      dispatcher.forward(request, response); 
	
		
	}
	
	private void deal()
	{
		// System.out.println("deal");
		//initialDeck.newDeck();
		//initialDeck.shuffleDeck();
		initialDeck.stackDeck();
		this.player1.setWinner(false);
		this.player2.setWinner(false);
		this.player1.setScore(0);
		this.player2.setScore(0);
		this.player1.clearDeck();
		this.player2.clearDeck();
		while(initialDeck.getCardsLeft()>0)
		{
		this.player1.addtoDeck(initialDeck.removeCard(0));
		this.player2.addtoDeck(initialDeck.removeCard(0));
		}
	}
	
//playcard
	
		
	private void playCard(){
		if(isWar)
		{
			//war game
			p1WarCard1=this.player1.getDeck().removeCard(0);
			p1WarCard2=this.player1.getDeck().removeCard(0);
			p1WarCard3=this.player1.getDeck().removeCard(0);
			p1WarCard4=this.player1.getDeck().removeCard(0);
			
			p2WarCard1=this.player2.getDeck().removeCard(0);
			p2WarCard2=this.player2.getDeck().removeCard(0);
			p2WarCard3=this.player2.getDeck().removeCard(0);
			p2WarCard4=this.player2.getDeck().removeCard(0);
			
			// winning logic
			if(p1WarCard4.getValue()>p2WarCard4.getValue()){
				
			//add cards 
				this.player1.getDeck().addCard(player1CurrentCard);
				this.player1.getDeck().addCard(p1WarCard1);
				this.player1.getDeck().addCard(p1WarCard2);
				this.player1.getDeck().addCard(p1WarCard3);
				this.player1.getDeck().addCard(p1WarCard4);
				
				this.player1.getDeck().addCard(player2CurrentCard);
				this.player1.getDeck().addCard(p2WarCard1);
				this.player1.getDeck().addCard(p2WarCard2);
				this.player1.getDeck().addCard(p2WarCard3);
				this.player1.getDeck().addCard(p2WarCard4);
				
				this.player1.setScore(this.player1.getScore()+10);
			}
			else
				if(p1WarCard4.getValue()<p2WarCard4.getValue()){
					
					//tie game add cards
					this.player2.getDeck().addCard(player2CurrentCard);
					this.player2.getDeck().addCard(p2WarCard1);
					this.player2.getDeck().addCard(p2WarCard2);
					this.player2.getDeck().addCard(p2WarCard3);
					this.player2.getDeck().addCard(p2WarCard4);
					
					this.player2.getDeck().addCard(player1CurrentCard);
					this.player2.getDeck().addCard(p1WarCard1);
					this.player2.getDeck().addCard(p1WarCard2);
					this.player2.getDeck().addCard(p1WarCard3);
					this.player2.getDeck().addCard(p1WarCard4);
					
			}
				else{
					
	// tie logic
					if(p1WarCard4.getValue()==p2WarCard4.getValue()){
					 isWar = false;
					 this.player1.getDeck().addCard(player2CurrentCard);
						this.player1.getDeck().addCard(p2WarCard1);
						this.player1.getDeck().addCard(p2WarCard2);
						this.player1.getDeck().addCard(p2WarCard3);
						this.player1.getDeck().addCard(p2WarCard4);
						
						this.player2.getDeck().addCard(player1CurrentCard);
						this.player2.getDeck().addCard(p1WarCard1);
						this.player2.getDeck().addCard(p1WarCard2);
						this.player2.getDeck().addCard(p1WarCard3);
						this.player2.getDeck().addCard(p1WarCard4);
					 
					}
		}
	}
		
		//normal game
		else{
			player1CurrentCard = this.player1.getDeck().removeCard(0);
		    player2CurrentCard = this.player2.getDeck().removeCard(0);
		 // winning logic
			if(player1CurrentCard.getValue()>player2CurrentCard.getValue()){

		// normal game add cards
				this.player1.getDeck().addCard(player1CurrentCard);
				this.player1.getDeck().addCard(player2CurrentCard);
				this.player1.setScore(this.player1.getScore()+2);
			}
			else
				if(player1CurrentCard.getValue()<player2CurrentCard.getValue()){
					//winner 
					this.player2.getDeck().addCard(player1CurrentCard);
					this.player2.getDeck().addCard(player2CurrentCard);
					this.player2.setScore(this.player2.getScore()+2);
			}
				else{
					
	// tie logic
					if(player1CurrentCard.getValue()==player2CurrentCard.getValue()){
						//winner 
					 isWar = true;
}
		}
		
		//System.out.println("playing");
	    
	}
}
}


