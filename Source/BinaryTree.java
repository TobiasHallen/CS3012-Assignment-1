
import java.util.HashMap; 
import java.util.Map;

  
class Node  
{ 
    int key; 
    public Node left, right, parent; 
  
    Node(int key)  
    { 
        this.key = key; 
        left = right = parent = null; 
    } 
} 
  
class BinaryTree  
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
        } 
        else if (key > x.key)  
        { 
            x.right = insert(x.right, key); 
            x.right.parent = x; 
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


  
} 