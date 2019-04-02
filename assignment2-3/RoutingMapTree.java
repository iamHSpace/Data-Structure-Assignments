import java.util.*;
public class RoutingMapTree
{
    Exchange root;
	public RoutingMapTree()
	{
        root=new Exchange(0);
	}
	public Boolean containsNode(Exchange a)
	{
	    Exchange node=root;
	    if(a.id==root.id) return true;
        while(node!=null)
        {
            if((node.l).Ismember(a)==true) return true;
            else
            {
                for(int k=1;k<=node.counter;k++)
                {
                    try
                    {
                        if((node.subtree(k)).containsNode(a)==true) return true;
                    }catch(Exception en3){}
                }
            }
        }
        return false;
	}
	public void addexchange(int a, int b) throws CustomException
	{
	    try{
        Exchange chiild=new Exchange(b);
        Exchange node=find(a);
        node.addchild(chiild);
         System.out.println("Child added");
	    }catch(Exception e3){
        throw new CustomException("Node not found");}
	}
    public Exchange find(int a)
    {
        Exchange node=root;
        Exchange temp= null;
        if(node.id==a) return node;
        if(node.counter!=0)
        {
            for(int k=1;k<=node.counter;k++)
            {
                try
                {
                    if((node.child(k)).id==a) return node.child(k);
                    temp=node.child(k);
                } catch(Exception en7){}
                for(int raj= 1; raj<= temp.counter; raj++){
                Exchange zz=(temp.subtree(raj)).find(a);
                if(zz!=null) return zz;}
            }
        }
        return null;
    }
    public void switchOn(int M, int E) throws CustomException
    {
        try
        {
            Exchange node=find(E);
            MobilePhone MP=new MobilePhone(M);
            MobilePhoneSet nset=node.set;
            if(((root.set).MPSet).IsMember(MP)==false)
            {
               while(node!=null)
                {
                    node.addmobile(MP);
                    node=node.parnt;
                }
            }
            if(((root.set).MPSet).IsMember(MP)==true)
            {
                while(node!=null)
                {
                    MobilePhone abcd=nset.findit(M);
                    abcd.b=true;
                }
                return;
            }
        }catch(Exception e1){
        throw new CustomException("Node not found");}
    }
    public void querychild(int a, int b) throws CustomException
    {
        try
        {
        Exchange ab= find(a);
        System.out.println((ab.child(b)).id);
        }catch(Exception e4)
        {
            throw new CustomException("Node not found");
        }
    }
    public void switchOff(int a)throws CustomException
    {
        MobilePhone MP=new MobilePhone(a);
        Exchange node=root;
        if(((root.set).MPSet).IsMember(MP)==true)
        {
            MobilePhone abcd=(node.set).findit(a);
            abcd.b=false;
                for(int p=1;p<=node.counter;p++)
                {
                    if((((node.child(p)).set).MPSet).IsMember(MP))
                    {
                        node=node.child(p);
                        MobilePhone bcd=(node.set).findit(a);
                        bcd.b=false;
                    }
                }
        } else throw new CustomException("Mobile not found");
    }
    public void query(int a) throws CustomException
    {
        try{
        Exchange exc=find(a);
        (exc.set).Mprint();
        if(((exc.set).MPSet).IsEmpty()==true) throw new CustomException("Set empty");
        } catch (Exception e2){throw new CustomException("Node not found");
        }
    }
    public Exchange findPhone(int a)throws CustomException
    {
        try
        {
            MobilePhone MP=new MobilePhone(a);
            Exchange node=root;
            Exchange tempnode=null;
            MobilePhone bcd=(node.set).findit(a);
            if(((node.set).MPSet).IsMember(MP)==true && bcd.b==true)
            {
                if(node.isLeaf()==true) return node;
                for(int p=1;p<=node.counter;p++)
                {
                    if((((node.child(p)).set).MPSet).IsMember(MP))
                    {
                        tempnode=node.child(p);
                        for(int kk= 1; kk<= tempnode.counter; kk++)
                        {
                            Exchange zz=(tempnode.subtree(kk)).findPhone(a);
                            if(zz!=null) return zz;
                        }
                    }
                }
            }else throw new CustomException("Mobile not found or is switched off");
        }catch (Exception ehjg){}
        return null;
    }
    public Exchange lowestrouter(int a, int b)
    {
        try
        {
            Exchange node=root;
            Exchange ab=find(a);
            Exchange abc=find(b);
            Exchange temp=ab.parnt;
            if(ab.id==abc.id) return ab;
            while(temp!=null)
            {
                for(int i=1;i<=temp.counter;i++)
                {
                    if((temp.subtree(i)).find(b)!=null)
                    {
                        return temp;
                    }
                }
                temp=temp.parnt;
            }
        } catch(Exception jh){};
    return null;
    }
    public ExchangeList routecall(int a, int b) throws CustomException
    {
        try
        {
            ExchangeList abcde=new ExchangeList();
            ExchangeList abcdef=new ExchangeList();
            Exchange ab=findPhone(a);
            Exchange abc=findPhone(b);
            Exchange abcd=lowestrouter(ab.id,abc.id);
            MobilePhone MP1=(abcd.set).findit(a);
            MobilePhone MP2=(abcd.set).findit(b);
            if(MP1.b==true && MP2.b==true)
            {
                if(ab.id==abcd.id)
                {
                    (abcde.exlist).add(ab.id);
                    return abcde;
                }
                while(ab!=abcd)
                {
                    (abcde.exlist).add(ab.id);
                    ab=ab.parnt;
                }
                (abcde.exlist).add(abcd.id);
                while(abc!=abcd)
                {
                    (abcdef.exlist).addFirst(abc.id);
                    abc=abc.parnt;
                }
                for(int jj=0;jj<(abcdef.exlist).size();jj++)
                {
                    (abcde.exlist).add((abcdef.exlist).get(jj));
                }
                return abcde;
            }else throw new CustomException("Mobile not found or is switched off");
        }catch(Exception hrg){};
    return null;
    }
    public void movephone(int a, int b) throws CustomException
    {
        try
        {
            MobilePhone MP= new MobilePhone(a);
            Exchange old = findPhone(a);
            Exchange ex=find(b);
            Exchange temp=old;
            if(ex.isLeaf()==true && MP.b==true)
            {
                while(temp!=null)
                {
                    ((temp.set).MPSet).delete(MP);
                    temp=temp.parnt;
                }
            switchOn(a,b);
            }
            else throw new CustomException("Mobile not found or is switched off");
        }
        catch(Exception gjkdn){}
    }
	public void performAction(String actionMessage)
	{
	    System.out.println(actionMessage);
	    String[] actmsg=actionMessage.split("\\W+");
        if(actmsg[0].equals("addExchange"))
        {
            try
            {
                addexchange(Integer.parseInt(actmsg[1]),Integer.parseInt(actmsg[2]));
            }catch(Exception e9){System.out.println("Node not found");}
        }
        if(actmsg[0].equals("switchOnMobile"))
        {
            try
            {
                switchOn(Integer.parseInt(actmsg[1]),Integer.parseInt(actmsg[2]));
                System.out.println("Switched On");
            }catch(Exception e8){System.out.println("Node not found");}
        }
        if(actmsg[0].equals("switchOffMobile"))
        {
            try
            {
                switchOff(Integer.parseInt(actmsg[1]));
                System.out.println("Switched Off");
            }catch(Exception e7){System.out.println("Phone not found");}
        }
        if(actmsg[0].equals("queryNthChild"))
        {
            try
            {
                System.out.println("Query");
                querychild(Integer.parseInt(actmsg[1]),(Integer.parseInt(actmsg[2]))+1);
            }catch (Exception e6){System.out.println("Child not found");}
        }
        if(actmsg[0].equals("queryMobilePhoneSet"))
        {
            try
            {
                System.out.println("Set is:");
                query(Integer.parseInt(actmsg[1]));
            }catch (Exception e5){System.out.println("Wrong query");}
        }
        if(actmsg[0].equals("lowestRouter"))
        {
            Exchange bbb=lowestrouter(Integer.parseInt(actmsg[1]),Integer.parseInt(actmsg[2]));
            System.out.println(bbb.id);

        }
        if(actmsg[0].equals("findPhone"))
        {
            try
            {
                Exchange aaa= findPhone(Integer.parseInt(actmsg[1]));
                System.out.println(aaa.id);
            }catch(Exception e8){System.out.println("Phone is not present");}
        }
        if(actmsg[0].equals("findCallPath"))
        {
            try{
            ExchangeList ll=routecall(Integer.parseInt(actmsg[1]),Integer.parseInt(actmsg[2]));
            System.out.println(ll.exlist);} catch(Exception kshv){System.out.println("Mobile switched off");}
        }
        if(actmsg[0].equals("movePhone"))
        {
            try
            {
                movephone(Integer.parseInt(actmsg[1]),Integer.parseInt(actmsg[2]));
            }catch(Exception e8){System.out.println("Phone switched off");}
        }
        System.out.println("");
	}
}
