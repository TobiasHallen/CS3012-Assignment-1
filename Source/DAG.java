
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
				for(int i=0;i<adjList.size();i++)
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