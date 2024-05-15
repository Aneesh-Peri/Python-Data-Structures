// Name:
// Date:

import java.util.*;
import java.io.*;


public class MazeGrandMaster
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename (no .txt): ");
      Maze m = new Maze(sc.next()+".txt");  //append the .txt 
      m.display();       
      System.out.println("Options: ");
      System.out.println("1: Length of the shortest path\n\tIf no path exists, say so.");
      System.out.println("2: Length of the shortest path\n\tList the shortest path\n\tDisplay the shortest path\n\tIf no path exists, say so.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
      sc.close();
   } 
}

class Maze
{
   //constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char TEMP = 'o';
   private final char PATH = '*';
   
   //instance fields
   private char[][] maze;
   private int startRow, startCol;
  /** 
	 * Constructor.
    * Creates a "deep copy" of the array.
    * We use this in Codepost. 
	 */
   public Maze(char[][] m)  
   {
      maze = m;
      for(int r = 0; r < maze.length; r++)
      {
         for(int c = 0; c < maze[0].length; c++)
         { 
            if(maze[r][c] == START)      //identify start
            {
               startRow = r;
               startCol = c;
            }
         }
      }
   } 	
  /**
	 * Write this one-arg constructor.
    * Use a try-catch block.
	 * Use next(), not nextLine() 
    * Search the maze to find the location of 'S' 
	 */
   public Maze(String filename)    
   {
      // Setting up a scanner
      Scanner infile = null;
         try
         {
            infile = new Scanner(new File(filename));
         }
         catch (Exception e)
         {
            System.out.println("File not found");
         }
         /* enter your code here */
         String tempString = infile.nextLine();
         String[] tempValues = tempString.trim().split(" ");
         char[][] finalArray = new char[Integer.parseInt(tempValues[0])][Integer.parseInt(tempValues[1])];
         int starterValue = 0;
         while(infile.hasNext())
         {
            finalArray[starterValue] = infile.nextLine().toCharArray();
            starterValue++;
         }
         maze = finalArray;
         for(int r = 0; r < maze.length; r++)
         {
            for(int c = 0; c < maze[0].length; c++)
            {
               if(maze[r][c]==START)
               {
                  startRow = r;
                  startCol = c;
               }
            }
         }
      
   }  
   public char[][] getMaze()
   {
      return maze;
   }   
   public void display()
   {
      if(maze==null) 
         return;
       for (char[] chars : maze) {
           for (int b = 0; b < maze[0].length; b++) {
               System.out.print(chars[b]);
           }
           System.out.println();
       }
      System.out.println();
   }   
   public void solve(int n)
   {
      switch(n)
      {    
         case 1:  
            int shortestPath = findShortestLengthPath(startRow, startCol);
            if( shortestPath < 999 )
               System.out.println("Shortest path is " + shortestPath);
            else
               System.out.println("No path exists."); 
            display();
            break;
         case 2:
            String strShortestPath = findShortestPath(startRow, startCol);
            if( strShortestPath.length()!=0 )
            {
               System.out.println("Shortest length path is: " + getPathLength(strShortestPath));
               System.out.println("Shortest path is: " + strShortestPath);
               markPath(strShortestPath);
               display();  //display solved maze
            }
            else
               System.out.println("No path exists."); 
            break;
         default:
            System.out.println("File not found");   
      }
   }
 /*  MazeGrandMaster 1   
     recur until you find E, then return the shortest path
     returns 999 if it fails
     precondition: Start can't match with Exit
 */ 
   public int findShortestLengthPath(int r, int c)
   {  
      if(r < 0|| r>= maze.length||c < 0|| c>= maze[0].length)
      {
         return 999;
      }
      if(maze[r][c]==EXIT)
      {
         return 0;
      }
      if(maze[r][c]==START||maze[r][c]==DOT)
      {
         char unknown = maze[r][c];
         maze[r][c] = TEMP;
         int leftCheck = 1 + findShortestLengthPath(r, c-1);
         int RightCheck = 1 + findShortestLengthPath(r,c+1);
         int DownCheck = 1 + findShortestLengthPath(r+1, c);
         int UpCheck = 1 + findShortestLengthPath(r-1, c);
         int MinLength = Math.min(RightCheck, Math.min(leftCheck,Math.min(UpCheck,DownCheck)));
         maze[r][c] = unknown;
         return MinLength;
      }
      return 999;
   }  
   /*  MazeGrandMaster 2   
    recur until you find E, then build the path with (r,c) locations
    and the number of steps, e.g. ((5,0),10),((5,1),9),((6,1),8),((6,2),7),
    ((6,3),6),((6,4),5),((6,5),4),((6,6),3),((5,6),2),((4,6),1),((4,7),0)

    as you build, choose the shortest path at each step
    returns empty String if there is no path
    precondition: Start can't match with Exit
 */
   public String findShortestPath(int r, int c)
   {  
      // row/column out of bounds
      if(r<0||r>=maze.length||c<0||c>=maze.length)
      {
         return "";
      }
      // current space is a wall
      if(maze[r][]==WALL)
      {
         return "";
      }
      // current space is the exit
      if(maze[r][c]==EXIT)
      {    
         return "((" + r + "," + c + ")" + "," + 0 + ")";
      }
      // current space is either the start or `-`
      if(maze[r][c]==START||maze[r][c]==DOT)
      {         
         // find the length of each path
         int upPathLen = findShortestLengthPath(r-1, c); // using this function because trying to find the shortest path in this direction
         int downPathLen = findShortestLengthPath(r+1, c); // same thing as above statement but in down direction
         int leftPathLen = findShortestLengthPath(r, c-1); // same thing but going left
         int rightPathLen = findShortestLengthPath(r, c+1); // same thing but going right 
         // variables which are going to help with the recursion by including the row and col coordinates
         int nextRowCoord = r;
         int nextColCoord = c;
         // find the path with the shortest length
         int minValue = Math.min(upPathLen,Math.min(downPathLen,Math.min(leftPathLen,rightPathLen)));        
         // find which path was the shortest, and return the String with that path's length and coordinates
         if(minValue == upPathLen) // `up` path is the shortest
         {
            nextRowCoord = r-1;
            nextColCoord = c;
         }
         else if(minValue == downPathLen) // down path is the shortest
         {
            nextRowCoord = r+1;
            nextColCoord = c;
         }
         else if(minValue == leftPathLen) // if going left is shortest path
         {
            nextRowCoord = r;
            nextColCoord = c-1;
         }
         else if(minValue == rightPathLen) // if going right is the shortest path
         {
            nextRowCoord = r;
            nextColCoord = c+1;
         }       
         // return with the given format
         return ("((" + r + "," + c + ")," +(minValue+1)+ ")," + findShortestPath(nextRowCoord,nextColCoord) ) ;
      }
      return "";
   }	
	/** MazeGrandMaster 2 
       returns the length, i.e., third number when the format of the strPath is 
            "((3,4),10),((3,5),9),..."
       returns 999 if the string is empty
       precondition: strPath is either empty or follows the format above
    */
   public int getPathLength(String strPath)
   {  
      if(strPath=="")
      {
        return 999; 
      }
      else{
         strPath = strPath.replace("(","");
         strPath = strPath.replace(")","");
         String[] lengtharray = strPath.split(",");
         return Integer.parseInt(lengtharray[2]);
      }
   } 

