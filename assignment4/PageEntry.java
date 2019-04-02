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
    PageEntry(String pageName)
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
                                                    //char c[]= array[i].toCharArray();
                            //System.out.println(array[i].length());
                            if(array[i].equals("stacks")) array[i]="stack";
                            if(array[i].equals("structures")) array[i]="structure";
                            if(array[i].equals("applications")) array[i]="application";
                            WordEntry we =new WordEntry (array[i]);
                            Position po=new Position(this,j);
                            we.addPosition(po);
                            mht.addPositionsForWord(we);
                            /*if(pi.findw(we)!=null)
                                (pi.findw(we)).addPosition(po);
                            else
                            {
                                (pi.wlist).insert(we);
                                (pi.findw(we)).addPosition(po);
                            }
                            if(c[array[i].length()-1]== 's')
                            {
                                array[i]=array[i].substring(0,(array[i].length()-1));
                                WordEntry we =new WordEntry (array[i]);
                                Position po=new Position(this,j);
                                if(pi.findw(we)!=null)
                                    (pi.findw(we)).addPosition(po);
                                else
                                {
                                    (pi.wlist).insert(we);
                                    (pi.findw(we)).addPosition(po);
                                }
                            }*/
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
    PageIndex getPageIndex()
    {
        return pi;
    }
}

