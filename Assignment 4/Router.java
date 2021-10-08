
/**
 * A class that will be used to create Router objects with a name and an address. 
 *
 * @author Sonny Smith
 * @version 10/08/21
 * 
 */
public class Router 
    {                  
      private String name;
      private String address; 
    
    public Router(String n, String a)
    {
       name = n;
       address = a;
    }
     
    public Router deepCopy()
    {
        Router copy = new Router(this.name, this.address);
        return copy; 
    }
     
    public String getName()
    {
        String n = this.name;
        return n; 
    }
    
    public String getAddress()
    {
        String a = this.address;
        return a; 
    }
    
    public String toString()
    {
        return "\nName: " + name + " Address: " + address; 
    }
    
    }
