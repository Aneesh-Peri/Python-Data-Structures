// Name:   Date:

public class MatrixRecreate
{
   public static void main(String[] args)
   {
      int[][] matrix = TheMatrix.create();
      int[] rowcount = new int[matrix.length];
      int[] colcount = new int[matrix[0].length];
      TheMatrix.count(matrix, rowcount, colcount);
      int[][] new_matrix = TheMatrix.getRecreatedMatrix();
      TheMatrix.re_create(rowcount, colcount);
      if( new_matrix == null )
         System.out.println("Did not find a match.");
      else
         TheMatrix.display( new_matrix, rowcount, colcount );
   }
}
class TheMatrix
{
	//do not instantiate recreatedMatrix yet. Only instantiate and set that in recur.
   private static int[][] recreatedMatrix = null;
   
   public static int[][] getRecreatedMatrix()
   {
      return recreatedMatrix;
   }
   public static int[][] create()
   {
      int rows = 2 + (int)(Math.random() * 5);
      int cols = 2 + (int)(Math.random() * 5);
      int[][] matrix = new int[rows][cols];
      for(int i = 0; i < rows;i++)
      {
        for(int j = 0; j< cols; j++)
        {
          matrix[i][j] = (int)(Math.random()*2);
        }
      }
     return matrix;
   }
   public static void count(int[][] matrix, int[] rowcount, int[] colcount)
   {
     for(int r = 0; r < matrix.length; r++)
     {
       for(int c = 0; c < matrix[0].length; c++)
       {
         if(matrix[r][c]==1)
         {
           rowcount[r] +=1;
           colcount[c] += 1;
         }
       }
     }

   }
   public static void display(int[][] matrix, int[] rowcount, int[] colcount)
   {
      
   }
   public static void re_create(int[] orig_rowcount, int[] orig_colcount)
   {
      int[][] new_matrix = new int[orig_rowcount.length][orig_colcount.length];	
      recur(new_matrix, orig_rowcount, orig_colcount, 0, 0);
   }
   private static void recur(int[][] new_matrix, int[] orig_rowcount, int[] orig_colcount, int row, int col)
   {
      if(compare(new_matrix, orig_rowcount, orig_colcount))    //base case: if new_matrix works, then copy over to recreatedMatrix
      {
      	//copy over from new_matrix to recreatedMatrix (not just references)
         recreatedMatrix = new int[new_matrix.length][];
         for(int i = 0; i < new_matrix.length; i++)
         {
            recreatedMatrix[i] = new int[new_matrix[i].length];
            for (int j = 0; j < new_matrix[i].length; j++)
            {
               recreatedMatrix[i][j] = new_matrix[i][j];
            }
         }           //we've found it!
      }
   	//ENTER YOUR PERMUTATION CODE HERE            
     
   }
   private static boolean compare(int[][] new_matrix, int[] orig_rowcount, int[] orig_colcount)
   {  
      
      return false;
   }
}
