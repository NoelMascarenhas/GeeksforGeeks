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
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        String ans = "";
        int i = 0, j = 0;
        while (i < n) {
            String t = s.substring(j, i + 1);
            int x = s.indexOf(t, i + 1);
            if (x != -1) {
                if (t.length() > ans.length()) {
                    ans = t;
                }
                i++;
            } 
            else {
                j++;
            }
            if (i < j) {
                i = j;
            }
        }
        if (ans.equals("")) {
            return "-1";
        }
        return ans;
    }
};