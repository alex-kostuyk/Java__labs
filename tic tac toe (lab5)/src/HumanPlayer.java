
public class HumanPlayer implements Player
{
	
	Board board =new Board();
	
	
	 @Override
	 
	public  int get_move()
	{
		 System.out.println("your turn:");
	        int num=0;
	        if(Game.scanner.hasNextInt())
	        {
	            num = Game.scanner.nextInt();
	           
	        } 
	        else
	        {
	            System.out.println("incorrect number try again");
	            Game.scanner.next();
	            num = get_move();
	        }
	        
	        
			 if(num>9||num<1)
			  {
				
				 System.out.println("incorrect number try in range 1-9");
				 num=get_move();
			  }
			 else if(!board.make_move(num-1,board.player))
				{
					
					System.out.println(num +" already taken try another number");
					num=get_move();
				}
			     
	        return num-1;
	}
	 
	 public boolean WhoStart()
	 {
		int who =-1;
		 System.out.println("choose who goes first X or O  (enter   1   to make Ai go first)");
		 if(Game.scanner.hasNextInt())
             who = Game.scanner.nextInt();  
		 
		 if(who==1)
		   return false;
		 else 
			 return true;
	 }
}
