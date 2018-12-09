package circList;

import java.util.LinkedList;

public class CircularLinkedList <E> extends LinkedList<E> {

    public Object next(Object element)
    {
        if(element.equals(this.getLast()))
            return this.getFirst();
        return this.get(this.indexOf(element)+1);
    }

    public Object prev(Object element)
    {
        if(element.equals(this.getFirst()))
            return this.getLast();
        return this.get(this.indexOf(element)-1);
    }
}
