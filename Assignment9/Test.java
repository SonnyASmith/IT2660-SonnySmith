/**
 * A class used to test the methods of the Graph class. 1000 nodes will be generated with 1 to 5 connections to create a graph.
 * Searching of the graph will be initiated with user input.
 * Searching methods will return the success/failure of the search, the number of nodes searched, and the nodes that were encountered
 * while searching for the target node.
 *
 * @author Sonny Smith
 * @version 12/17/21
 */
import java.util.Random;
import java.util.Scanner;
public class Test
{
    public static void main(String[] args)
    {
      Random random = new Random();
      Scanner keyboard = new Scanner(System.in);
      boolean running = true;
      int fail = 0; //A counter for failed edge creation
      int n = 1000; //The size of the graph
        Graph g = new Graph(n);

      for(int i = 0; i < n; i++) //Generates all the vertices
      {
       g.createVert(random.nextInt(100000) + 1);
      }
    
      for(int j = 0; j < n; j++) //Creates edges for all the vertices
      {
          int q; //A variable that is used to control the number of edges that are created
          if(j < (n/10) ) 
          {
            q = (random.nextInt(2) + 1);
          }
          else
          {
              q = (random.nextInt(5) + 1);
          }
          for(int k = 0; k < q; k++)
          {
            int c = random.nextInt(n);
            fail = 0; //A counter for failed edge creation
             if(!g.createEdge(j, c ) )
             {
              while(!g.createEdge(j, fail ) && (fail < n) ) //A failsafe in the even that a randomly chosen vertex cannot be used
              {
               fail++;
              }
              if(fail > n) //In the unlikely event a vertex is unable to have an edge connection to any other vertex
              {           // the program terminates to prevent possible issues
                System.out.println("Graph Creation Error");
                System.exit(1);  
              }
             }
  
          }
       
          
       }

      while(running)
      {  System.out.println("Enter: " + "\n1 to perform a depth-first search: " + 
                            "\n2 To perform a breadth-first search: " + 
                            "\n3 to print all the vertices " + "\n4 to print all the edges/connections" + 
                            "\n5 to verify that all vertices have at least one edge" +
                            "\nOr any other key to exit.");
                            
          switch(keyboard.nextInt() )
          {
            case 1: System.out.println("To perform a depth-first search, enter target vertex");
                    g.dfSearch(keyboard.nextInt() );
             break;
            case 2: System.out.println("To perform a breadth-first search, enter target vertex");
                    g.bfSearch(keyboard.nextInt() ); 
             break;
            case 3:  g.printVertices();
             break;
            case 4:  g.printEdges();
             break;
             case 5: g.edgeTest();
             break;
             default:    
             System.exit(0); 
          }
      
      }

   }
    
}

