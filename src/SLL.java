
public class SLL<T extends Comparable<T>> {
	private Node<T> start;
	private Node<T> end;
	private int size;
	
	public SLL() {
		start = null;
		end = null;
	}
	
	/* Finds the total size of the linked list, returns the value in an int.
	 */
    public int size(){
        Node<T> curr = start;
        int length = 0;

        while(curr != null)
        {
            length++;
            curr = curr.getNext();
        }

        return length;
    }
    
	/** This method checks if the start of the linked list is empty.
	  	Returns true if start is empty.
	 */
    public boolean isEmpty(){ 
    		return (start == null); 
    }
    
    /*
    public int compareTo(SLL<T> other) 
    {
       if (this.equals(other))
          return 0;
       else
          return this.compareTo(other); 
    }
	*/
    
    public int compareAsc(Node<T> n1, Node<T> n2) 
    {
       int f1 = ((Word) n1.getData()).getCount();
       int f2 = ((Word) n2.getData()).getCount();
       if (f2-f1 == 0) 
          return n1.compareTo( n2);
       else
          return f2 - f1; 
    }
    
    public int compareDec(Node<T> n1, Node<T> n2) 
    {

       int f1 = ((Word) n1.getData()).getCount();
       int f2 = ((Word) n2.getData()).getCount();

       if (f1 - f2 == 0) 
          return n1.compareTo(n2);
       else
          return f1 - f2; 
    }
    
    /** This method orders the nodes before adding them. 
     */
    public void addInOrder(Node<T> n) 
    {
        if (start == null) {
            start = n; end = n;
        } 
        else {
            if (n.getData().compareTo(start.getData()) <= 0) // less than first item, insert here. 
               addToStart(n);
            else 
            {
               Node<T> curr = start;
               while (curr.getNext() != null && n.getData().compareTo(curr.getNext().getData()) > 0) 
               {
                  curr = curr.getNext();
               }
               if (curr.getNext() == null) // did not find a place 
               {
                   addToEnd(n);
               }
               else 
               {
                   n.setNext(curr.getNext());
                   curr.setNext(n);
               }
               
            }
        }
    }
	
    /** Adds to the start of a linked list by taking in data.
     	First, finds if the current list is empty, if it is adds to start.
      	If it does not, adds given data to the start of the list.
     */
    public void addToStart(Node<T> data) 
    { 
        if(isEmpty())
            start = data;
        else
        {
          data.setNext(start);
          start = data;
        }
    }
        
    /** This method adds the given data to the end of a list.
      	First, checks if the current list is empty, then proceeds to check
      	until end is null.
      	Finally, it adds the data to the end of the linked list.
     */
    public void addToEnd(Node<T> data) {
    			if(start != null){
    				end = start;
    				while(end.getNext() != null){
                   end = end.getNext();
                }
             end.setNext(data);
            }
            else
            		start = data;   
    }
    
    /* This method returns the node values at a given index.
     */
    public T get(int index){
    		T data = null;
        int length = size();
        Node<T> curr = start;
            
        if (index <= length && index >=0){
        		curr = start;
        		for (int count = 0; count < index; count++)
        			curr = curr.getNext();
        			data = curr.getData();    
            }
        return data;
        }
    
    /* This method returns the index of a certain node as an int.
     */
    public int getIndex(Node<T> other) {
    		Node<T> tmp = start;
    		int i = 0;
    		int y = 0;
    		size = size();
    		while(i < size) {
    			if (tmp.getData() == other.getData()) {
    				y = i;
    			}
    			i++;
    			tmp.getNext();
    		}
    		return y;
    }

    /** This method returns true if the given node is already in the linked list.
      	Returns false if the data is not already in the linked list.
     */
	public boolean contains(Node<T> other) {
		boolean result = false;
		int i = 0;
		Node<T> tmp = start;
		size = size();
		while(i < size) {
			if(tmp.getData() == other.getData()) {
				result = true;
			}
			tmp.getNext();
			i++;
		}
		return result;
	}
     
}