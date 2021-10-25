
public class Board extends Game
{

	public char player='X',opponent='O';
	public static char [][] board = new char [3][3]; 
	
	
	
	public  void BoardInitialization()
	{
	   make_board();
		print_board();
	   
	   
	}

	private  void make_board()
	{
		for(int i =0;i<3;i++)
			for(int j =0;j<3;j++)
			   board[i][j]= ' ';	
		
	}
	private  void print_board()
	{
		for(int i =0;i<3;i++)
			{
			for(int j =0;j<3;j++)
				System.out.print("|"+board[i][j]+"|");
			 System.out.println();
			}
			
				
	}
	public  boolean make_move(int number,char letter)
	{
		
		int row = number/3 ;
		int col= number%3; 
		
	  
		
		if(board[row][col]==' ')
			{
			board[row][col] = letter;
		    print_board();
		     if(checkWinner()==10||checkWinner()==-10)
		         {
		           current_winner(letter);
		          
		          }
		     else if(checkWinner()==0)
		    	 current_winner('=');
		     return true;
		 	
			}
		return false;
		
	}
	public int OpenSpots()
	{
		 int openSpots = 0;
		  for (int i = 0; i < 3; i++) 
		  {
		    for (int j = 0; j < 3; j++)
		    {
		      if (board[i][j] == ' ') 
		        openSpots++;
		    }
		  }
		      return openSpots;
	}
	
	
	
	public int checkWinner()
	{
		  char winner = 'd';
		  char[][]b= board;
		
		  for (int row = 0; row<3; row++)
		    {
		        if (b[row][0]==b[row][1] &&
		            b[row][1]==b[row][2])
		        {
		            winner = b[row][0];
		        }
		    }
		 
		  
		    for (int col = 0; col<3; col++)
		    {
		        if (b[0][col]==b[1][col] &&
		            b[1][col]==b[2][col])
		        {
		        	 winner =b[0][col];
		        }
		    }
		 
		 
		    if (b[0][0]==b[1][1] && b[1][1]==b[2][2])
		    {
		    	 winner =b[0][0];
		    }
		 
		    if (b[0][2]==b[1][1] && b[1][1]==b[2][0])
		    {
		    	 winner =b[0][2];
		    }

		  int openSpots = 0;
		  for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		      if (board[i][j] == ' ') {
		        openSpots++;
		      }
		    }
		  }

		  if (winner == 'd' && openSpots == 0) {
		    winner= 't';
		  } 
		  if(winner=='X')
				 return -10;
			 if(winner=='O')
				 return 10;
			 if(winner=='t')
				 return 0;
			 return -1;
		}
	
	
	
}
