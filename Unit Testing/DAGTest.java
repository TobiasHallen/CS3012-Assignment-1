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
		DAG d = new DAG();
		d.createBSTGraph();
        
        //Tests for Two Nodes where Result is expected to be a third, Separate Node
		assertEquals("Testing for 39 and 18", "[27]", d.LCA("39", "18").toString());
		assertEquals("Testing for 29 and 18", "[27]", d.LCA("29", "18").toString());
		assertEquals("Testing for 29 and 39", "[35]", d.LCA("29", "39").toString());

		//Tests for Nodes a and b where a|b==result
		assertEquals("Testing for 39 and 35", "[35]", d.LCA("39", "35").toString());
		assertEquals("Testing for 39 and 27", "[27]", d.LCA("39", "27").toString());
		
		//tests for Nodes a and b where a==b==result
		assertEquals("Testing for 27 and 27", "[27]", d.LCA("27", "27").toString());
		assertEquals("Testing for 45 and 45", "[45]", d.LCA("45", "45").toString());
		
		//test for null input (output is null)
		assertEquals("Testing for null input", "[]", d.LCA(null, null).toString());
		
		//test recursive ability of LCA function, to find LCA of 3 or more Nodes
		assertEquals("Testing for >2 Nodes, i.e. 39, 18 and 68", "[45]", d.LCA(d.LCA("39", 
				"18").get(0).toString(), "68").toString());
	}
	
	/*	DAG used for Unit testing appears as such:
	 * 
	 * 			 2 --- 3 --- 4	
	 * 			/ \_  ______/
	 * 		   0   _\/
	 * 			\ /  \_	
	 * 			 1 --- 5
	 * 
	 * -------------TIME--------------->
	 */
	
	
	@Test
	public void testDAG()
	{
		DAG d = new DAG();
		d.createGraph();
		
		assertEquals("Testing for 2 Nodes with single LCA (3,5 = 2)", "[2]", d.LCA("3", "5").toString());
		assertEquals("Testing for 2 Nodes with multiple LCAs (4,5 = 1,2)", "[1, 2]", d.LCA("4", "5").toString());
		assertEquals("Testing for 1 Node with itself (5,5 = 5)", "[5]", d.LCA("5", "5").toString());
		assertEquals("Testing for 2 Nodes, one of which is the root (0,5 = 0)", "[0]", d.LCA("0", "5").toString());
		assertEquals("Testing for 2 Nodes where the left is the LCA (2,3 = 2)", "[2]", d.LCA("2", "3").toString());
		assertEquals("Testing for 2 Nodes where the right is the LCA (3,2 = 2)", "[2]", d.LCA("3", "2").toString());
		assertEquals("Testing for 1 Node where Node is a root (0,0 = 0)", "[0]", d.LCA("0", "0").toString());
		assertEquals("Testing for 2 Nodes where either are null", "[]", d.LCA(null, null).toString());
		
	}
	


}
