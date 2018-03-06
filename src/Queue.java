
/* This class holds all methods used for a Queue.
 */
public class Queue <T extends Comparable<T>> extends SLL<T>
{	
	/* This method returns data at the start of the queue.
	 * This method also removes the first entry in the queue.
	 */
    public void enqueue(T data)
    {
    		addHead(data);
    }
    
	/* This method returns data while removing from the start of the queue.
	 */
    public T dequeue()
    {
        return deleteTail();
    }
    
    /* This method returns the data given at the start of a queue.
     */
    public T peek()
    {
        return get(0);
    }

    /* This method returns a boolean depending if the queue is empty. 
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    /*This method empties a queue by removing all of the content in a queue.
     */
    public void empty() 
    {
    		while (!isEmpty()) 
    		{
    			dequeue();
    		}
    }
}