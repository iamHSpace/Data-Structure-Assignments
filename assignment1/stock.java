import java.io.*;
public class stock{
	//Perform I/O operation

	void performAction(String actionString){
	    long tStart = System.currentTimeMillis();
   String gajab[]=new String[8];
    int i=0;
    while(actionString.charAt(i)!='\t') i++;
    gajab[0]=actionString.substring(0,i);
    i++;
    int j=i;
    while(actionString.charAt(j)!='\t') j++;
    gajab[1]=actionString.substring(i,j);
    j=j+1;
    int k=j;
    while(actionString.charAt(k)!='\t') k++;
    gajab[2]=actionString.substring(j,k);
    k=k+1;
    int l=k;
    while(actionString.charAt(l)!='\t') l++;
    gajab[3]=actionString.substring(k,l);
    l=l+1;
    int m=l;
    while(actionString.charAt(m)!='\t') m++;
    gajab[4]=actionString.substring(l,m);
    m=m+1;
    int n=m;
    while(actionString.charAt(n)!='\t') n++;
    gajab[5]=actionString.substring(m,n);
    n=n+1;
    int o=n;
    while(actionString.charAt(o)!='\t') o++;
    gajab[6]=actionString.substring(n,o);
    o=o+1;
    int p=n;
    while(actionString.charAt(p)!='\t') p++;
    gajab[7]=actionString.substring(o);
    int [] a=new int[4];
    a[0]=Integer.parseInt(gajab[0]);
    a[1]=Integer.parseInt(gajab[2]);
    a[2]=Integer.parseInt(gajab[4]);
    a[3]=Integer.parseInt(gajab[6]);

    class link1{
    int T0,Texp,Qty,Price;
    String Name,Type,Stock;
    String Partial;
    link1 next;

    link1(int a1,String b1,int a2,String b2,int a3,String b3,int a4,String b4){

    T0 = a1;
    Name = b1;
    Texp = a2;
    Type = b2;
    Qty = a3;
    Stock = b3;
    Price = a4;
    Partial = b4;
    next = null;
    }
}
    class linklist{
        link1 head;
        linklist(int a1,String b1,int a2,String b2,int a3,String b3,int a4,String b4){
            head = new link1(a1,b1,a2,b2,a3,b3,a4,b4);
        }

        public void delete(int a1,String b1,int a2,String b2,int a3,String b3,int a4,String b4) {
        if(head == null){
            return;
        }
        link1 PN = null;
        link1 CN = head;
        while (CN != null) {
            PN = CN;
            CN = CN.next;
        }
        if(PN == null){
            head = head.next;
            return;
        }
        if (CN == null) {
            System.out.println("A node with that value does not exist.");
            return;
        }
        PN.next = CN.next;
    }
     public void insert(int a1,String b1,int a2,String b2,int a3,String b3,int a4,String b4) {
        link1 tempnode = head;
        head = new link1(a1,b1,a2,b2,a3,b3,a4,b4);
        head.next = tempnode;
        return;
    }
    }
    long tEnd = System.currentTimeMillis();
    double tdelta=(tEnd-tStart)/1000.0;

    //link1 element=new link1(a[0],gajab[1],a[1],gajab[3],a[2],gajab[5],a[3],gajab[7]);
    //System.out.println(element.T0);
if(tdelta<(a[0]+a[1]) && a[3]>=0 /*&& tdelta>=a[0]*/)
    {
    link1 element=new link1(a[0],gajab[1],a[1],gajab[3],a[2],gajab[5],a[3],gajab[7]);
    System.out.println(element.T0);
    System.out.println(element.Name);
    try{
    FileOutputStream ofile = new FileOutputStream ("out. txt",true );
    PrintStream rndm = new PrintStream (ofile);
    rndm.println(element.T0+"    "+element.Name+"    "+element.Texp+"   "+element.Type+"    "+element.Qty+" "+element.Stock+"   "+element.Price+"   "+element.Partial);

    } catch(Exception e1){}
    }
	}
}
