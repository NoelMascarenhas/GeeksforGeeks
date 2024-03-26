//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    String sum(String s1,String s2){
        int n1=s1.length(),n2=s2.length();
        StringBuilder sb=new StringBuilder();
        int i=n1-1,j=n2-1,carry=0;
        while(i>=0 || j>=0 || carry!=0){
            int sum=carry;
            sum+=i>=0?s1.charAt(i--)-'0':0;
            sum+=j>=0?s2.charAt(j--)-'0':0;
            sb.append(sum%10);
            carry=sum/10;
        }
        return sb.reverse().toString();
    } 
    boolean solve(int st,int i,int j,String n){
        String s1=n.substring(st,i+1);
        String s2=n.substring(i+1,j);
        String sum=sum(s1,s2);
        int len=sum.length();
        
        if(j+len>n.length())return false;
        if(n.substring(j,j+len).equals(sum)){
           if(j+len==n.length())return true;
           if(solve(i+1,j-1,j+len,n))return true;
        }
        return false;
    }
    public boolean isAdditiveSequence(String n) {
        for(int i=0;i<n.length();i++){
            for(int j=i+1;j<=n.length();j++){
                if(solve(0,i,j,n))return true;
            }
        }
        return false;
    }
}
