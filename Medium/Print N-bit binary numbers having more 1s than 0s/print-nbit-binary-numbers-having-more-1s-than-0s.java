//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String>ans = new ArrayList<>();
        int total = (int)Math.pow(2,N);
        int len = total - (int)Math.pow(2,N-1);
        for(int i=1;i<=len;i++){
            String str = Integer.toBinaryString(total-i);
            if(isValid(str))ans.add(str);
        }
        return ans;
    }
    boolean isValid(String str){
        int one = 0,zero = 0;
        for(char c:str.toCharArray()){
            if(c=='0')zero++;
            else one++;
            if(one<zero)return false;
        }
        return one>=zero;
    }
}