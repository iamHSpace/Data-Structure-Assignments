public class SearchEngine
{
	public SearchEngine(){}
		InvertedPageIndex ipi=new InvertedPageIndex();
		void addpage(String str)
		{
		    InvertedPageIndex ipia=ipi;
		    PageEntry pp=new PageEntry(str);
		    ipia.addPage(pp);
		}
		void findpages(String str)
		{
            InvertedPageIndex ipif=ipi;
            MySet<PageEntry> mpe=new MySet<PageEntry>();
            mpe = ipif.getPagesWhichContainWord(str);
            WordEntry st=new WordEntry(str);
            Link<PageEntry> currnode = mpe.head;
            //MyLinkedList<String> kha = new MyLinkedList<String>();
            while(currnode!=null)
            {
                /*Linknode<Position> khs = ((((currnode.obj).pi).findw(st)).plist).head;
                while(khs!=null)
                if(kha.ismember(((khs.obj).p).name)==false)
                Do not print the same thing over idiot.
                kha.insert(((khs.obj).p).name);
                khs=khs.Next;
                }*/
                if(currnode!=null)
                {
                    if(currnode.next!=null)  System.out.print((currnode.obj).name+", ");
                    else System.out.println((currnode.obj).name);
                }
                currnode=currnode.next;
            }
            if(mpe.head==null) System.out.println("No webpage contains word "+str);
;		}
		void findposition(String word, String pname)
		{
		    try
            {
                InvertedPageIndex ipip=ipi;
                PageEntry pee = ipip.getpage(pname);
                WordEntry ste=new WordEntry(word);
                Linknode<Position> pos=((((pee.mht).findword(word)).plist).head).Next;
                while(pos!=null)
                {
                    System.out.println((pos.obj).wi);
                    pos=pos.Next;
                }
            }catch(Exception e1){System.out.println("Webpage "+pname +" does not contain word "+word);}
		}

	public void performAction(String actionMessage)
	{
		System.out.println(actionMessage);
		String arre[]=actionMessage.split(" ");
		if(arre[0].equals("addPage"))
        {
            addpage(arre[1]);
        }
        if(arre[0].equals("queryFindPagesWhichContainWord"))
        {
            char cc[]= arre[1].toCharArray();
            //if(cc[arre[1].length()-1]== 's')    arre[1]=arre[1].substring(0,(arre[1].length()-1));
            arre[1]=arre[1].toLowerCase();
            findpages(arre[1]);
        }
        if(arre[0].equals("queryFindPositionsOfWordInAPage"))
        {
            arre[1] = arre[1].toLowerCase();
            findposition(arre[1],arre[2]);
        }
	}
}
