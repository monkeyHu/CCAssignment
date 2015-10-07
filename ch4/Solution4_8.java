package ch4;

/*find the first common ancestor of two nodes in a binary tree*/
public class Solution4_8 {
	TreeNode FirstcommonAncesotr(TreeNode p, TreeNode q){
		if(p==null && q == null)
			return null;
	
		while( p != null){
			if(father(p,q)) return p;
			p = p.parent;
		}
		return null;
	}
	
	//find if p is the ancestor of q
	boolean father(TreeNode p, TreeNode q){
		if(p == null) return false;
		else if(p == q) return true;
		else return father(p.left,q) || father(p.right,q);
	}

}
