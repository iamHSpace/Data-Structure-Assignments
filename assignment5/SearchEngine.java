import java.util.*;
import java.io.IOException;
public class SearchEngine
{
    public SearchEngine(){
        /** Defining the constructor*/
	}
		InvertedPageIndex ipi=new InvertedPageIndex();
		public void addpage(String str)
		{
		    /**Adding a page by adding a newly created page entry to the inverted page index*/
		    PageEntry pp=new PageEntry(str);
		    ipi.addPage(pp);
		}
		public void findpages(String str)
		{
		    String[] sttr = new String[1];
		    sttr[0] = str;
            MySet<PageEntry> mpe=new MySet<PageEntry>();
            mpe = ipi.getPagesWhichContainWord(str);
            //WordEntry st=new WordEntry(str);
		    MySort ms = new MySort();
		    ArrayList<SearchResult> aa = ms.sortThisList(mpe,sttr,1);
		    for(int ip=0; ip<aa.size();ip++)
            {
                if(ip!= aa.size()-1)
                System.out.print(((aa.get(ip)).p).name+", ");
                else System.out.println(((aa.get(ip)).p).name);
                //System.out.println((aasr.get(ik)).r);
            }
            Link<PageEntry> currnode = mpe.head;
            /*while(currnode!=null)
            {
                if(currnode!=null)
                {
                    if(currnode.next!=null)  System.out.print((currnode.obj).name+", ");
                    else System.out.println((currnode.obj).name);
                }
                currnode=currnode.next;
            }*/
            if(mpe.head==null) System.out.println("No webpage contains word "+str);
;		}
		public void findposition(String word, String pname)
		{
		    try
            {
                PageEntry pee = ipi.getpage(pname);
                WordEntry ste=new WordEntry(word);
                Linknode<Position> pos=((((pee.mht).findword(word)).plist).head).Next;
                while(pos!=null)
                {
                    if(pos.Next!=null)  System.out.print((pos.obj).wi+", ");
                    else System.out.println((pos.obj).wi);
                    pos=pos.Next;
                }
            }catch(NullPointerException e99) {e99.printStackTrace();}
            /**Catching the null pointer exception if word/page is not found*/
		}
		public void findpagesOR(String str[])
		{
		    try
		    {
                MySort ms = new MySort();
                ArrayList<SearchResult> aasr = ms.sortThisList(ipi.pglist,str,1);
                for(int ik=0; ik<aasr.size();ik++)
                {
                    if(ik!= aasr.size()-1) System.out.print(((aasr.get(ik)).p).name+", ");
                    else System.out.println(((aasr.get(ik)).p).name);
                    //System.out.println((aasr.get(ik)).r);
                }
            }catch(Exception e99){System.out.println("No webpage contain any of these words.");}
            //if(aasr.size()==0) System.out.println("No webpage contain any of these words.");
		}
		public void findpagesAND(String str[])
		{
            MySort ms = new MySort();
		    ArrayList<SearchResult> aasr = ms.sortThisList(ipi.pglist,str,2);
		    for(int ik=0; ik<aasr.size();ik++)
            {
                if(ik!= aasr.size()-1) System.out.print(((aasr.get(ik)).p).name+", ");
                else System.out.println(((aasr.get(ik)).p).name);
                //System.out.println((aasr.get(ik)).r);
            }
            if(aasr.size()==0) System.out.println("No webpage contains all of these words.");
		}
		public void findphrase(String str[])
		{
		    MySet<PageEntry> mpe = ipi.getPagesWhichContainPhrase(str);
            Link<PageEntry> currnode = mpe.head;
            /*while(currnode!=null)
            {
                System.out.println((currnode.obj).name);
                currnode = currnode.next;
            }*/
            MySort ms = new MySort();
		    ArrayList<SearchResult> aasr = ms.sortThisList(mpe,str,3);
		    for(int ik=0; ik<aasr.size();ik++)
            {
                if(ik!= aasr.size()-1) System.out.print(((aasr.get(ik)).p).name+", ");
                else System.out.println(((aasr.get(ik)).p).name);
                //System.out.println((aasr.get(ik)).r);
            }
            if(aasr.size()==0) System.out.println("No webpage contains this phrase.");
            /*MySet<PageEntry> mpen = new MySet<PageEntry>();
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
                        WordEntry wwe = (((pnode.obj).mht).findword(str[ty]));
                        if(!(wwe.avlt).search(((pos.obj).wi)+1)) break;
                        if(ty == str.length - 1) System.out.println((pnode.obj).name);
                    }
                    pos = pos.Next;
                }
                pnode = pnode.next;
            }
            if(mpe.head==null) System.out.println("No webpage contains word "+str);*/
		}

	public void performAction(String actionMessage)
	{
		System.out.println(actionMessage);
		String arre[]=actionMessage.split(" ");
		for(int i=1; i<arre.length;i++)
        {
            arre[i]=arre[i].toLowerCase();
            if(arre[i].equals("stacks")) arre[i]="stack";
            if(arre[i].equals("structures")) arre[i]="structure";
            if(arre[i].equals("applications")) arre[i]="application";
        }
		if(arre[0].equals("addPage"))
        {
            addpage(arre[1]);
        }
        if(arre[0].equals("queryFindPagesWhichContainWord"))
        {
            char cc[]= arre[1].toCharArray();
            arre[1]=arre[1].toLowerCase();
            findpages(arre[1]);
        }
        if(arre[0].equals("queryFindPositionsOfWordInAPage"))
        {
            arre[1] = arre[1].toLowerCase();
            findposition(arre[1],arre[2]);
        }
        if(arre[0].equals("queryFindPagesWhichContainAllWords"))
        {
            int qw = arre.length;
            String stt[] = new String[qw-1];
            for(int aq=0;aq<qw-1;aq++)
            {
                stt[aq] = arre[aq+1];
            }
            findpagesAND(stt);
        }
        if(arre[0].equals("queryFindPagesWhichContainAnyOfTheseWords"))
        {
            int qe = arre.length;
            String ste[] = new String[qe-1];
            for(int ae=0;ae<qe-1;ae++)
            {
                ste[ae] = arre[ae+1];
            }
            findpagesOR(ste);
        }
        if(arre[0].equals("queryFindPagesWhichContainPhrase"))
        {
            int qw = arre.length;
            String stt[] = new String[qw-1];
            for(int aq=0;aq<qw-1;aq++)
            {
                stt[aq] = arre[aq+1];
            }
            findphrase(stt);
        }
        System.out.println(" ");
	}
}
