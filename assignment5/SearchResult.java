import java.util.*;
public class SearchResult implements Comparable<SearchResult>
{
    PageEntry p;
    float r;
    public SearchResult(PageEntry pe, float fr)
    {
        p=pe;
        r=fr;
    }
    public PageEntry getPageEntry()
    {
        return p;
    }
    public float getRelevance()
    {
        return r;
    }
    public int compareTo(SearchResult otherObject)
    {
        if(this.r>otherObject.r) return 1;
        if(this.r==otherObject.r) return 0;
        return -1;
    }
}
