/**
 * A class that will create a binary tree of nodes containing Listing objects. A prompt will allow user access to each of the methods
 * to fetch, insert, delete, update, or output the listings in the tree.
 * @author Sonny Smith
 * @version 11/07/21
 */
import java.util.Scanner; 
import java.util.StringTokenizer;
public class BinaryTree
{
    Node root; //The root node of the tree
    public boolean running; //Controls whether the prompt will continue running or not
   
    public BinaryTree()
    {
      root = null; 
      running = true; 
    }
    
     public class Node //Declares the Node innerclass that will be used to create nodes that the outerclass will  
     {                // use to create a binary tree. 
       private Listing node;    //A Listing object that will be stored in the node
       private Node rightList; //The right subtree
       private Node leftList;  //The left subtree
       public Node()//Default Constructor
       {
       }
     }
    
     public class Wrapper //A class that will be used to allow methods to
     {                    //return multiple nodes i.e a parent node and a child node
       Node nodeRef = null;
      
       public Wrapper()
       { 
       }
       
       public Node getNode()
       {
         return nodeRef;
       }
       
       public void setNode(Node n)
       {
        nodeRef = n;
       }
       
     }
    
    public void prompt(String choice)//Activates and passes arguments to methods based on user inputs
    {
        Scanner keyboard = new Scanner(System.in); //Used to receive user input 
        String delimeter = "|";//Used with tokenizer to separate multiple inputs in a single line
    
       switch(choice)
        {
          case "1": //Fetch 
             System.out.println("Enter a student's full name to fetch their information: ");
             System.out.println( fetch(keyboard.nextLine() ).toString() ); 
          break;
          case "2": //Insert
             System.out.println("Enter a student's full name and gpa separated by '|': ");
             StringTokenizer t = new StringTokenizer(keyboard.nextLine(), "|");
            try{
                System.out.println("Information Inserted? " + insert(new Listing(t.nextToken(), Double.parseDouble(t.nextToken() )) ) );
               }
            catch(java.util.NoSuchElementException e)//Catches error if user enters an invalid amount of arguments
              {
                 System.out.println("Invalid Argument(s) Entered!");
              }
            catch(java.lang.NumberFormatException e)//Catches error if user enters an invalid gpa
              {
                 System.out.println("Invalid Number(s) Entered!");
              }
          break;
          case "3": //Delete
            System.out.println("Enter a student's full name to delete their information: ");
            System.out.println("Information Deleted? " + delete(keyboard.nextLine() ) );
          break;
          case "4": //Update
            System.out.println("Enter the full name of the student that you wish to update: ");
            String s = keyboard.nextLine();
            System.out.println("Now, enter the new name and gpa information, separated by '|', to update the listing: ");
            StringTokenizer u = new StringTokenizer(keyboard.nextLine(), "|");
             try{
                    System.out.println("Listing Updated? " + update(s, new Listing(u.nextToken(), Double.parseDouble(u.nextToken() ))) );
                }
            catch(java.util.NoSuchElementException e)
                {
                   System.out.println("Invalid Argument(s) Entered!");
                 }
            catch(java.lang.NumberFormatException e)
                {
                   System.out.println("Invalid Number(s) Entered!");
                }
          break;
          case "5": //Output
             System.out.println("Outputting all listing information: ");
             output();
          break;
          default: //6 or any key to Exit
             System.out.println("Are You Sure You Want To Exit? "
                               +"Enter 'y' or 'Y' To Exit The Program Or Enter Any Other Key To Continue:");
                               String i = keyboard.nextLine();
               if(i.equalsIgnoreCase("y") ) 
                 {
                    System.out.println("Exiting Program");
                    running = false;
                    System.exit(0);               
                 }
              else
                 {
                   break;   
                 }

         }

    }
      
    public Listing fetch(String target) //Fetches a specific listing and outputs its information
    {
        Wrapper p = new Wrapper();
        Wrapper c = new Wrapper();

        if(findNode(target, p, c) == true && root != null) //If node with the desired target key is found then it is returned, else return null
        {
            System.out.println("Fetched: " + target);
            return c.getNode().node.deepCopy();
        }
        else
        {
            System.out.println("Unable To Fetch Target Listing: '" + target + "' Not Found");
            return new Listing("", 0.0);
     
        }
        
    }
    
    public boolean insert(Listing l) //Inserts a new listing into the tree
    {
        Wrapper p = new Wrapper();
        Wrapper c = new Wrapper();
        Node n = new Node();
     
        if(n == null) //Out of memory
        {
           return false; 
        }
        else if(findNode(l.getKey(), p, c) == true)
        {
          System.out.println("A Listing With That Name Already Exists!");
          return false; 
        }
        else
        {
          n.node = l.deepCopy();
          n.leftList = null;
          n.rightList = null;
             if(root == null)//If there is no root then the new node is inserted as the root
             {
               root = n;
             }
             else 
             {  
                findNode(l.getKey(), p, c); //Find the parent of the target node
                if(l.getKey().compareTo(p.getNode().node.getKey() ) < 0)
                {
                    p.getNode().leftList = n; //Insert the new node into the left list
                }
                else
                {
                    p.getNode().rightList = n; //Insert the new node into the right list
                }
                
             }
            return true;
        }
       
        
    }
    
