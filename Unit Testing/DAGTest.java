import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class DAGTest 
{
	
	//	Tree Used for the purposes of Unit Testing looks like this:
	
	//					45
	//				  /    \
	//				27		68
	//            /   \
	//			 18	   35	
	//                /   \
	//				 29	   39
	

	@Test
	public void testBST() 
	{
		BinaryTree tree = new BinaryTree(); 
        tree.root = tree.insert(tree.root, 45); 
        tree.root = tree.insert(tree.root, 27); 
        tree.root = tree.insert(tree.root, 68); 
        tree.root = tree.insert(tree.root, 18); 
        tree.root = tree.insert(tree.root, 35); 
        tree.root = tree.insert(tree.root, 29); 
        tree.root = tree.insert(tree.root, 39);
        
        //Tests for Two Nodes where Result is expected to be a third, Separate Node
		assertEquals("Testing for 39 and 18", 27, tree.LCA(tree.get(tree.root, 39), tree.get(tree.root, 18)).key);
		assertEquals("Testing for 29 and 18", 27, tree.LCA(tree.get(tree.root, 29), tree.get(tree.root, 18)).key);
		assertEquals("Testing for 29 and 39", 35, tree.LCA(tree.get(tree.root, 29), tree.get(tree.root, 39)).key);

		//Tests for Nodes a and b where a|b==result
		assertEquals("Testing for 39 and 35", 35, tree.LCA(tree.get(tree.root, 39), tree.get(tree.root, 35)).key);
		assertEquals("Testing for 39 and 27", 27, tree.LCA(tree.get(tree.root, 39), tree.get(tree.root, 27)).key);
		
		//tests for Nodes a and b where a==b==result
		assertEquals("Testing for 27 and 27", 27, tree.LCA(tree.get(tree.root, 27), tree.get(tree.root, 27)).key);
		assertEquals("Testing for 45 and 45", 45, tree.LCA(tree.get(tree.root, 45), tree.get(tree.root, 45)).key);
		
		//test for null input (output is null)
		assertEquals("Testing for null input", null, tree.LCA(null, null));
		
		//test recursive ability of LCA function, to find LCA of 3 or more Nodes
		assertEquals("Testing for >2 Nodes, i.e. 39, 18 and 69", 45, tree.LCA(tree.LCA(tree.get(tree.root, 39), 
				tree.get(tree.root, 18)), tree.get(tree.root, 68)).key);
	}
	
	@Test
	public void testDAG()
	{
		DAG d = new DAG();
		d.createGraph();
		d.LCA("4","5");

	}
	


}
