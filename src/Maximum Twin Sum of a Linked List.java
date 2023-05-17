/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        while(head != null){
            al.add(head.val);
            head = head.next;
        } 
        int sum = Integer.MIN_VALUE;
        int n = al.size();
        for(int i=0; i<al.size()/2; i++)
            sum = Math.max(sum , al.get(i)+al.get(n-i-1));
        
        return sum;
    }
}
