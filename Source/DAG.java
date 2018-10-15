
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;


class Node  
{ 
	int key; 
	public Node left, right, parent; 
	public String colour = "white";
	public int count=0;
	public ArrayList<Node> adj = new ArrayList<Node>();
	Node(int key)  
	{ 
		this.key = key; 
		left = right = parent = null; 
	} 
} 

class DAG  
{ 
	Node root;

	public Node insert(Node x, int key)  
	{ 
		if (x == null) 
			return new Node(key); 

		if (key < x.key)  
		{ 
			x.left = insert(x.left, key); 
			x.left.parent = x; 
			x.adj.add(x.left);
			x.left.adj.add(x);
		} 
		else if (key > x.key)  
		{ 
			x.right = insert(x.right, key); 
			x.right.parent = x; 
			x.adj.add(x.right);
			x.right.adj.add(x);
		} 

		return x; 
	} 


	public Node get(Node x, int key) 
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

	public Node LCA(Node x, Node y)  
	{ 
		Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>(); 

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


	public void BFSLCA(Node x)
	{
		ArrayList<Node> visited = new ArrayList<Node>();
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(x);
		while(queue.size()!=0){
			x = queue.poll();
			System.out.println(x.key);
			for(int i=0;i<x.adj.size();i++)
			{
				Node n = x.adj.get(i);
				if(!visited.contains(n))
				{
					visited.add(n);
					queue.add(n);
				}
			}

		}
	}


} 