
/**
 * A class that will be used to test the Freezer and Food classes. Objects will be created to fill, empty, and perform other actions
 * on the Freezer arrays to test their dynamic properties. 
 * @author Sonny Smith
 * @version 09/28/21
 */
public class Test
{
    public static void main(String[] args)
    {
       //Food Array
        Freezer obj1 = new Freezer(new Food("Steak") ); 
       System.out.println("The new freezer has: ");
        obj1.printItem(0); //Shows the first item in the array
    
       //Inserting items into the array
         obj1.insert(new Food("Fries"), 1); 
  
         obj1.insert(new Food("Vegetables"), 2);

         obj1.insert(new Food("Chicken Nuggets"), 3); 
  
       
       System.out.println("\nAfter adding a few items, the freezer has: "); 
       obj1.printArray();
        
         obj1.insert(new Food("Onion Rings"), 3); //Inserts a food item in the middle of the array and the array readjusts in response 
         obj1.insert(new Food("Breadsticks"), 0); //Inserts a food item in the front of the array and the array readjusts in response
        
       System.out.println("\nNow some more items have been added: "); 
       obj1.printArray();
        
         //Deleting items from the array
      System.out.println("\nNow it is time to delete the second item");
        
        obj1.delete(1);
        System.out.println("\nThe freezer now has: ");
        obj1.printArray();
          
      //Updating items in the array
      System.out.println("\nNow it is time to update the array by making the second item ice cream");
         
         obj1.update(new Food("Ice Cream"), 1); 
      System.out.println("\nThe freezer now has: ");
      obj1.printArray();
        
        //Fetching items
        System.out.println("\nNow I am going to fetch some items from the freezer"); 
          System.out.println("\nThe freezer has: "); 
          for(int i = 0; i < obj1.getLength(); i++)
        {
            System.out.println(obj1.fetch(i).getName() );
        }
        System.out.println("\nThe first item is: " + obj1.fetch(0).getName() );
        System.out.println("\nThe fourth item is: " + obj1.fetch(3).getName() );
      
      
    
        
        

        
        
        
      
     
    
         
        
    }
}
