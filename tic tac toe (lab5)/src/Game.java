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
		Data  data = new Data();
		 HumanPlayer player = new HumanPlayer();
		 AiPlayer Aiplayer = new AiPlayer();
		 Board board = new Board();
		
		 
		 data.FileInitialization();
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
		{
			System.out.println(letter + " Winner!   (enter ~ to start new game)");
			if(letter=='O')
			   {
				DataFields.state[1][Data.current_player_id]++;
				DataFields.state[0][0]++;
			   }
			else
				DataFields.state[0][Data.current_player_id]++;
		}
		else 
			{
			System.out.println( " Tie!  (enter ~ to start new game)");
			DataFields.state[2][Data.current_player_id]++;
			DataFields.state[2][0]++;
			}
		
		
		if(Game.scanner.next().charAt(0)=='~')
		    	Initialization();
		else 
		    {
			 Game.Game_running = false;
			 Data data =new Data();
			 data.sort();
			   Game.scanner.close();
			}
		
	}
	
	
	
	
}