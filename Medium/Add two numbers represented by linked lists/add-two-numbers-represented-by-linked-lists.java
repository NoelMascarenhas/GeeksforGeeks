//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node add(Node first , Node second){
        
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;
        
        while(first != null || second != null || carry > 0){
            
            int sum = carry;
            
            if(first != null){
               sum += first.data;
               first = first.next;
            }
            
             if(second != null){
               sum += second.data;
               second = second.next;
            }
            
            carry = sum/10;
            current.next = new Node(sum%10); 
            current = current.next;
        }
        return dummy.next;
        
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        
        Node list1 = reverse(first);
        Node  list2 = reverse(second);
        
        Node ans = add(list1 , list2);
        
        ans = reverse(ans);
        
        Node cur = ans;
        
        //Avoid leading zeros
        while(cur != null && cur.data == 0){
            cur = cur.next;
        }
        
        return cur == null ? new Node(0) : cur;
    }
    
}