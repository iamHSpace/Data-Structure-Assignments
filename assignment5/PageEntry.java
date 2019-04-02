import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class PageEntry
{
    BufferedReader br = null;
    PageIndex pi=new PageIndex();
    MyHashTable mht = new MyHashTable();
    String name;
    /**Constructor does the following things:\n
    *Reading the page.\n
    *Making all the words lowercase and replacing symbols with a "space".\n
    *Making a word entry for each word and assigning them their position.\n
    *Also, replacing plural words by singular as instructed.\n
    *Adding words in a HashTable.*/
    public PageEntry(String pageName)
    {
        name=pageName;
        try
        {
            String ab=null;
            br = new BufferedReader(new FileReader(pageName));
            int j=0;
            while ((ab = br.readLine()) != null)
            {
                if(ab.length()!=0)
                {
                    ab=ab.toLowerCase();
                    ab=ab.replace("{"," ");
                    ab=ab.replace("}"," ");
                    ab=ab.replace("<"," ");
                    ab=ab.replace(">"," ");
                    ab=ab.replace("("," ");
                    ab=ab.replace(")"," ");
                    ab=ab.replace("="," ");
                    ab=ab.replace("."," ");
                    ab=ab.replace(","," ");
                    ab=ab.replace(";"," ");
                    ab=ab.replace(":"," ");
                    ab=ab.replace("?"," ");
                    ab=ab.replace("#"," ");
                    ab=ab.replace("!"," ");
                    ab=ab.replace("-"," ");
                    ab=ab.replace("["," ");
                    ab=ab.replace("]"," ");
                    ab=ab.replace("\'"," ");
                    ab=ab.replace("\""," ");
                    String array[]=ab.split(" +");
                    for(int i=0; i<array.length;i++)
                    {
                        j++;
                        if(!array[i].equals("a") && !array[i].equals("an")  && !array[i].equals("the") && !array[i].equals("they") && !array[i].equals("these") && !array[i].equals("this") && !array[i].equals("for") && !array[i].equals("is") && !array[i].equals("are") && !array[i].equals("was") && !array[i].equals("of") && !array[i].equals("of") && !array[i].equals("or") && !array[i].equals("and") && !array[i].equals("does") && !array[i].equals("will") && !array[i].equals("whose"))
                        {
                            if(array[i].equals("stacks")) array[i]="stack";
                            if(array[i].equals("structures")) array[i]="structure";
                            if(array[i].equals("applications")) array[i]="application";
                            WordEntry we =new WordEntry (array[i]);
                            Position po=new Position(this,j);
                            we.addPosition(po);
                            mht.addPositionsForWord(we);
                        }
                    }
                }
            }
        }catch (IOException e) {e.printStackTrace();}
        finally
        {
			try
			{
				if (br != null)br.close();
			} catch (IOException ex) {ex.printStackTrace();}
        }
    }
    public PageIndex getPageIndex()
    {
        return pi;
    }
    /**This function returns the inverse added positions of a word within this page thereby allowing us to sort pages according to their relevance.*/
    public float getRelevanceOfPage(String str[], int jk)
    {
        int l = str.length;
        float q,s=0;
        if(jk==1)
        {
            for(int kk=0;kk<l;kk++)
            {
                WordEntry w = mht.findword(str[kk]);
                float r =0;
                if(w!=null)
                {
                    Linknode<Position> hhead = ((w.plist).head).Next;
                    while(hhead!=null)
                    {
                        q=(hhead.obj).wi;
                        r = r+(1/(q*q));
                        hhead = hhead.Next;
                    }
                }
                s=s+r;
            }
        }
        if(jk==2)
        {
        for(int kk=0;kk<l;kk++)
        {
            WordEntry w = mht.findword(str[kk]);
            float r =0;
            if(w==null)
                return -1;
            if(w!=null)
            {
                Linknode<Position> hhead = ((w.plist).head).Next;
                while(hhead!=null)
                {
                    q=(hhead.obj).wi;
                    r = r+(1/(q*q));
                    hhead = hhead.Next;
                }
            }
            s=s+r;
        }
        }
        if(jk==3)
        {
            WordEntry w = mht.findword(str[0]);
            for(int i=1;i<l;i++)
            {
                WordEntry w2 = ((this.mht).findword(str[i]));
                float r=0;
                if(w!= null && w2!= null)
                {
                    MyLinkedList<Position> out = w.plist;
                    Linknode<Position> p = (out.head).Next;
                    while(p != null)
                    {
                        if((w2.avlt).search((p.obj).wi + i) == true)
                        {
                           q = (p.obj).wi;
                           r = r+(1/(q*q));
                           s=r;
                        }
                        p = p.Next;
                    }
                }
            }
        }
        return s;
    }
}
