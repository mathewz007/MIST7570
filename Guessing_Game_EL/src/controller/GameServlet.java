 package controller; 

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;



import model.GameNumber; 
import model.Message; 

/** 
 * Servlet implementation class GameServlet 
 */ 
@WebServlet( 
                description = "A servlet to control our simple guessing game", 
                urlPatterns = { "/GameServlet", "/doGuess"},
                initParams ={ 
                        @WebInitParam(name= "guesses", value = "1", description= "initial guess"), 
                        @WebInitParam(name= "minimum", value = "0", description= "minimum value"), 
                        @WebInitParam(name= "maximum", value = "10", description= "maximum value"), 
                        
        }
                ) 
public class GameServlet extends HttpServlet { 
        private static final long serialVersionUID = 1L; 
        
        private GameNumber guesses; 
        private int minimum; 
        private int maximum; 
        private GameNumber target; 
private Message msg; 
        
        
        
    /** 
     * @see HttpServlet#HttpServlet() 
     */ 
    public GameServlet() { 
        super(); 
        // TODO Auto-generated constructor stub 
    } 
    
    // 
    
    
    public void init(ServletConfig config) throws ServletException{ 
            int tempGuesses =Integer.parseInt(config.getInitParameter("guesses")); 
            this.minimum =Integer.parseInt(config.getInitParameter("minimum")); 
            this.maximum =Integer.parseInt(config.getInitParameter("maximum")); 
            this.guesses = new GameNumber(tempGuesses); 
            target = new GameNumber(); 
            // calling gameNumber target 
            target.setRandom(minimum,maximum); 
             } 
    
    

        /** 
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
         */ 
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
                this.doPost(request, response); 
                
                
        } 

        /** 
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
         */ 
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
                
                // get input - target, guess, number of guesses, minimum and maximum 
                GameNumber guess = new GameNumber(Integer.parseInt(request.getParameter("guess")));
         
     
                    HttpSession session = request.getSession(); 
                 // get session values
                 if( session.getAttribute("guesses") == null )
                     guesses = new GameNumber(1);                          
 
    msg=(Message) session.getAttribute("msg"); 
 
    
 // set up HashMaps
    Map<String, String> est= new HashMap<String,String>();
         est.put("10", "2.5") ;  
         est.put("50", "5") ; 
         est.put("100", "6") ;   
         est.put("500", "8") ;    
         est.put("1000", "9") ; 
         est.put("10000", "11") ; 
         est.put("10000", "12") ; 
 //get map values 
         est = new HashMap<String, String>();
    
    // set session Attributes
    session.setAttribute("target", target); 
        session.setAttribute("minimum", minimum); 
    session.setAttribute("maximum", maximum); 
  session.setAttribute("guesses", guesses);
  session.setAttribute("est", est);              
                // initialize output 
       
            Message msg =new Message("msg"); 
                String url = "/guess.jsp"; 
                
                // compare the guess with the target 
           if(guess.getValue() == target.getValue() ){ 
                   // winner 
                   msg.setMsg("Correct! You got it in "+ guesses.getValue() + " guesses."); 
                   url = "/correct.jsp"; 
                             } else { 
                   // next guess 
                   guesses.increment();
                   if (guess.getValue() < target.getValue() ) { 
                           //low 
                           msg.setMsg("Incorrect guess! Guess higher next time."); 
                   } else { 
                           // high 
                           msg.setMsg("Incorrect guess! Guess lower next time."); 
                   } 
           } 
            
           // setting the msg 
           request.setAttribute("msg", msg); 
        

          
           // send control to the next component 
           RequestDispatcher dispatcher = request.getRequestDispatcher(url); 
           dispatcher.forward(request, response); 
                
          
        } 

} 