import java.util.*;
public class PageIndex
{
    MyLinkedList<WordEntry> wlist= new MyLinkedList<WordEntry>();
    public WordEntry findw(WordEntry w)
    {
        Linknode<WordEntry> cn = wlist.head;
        if(cn==null) return null;
        while(cn!=null && !((cn.obj).word).equals(w.word))
        {
            cn=cn.Next;
        }
        if(cn!=null) return cn.obj;
        return null;
    }
    public void addPositionForWord(String str, Position p)
    {
        WordEntry w=new WordEntry(str);
        if(this.findw(w)==null)
        {
            wlist.insert(w);
            (w.plist).insert(p);
        }
        if(this.findw(w)!=null)
        {
            (this.findw(w)).addPosition(p);
        }
    }
    public MyLinkedList<WordEntry> getWordEntries()
    {
        return wlist;
    }
}

