
import java.io.*;
import java.io.IOException;
import java.util.Scanner; 


public class Data
{
	
	public static int current_player_id;
	
	private static File file = new File("data.txt"); 
	
	private static boolean authorization_done =false;
	private int player_amount =0;
	public void FileInitialization()
    {
    	
		
		try {	
    		if (!file.exists()) 
    		 {
    			file.createNewFile();
    			System.out.println("LeaderBoard created"); 	
    		 }
    		} 
    	catch (IOException error) 
    	{
    		System.out.println("An error occurred.");
    		return;
    	}
		
    	 if(!authorization_done)
    		 Authorization();
    	 else
    		 {
    		 sort();
    		 PrintLeaderBoard();
    		 }
    }
    private  void write()
    {

    	try {
    		FileWriter fileWriter = new FileWriter(file);
    		BufferedWriter bw = new BufferedWriter(fileWriter);
    		int i=0;
    		
    		while( DataFields.players[i]!=null)
    		{
    		  bw.write(DataFields.players[i]); 
    		  for(int j=0;j<3;j++)
    		  bw.write(" "+DataFields.state[j][i]);
    	     	bw.newLine();
    		  i++;
    		}
    		
    		
    				bw.close();
    	    }
    	catch(IOException error)
    	{
    	    return;	
    	}
    	
    }
    private  void Read()
    {
    	try {	
    		 Scanner file_scanner = new Scanner(file);
    	     	
    		   int i=0;
    		   while(file_scanner.hasNext()&&i<DataFields.max-1)
   	     	{	 
    			   DataFields.players[i] = file_scanner.next();
    			   for(int j=0;j<3;j++)   
    			if(file_scanner.hasNextInt())  DataFields.state[j][i] = file_scanner.nextInt(); 
    				  i++;
    			  player_amount =i;
    		  }
    		   file_scanner.close();
        	}
    	catch(IOException error)
    	{
    	    return;	
    	}
    }
   
    private void Authorization() 
    {
    	System.out.println("Authorization: (enter your nickname)");
    	 String nickname=null;
    	 nickname = Game.scanner.next(); 
    	   Read(); 
    	   DataFields.players[0]="Ai";
    	 
     		for(int i=0;i<DataFields.max-1;i++)
     		{
     			
     			if(DataFields.players[i]==null)
     			{
     				DataFields.players[i]=nickname;
     				 current_player_id =i;
     				System.out.println("welcome! new player)");
     				break;
     			}
     			
     			else if( DataFields.players[i].equals(nickname))
     				{
     				System.out.println("authorization done!");  
     				current_player_id =i;
     				    break;
     				}
     		
     			
     		}
     		authorization_done=true;
            sort(); 
         	PrintLeaderBoard();
    }
    private void PrintLeaderBoard()
    {
    	try {
    		FileReader fileReader = new FileReader(file);
    		BufferedReader br = new BufferedReader(fileReader);
    		System.out.println("LeaderBoard:"); 	  
    		 int i=0;  
    		while(br.ready())
    		  {
    			 i++;
    			System.out.println(i+":  "+br.readLine());
    		  }
    		  
    		  br.close();
    	
        	}
    	catch(IOException error)
    	{
    	    return;	
    	}
    	
    }
  
    public  void sort()
    {
    	int []sort= new int[player_amount];
    	 for (int i = 0; i < player_amount; i++)
			sort[i]=(2*DataFields.state[0][i])+DataFields.state[1][i]+(2*DataFields.state[2][i]);
		
		int n = player_amount;
	    for (int i = 0; i < n-1; i++)
	        for (int j = 0; j < n-i-1; j++)
	            if (sort[j] < sort[j+1]) 
	            {
	                int temp = sort[j];
	                sort[j] = sort[j+1];
	                sort[j+1] = temp;
	                change_index(j,j+1);
	            }
		
		write();
    }
    
    
    
    private void change_index(int from,int to)
    {
    	String casheS = DataFields.players[from];
    	DataFields.players[from] = DataFields.players[to];
    	DataFields.players[to]=casheS;
		for(int i=0;i<3;i++)
		{
			int cashe = DataFields.state[i][from];
			DataFields.state[i][from]=DataFields.state[i][to];;
		 DataFields.state[i][to] = cashe;
		}
			  
    }
  
	
}