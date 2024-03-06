//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        ArrayList<Integer> a=new ArrayList<Integer>();
        int m=pattern.length();
        int n=text.length();
        int c=0;
        for(int i=0;i<n-m+1;i++)
        {
            String s1=text.substring(i,i+m);
            if(s1.equals(pattern))
            {
                a.add(i+1);
                c++;
            }
        }
        return a;
    }
}