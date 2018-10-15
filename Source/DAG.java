
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;


class Node  
{ 
	int key; 
	public ArrayList<Node> children = new ArrayList<Node>();
	public ArrayList<Node> parents = new ArrayList<Node>();
	public String colour = "white";
	public int count=0;
	public ArrayList<Node> adj = new ArrayList<Node>();
	Node(int key)  
	{ 
		this.key = key; 
		parents.add(null);
		children.add(null);
	} 
} 

class DAG  
{ 
	Node root;
	public ArrayList<Node> adjList = new ArrayList<Node>;

	public Node insert(Node x, Node y)  
	{ 
		if (root == null) 
		{
			root=x; 
			adjList.add(x);
		}
		if(!adjList.contains(x))
		{
			adjList.add(x);
			if(adjList.contains(y))
			{
				for(int i=0;i<adjList.size())
				{
					Node n = adjList.get(i);
					if(n==y)
					{
						adjList.get(i).parents.add(adjList.get(x));
					}
				}
			}
			else
			{
				adjList.add(y);
				adjList.get(x).children.add(adjList.get(y));
				adjList.get(y).parents.add(adjList.get(x));
			}
		}
		else
		{
			if(adjList.contains(y))
			{
				adjList.get(y).parents.add(adjList.get(x));
			}
			else
			{
				adjList.add(y);
				adjList.get(x).children.add(adjList.get(y));
				adjList.get(y).parents.add(adjList.get(x));
			}
		}
		return x; 
	} 


//	public Node get(Node x, int key) 
//	{
//		if (x == null) return null;
//		if(x.left==null)return x;
//		if      (key < x.key) return get(x.left, key);
//		if(x.right==null)return x;
//		else if (key > x.key) return get(x.right, key);
//		else              {
//			return x;
//		}
//	}

//	public Node LCA(Node x, Node y)  
//	{ 
//		Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>(); 
//
//		while (x != null)  
//		{ 
//			ancestors.put(x, Boolean.TRUE); 
//			x = x.parent; 
//		} 
//
//		while (y != null)  
//		{ 
//			if (ancestors.containsKey(y) != ancestors.isEmpty()) 
//				return y; 
//			y = y.parent; 
//		} 
//
//		return null; 
//	} 


	public void BFSLCA(Node x, Node y)
	{
		Node node;
		for(int j=0;j<2;j++)
		{
			if(j==0)node=x;
			else node = y;
			ArrayList<Node> visited = new ArrayList<Node>();
			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(node);
			while(queue.size()!=0){
				node = queue.poll();
				System.out.println(node.key);
				for(int i=0;i<node.adj.size();i++)
				{
					Node n = node.adj.get(i);
					if(!visited.contains(n))
					{
						visited.add(n);
						queue.add(n);
						if(j==0)node.colour="Blue";
						else if(node.colour=="Blue")node.colour="Red";
						if(node.colour=="Red")
						{
							
						}
					}
				}

			}

		}
	}
} 