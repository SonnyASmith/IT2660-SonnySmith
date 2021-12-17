/**
 * A class that will be used to create a graph of nodes that contain an integer value.
 * A Vertex Array and Adjacency List will be used to represent the graph.
 * Breadth-First and Depth-First searching methods will be implemented with nodes only
 * being searched once.
 *
 *
 * @author Sonny Smith
 * @version 12/17/21
 */
import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Graph
{
    Listing[] vertices;//The array that contains the vertices which are nodes
    Node[] edges; //The array that contains the linked lists of each vertex's edges
    private int index; //Used to track the current number of vertices
    private int size;//Used to track the maximum number of vertices
    private int popped;
    public Graph(int n) //Constructor
    {
      vertices = new Listing[n]; //Initializes the vertex array
      edges = new Node[n];
      for(int i = 0; i < n; i++) //Initializes the edge array of linked lists with dummy nodes
      {
        edges[i] = new Node();
      }
      index = 0; 
      size = n; 
    }
    
       public class Node //Declares the Node innerclass that will be used to create nodes for the edges of the class
     {               
       private Node nextHop; //The next node in the list.
       private int id; //Used to identify the vertices that edge nodes point to
       private int weight; //Used to store the weight of the edge
 
    
       public Node() //Default constructor for edge dummy node
       {
         this.id = -1;
         this.weight = -1;
         this.nextHop = null;
      
       }
       public Node(int e) //Creates an edge node
       {
         this.id = e;
         this.nextHop = null;
    
       }
       public int getID()
       {
         return this.id;
       }
       public int getWeight()
       {
          return this.weight; 
       }
       
     }

     public void createVert(int value) //Creates a vertex
     {
         
         if(index == size)//Tests if the graph is full
         {
        
             return;   
         }
         else //If the graph is not full then a new vertex is created and added to the vertex array
         {
            vertices[index] = new Listing(value);
            index++; 
         }
         
                 
         
     }
     
     public boolean createEdge(int v1, int v2)//Creates an edge between two vertices to connect them
     {
         if(index == 0) //Checks if the graph is empty
          {
     
             return false;
          }
          else if( ((v1 >= size) || (v1 < 0)) || ((v2 >= size) || (v2 < 0)) ||(v1 == v2) ||  
                   (vertices[v1] == null || vertices[v2] == null)              ) //Checks for invalid inputs
              {
                
                  return false;
              }
          else if(index == 1 || ( (vertices[v1].getConnections() == 5) || vertices[v2].getConnections() == 5) )//Checks if the edges
          {                                                                                                     // can be connected
        
             return false;
          }
          else
          {

                 Node temp = edges[v1];
                 while(temp.nextHop != null) //Searches through the linked list
                 {
                     if(v2 == temp.nextHop.getID() )
                     {
               
                        return false;
                     }
                     else
                     {
                     
                         temp = temp.nextHop;
                     }
                 }
                 temp.nextHop = new Node(v2); //Creates the edge node
                 vertices[v1].addConnection();//Increments the edge counter
                 createEdge(v2, v1, true); //Ensures that the graph is undirected by having connections in both ways for the vertices
     
                  return true;
            
      
                 }

            }
                
     private boolean createEdge(int v1, int v2, boolean alreadyConnected) //Creates edge an edge connection from the 2nd vertex to the 
     {                                                                    // first one so that the graph is undirected
         if(alreadyConnected  == false)
         {
          return false;   
         }
         else
         {
            Node temp = edges[v1];
                 while(temp.nextHop != null) //Searches through the linked list
                 {
                     if(v2 == temp.nextHop.getID() ) 
                     {
          
                        return false;
                     }
                     else
                     {
       
                         temp = temp.nextHop;
                     }
                 }
                 temp.nextHop = new Node(v2); //Creates the edge node
                 vertices[v1].addConnection();//Increments the edge counter
                 temp.nextHop.weight = Math.abs( (v1 % size) - (v2 % size) );

                 return true;   
         }
       
     }
            
            
     public void printVertices() //Outputs all of the vertices in the graph
     {
         if(index == 0)
         {
             System.out.println("The Graph Is Empty!!");
         }
         else
         {
             System.out.println("The graph has: " + index + " vertices which are: ");
             for( int i = 0; i < index; i++)
             {
                System.out.println("Vertex: " + i + " value: " + vertices[i].toString() );
          
             }
         }
     }
     
    public void printEdges()
    {
      
        if(index == 0)
         {
             System.out.println("The Graph Is Empty!!");
         }
         else
         {
            for( int i = 0; i < index; i++)
             {
                 if(edges[i].id == -1 && edges[i].nextHop == null) //If the dummy node has no next hop then there are no edges
                 {
                       System.out.println("Vertex: " + i + " Has No Edges!"); 
                 }
                 else{
                  System.out.println("The Edges Of Vertex: " + i + " Are: ");
                    Node j = edges[i].nextHop;
                   while(j != null)
                  {
                      System.out.println(j.getID() );
                      j = j.nextHop;
                  }
                     }
             }
         }
    }
     

    
    public boolean dfSearch(int targetVert) //Depth-First search that begins its search with a random vertex.
    {
        Random r = new Random();
        int choice = r.nextInt(size);
        int vert = -1; //Initialized to impossible vertex number
        Stack<Integer> stack = new Stack(); //Initiates a stack from the Java stack class
        
        for(int l = 0; l < index; l++) //Resets the pushed states of all the vertices in case a previous search was performed
        {
           vertices[l].setPushed(false);
        }
        popped = 0;//Initializes the popped vertex counter to 0
        
        stack.push(choice); //Adds chosen vertex to the stack
        vertices[choice].setPushed(true);
        System.out.println("Depth-First Search beginning with vertex: " + choice);
        while(!stack.isEmpty() ) //A loop that runs as long as there are vertices on the stack
          {
             vert = stack.pop(); //Pops a vertex from the stack
             popped++;
             System.out.println("Vertex: " + vert + " Value: " + vertices[vert].getValue() );
      
             if(vert == targetVert ) //Compares popped vertices to the target vertex
             {
               System.out.println("Successfully located vertex: " + vert
                                   + " in " + popped + " searches!"     );
               System.out.println("The value of vertex: " + vert + " is: " + vertices[vert].getValue() );
               return true;
             }
             for(int edge = 0; edge < size; edge++)
                {
                  Node j = edges[edge];//
                    while(j.nextHop != null)
                  {
                      if( !vertices[j.nextHop.getID() ].getPushed() ) //Looks for descendent edges that have not been pushed
                      {
                         stack.push(j.nextHop.getID() );
                         vertices[j.nextHop.getID() ].setPushed(true);
                      }
                      j = j.nextHop;
                  } // end nested while

                 } // end for
          } // end while
         
          System.out.println("Vertex: " + targetVert + " not found in " + popped + " searches!" );
          return false; //If target vertex was not found then return false

    }
    
    public boolean bfSearch(int targetVert)
    {
        Random r = new Random();
        int choice = r.nextInt(size);
        int vert = -1; //Initialized to impossible vertex number
        Queue<Integer> queue = new LinkedList<Integer>(); //Initiates a stack from the Java stack class
        
        for(int l = 0; l < index; l++) //Resets the pushed states of all the vertices in case a previous search was performed
        {
           vertices[l].setPushed(false);
        }
        popped = 0;//Initializes the popped vertex counter to 0
        
        queue.add(choice); //Adds chosen vertex to the stack
        vertices[choice].setPushed(true);
        System.out.println("Breadth-First Search beginning with vertex: " + choice);
        while(!queue.isEmpty() ) //A loop that runs as long as there are vertices on the stack
          {
             vert = queue.poll(); //Pops(pulls) a vertex from the queue
             ++popped;
             System.out.println("Vertex: " + vert + " Value: " + vertices[vert].getValue() );
          
             if(vert == targetVert ) //Compares popped vertices to the target vertex
             {
               System.out.println("Successfully located vertex: " + vert
                                   + " in " + popped + " searches!"     );
               System.out.println("The value of vertex: " + vert + " is: " + vertices[vert].getValue() );
               return true;
             }
             for(int edge = 0; edge < size; edge++)
                {
                  Node j = edges[edge];
                    while(j.nextHop != null)
                  {
                      if( !vertices[j.nextHop.getID() ].getPushed() ) //Looks for descendent edges that have not been pushed
                      {
                         queue.add(j.nextHop.getID() );
                         vertices[j.nextHop.getID() ].setPushed(true);
                      }
                      j = j.nextHop;
                  } // end nested while

                 } // end for
          } // end while
         
          System.out.println("Vertex: " + targetVert + " not found in " + popped + " searches!" );
          return false; //If target vertex was not found then return false
   
    
    }

    
    public boolean edgeTest()
    {
         for(int i = 0; i < size; i++)
        {
              if( (vertices[i].getConnections() == 0 ) || (vertices[i].getConnections() < 1) )
              {
                System.out.println("NO CONNECTION FOUND!!");
                System.out.println("Vertex: " + i + " " + vertices[i]);
                return false;
              }

        }
        System.out.println("All Vertices Have An Edge");
        return true;
    }
}
