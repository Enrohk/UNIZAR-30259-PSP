package data;

import exception.LinkedListException;

public class MyLinkedList<T> {

    private int size;
    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private LinkedNode<T> iterator;

    public MyLinkedList ()
    {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add (LinkedNode<T> next) throws LinkedListException
    {
        if(size == 0)
        {
            first = next;
            last = next;
        }
        else{
            addLast(next);
        }

        size++;

    }

    public void initIterator ()
    {
        iterator = first;
    }


    public boolean hasNext ()
    {
        return iterator!=null;
    }

    public LinkedNode<T> next () throws LinkedListException
    {

        if(iterator!=null)
        {
            LinkedNode<T> mock = iterator;
            iterator = mock.getNextNode();
            return mock;
        }
        else
            throw new LinkedListException("You must init iterator before start to iterate");

    }

    private void addLast(LinkedNode<T> next) throws LinkedListException
    {
        if (last.getNextNode() == null)
        {
            LinkedNode<T> mock = last;
            mock.setNextNode(next);
            last = next;
        }
        else
            throw new LinkedListException("Cant add last item");
    }


}
