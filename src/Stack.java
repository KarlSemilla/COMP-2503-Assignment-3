
public class Stack <T extends Comparable<T>> extends SLL<T>
{
	/*	This method pushes data to the top of the stack and pushes old data to the bottom.
	 */
    public void push(T data)
    {
        addHead(data);
    }
    
    /* This method pushes data at the top of the stack out.
     * Returns the data at the top of the stack.
     */
    public T pop()
    {
        return deleteHead();
    }
    
    /* Returns the data at the top of the stack.
     */
    public T peek()
    {
        return get(0);
    }
    
    /* Returns a boolean result depending on if the stack is empty or not.
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    /* This method empties the stack by removing all of it's contents.
     */
    public void empty() 
    {
    		while (!isEmpty()) 
    		{
    			pop();
    		}
    }
}