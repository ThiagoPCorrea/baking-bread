package circList;

import java.util.LinkedList;

public class CircularLinkedList <E> extends LinkedList<E> {

    public Object next(Object element)
    {
        if(element == this.getLast())
            return this.peekFirst();
        return this.get(this.indexOf(element)+1);
    }

    public Object prev(Object element)
    {
        if(element == this.getFirst())
            return this.peekLast();
        return this.get(this.indexOf(element)-1);
    }
}
