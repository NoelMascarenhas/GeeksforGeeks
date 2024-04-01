//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.pairsViolatingBST(n, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int k;
    public static int pairsViolatingBST(int n, Node root) {
        k=0;
        int arr[] = new int[n];
        inorder(root, arr);
        return countInversion(arr, 0, n-1);
    }
    static void inorder(Node root, int arr[]) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr);
        arr[k++]= root.data;
        inorder(root.right, arr);
    }
    static int countInversion( int arr[]  , int l , int r){
        int res = 0;
        if(l<r){
            int  m = (l+r)/2;// count inversion in left half
            res  +=  countInversion(arr,l,m);// count inversion in right half.
            res  +=  countInversion(arr,m+1,r);// count inversion while merging left and right parts.
            res +=  countAndMerge(arr,l,m,r);
        }
        return  res;
    }
    static int countAndMerge(int arr[] , int l , int m , int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int left[] = new int [n1];
        int right[] = new int [n2];
        for( int i = 0 ;i <n1; i++){
            left[i]  = arr[l+i];
        }
        for( int i = 0 ;i <n2; i++){
            right[i]  = arr[m+1+i];
        }
        int ans = 0, i=0 , j=0, k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k] = left[i] ; i++;k++;
            }
            else{
                arr[k] = right[j]; j++ ;k++ ; ans += (n1-i);
            }
        }
        while(i<n1){
            arr[k] =  left[i]; i++;k++;
        }
        while(i<n2){
            arr[k] =right[j]; j++ ;k++;
        }
        return ans;
    }
}