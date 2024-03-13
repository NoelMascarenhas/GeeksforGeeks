//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

 
class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] ans = new int[m*n];
        int i=0;
        int row=0,col=0;
        boolean up = true;
        while(row<m && col<n){
            if(up){
                while(row>0 && col<n-1){
                    ans[i++]=mat[row][col];
                    row--;
                    col++;
                }
                ans[i++]=mat[row][col];
                if(col==n-1){
                    row++;
                }
                else{
                    col++;
                }
            }else{
                while(col>0 && row<m-1){
                    ans[i++]=mat[row][col];
                    row++;
                    col--;
                }
                ans[i++]=mat[row][col];
                if(row==m-1){
                    col++;
                }
                else{
                    row++;
                }
            }
            up=!up;
        }
        return ans;
    }
}