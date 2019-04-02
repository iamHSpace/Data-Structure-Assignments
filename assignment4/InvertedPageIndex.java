import java.util.*;
public class InvertedPageIndex
{
    MySet<PageEntry> pglist=new MySet<PageEntry>();
    void addPage(PageEntry p)
    {
        pglist.addElement(p);
    }
    MySet<PageEntry> getPagesWhichContainWord(String str)
    {
        WordEntry nn=new WordEntry(str);
        Link<PageEntry> currnode=pglist.head;
        MySet<PageEntry> pclist = new MySet<PageEntry>();
        while(currnode!=null)
        {
                if(((currnode.obj).mht).findword(str)!=null)
                {
                    /*Linknode<Position> khs = (((currnode.pi).findw).plist).head;
                    while(khs!=null)
                    {
                        System.out.println(khs.p.pi);
                        khs=khs.Next;
                    }*/
                    pclist.addElement(currnode.obj);
                }
            currnode=currnode.next;
        }
        //if(pclist.head==null) System.out.println("Word not found");
        return pclist;
    }
    PageEntry getpage(String str)
    {
        Link<PageEntry> currnode=pglist.head;
        while(currnode!=null && !((currnode.obj).name).equals(str))
        {
            currnode=currnode.next;
        }
        return currnode.obj;
    }
}


