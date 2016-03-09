package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Card;
import model.Deck;
import model.Player;

/**
 * Servlet implementation class War_Game
 */
@WebServlet(
		description = "A servlet to control our War card game", 
		urlPatterns = { "/War_Game", "/doBattle" 
	
})
public class War_Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Player player1,player2;
private Card player1Card,player2Card;
ArrayList<Card> player1pile,player2pile;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public War_Game() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{ 
    	
    	String player1= (config.getInitParameter("player1"));
    	String player2=(config.getInitParameter("player2"));
    
    	
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
		
		
		// getting player name input 
		
		String player1 =request.getParameter("player1");
		String player2= request.getParameter("player2");
		
		
		// store names in the Player object 
		
		Player player = new Player(player1,player2);
		
		
		
		
		
		// creating session 
		
		HttpSession session = request.getSession();
		
		// setting the session attribute 
		session.setAttribute("player1", player1);
		session.setAttribute("player2", player2);
		
		//  Creating Game 
		
		//Shuffling deck 
	
		Deck deck = new Deck();
		deck.shuffleDeck();
		
		// adding cards to player 1
		
		 
		
		
		
		
		
	}

}
