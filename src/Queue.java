
public class Queue <T extends Comparable<T>> extends SLL<T>
{
    public void enqueue(T data)
    {
    		addTail(data);
    }

    public T dequeue()
    {
        return deleteHead();
    }

    public T peek()
    {
        return get(0);
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    public void empty() 
    {
    		while (!isEmpty()) 
    		{
    			dequeue();
    		}
    }
}