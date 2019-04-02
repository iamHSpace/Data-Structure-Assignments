import java.util.*;
class Linknode<X>
{
    X obj;
    Linknode<X> Next;
    Linknode(X a)
    {
    obj=a;
    Next = null;
    }
}

public class MyLinkedList<X>
{
    Linknode<X> head;
    MyLinkedList()
        {
            head = null;
        }
    public Boolean isempty()
        {
            return(head==null);
        }
    public void Delete(X o)
        {
        if(head == null)    return;
        Linknode<X> PN = null;
        Linknode<X> CN = head;
        while (CN != null && !(CN.obj).equals(o))
        {
            PN = CN;
            CN = CN.Next;
        }
        if(PN == null)
        {
            head = head.Next;
            return;
        }
        if (CN == null)
        {
            System.out.println("A node with that value does not exist.");
            return;
        }
        PN.Next = CN.Next;
        }
    public void insert(X o)
        {
        Linknode<X> tempnode = head;
        if(head==null)
        {
            head=new Linknode<X>(o);
            return;
        }
        Linknode<X> prevnode = new Linknode<X>(o);
        while(tempnode.Next!=null)
        {
            tempnode=tempnode.Next;
        }
        prevnode.obj=o;
        tempnode.Next=prevnode;
        return;
        }
    public Boolean ismember(X o)
        {
            Linknode<X> PN = null;
            Linknode<X> CN = head;
            while(CN !=null && !(CN.obj).equals(o))
            {
                PN = CN;
                CN = CN.Next;
            }
            return !(CN==null);
        }
    public MyLinkedList<X> Union(MyLinkedList<X> a)
        {
            Linknode<X> CN1=a.head;
            Linknode<X> CN2=head;
            if(CN1==null) return a;
            if(CN2==null) return this;
            MyLinkedList<X> c=new MyLinkedList<X>();
            while(CN1 != null)
            {
                c.insert(CN1.obj);
                CN1=CN1.Next;
            }
            while(CN2 != null)
            {
                if(a.ismember(CN2.obj)==false)
                c.insert(CN2.obj);
                CN2=CN2.Next;
            }
            return c;
        }
    public MyLinkedList<X> Intersection(MyLinkedList<X> a)
        {
            Linknode<X> CN1=a.head;
            Linknode<X> CN2=head;
            MyLinkedList<X> d= new MyLinkedList<X>();
            if(CN1==null || CN2==null) return null;
            while(CN2 !=null)
            {
                if(a.ismember(CN2.obj)==true)
                d.insert(CN2.obj);
                CN2=CN2.Next;
            }
            return d;
        }
}
