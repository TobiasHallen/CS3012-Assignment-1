import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BinaryTreeTest 
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
	public void test() 
	{
        BinaryTree tree = new BinaryTree(); 
        tree.root = tree.insert(tree.root, 45); 
        tree.root = tree.insert(tree.root, 27); 
        tree.root = tree.insert(tree.root, 68); 
        tree.root = tree.insert(tree.root, 18); 
        tree.root = tree.insert(tree.root, 35); 
        tree.root = tree.insert(tree.root, 29); 
        tree.root = tree.insert(tree.root, 39);
        
		assertEquals("Testing for 39 and 18", 27, tree.LCA(tree.get(tree.root, 39), tree.get(tree.root, 18)).key);
		assertEquals("Testing for 29 and 18", 27, tree.LCA(tree.get(tree.root, 29), tree.get(tree.root, 18)).key);
		assertEquals("Testing for 29 and 39", 35, tree.LCA(tree.get(tree.root, 29), tree.get(tree.root, 39)).key);

		assertEquals("Testing for 39 and 35", 35, tree.LCA(tree.get(tree.root, 39), tree.get(tree.root, 35)).key);
		assertEquals("Testing for 39 and 27", 27, tree.LCA(tree.get(tree.root, 39), tree.get(tree.root, 27)).key);
		
		assertEquals("Testing for 27 and 27", 27, tree.LCA(tree.get(tree.root, 27), tree.get(tree.root, 27)).key);

		assertEquals("Testing for 45 and 45", 45, tree.LCA(tree.get(tree.root, 45), tree.get(tree.root, 45)).key);
		
		assertEquals("Testing for null input", null, tree.LCA(null, null));
		

		
	}

}