        public boolean delete(String target) //Delete a specific listing
       {
          Wrapper p = new Wrapper();
          Wrapper c = new Wrapper();
          Node big;
          Node nextBig; 

        if(findNode(target, p, c) == false) //If node not found then return false
        {
          return false; 
        }
        else //Determine how the delete function will be handled on the target node
        {
            
            if(c.getNode().leftList == null && c.getNode().rightList == null)//Case1: Target node is a leaf with no children
             {
              if(p.getNode().leftList == c.getNode() ) //If target node is a left child
               {
                   if(c.getNode() == root)//Resets root if target is the root
                   {
                    root = null;
                   }
                   p.getNode().leftList = null;//Deletes the target
               }
              else //Target node is a right child
               {
                     if(c.getNode() == root)//Resets root if target is the root
                   {
                    root = null;
                   }
                   p.getNode().rightList = null;
             }
            
             }//end case 1 
        
         else if( c.getNode().leftList == null || c.getNode().rightList == null) //Case2: Target has one child
            {
              
              if(p.getNode().leftList == c.getNode() ) //If target node is a left child
              {
               
                  if(c.getNode().leftList != null )//If target node has a left child 
                 {
                              if(c.getNode() == root)//Reassigns Root node if target is the root
                        {
                         root = c.getNode().leftList;
                        }
                        p.getNode().leftList = c.getNode().leftList; //Reassigns the child node to take target's position(deleting it)
                 }
                  else //Target node has a right child
                 {
                        if(c.getNode() == root)//Reassigns Root node if target is the root
                        {
                         root = c.getNode().rightList;
                        }
                        p.getNode().leftList = c.getNode().rightList; //Reassigns the child node to take the target's position(deleting it)
                 }
              
              }//end of left child
              
              else //Target node is a right child
               {
                 
                if(c.getNode().leftList != null )//If target node has a left child 
                 {
                        
                     if(c.getNode() == root)//Reassigns Root node if target is the root
                       {
                         root = c.getNode().leftList;
                       }
                      p.getNode().rightList = c.getNode().leftList; //Reassigns the child node to take target's position(deleting it)
                 }
                else //Target node has a right child
                 {
                        
                    if(c.getNode() == root)//Reassigns Root node if target is the root
                      {
                         root = c.getNode().rightList;
                      }
                    p.getNode().rightList = c.getNode().rightList; //Reassigns the child node to take the target's position(deleting it)
                 }
                
               }//end of right child
                
            } //end case 2 
            else //Case 3: deleted node has 2 children
             {
               nextBig = c.getNode().leftList;
               big = nextBig.rightList; 
               if(big != null)
               {
                 while(big.rightList != null)//Navigate the right edge of the right subtree
                 {
                  nextBig = big;
                  big = big.rightList;
                 }
                 c.getNode().node = big.node; //Saves the replacement node that was found in the right subtree
                 nextBig.rightList = big.leftList;//Saves the left subtree of the replacement node
                
               }
               else //Left child does not have a right subtree
               {
                  nextBig.rightList = c.getNode().rightList;//Saves the right subtree
                  if(p.getNode().leftList == c.getNode() )//Deleted node is a left child
                  {
                        if(c.getNode() == root)//Reassigns Root node if target is the root
                        {
                         root = nextBig;
                        }
                        p.getNode().leftList = nextBig; //Reassigns child node to the parent of the target node, skipping it
                  }
                  else //Deleted node is a right child
                  {
                         if(c.getNode() == root)//Reassigns Root node if the target is the root
                        {
                         root = nextBig;
                        }
                        p.getNode().rightList = nextBig;  //Reassigns child node to the parent of the target node, skipping it
                  }
                 
               }
              
              
            }//end case 3
            
            return true;
        }//end of delete method
                 
    }
    
    public boolean update(String target, Listing l) //Updates a specific listing deleting it and reinserting it with new information
    {
       if(delete(target) == false)
        {
           return false; //If the target cannot be found and deleted then the update function fails
        }
        else if(insert(l) == false)
        {
           return false; //If the new listing cannot be inserted then the update fails 
        }
        return true; //If neither process failed then the update succeeded
   
    }
     
    public void output() //Output that prints the listing information based on the name of the listing in alphabetical order
    {
 
      if(root == null)//If the tree is empty there is nothing to output
      {
        return;
      }
        if(root.leftList != null)//The left subtree is printed first
      {
        output(root.leftList);
        
      }
      System.out.println(root.node.toString() ); //The root node is printed next
      if(root.rightList !=null) //The right subtree is printed last
      {
         output(root.rightList);
        }

    }
    
    private void output(Node r) //Receives arguments from the parameterless output method to perform its functions
    {
       
      if(root == null)
      {
        return;
      }
      if(r.leftList != null)
      {
         output(r.leftList);
        
      }
      System.out.println(r.node.toString() );
      if(r.rightList != null)
      {
        output(r.rightList);
      }
    }
   
     private boolean findNode(String target, Wrapper parent, Wrapper child) //Used by the other methods to locate nodes
     {
        parent.setNode(this.root); 
        child.setNode(this.root);
        
        if(root == null) //Tree is empty there is no node to find
        { 
             return false;
        }
        else
        {
          
            while(child.getNode() != null)//While there are nodes left in the tree
          {    
            if(child.getNode().node.compareToIgnoreCase(target) == 0 ) //If target node is found in the tree
            {
                 return true;
            }
            else//Node not found so tree is searched
            {  
              parent.setNode(child.getNode() );  //Initializes the parent node to the child node        
              if(target.compareToIgnoreCase( child.getNode().node.getKey() ) < 0) //If the target is less than the child node
              {
                 child.setNode(child.getNode().leftList);//Searches left sublist
              }
              else //If the target is greater than the child node
              {
               child.setNode(child.getNode().rightList);//Searches right sublist
              }
              
            }
          }
          return false; //If the node cannot be found, then return false
        }
      }                                            

  }

