import java.util.Scanner;

public class Game 
{
	
	public static boolean Game_running=true;
	
	
    static Scanner scanner = new Scanner(System.in);
 
    
	public static void main(String[] args) 
	{ 			
		Initialization();		 
	}
	
	
	public static void  Initialization()
	{
		boolean turn=true;

		 HumanPlayer player = new HumanPlayer();
		 AiPlayer Aiplayer = new AiPlayer();
		 Board board = new Board();
		
		  board.BoardInitialization();    	    
			 turn=player.WhoStart();
		 
		 while(Game_running)
		{
			if(turn)
				board.make_move(player.get_move(),board.player);	
			else		
				board.make_move(Aiplayer.get_move(),board.opponent);
			
			turn=!turn;
		}
		 
	}
	
	public  void  current_winner(char letter)
	{
		if(letter!='=') 
		    System.out.println(letter + " Winner!   (enter ~ to start new game)");
		else 
			System.out.println( " Tie!  (enter ~ to start new game)");
		
		if(Game.scanner.next().charAt(0)=='~')
		    	Initialization();
		else 
		    {
			 Game.Game_running = false;
			   Game.scanner.close();
			}
	}
	
	
	
	
}