  /** MazeGrandMaster 2 
      recursive method that takes a String created by findShortestPath(r, c)     
      in the form of ((5,0),10),((5,1),9),((6,1),8),((6,2),7),
              ((6,3),6),((6,4),5),((6,5),4),((6,6),3),((5,6),2),((4,6),1),
              ((4,7),0) and marks the actual path in the maze 
      precondition: the String is either an empty String or one that has the format shown above the (r,c) must be correct for this method to work
   */
   public void markPath(String strPath)
   {
      if(strPath.equals(""))
         return;
      else{
         strPath = strPath.replace("(","");
         strPath = strPath.replace(")","");
         String[] lengtharray = strPath.split(",");
         for(int i = 0; i < lengtharray.length;i+=3)
         {          
            int r = Integer.parseInt(lengtharray[i]);
            int c = Integer.parseInt(lengtharray[i+1]);
            if(maze[r][c]==DOT)
            {
               maze[r][c] = PATH;
            }         
         }
      }  
   }
}
/**************************************************************
      ----jGRASP exec: java MazeGrandMaster_teacher
 Enter the maze's filename (no .txt): maze1
 WWWWWWWW
 W....W.W
 WW.W...W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 W......W
 WWWWWWWW

 Options:
 1: Length of the shortest path
 	If no path exists, say so.
 2: Length of the shortest path
 	List the shortest path
 	Display the shortest path
 	If no path exists, say so.
 Please make a selection: 2
 Shortest length path is: 10
 Shortest path is: ((5,0),10),((5,1),9),((6,1),8),((6,2),7),((6,3),6),((6,4),5),((6,5),4),((6,6),3),((5,6),2),((4,6),1),((4,7),0)
 WWWWWWWW
 W....W.W
 WW.W...W
 W....W.W
 W.W.WW*E
 S*W.WW*W
 W******W
 WWWWWWWW


  ----jGRASP: operation complete.

  ******************************************/