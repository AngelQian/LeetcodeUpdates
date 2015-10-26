/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)  
            return null;  
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();  
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);  
        map.put(node,copy);  
        DFS(node,map);  
        return copy; 
    }
    private void DFS(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        for(UndirectedGraphNode neighbor: node.neighbors){
            if(!map.containsKey(neighbor)){  
                UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);  
                map.put(neighbor, copy);
                DFS(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
}