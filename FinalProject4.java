package CodeStructure4;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;

public class FinalProject4 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		
		
		
		
		FileQueue<String> queue = new FileQueue<String>(null);
		Valid<String> queueValid = new Valid<String>(null);
		Invalid<String> queueInvalid = new Invalid<String>(null);
		Solved<String> queueSolved = new Solved<String>(null);
		//created all the used queues
		
		
		File file = new File("/Users/garrettbaker/eclipse-workspace/FinalProject/sampleIn.txt");
		

		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine())
		{
			queue.push(scan.nextLine()); //takes the lnes from the file and add them to a standard queue
		}
		
		while(queue.front != null)
		{
			
				int parentheses = 0;  //I use these number as a strategy to see if the problem is valid
				int integers = 0;
				int operators = 0;
				String prob = queue.pop();
				char[] ch1 = prob.toCharArray();  //changes the string into a character array to be used
				for(int i = 0; i < ch1.length; i++)
				{
					if(ch1[i] == '(' )  //for every opening parentheses I add 1 and every closing one I
					{                   //subtract 1.  If they're even they should equal 0
						parentheses++;
					}
					else if(ch1[i] == ')')
					{
						parentheses--;
					}
					if(ch1[i] >= '0' && ch1[i] <= '9')
					{
						integers++;
					}
					if(ch1[i] == '+')  //takes the number of integer and number of "operators",
					{				   //the number of integers should be one more than the operators
						operators++;
					}
					else if(ch1[i] == '-')
					{
						operators++;
					}
				}
				if(parentheses != 0)
				{
					prob = prob + "Invalid";
					queueInvalid.push(prob);
					
				}
				else if(operators != (integers - 1))
				{
					prob = prob + "Invalid"; //adds invalid so at the end we know which one are invalid
					queueInvalid.push(prob);
					
				}
				else
				{
					queueValid.push(prob);
					
				}
			
			
		}
		
		while(queueValid.front != null)
		{
			
			int sum = 0;
			String prob = queueValid.pop();
			int integerNumber = Integer.parseInt(prob);  //takes the string and turns it into an integer
			sum = integerNumber;
			prob = prob + "=" + sum;  //the new string is the old string with the sum added to the end
			queueSolved.push(prob);
					
		}
		
		File writeFile = new File("/iCloud Drive/Desktop/sampleOut.txt");
		
		
		try 
		{
			PrintWriter pw = new PrintWriter(writeFile);
		 
			
			while(queueSolved.front != null)
			{
				
				String prob = queueSolved.pop(); //takes each line of the solved queue and writes to the new file
				try
				{
					pw.println(prob);
				}
				catch(Exception e)
				{
					
				}
			}
			while(queueInvalid.front != null)//put the Invalid after to separate the solved problems
			{								 //from the invalid problems
				String prob = queueInvalid.pop();
				try
				{
					pw.println(prob);
				}
				catch(Exception e)
				{
					
				}
			}
			
			pw.close();
			
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("No such file found.");
		}
		catch(IOException e)
		{
			System.out.print("The File Writer Broke.");
		}
		
		//validity(queue, queueValid, queueInvalid);
		//solve(queueValid, queueSolved);
		//write(queueSolved, queueInvalid, "/iCloud Drive/Desktop/sampleOut.txt");
	}
	
	
	
	//ALL OF THESE MASS COMMENTS IS WHAT MY CODE WOULD LOOK LIKE
	//DUE TO ME TRYING TO GET THIS TO WORK FOR SO LONG I DECIDED TO WRITE IT IN A SIMPLER
	//FORM ABOVE


	
	
	
	
	
	/*
	public static void validity(FileQueue<String> queue, Valid<String> queueValid, Invalid<String> queueInvalid)
	{
		
		while(queue.front != null)
		{
			
				int parentheses = 0;
				int integers = 0;
				int operators = 0;
				String prob = queue.pop();
				char[] ch1 = prob.toCharArray();
				for(int i = 0; i < ch1.length; i++)
				{
					if(ch1[i] == '(' )
					{
						parentheses++;
					}
					else if(ch1[i] == ')')
					{
						parentheses--;
					}
					if(ch1[i] >= '0' && ch1[i] <= '9')
					{
						integers++;
					}
					if(ch1[i] == '+')
					{
						operators++;
					}
					else if(ch1[i] == '-')
					{
						operators++;
					}
				}
				if(parentheses != 0)
				{
					prob = prob + "Invalid";
					queueInvalid.push(prob);
					
				}
				else if(operators != (integers - 1))
				{
					prob = prob + "Invalid";
					queueInvalid.push(prob);
					
				}
				else
				{
					queueValid.push(prob);
					
				}
			
			
		}
			
	}
	*/	
	/*
	public static void solve(Valid<String> queueValid, Solved<String> queueSolved)
	{
			while(queueValid.front != null)
			{
				
				int sum = 0;
				String prob = queueValid.pop();
				int integerNumber = Integer.parseInt(prob);
				sum = integerNumber;
				prob = prob + "=" + sum;
				queueSolved.push(prob);
						
			}
			
			
	}
	*/
	/*	
	public static void write(Solved<String> queueSolved,Invalid<String> queueInvalid, String newFileName)
	{
			File writeFile = new File(newFileName);
			
			
			try 
			{
				PrintWriter pw = new PrintWriter(writeFile);
			 
				
				while(queueSolved.front != null)
				{
					
					String prob = queueSolved.pop();
					try
					{
						pw.println(prob);
					}
					catch(Exception e)
					{
						
					}
				}
				while(queueInvalid.front != null)
				{
					String prob = queueInvalid.pop();
					try
					{
						pw.println(prob);
					}
					catch(Exception e)
					{
						
					}
				}
				
				pw.close();
				
			}
			catch (FileNotFoundException e) 
			{
				System.out.println("No such file found.");
			}
			catch(IOException e)
			{
				System.out.print("The File Writer Broke.");
			}
	}
		*/
		
		

	

}
