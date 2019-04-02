import java.util.*;
public class WordEntry
{
    String word;
    MyLinkedList<Position> plist=new MyLinkedList<Position>();
    AVLTree avlt = new AVLTree();
    public WordEntry(String Word)
    {
        word=Word;
    }
    public void addPosition(Position position)
    {
        plist.insert(position);
        avlt.insert(position);
    }
    public void addPositions(MyLinkedList<Position> positions)
    {
        plist.Union(positions);
    }
    public MyLinkedList<Position> getAllPositionsForThisWord()
    {
        return plist;
    }
    public class AVLNode
    {
         AVLNode left, right;
         Position p;
         int height;
         public AVLNode()
         {
             left = null;
             right = null;
             p = null;
             height = 0;
         }
         public AVLNode(Position n)
         {
             left = null;
             right = null;
             p = n;
             height = 0;
         }
     }
     class AVLTree
     {
        private AVLNode root;
        public AVLTree()
         {
             root = null;
         }
         public boolean isEmpty()
         {
             return root == null;
         }
         public void insert(Position data)
         {
             root = insert(data, root);
         }
         private int height(AVLNode t )
         {
             return t == null ? -1 : t.height;
         }
         int max(int a, int b)
         {
             if(a>=b) return a;
             return b;
         }
         private AVLNode insert(Position x, AVLNode t)
         {
             if (t == null)
                 t = new AVLNode(x);
             else if (x.wi < (t.p).wi)
             {
                 t.left = insert( x, t.left );
                 if( height( t.left ) - height( t.right ) == 2 )
                     if( x.wi < ((t.left).p).wi)
                         t = rotateWithLeftChild( t );
                     else
                         t = doubleWithLeftChild( t );
             }
             else if( x.wi > (t.p).wi)
             {
                 t.right = insert( x, t.right );
                 if( height( t.right ) - height( t.left ) == 2 )
                     if( x.wi > ((t.right).p).wi)
                         t = rotateWithRightChild( t );
                     else
                         t = doubleWithRightChild( t );
             }
             else
               ;  // Duplicate; do nothing
             t.height = max( height( t.left ), height( t.right ) ) + 1;
             return t;
         }
         private AVLNode rotateWithLeftChild(AVLNode k2)
         {
             AVLNode k1 = k2.left;
             k2.left = k1.right;
             k1.right = k2;
             k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
             k1.height = max( height( k1.left ), k2.height ) + 1;
             return k1;
         }
        private AVLNode rotateWithRightChild(AVLNode k1)
         {
             AVLNode k2 = k1.right;
             k1.right = k2.left;
             k2.left = k1;
             k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
             k2.height = max( height( k2.right ), k1.height ) + 1;
             return k2;
         }
         private AVLNode doubleWithLeftChild(AVLNode k3)
         {
             k3.left = rotateWithRightChild( k3.left );
             return rotateWithLeftChild( k3 );
         }
         private AVLNode doubleWithRightChild(AVLNode k1)
         {
             k1.right = rotateWithLeftChild( k1.right );
             return rotateWithRightChild( k1 );
         }
         public int countNodes()
         {
             return countNodes(root);
         }
         private int countNodes(AVLNode r)
         {
             if (r == null)
                 return 0;
             else
             {
                 int l = 1;
                 l += countNodes(r.left);
                 l += countNodes(r.right);
                 return l;
             }
         }
         public boolean search(int val)
         {
             return search(root, val);
         }
         private boolean search(AVLNode r, int val)
         {
             boolean found = false;
             while ((r != null) && !found)
             {
                 int rval = (r.p).wi;
                 if (val < rval)
                     r = r.left;
                 else if (val > rval)
                     r = r.right;
                 else
                 {
                     found = true;
                     break;
                 }
                 found = search(r, val);
             }
             return found;
         }
     }
}
