//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    int[] Series(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(1);
        int mod = 1_000_000_007;
        for(int i=2;i<=n;i++){
            int x=(ans.get(i-1)+ans.get(i-2)) % mod;
            ans.add(x);
        }
        int[] array = new int[ans.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = ans.get(i);
        }
        return array;
    }
}