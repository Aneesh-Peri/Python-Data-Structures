// Name:   
// Date:
 
import java.util.*;
import java.io.*;
 
/* Resource classes and interfaces
 * for use with Graphs3: EdgeList,
 *              Graphs4: DFS-BFS
 *          and Graphs5: EdgeListCities
 */
 
/**************** Graphs 3: EdgeList *****/
interface VertexInterface
{
   public String getName();
   public HashSet<Vertex> getAdjacencies();
   
   /*
     postcondition: if the set already contains a vertex with the same name, the vertex v is not added
                    because adjacencies is a HashSet, this method should operate in O(1)
   */
   public void addAdjacent(Vertex v);
   /*
     postcondition:  returns as a string one vertex with its adjacencies, without commas.
                     for example, D [C A]
     */
   public String toString(); 
 
} 
 
/*************************************************************/
class Vertex implements VertexInterface, Comparable<Vertex> //2 vertexes are equal if and only if they have the same name
{
   private final String name;
   private HashSet<Vertex> adjacencies = new HashSet<Vertex>();
  /* enter your code here  */
   public Vertex(String nam)
   {
      name=nam;
   }
   public String toString()
   {   
      String accumulate=name+" [";
    
      for(Vertex v: adjacencies)
      {
         accumulate+=v.name + " ";
      
      }
      if(accumulate.charAt(accumulate.length()-1) == ' ')
      {
         accumulate = accumulate.substring(0,accumulate.length()-1);
      }
    
      return accumulate+"]";
    
   }
  
   public String getName()
   {
      return name;
   }
   public HashSet<Vertex> getAdjacencies()
   {
      return adjacencies;
   }
   public void addAdjacent(Vertex v)
   {   
      if(!adjacencies.contains(v))
         adjacencies.add(v);
   }
   public boolean equals(Object obj)
   {
      if(obj instanceof Vertex)
      {
         return name.equals(((Vertex)obj).getName());
      }
      return false;
   }
   public int compareTo(Vertex other)
   {
      return name.compareTo(other.getName());
   }
   public int hashCode()
   {
      return name.hashCode();
   }
}   
 
/*************************************************************/
interface AdjListInterface 
{
   public Set<Vertex> getVertices();
   public Vertex getVertex(String vName);
   public Map<String, Vertex> getVertexMap();  //this is just for codepost testing
   
   /*      
      postcondition: if a Vertex with the name v exists, then the map is unchanged.
                     addVertex should work in O(log n)
   */
   public void addVertex(String vName);
   
   /*
      precondition:  both Vertexes, source and target, are already stored in the graph.
      postcondition:  addEdge should work in O(log n)
   */
   public void addEdge(String source, String target); 
   
   /*
       returns the whole graph as one string, e.g.:
       A [C]
       B [A]
       C [C D]
       D [C A]
     */
   public String toString(); 
 
}
 
  
/********************** Graphs 4: DFS and BFS *****/
interface DFS_BFS
{
   public String depthFirstSearch(String name);
   public String breadthFirstSearch(String name);
   /*   extra credit  */
   // public String depthFirstRecur(String name);
//    public List<Vertex> depthFirstRecurHelper(Vertex v, List<Vertex> reachable);
}
 
/****************** Graphs 5: Edgelist with Cities *****/
interface EdgeListWithCities
{
   public void readData(String cities, String edges) throws FileNotFoundException;
   public int edgeCount();
   public int vertexCount();
   public boolean isReachable(String source, String target);
   public boolean isStronglyConnected(); //return true if every vertex is reachable from every 
                                          //other vertex, otherwise false 
}
 
 
/*************  start the Adjacency-List graph  *********/
public class AdjList implements AdjListInterface,   DFS_BFS, EdgeListWithCities
{
   //we want our map to be ordered alphabetically by vertex name
   private Map<String, Vertex> vertexMap = new TreeMap<String, Vertex>();
      
   /* constructor is not needed because of the instantiation above */
  
   /* enter your code here  */
   public Set<Vertex> getVertices()
   {
      Set<Vertex> set = new HashSet<Vertex>();
      for(String s: vertexMap.keySet())
      {
         set.add(vertexMap.get(s));
      }
      return set;
   }
   public Vertex getVertex(String vName)
   {
      return vertexMap.get(vName);
   }
   public Map<String, Vertex> getVertexMap()
   {
      return vertexMap;
   }
   public void addVertex(String vName)
   {
      vertexMap.put(vName,new Vertex(vName));
   }
   public void addEdge(String source,String target)
   {
      Vertex vert = vertexMap.get(source);
      vert.addAdjacent(vertexMap.get(target));
   }
   public String toString()
   {  
      String accumulate = "";
      for(String s: vertexMap.keySet())
      {  
         
         accumulate += vertexMap.get(s) + "\n";
         
      }
      return accumulate;
   }
   public String depthFirstSearch(String name)
   {
      String finalString = "";
      Stack<Vertex> stk = new Stack<>();
      List<Vertex> lst = new ArrayList<>();
      Set<Vertex> visited = new HashSet<>();
       
      stk.push(vertexMap.get(name));
      while (!stk.isEmpty())
      {
         Vertex val = stk.pop();
         if (!visited.contains(val))
         {
            visited.add(val);
            lst.add(val);
            for (Vertex vertex : val.getAdjacencies())
            {
               if (!visited.contains(vertex))
               {
                  stk.push(vertex);
               }
            }
         }
      }
       
      for (Vertex v : lst)
      {
         finalString += v.getName() + " ";
      }
       
      return finalString;   
   }
    
   public String breadthFirstSearch(String name)
   {  
      String finalString = "";
      Queue<Vertex> que = new LinkedList<>();
      List<Vertex> lst = new ArrayList<>();
      Set<Vertex> visited = new HashSet<>();
       
      que.add(vertexMap.get(name));
      while (!que.isEmpty())
      {
         Vertex val = que.remove();
         if (!visited.contains(val))
         {
            visited.add(val);
            lst.add(val);
            for (Vertex vertex : val.getAdjacencies())
            {
               if (!visited.contains(vertex))
               {
                  que.add(vertex);
               }
            }
         }
      }
       
      for (Vertex v : lst)
      {
         finalString += v.getName() + " ";
      }
       
      return finalString;   
   
   }
   
   public void readData(String cities, String edges) throws FileNotFoundException
   {
      Scanner cityInfile = new Scanner(new File(cities));
      while(cityInfile.hasNext())
      {  
         String cityName = cityInfile.next();
         vertexMap.put(cityName, new Vertex(cityName));
      }
      Scanner edgeInfile = new Scanner(new File(edges));
      while(edgeInfile.hasNext())
      {  
         String from = edgeInfile.next();
         String to = edgeInfile.next();
         getVertex(from).addAdjacent(getVertex(to));
      }
   }
   public int edgeCount()
   {
      int c = 0;
      for(String city: vertexMap.keySet())
      {
         c += getVertex(city).getAdjacencies().size();
      }
      return c;
   }
   public int vertexCount()
   {
      return vertexMap.keySet().size();
   }
   public boolean isReachable(String source, String target)
   {
      return depthFirstSearch(source).contains(target);
   }
   public boolean isStronglyConnected()
   {
      for(String city: vertexMap.keySet())
      {
         for(String target: vertexMap.keySet())
         {
            if(!isReachable(city,target))
            {
               return false;
            }
         }
      }
      return true;
   }
   
}