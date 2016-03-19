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
import javax.websocket.Session;

import model.Deck;
import model.Player;
import model.Card;
/**
 * Servlet implementation class War_Game
 */
@WebServlet(
		description = "A servlet to control our War card game", 
		urlPatterns = { "/War_Game", "/doBattle", "/doTie","/doTieBreak"

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
private Deck p1WarDeck, p2WarDeck;



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
			session.setAttribute("p1WarDeck", p1WarDeck);
			session.setAttribute("p2WarDeck", p2WarDeck);
			isWar = false;

		}
		else

		{

		
			
			//System.out.println("Normal game");
			if(this.player1.isGameWinner() || this.player2.isGameWinner())
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
				this.player2.setGameWinner(true);
				url = "/Final.jsp";
				session.setAttribute("winner",this.player2.getName());
			}
			else if( this.player2.getDeck().getCardsLeft() ==0 ){
				//System.out.println("P1 won");
				this.player1.setGameWinner(true);
				url = "/Final.jsp";
				session.setAttribute("winner", this.player1.getName());
			}
			else{
				//System.out.println("continue..");
				playCard();
				url="/Battle.jsp";
			}

		}
		
		if(this.player1.isDealWinner())
			session.setAttribute("winner",this.player1.getName());
		else if(this.player2.isDealWinner())
			session.setAttribute("winner",this.player2.getName());
		else
			session.setAttribute("winner", "No one");
		// setting the session attribute 
		session.setAttribute("player1Name", this.player1.getName());
		session.setAttribute("player1Score", this.player1.getScore());
		//System.out.println(this.player1.getName()+ ":"+player1CurrentCard);
		session.setAttribute("player1Card", player1CurrentCard);



		session.setAttribute("player2Name", this.player2.getName());
		session.setAttribute("player2Score", this.player2.getScore());
		//System.out.println(this.player2.getName()+":"+player2CurrentCard);
		session.setAttribute("player2Card", player2CurrentCard);

		session.setAttribute("isWar", isWar);
		session.setAttribute("player1CardsLeft", this.player1.getDeck().getCardsLeft());
		session.setAttribute("player2CardsLeft", this.player2.getDeck().getCardsLeft());


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
		this.player1.setDealWinner(false);
		this.player2.setDealWinner(false);
		this.player1.setGameWinner(false);
		this.player2.setGameWinner(false);
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


		}
	}
}


