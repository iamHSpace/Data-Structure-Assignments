import java.util.*;
class Link<X>
{
    X obj;
    Link<X> next;
    Link(X a)
    {
    obj=a;
    next = null;
    }
}

public class MySet<X>
{
    Link<X> head;
    MySet()
        {
            head = null;
        }
    public Boolean IsEmpty()
        {
            return(head==null);
        }
    public void delete(X o)
        {
        if(head == null)    return;
        Link<X> PN = null;
        Link<X> CN = head;
        while (CN != null && CN.obj!=o)
        {
            PN = CN;
            CN = CN.next;
        }
        if(PN == null)
        {
            head = head.next;
            return;
        }
        if (CN == null)
        {
            System.out.println("A node with that value does not exist.");
            return;
        }
        PN.next = CN.next;
        }
    public void addElement(X o)
        {
        Link<X> tempnode = head;
        if(head==null)
        {
            head=new Link<X>(o);
            return;
        }
        Link<X> prevnode = new Link<X>(o);
        while(tempnode.next!=null)
        {
            tempnode=tempnode.next;
        }
        prevnode.obj=o;
        tempnode.next=prevnode;
        return;
        }
    public Boolean IsMember(X o)
        {
            Link<X> PN = null;
            Link<X> CN = head;
            while(CN !=null && CN.obj!=o)
            {
                PN = CN;
                CN = CN.next;
            }
            return !(CN==null);
        }
    public MySet<X> union(MySet<X> a)
        {
            Link<X> CN1=a.head;
            Link<X> CN2=head;
            if(CN1==null) return a;
            if(CN2==null) return this;
            MySet<X> c=new MySet<X>();
            while(CN1 != null)
            {
                c.addElement(CN1.obj);
                CN1=CN1.next;
            }
            while(CN2 != null)
            {
                if(a.IsMember(CN2.obj)==false)
                c.addElement(CN2.obj);
                CN2=CN2.next;
            }
            return c;
        }
    public MySet<X> intersection(MySet<X> a)
        {
            Link<X> CN1=a.head;
            Link<X> CN2=head;
            MySet<X> d= new MySet<X>();
            if(CN1==null || CN2==null) return null;
            while(CN2 !=null)
            {
                if(a.IsMember(CN2.obj)==true)
                d.addElement(CN2.obj);
                CN2=CN2.next;
            }
            return d;
        }
}
