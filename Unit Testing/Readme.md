# UNIT TESTS

The binary search tree which serves as an example and is used in the unit tests looks as follows:


						45
					  /    \
					27		68
	              /   \
				 18	   35	
	                  /   \
					 29	   39
				
				
Tests are comprised of sets of nodes, with an expected result, e.g.

Node A:		Node B:		Expected Result Node:
39			18			27					 
29			18			27
29			39			35
39			35			35
39			27			27
27			27			27
45			45			45


