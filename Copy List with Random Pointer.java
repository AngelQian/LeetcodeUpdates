/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
            
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode tmp = head;
        while(tmp!=null){
            map.put(tmp, new RandomListNode(tmp.label));
            tmp=tmp.next;
        }
        
        tmp=head;
        while(tmp!=null){
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }
        
        return map.get(head);
    }
}