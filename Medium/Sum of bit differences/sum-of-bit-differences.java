//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().sumBitDifferences(arr, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    long sumBitDifferences(int[] arr, int n) {
        long sum=0;
        for(int bitPos=0;bitPos<32;bitPos++){
            int countZeros=0;
            int countOnes=0;
            for(int i=0;i<n;i++){
                if((arr[i] & (1 << bitPos)) != 0){
                   countOnes++; 
                }
                else{
                    countZeros++;
                }
            }
            sum += (long) countOnes * countZeros *2;
        }
        return sum;
    }
}