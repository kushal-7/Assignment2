import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;
    private int size=0; 


    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;
        //private int size;  // left and right subtrees
                  // number of nodes in subtree

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            //this.size=size;
            
            left=null;
            right=null;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
        root=null; 
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {

         if (size()==0) {
            return true;
        } 
        return false;      
    }

    public int size() {
      return size;
       
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */


    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key==null) throw new IllegalArgumentException("Get Value Is Null");
        Node curnode= root;
        do
        {
            int compare= key.compareTo(curnode.key);
            if(compare<0){
                curnode=curnode.left;

            }
            else if(compare>0){
                curnode =curnode.right;
            }
        }
        while(curnode.key!= key);

        if (curnode.key ==key){
            
        }
        return curnode.val;
        
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        
        Node newNode = new Node(key,val);
        if(root==null)  root=newNode;
        else
        {
            Node curnode=root;
            Node head;
            do
            {
                head=curnode;
                int compare=key.compareTo(curnode.key);
                if(compare<0)
                {
                    curnode=curnode.left;
                    if(curnode==null)
                    {
                        head.left=newNode;
                        size=size+1;
                        return;
                    }
                    else if(curnode.key==key)
                    {
                        curnode.val=val;
                        return;
                    }
                }
                else if(compare>0)
                {
                    
                    curnode=curnode.right;
                    if(curnode==null)
                    {
                        head.right = newNode;
                        size=size+1;
                        return;

                    }
                    else if (curnode.key==key)
                    {
                        curnode.val=val;
                        return;
                    }
                }
            }
            while(true);
        }
        size=size+1;
       
    }

    // private Node put(Node x, Key key, Value val) {
        
    // }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if(size==0) throw new NoSuchElementException("No element found in tree");

        else{
            Node curnode=root;
            while(curnode.left!=null)
            {
                curnode=curnode.left;
            }
            
            return curnode.key;
        }
       
    } 

     public Key max() {
        if(size==0) throw new NoSuchElementException("No element found in tree");

        else{
            Node curnode=root;
            while(curnode.right!=null)
            {
                curnode=curnode.right;
            }
            
            return curnode.key;
        }
       
    }

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if(isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        
        Node curnode = root;
        Node head = null;
        do
        {
            head = curnode;
            int compare = key.compareTo(head.key);
            if(key == null){
                throw new IllegalArgumentException("calls floor() with a null key");
            }
            if(compare == 0){
                return head.key;
            }
            if(compare < 0){
                curnode = head.left;
            }
            
            else if(compare > 0){
                curnode = head.right;
                
                int cmp = key.compareTo(curnode.key);
                if(cmp < 0 ){
                    return head.key;
                }
               
                else{
                    curnode = head.right;
                } 
            }
        }
        while(curnode != null);
        return head.key;
    }

    // public Key select(int k) {
    //     if ((k < 0) || k >= size()) {
    //         throw new IllegalArgumentException("Rank cannot be less than 1 and more than size ");
    //     }
    //     Node temporary=select(root,k);
    //     if(temporary==null) return temporary.key;
    //     else return null;
    // }

    // // Return key of rank k. 
    // private Node select(Node x, int k) {
    //     while(x!=null)
    //     {
    //         int store=size(x.left);
    //         if(store>k) x=x.left;

    //         else if(store<k){
    //             x=x.right;
    //             k=k-store-1;
    //         }
    //         else return x;
    //     }
    //     return null;
         
    // } 

   
    public Iterable<Key> keys(Key lo, Key hi) {
      if (lo == null){ 
            throw new IllegalArgumentException("argument is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("argument is null");
        }
        Queue<Key> obj1 = new LinkedList<> ();
        keys(root, obj1, lo, hi); 
        return obj1;
    } 

    private void keys(Node x,Queue<Key> obj1, Key lo, Key hi) { 
        if (x == null) return;  
        
        Node temporarya = x; 


        do{  
      
            int comparea = temporarya.key.compareTo(hi);
            int compareb = temporarya.key.compareTo(lo);
            if (temporarya.left == null){   
                if (comparea <= 0 && compareb >= 0)  obj1.offer(temporarya.key);
                temporarya = temporarya.right;

            }else{  
                Node temporaryb = temporarya.left;
            
                while (temporaryb.right != null && temporaryb.right != temporarya)  
                    temporaryb = temporaryb.right;  
        
                if (temporaryb.right == null)
                {  
                    temporaryb.right = temporarya;  
                    temporarya = temporarya.left; 

                }
                else
                {  
                    temporaryb.right = null;    
                    if (comparea  <= 0 && compareb >= 0)  obj1.offer(temporarya.key);  
                    temporarya = temporarya.right;  
                }  
            }  
        } 

        while (temporarya != null);

    }  

   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
    Solution<String,Integer> show = new Solution<String,Integer>();
        show.put("ABDUL",1);
        System.out.println(show.get("ABDUL"));
        show.put("HRITHIK",2);
        show.put("SAI",3);
        show.put("SAMAL",6);
        System.out.println(show.get("SAI"));
        show.put("TASHI",4);
        System.out.println("Size Of The Tree is " + show.size());
        System.out.println("Minimum Key From The key is " + show.min());
        System.out.println(show.floor("HRITHIK"));
        System.out.println(show.floor("HAHA"));
        System.out.println(show.keys("ABDUL","TASHI"));
        show.put("CHIMI",5);
        show.put("SAMAL",4);
        System.out.println(show.get("SAMAL"));
        show.put("NIMA",7);
        System.out.println("Size Of The Tree is " + show.size());
        System.out.println(show.floor("CHIMA"));
      
        show.put("SONAM",8);
        System.out.println(show.keys("ABDUL","TASHI"));

        
        
        

       

       
    }
}