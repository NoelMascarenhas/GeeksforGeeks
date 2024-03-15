//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
   public Node sort(Node head){
        Node dummy = head;
        int count=0;
        while(dummy!=null){
            count++;
            dummy=dummy.next;
        }
        dummy=head;
        int[] arr =new int[count];
        for(int i=0;i<count;i++){
            arr[i]=dummy.data;
            dummy=dummy.next;
        }
        Arrays.sort(arr);
        Node newHead = new Node(arr[0]);
        Node curr = newHead;
        for(int i=1;i<arr.length;i++){
            curr.next= new Node(arr[i]);
            curr=curr.next;
        }
        return newHead;
   }
}