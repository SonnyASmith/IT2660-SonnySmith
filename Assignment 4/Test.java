
/**
 * A class that will test NodeList's functions. 
 *
 * @author Sonny Smith
 * @version 10/08/21
 */
public class Test
{
    
   public static void main(String[] args)
   {
       NodeList list = new NodeList();
       
      System.out.println(list.append(list.new Node(new Router("Gateway1", "129.35.41.1") )) );
      System.out.println(list.append(list.new Node( new Router("Gateway2", "129.35.41.2") ) ) );
      System.out.println(list.append(list.new Node( new Router("Border1", "178.8.8.7") ) ) );
      System.out.println(list.append(list.new Node( new Router("Central1", "145.12.2.16") ) ) );

      System.out.println("The routers in the list are: ");
       list.printList(); 
      //Deleting from the list
      
      System.out.println("\nTime to delete some routers");
        System.out.println(list.delete(2) ); 
        System.out.println(list.delete(2) );
        System.out.println(list.delete(1) ); 
      System.out.println("Now the routers in the list are: ");
        list.printList(); 
      
      //Inserting a Node that already exists
        
      System.out.println("\nCan we insert Gateway1 twice?"); 
        list.insertAt(list.new Node(new Router("Gateway1", "129.35.41.1") ), 2 ) ;
 
      //Inserting new nodes
      
      System.out.println("\nTime to insert more routers");
       //Inserts a node at an invalid position which gets deined
      list.insertAt(list.new Node(new Router("Gateway3", "129.35.41.3") ), -2 ); 
       //Inserts a node using the general case
      list.insertAt(list.new Node(new Router("Gateway3", "129.35.41.3") ), 2 );
  
      //Inserts a new node at the start of the list which is the 2nd edge case
      list.insertAt(list.new Node(new Router("Gateway1Backup", "129.35.42.1") ), 0 ); 

      //Inserting a node outside of the boundaries of the list which places it at the end of the list which is the 1st edge case
      list.insertAt(list.new Node(new Router("Central2", "145.12.2.18") ), 100 );
        list.printList(); 
        list.printSize();

       
      //Updating the list
      System.out.println("\nTime to update the last router with CentralBackup5");
   
      System.out.println(list.update(list.new Node(new Router("CentralBackup5", "145.12.2.50")), 3 ) );
      System.out.println("Now the routers in the list are: ");
       list.printSize();
       list.printList(); 
         
      System.out.println("\nCan we fetch Border1 which was deleted?");
         System.out.println(list.fetchName("Border1"));
        System.out.println(list.fetchAddress("178.8.8.7") );
 
      // Fetching and printing addresses from names and names from addresses
      System.out.println("\nTime to find the address of Gateway1");
        list.printAddress("Gateway1");
       
      System.out.println("\nTime to find the name of 129.35.41.1");
        list.printName("129.35.41.1");  
   }
  
}
