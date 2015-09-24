package ch4;

/*find the first common ancestor of two nodes in a binary tree*/
public class Solution4_8 {
	TreeNode FirstcommonAncesotr(TreeNode p, TreeNode q){
		if(p == q)
			return null;
		
		while( p != null){
			if(isOnPath(p,q)){
				return p;
			}
			p = p.parent;
		}
		return null;
	}
	
	boolean isOnPath(TreeNode p, TreeNode q){
		while(p != q && q != null){
			q = q.parent;
		}
		return p == q;
	}
}
