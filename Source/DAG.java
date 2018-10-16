
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class DAG  
{ 
	Node[] globalNodes;
	HashSet<Node> S = new HashSet<Node>(); 
	class Node
	{
		public int count;
		public String colour = "White";
		public final String name;
		public final HashSet<Edge> inEdges;
		public final HashSet<Edge> outEdges;
		public Node(String name) {
			this.name = name;
			inEdges = new HashSet<Edge>();
			outEdges = new HashSet<Edge>();
			count=0;
		}
		public Node addEdge(Node node)
		{
			Edge e = new Edge(this, node);
			outEdges.add(e);
			node.inEdges.add(e);
			return this;
		}
		@Override
		public String toString() 
		{
			return name;
		}
	}

	class Edge
	{
		public final Node from;
		public final Node to;
		public Edge(Node from, Node to) 
		{
			this.from = from;
			this.to = to;
		}
	}

	public ArrayList<Node> LCA(String X, String Y)
	{
		Node n = null;
		Node m = null;
		ArrayList<Node> ret = new ArrayList<Node>();
		if(X==null|Y==null) return ret;

		for(int i=0;i<globalNodes.length;i++)
		{
			if(globalNodes[i].name==X){
				n=globalNodes[i];
			}
			if(globalNodes[i].name==Y){
				m=globalNodes[i];
			}
			globalNodes[i].colour="White";
			globalNodes[i].count=0;

		}
		if(n.equals(m))
		{
			ret.add(n);
			return ret;
		}
		if(!n.inEdges.isEmpty())
			for( Edge x : n.inEdges)
			{
				if(x.from.equals(m))
				{
					ret.add(m);
					return ret;
				}
			}
		if(!n.outEdges.isEmpty())
			for( Edge x : n.outEdges)
			{
				if(x.to.equals(m))
				{
					ret.add(n);
					return ret;
				}
			}
		blue(n);
		red(m);

		for(int i=0;i<globalNodes.length;i++)
		{
			if(globalNodes[i].colour=="Red")
			{
				for(Edge x : globalNodes[i].inEdges)
				{
					x.from.count++;
				}
			}
		}
		for(int i=0;i<globalNodes.length;i++)
		{
			//System.out.println(globalNodes[i].toString()+": "+globalNodes[i].colour+globalNodes[i].count);
			if(globalNodes[i].count==0&&globalNodes[i].colour=="Red")
			{
				ret.add(globalNodes[i]);
			}
		}
		return ret;
	}

	public void blue(Node n)
	{
		n.colour="Blue";
		for(Edge x : n.inEdges)
		{
			x.from.colour="Blue";
			blue(x.from);
		}
	}

	public void red(Node n)
	{
		if(n.colour=="Blue")n.colour="Red";
		for(Edge x : n.inEdges)
		{
			if(x.from.colour=="Blue")
				x.from.colour="Red";
			red(x.from);
		}
	}

	public void createGraph()
	{
		Node zero = new Node("0");
		Node one = new Node("1");
		Node two = new Node("2");
		Node three = new Node("3");
		Node four = new Node("4");
		Node five = new Node("5");
		zero.addEdge(two).addEdge(one);
		one.addEdge(four).addEdge(five);
		two.addEdge(three).addEdge(five);
		three.addEdge(four);

		Node[] allNodes = {zero, one, two, three, four, five};
		globalNodes = allNodes;

		
		for(Node n : allNodes){
			if(n.inEdges.size() == 0){
				S.add(n);
			}
		}
	}

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