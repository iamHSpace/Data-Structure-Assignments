import java.util.*;
public class Position
{
    PageEntry p;
    int wi;
    Position(PageEntry page, int wordIndex)
    {
        wi=wordIndex;
        p=page;
    }
    PageEntry getPageEntry()
    {
        return p;
    }
    int getWordIndex()
    {
        return wi;
    }
}

