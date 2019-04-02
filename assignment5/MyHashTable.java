import java.util.*;
public class MyHashTable
{
    MyLinkedList<WordEntry>[] ht =(MyLinkedList<WordEntry>[]) new MyLinkedList[100];
    MyHashTable()
    {
        for(int i=0;i<100;i++)
        {
            ht[i]= new MyLinkedList<WordEntry>();
        }
    }
    private int getHashIndex(String str)
    {
        int sum=7;
        for(int ii=0; ii<str.length();ii++)
        {
            sum = sum + str.charAt(ii);
        }
        sum = sum%100;
        return sum;
    }
    public WordEntry findword(String str)
    {
        int hii = getHashIndex(str);
        Linknode<WordEntry> CN= ht[hii].head;
        Linknode<WordEntry> PN= null;
        if(CN==null) return null;
        while(CN!=null && !((CN.obj).word).equals(str))
        {
            PN = CN;
            CN = CN.Next;
        }
        if(CN==null) return null;
        return CN.obj;
    }
    void addPositionsForWord(WordEntry w)
    {
        int hi = getHashIndex(w.word);
        //System.out.println(hi);
        Linknode<WordEntry> CN= ht[hi].head;
        Linknode<WordEntry> PN= null;
        while(CN!=null )
        {
            if(((CN.obj).word).equals(w.word))
            PN = CN;
            CN = CN.Next;
        }
        if(PN==null)
        {
            ht[hi].insert(w);
            Linknode<WordEntry> currnode = ht[hi].head;
            while(currnode.Next !=null)
            currnode = currnode.Next;
            (currnode.obj).addPosition(((w.plist).head).obj);
        }
        else
        {
            (PN.obj).addPosition(((w.plist).head).obj);
        }
    }
}

