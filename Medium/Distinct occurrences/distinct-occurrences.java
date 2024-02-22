//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int  subsequenceCount(String s, String t)
    {
        int n=s.length();int m=t.length();
        char a[]= s.toCharArray();
        char b[]=t.toCharArray();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][m]=1;
        }
        int mod=1000000007;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(a[i]==b[j]){
                    dp[i][j]=(dp[i+1][j+1]%mod+dp[i+1][j]%mod)%mod;
                }else{
                    dp[i][j]=dp[i+1][j]%mod;
                }
            }
        }
        return dp[0][0]%mod;
    }
}