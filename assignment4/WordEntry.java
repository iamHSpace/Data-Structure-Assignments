import java.util.*;
public class WordEntry
{
    String word;
    MyLinkedList<Position> plist=new MyLinkedList<Position>();
    WordEntry(String Word)
    {
        word=Word;
    }
    void addPosition(Position position)
    {
        plist.insert(position);
    }
    void addPositions(MyLinkedList<Position> positions)
    {
        plist.Union(positions);
    }
    MyLinkedList<Position> getAllPositionsForThisWord()
    {
        return plist;
    }
}

