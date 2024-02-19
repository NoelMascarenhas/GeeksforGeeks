//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
         for(Character c: map.keySet()) {
            pq.add(map.get(c));
        }
        
        int count = 0;
        while(count!=k) {
            int num = pq.remove();
            num--;
            if(num>0) {
                pq.add(num);
            }
            count++;
        }
        
        int sum = 0;
        
        while(!pq.isEmpty()) {
            sum+= (int)Math.pow(pq.remove(),2);
        }
        
        return sum;
    }
}