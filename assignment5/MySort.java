import java.util.*;
public class MySort
{
    public ArrayList<SearchResult> sortThisList(MySet<PageEntry> list, String str[],int mn)
    {
        ArrayList<SearchResult> asr = new ArrayList<SearchResult>();
        Link<PageEntry> cn = list.head;
        SearchResult temp = null;
        if(mn==1)
        {
            while(cn!=null)
            {
                if((cn.obj).getRelevanceOfPage(str,1)>0)
                {
                    SearchResult sr = new SearchResult(cn.obj,(cn.obj).getRelevanceOfPage(str,1));
                    asr.add(sr);
                }
                cn = cn.next;
            }
            int j;
            for(int i=1; i<asr.size();i++)
            {
                j=i;
                while(j>0 && asr.get(j-1).compareTo(asr.get(j))==-1)
                {
                    temp = asr.get(j-1);
                    asr.set(j-1,asr.get(j));
                    asr.set(j,temp);
                    j=j-1;
                }
            }
        }
        if(mn==2)
        {
            while(cn!=null)
            {
                if((cn.obj).getRelevanceOfPage(str,2)>0)
                {
                    SearchResult sr = new SearchResult(cn.obj,(cn.obj).getRelevanceOfPage(str,2));
                    asr.add(sr);
                }
                cn = cn.next;
            }
            int j;
            for(int i=1; i<asr.size();i++)
            {
                j=i;
                while(j>0 && asr.get(j-1).compareTo(asr.get(j))==-1)
                {
                    temp = asr.get(j-1);
                    asr.set(j-1,asr.get(j));
                    asr.set(j,temp);
                    j=j-1;
                }
            }
        }
        if(mn==3)
        {
            while(cn!=null)
            {
                SearchResult sr = new SearchResult(cn.obj,(cn.obj).getRelevanceOfPage(str,3));
                //System.out.println("a");
                asr.add(sr);
                cn = cn.next;
            }
            int j;
            for(int i=1; i<asr.size();i++)
            {
                j=i;
                while(j>0 && asr.get(j-1).compareTo(asr.get(j))==-1)
                {
                    temp = asr.get(j-1);
                    asr.set(j-1,asr.get(j));
                    asr.set(j,temp);
                    j=j-1;
                }
            }
        }
        return asr;
    }
}
