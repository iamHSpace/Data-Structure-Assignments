import java.util.*;
public class Position
{
    PageEntry p;
    int wi;
    public Position(PageEntry page, int wordIndex)
    {
        wi=wordIndex;
        p=page;
    }
    public PageEntry getPageEntry()
    {
        return p;
    }
    public int getWordIndex()
    {
        return wi;
    }
}

