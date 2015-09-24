package ch4;

/*We first check if small tree is empty, then check if small tree is the subtree of the big tree recursively*/
public class Solution4_10 {
	boolean containsTree(TreeNode n1, TreeNode n2){
		if(n2 == null) // if small tree is empty
			return true;
		return subTree(n1,n2);
	}
	
	boolean subTree(TreeNode t1, TreeNode t2){
		if(t1 == null){
			return false; //Big tree empty while subtree still not found
		}else if(t1.value == t2.value && matchTree(t1,t2)){
			return true;
		}
		
		return (subTree(t1.left,t2)|| subTree(t1.right,t2));
	}
	
	boolean matchTree(TreeNode r1, TreeNode r2){
		if(r2 == null && r1 == null){
			return true;//nothing left in the subtree
		}else if(r1 == null || r2 == null){
			return false;
		}else if(r1.value != r2.value){
			return false;
		}else{
			return (matchTree(r1.left,r2.left) && (matchTree(r1.right,r2.right)));
		}
	}
}
