import java.util.*;
class Prime
{
 public static void main(String argv[])
 {
   Scanner sc=new Scanner(System.in);
   int i,num;
   num=sc.nextInt();
   int count=0;
   for(i=1;i<num;i++)
   {
    if(num%i==0)
    {
     count++;
    }
   }
    System.out.println("count="+count);
    if(count<2)
    {
      System.out.println(" prime");
    }
    else
    {
      System.out.println("not prime");
    }
   }
}  
   