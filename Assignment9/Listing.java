/**
 * A class used to store data for the nodes of the graph.
 *
 * @author Sonny Smith
 * @version 12/17/21
 */
public class Listing
{
    private int value; //The value stored in a listing object
    private int connections; //Used to track the number of connected vertices a listing node has
    private boolean pushed; //Whether or not a listing node has been added to a stack/queue
    public Listing(int x)
    {
       value = x; 
       pushed = false;
       connections = 0;
    }

   public Listing deepCopy()
    {
      return new Listing(this.value);
    }
    
    public String toString()
    {
      return "" + this.value;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public int getConnections()
    {
      return this.connections;
    }
    
    public void addConnection()
    {
       this.connections++; 
    }
    
    public boolean getPushed()
    {
      return this.pushed;
    }
    
    public void setPushed(boolean state) //Changes the pushed state of the listing object
    {
       this.pushed = state;
    }

}
