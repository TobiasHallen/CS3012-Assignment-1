
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


class Node  
{ 
	private int v; 
    private int weight; 
    public String colour = "white";
    Node(int _v, int _w) { v = _v;  weight = _w; } 
    int getV() { return v; } 
    int getWeight()  { return weight; } 
} 

class DAG  
{ 
	private int V; 
    private LinkedList<Node>adj[]; 
    @SuppressWarnings("unchecked")
	DAG(int v) 
    { 
        V=v; 
        adj = new LinkedList[V]; 
        for (int i=0; i<v; ++i) 
        {    
        	adj[i] = new LinkedList<Node>(); 
        }	
    } 
    void addEdge(int u, int v, int weight) 
    { 
    	Node node = new Node(v,weight); 
        adj[u].add(node);
    	//System.out.println(adj[u].get(0).getV());

    } 
    String printGraph()
    {
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<adj.length;i++)
    	{
    		for(int j=0; j<adj[i].size();j++)
    		{
    			sb.append(adj[i].get(j).getV()+":");
        		sb.append(adj[i].get(j).getWeight()+"  ");
    		}
    		sb.append("    ");
    	}
    	System.out.println(sb.toString());
    	return sb.toString();
    }


//	public void BFSLCA(Node x, Node y)
//	{
//		Node node;
//		for(int j=0;j<2;j++)
//		{
//			if(j==0)node=x;
//			else node = y;
//			ArrayList<Node> visited = new ArrayList<Node>();
//			LinkedList<Node> queue = new LinkedList<Node>();
//			queue.add(node);
//			while(queue.size()!=0){
//				node = queue.poll();
//				System.out.println(node.key);
//				for(int i=0;i<node.adj.size();i++)
//				{
//					Node n = node.adj.get(i);
//					if(!visited.contains(n))
//					{
//						visited.add(n);
//						queue.add(n);
//						if(j==0)node.colour="Blue";
//						else if(node.colour=="Blue")node.colour="Red";
//						if(node.colour=="Red")
//						{
//							
//						}
//					}
//				}
//
//			}
//
//		}
//	}
} 

class BSTNode  
{ 
    int key; 
    public BSTNode left, right, parent; 
  
    BSTNode(int key)  
    { 
        this.key = key; 
        left = right = parent = null; 
    } 
} 
  
class BinaryTree  
{ 
    BSTNode root;
  
    public BSTNode insert(BSTNode x, int key)  
    { 
        if (x == null) 
            return new BSTNode(key); 
  
        if (key < x.key)  
        { 
            x.left = insert(x.left, key); 
            x.left.parent = x; 
        } 
        else if (key > x.key)  
        { 
            x.right = insert(x.right, key); 
            x.right.parent = x; 
        } 
  
        return x; 
    } 
    
    
    public BSTNode get(BSTNode x, int key) 
    {
		if (x == null) return null;
		if(x.left==null)return x;
		if      (key < x.key) return get(x.left, key);
		if(x.right==null)return x;
		else if (key > x.key) return get(x.right, key);
		else              {
			return x;
		}
	}
  
    public BSTNode LCA(BSTNode x, BSTNode y)  
    { 
        Map<BSTNode, Boolean> ancestors = new HashMap<BSTNode, Boolean>(); 
  
        while (x != null)  
        { 
            ancestors.put(x, Boolean.TRUE); 
            x = x.parent; 
        } 
        
        while (y != null)  
        { 
            if (ancestors.containsKey(y) != ancestors.isEmpty()) 
                return y; 
            y = y.parent; 
        } 
  
        return null; 
    } 


  
} 