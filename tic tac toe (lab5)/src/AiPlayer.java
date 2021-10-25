import java.util.concurrent.ThreadLocalRandom;


public class AiPlayer implements Player
{
	
	Board boardObject =new Board();
	
	
	
	 @Override 
		public  int get_move()
		{
		
		 System.out.println("enemy turn:");
		 
		 if(boardObject.OpenSpots()==9)
			 return ThreadLocalRandom.current().nextInt(0, 9);
		
		 return findBestMove(Board.board);
		 
		 
		}
	
	private int minimax(char [][]board,int depth,boolean isMax)
	{
		 int score =  boardObject.checkWinner();
		 if(score!=-1)
			 return score;      
	    if (isMax)
	    {
	       int bestVal = Integer.MIN_VALUE ;
	       for (int i = 0; i<3; i++)
	        {
	            for (int j = 0; j<3; j++)
	            {     
	                if (board[i][j]==' ')
	                {
	                    board[i][j] = boardObject.opponent;
	                    int mov= minimax(board, depth+1, false);
	                    board[i][j] = ' ';
	                    bestVal =Math.max( bestVal,mov) ;         
	        	  }
	          }
	        }
	          return bestVal;
	    }

	    else 
	    {
	        int bestVal= Integer.MAX_VALUE ;
	       
	        for (int i = 0; i<3; i++)
	        {
	            for (int j = 0; j<3; j++)
	            {            
	                if (board[i][j]==' ')
	                {
	                    board[i][j] = boardObject.player;
	                    int mov= minimax(board, depth+1, true);
	                     board[i][j] = ' ';
	                    bestVal =Math.min( bestVal,mov) ;       
	        	  }
	          }
	        }

	        return bestVal;
	    }
	}
	private int findBestMove(char board[][])
	 {
	     int bestVal = Integer.MIN_VALUE,row=0,col=0;
	    
       for (int i = 0; i<3; i++)
	     {
	         for (int j = 0; j<3; j++)
	         {
	             
	             if (board[i][j]==' ')
	             {                
	                 board[i][j] = boardObject.opponent;       
	                   int moveVal = minimax(board, 0, false);   
	                 board[i][j] = ' ';  
	                 if (moveVal > bestVal)
	                 {
	                     row=i;
	                     col=j;
	                     bestVal = moveVal;
	                     
	                 }
	             }
	         }
  
	     }
	    return (row*3+col);
	 }
}
