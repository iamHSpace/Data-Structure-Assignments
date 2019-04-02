import java.util.*;
public class InvertedPageIndex
{
    MySet<PageEntry> pglist=new MySet<PageEntry>();
    public void addPage(PageEntry p)
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
                pclist.addElement(currnode.obj);
            currnode=currnode.next;
        }
        return pclist;
    }
    public PageEntry getpage(String str)
    {
        Link<PageEntry> currnode=pglist.head;
        while(currnode!=null && !((currnode.obj).name).equals(str))
        {
            currnode=currnode.next;
        }
        return currnode.obj;
    }
    public MySet<PageEntry> getPagesWhichContainPhrase(String str[])
    {
        MySet<PageEntry> mpe = this.pglist;
        Link<PageEntry> currnode = mpe.head;
        MySet<PageEntry> mpen = new MySet<PageEntry>();
        MySet<PageEntry> mpef = new MySet<PageEntry>();
        while(currnode!=null)
        {
            if((currnode.obj).getRelevanceOfPage(str,2)>0) mpen.addElement(currnode.obj);
            currnode = currnode.next;
        }
        Link<PageEntry> pnode = mpen.head;
        Linknode<Position> pos = null;
        while(pnode!=null)
        {
            pos=(((((pnode.obj).mht).findword(str[0])).plist).head).Next;
            while(pos!=null)
            {
                for(int ty=1; ty<str.length; ty++)
                {
                    //System.out.println(ty);
                    //System.out.println(str.length);
                    WordEntry wwe = (((pnode.obj).mht).findword(str[ty]));
                    if(!(wwe.avlt).search(((pos.obj).wi)+ty)) break;
                    if(ty == str.length - 1)
                    {
                        if(!mpef.IsMember(pnode.obj))  mpef.addElement(pnode.obj);
                    }
                }
                pos = pos.Next;
            }
            pnode = pnode.next;
        }
        if(mpe.head==null) System.out.println("No webpage contains word "+str);
        //System.out.println(mpef.IsEmpty());
        return mpef;
    }
}


