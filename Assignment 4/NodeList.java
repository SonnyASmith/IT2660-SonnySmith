
/**
 * A class that will create a linked list of nodes with Router objects that supports insert, update, fetch, and print functions.
 *
 * @author Sonny Smith
 * @version 10/08/21
 */
public class NodeList
{
   
    private Node d; //The dummy node
    private Node start; //The node at the start of the list
    private Node end;  //The node at the end of the list
    private int size; //The size of the list
    
    public NodeList()//The default constructor that creates a linked list starting with the dummy node 
    {
        d = new Node();
        d.listing = null;
        d.nextHop = null; 
        start = d;
        end = d; 
        size = 0; 
    }

     public class Node //Declares the Node innerclass that will be used to create nodes that the outerclass will  
     {                // create a linked list of. 
       private Router listing; //A router object that will be accessed through each node
       private Node nextHop; //The next node in the list.
     
       public Node()//Default Constructor
       {
       }
      
       public Node(Router newRouter)
       {  
         listing = newRouter;
         nextHop = null; 
       } 
     }
    
    public Router fetchName(String targetName) //Fetches the router object using its name 
    {
        Node p = d.nextHop;  
        
        for(int i = 0; i < size; i++) //Searches through the list
        { 
            
             if(targetName == p.listing.getName() )
           {
               return p.listing.deepCopy();
           }
           else
           {
            p = p.nextHop; 
           }
        }
         return null; //If no router is found
    }
    
     public Router fetchAddress(String targetAddress) // Fetches the router object using its address
    {
        Node p = d.nextHop; 
        
        for(int i = 0; i < size; i++) //Searches through the list
        { 
           // System.out.println("Fetching!");        
           if(targetAddress == p.listing.getAddress() )
           {
               return p.listing.deepCopy();
           }
           else
           {
            p = p.nextHop; 
           }
         
        }
        return null; //If no router is found
    }
    
    public boolean delete(int targetPos)
    {
      Node q = d; //Stores preceeding nodes and is initiated using the dummy node
      Node p = d.nextHop; //Stores the nodes that will be checked against the target name
      int position = 0; 
      while(p != null && position != targetPos && position < size) //Searches through the list
      { 
            q = p;
            p = p.nextHop;  
            position++; 
          
      }
        
      if(p != null && p.nextHop == null)
      {
         q.nextHop = null;
         end = q;
         size--;
         return true; 
      }
      else if(p != null)
      {
       q.nextHop = p.nextHop; //Changes the nextHop of the node preceeding the target to skip the targe node.
       size--; 
       return true;           
      }
      else
      { 
       System.out.println("There is no router to delete in that position");
       return false;   
      }
        
    }
    
    public boolean insertAt(Node n, int targetPos)
    {
  
        if(targetPos < 0)
        {
            System.out.println("Invalid Position!");
            return false;
        }
        else if(targetPos == 0)
        {
            //Inserts at the start of the list
            insertStart(n);
            return true;
        }
        else if (targetPos >= size)
        {
          //Inserts at the end of the list
          append(n);
          return true;
        }
        else
        {
          //General Insert 
          insert(n, targetPos);
          return true; 
        }
    }
    
    public void insertStart(Node n) //2nd edge case that inserts a node at the start of the linked list
    {
        n.nextHop = d.nextHop; //Shifts the current first node to be after the new node
        d.nextHop = n; //Sets the new node to be in the first position after the dummy node
        size++; //Increments the size of the list
    }
    
    public boolean append(Node n)
    {

       if(fetchName(n.listing.getName() ) != null || fetchAddress(n.listing.getAddress() ) != null) //Tests for duplicate Routers
        {                                                                                             // in the linked list
            System.out.println("That router already exists!"); 
            return false; 
        }
        else
        {

        end.nextHop = n; //Sets the previous endpoint to link to the new endpoint
        n.nextHop = null; //Sets the nextHop of the new endpoint to be null to indicate the end of the list
        end = n; //Sets the end value to be the new endpoint
        size++; //Increments the size variable
        return true;
        }  
        
    }
    
    private void insert(Node n, int targetPos) //Inserts a new node at a target position by shifting the node in that position 
    {                                                  
      Node q = d; //Stores preceeding nodes and is initiated using the dummy node
      Node p = d.nextHop; //Stores the nodes that will be checked against the target name
        
      if(fetchName(n.listing.getName() ) != null || fetchAddress(n.listing.getAddress() ) != null) //Tests for duplicate Routers
        {                                                                                             // in the linked list
            System.out.println("That router already exists!"); 
            return; 
        }
      else if(targetPos >= size) //Tests if the target position is outside of the bounds of the list and appends it instead
      {
          append(n);
          return; 
      }
      else
         {
       for(int i = 0; i < targetPos; i++) //Searches through the list and sets p to be the target node and q to be the preceeding node
       {
         q = p;
         p = p.nextHop;
       }
       
       } 
       n.nextHop = p; //Sets the nextHop of the new node to be the target node, shifting it 
       q.nextHop = n; //Sets the nextHop of the node preceding the target to be the new node, taking the target's original place
       size++; //Increments the size of the list
     
    }
    
    public boolean update(Node n,int targetPos) //Replaces a node at a specific position with a new node
    {
        if(delete(targetPos) == false) //Checks to see if delete failed
        {
         return false;   
        }
        else if(insertAt(n, targetPos) == false) //Checks to see if insert failed
        {
         return false; 
        }
        
        return true; //If both delete and insert suceeded then the list was updated
    }
    
    public void printSize()
    {
        System.out.println("\nThe size of the list is: " + size); 
    }
    
    public void printList() //Prints the entire linked list
    {
        Node p = d.nextHop;
        for(int i = 0; i < size; i++)
        {
            System.out.println(p.listing.toString() );
            p = p.nextHop; 
        }
        
    }
    
    public void printName(String targetAddress) //Prints the name of the router object with a specified address
    {
        if(fetchAddress(targetAddress) != null)
        {
            System.out.println("The router with the address: " + targetAddress + 
            " is named: " + fetchAddress(targetAddress).getName() ); 
        }
        else
        {
           System.out.println("There is no router with that address!");
        }

    }
    
    public void printAddress(String targetName) //Prints the address of the router object with a specified name
    {
        if(fetchName(targetName) != null)
        {
          System.out.println("The router with the name: " + targetName + 
          " has the address: " + fetchName(targetName).getAddress() ); 
        }
         else
        {
          System.out.println("There is no router with that name!");
        }
           
    }
    
}
