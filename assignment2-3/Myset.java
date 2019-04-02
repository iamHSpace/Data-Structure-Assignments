import java.util.*;
class Link
{
    MobilePhone obj;
    Link next;
    Link(MobilePhone m)
    {
    obj=m;
    next = null;
    }
}

public class Myset
{
    Link head;
    Myset()
        {
            head = null;
        }
    public Boolean IsEmpty()
        {
            return(head==null);
        }
    public void delete(MobilePhone o)
        {
        if(head == null)    return;
        Link PN = null;
        Link CN = head;
        while (CN != null && (CN.obj).num!=o.num)
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
    public void insert(MobilePhone o)
        {
        Link tempnode = head;
        if(head==null)
        {
            head=new Link(o);
            return;
        }
        Link prevnode = new Link(o);
        while(tempnode.next!=null)
        {
            tempnode=tempnode.next;
        }
        (prevnode.obj).num=o.num;
        tempnode.next=prevnode;
        return;
        }
    public Boolean IsMember(MobilePhone o)
        {
            Link PN = null;
            Link CN = head;
            while(CN !=null && (CN.obj).num!=o.num)
            {
                PN = CN;
                CN = CN.next;
            }
            return !(CN==null);
        }
    public Myset Union(Myset a)
        {
            Link CN1=a.head;
            Link CN2=head;
            Myset c=new Myset();
            while(CN1 != null && CN2 != null)
            {
                c.insert(CN1.obj);
                CN1=CN1.next;
            }
            while(CN2 != null)
            {
                if(a.IsMember(CN2.obj)==false)
                c.insert(CN2.obj);
                CN2=CN2.next;
            }
            return c;
        }
    public Myset Intersection(Myset a)
        {
            Link CN1=a.head;
            Link CN2=head;
            Myset d= new Myset();
            while(CN2 !=null)
            {
                if(a.IsMember(CN2.obj)==true)
                d.insert(CN2.obj);
                CN2=CN2.next;
            }
            return d;
        }
}

class Exchange
{
    public class List
    {
        Exchange obje;
        List next;
        List(Exchange e)
        {
            obje=e;
            next=null;
        }
    }
    public class methods
    {
        List head;
        methods()
        {
            head=null;
        }
        public void delete(Exchange o)
            {
            if(head == null)    return;
            List PN = null;
            List CN = head;
            while (CN != null && !CN.obje.equals(o))
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
        public void Insert(Exchange o)
            {
            List tempnode = head;
            if(head==null){ head=new List(o); return;}
            List prevnode = new List(o);
            while(tempnode.next!=null)
            {
                tempnode=tempnode.next;
            }
            tempnode.next=prevnode;
            }
        public Boolean Ismember(Exchange o)
            {
                List PN = null;
                List CN = head;
                while(CN !=null && (CN.obje).id!=o.id)
                {
                    PN = CN;
                    CN = CN.next;
                }
                return !(CN==null);
            }
    }

    Exchange parnt=null;
    int id;
    int counter=0;
    methods l=new methods();
    MobilePhoneSet set=new MobilePhoneSet();
    public Exchange(int number)
    {
        id=number;
    }

    public Exchange parent()
    {
        return parnt;
    }
    public int numChildren()
    {
        return counter;
    }
    public Exchange child(int i)throws CustomException
    {
        List currnode=null;
        currnode=l.head;
        if(i<=counter && i>0)
        {
            for(int j=1;j<i;j++)
            {
                currnode=currnode.next;
            }
        return currnode.obje;
        } else throw new CustomException("ith child does not exist");
    }
    public void addchild(Exchange o)
    {
        counter++;
        l.Insert(o);
        o.parnt=this;
    }
    public Boolean isRoot()
    {
        return(parnt==null);
    }
    public Boolean isLeaf()
    {
        return(counter==0);
    }
    public RoutingMapTree subtree(int i)
    {
        try
        {
            RoutingMapTree st=new RoutingMapTree();
            st.root= child(i);
            return st;
        }catch(Exception en1){}
        return null;
    }
    public void addmobile(MobilePhone a)
    {
        set.insertion(a);
    }
    public MobilePhoneSet residentSet()
    {
        return set;
    }
}

class MobilePhone
{
    Boolean b=true;
    int num;
    Exchange base;
    MobilePhone(int number)
    {
        num=number;
    }
    public int number()
    {
        return num;
    }
    public Boolean status()
    {
        return b;
    }
    public void switchOn() throws CustomException
    {
        if(b==false)  b=true;
        else throw new CustomException("Phone is already switched on");
    }
    public void switchOff() throws CustomException
    {
        if(b==true)  b=false;
        else throw new CustomException("Phone is already switched off");
    }
    public Exchange location() throws CustomException
    {
        if(b==true) return base;
        else throw new CustomException("Phone is switched off");

    }
}

class CustomException extends Exception
{
    public CustomException(String message)
    {
        super(message);
    }
}

class MobilePhoneSet
{
    Myset MPSet;
    public MobilePhoneSet()
    {
        MPSet=new Myset();
    }
    public void insertion(MobilePhone a)
    {
        MPSet.insert(a);
    }
    public void Mprint()
    {
        Link tempnode = MPSet.head;
        while(tempnode!=null)
        {
            if((tempnode.obj).b)
            System.out.println((tempnode.obj).num);
            tempnode=tempnode.next;
        }
    }
    public MobilePhone findit(int a) throws CustomException
    {
        Link tempnode = MPSet.head;
        while(tempnode!=null)
        {
            if((tempnode.obj).num==a)
            {
                return tempnode.obj;
            } else tempnode=tempnode.next;
        }throw new CustomException("Phone not found");
    }
}
class ExchangeList
{
    LinkedList<Integer> exlist= new LinkedList<Integer>();
}
