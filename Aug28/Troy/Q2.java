class Codec {
	// Didnt spend much time on this one and went to solutino directly

  // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
		return encode(root, true);
    }
    TreeNode encode(Node root, boolean isRight){
	if(root==null) return null;
	TreeNode newRoot = new TreeNode(root.val);
	TreeNode curr = newRoot;
	if(isRight){
		for(Node child:root.children){
			curr.right=encode(child,false);  //if current is RIGHT then flip to LEFT for the child's children!
			curr=curr.right;
		}
	}else{
		for(Node child:root.children){
			curr.left=encode(child,true);  //if current is LEFT then flip to RIGHT for the child's children!
			curr=curr.left;
		}
	}
	return newRoot;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
		return decode(root,true);
    }
    Node decode(TreeNode root, boolean isRight){
	if(root==null) return null;
	Node newRoot = new Node(root.val, new ArrayList<Node>());
	if(isRight){
		while(root.right!=null){
			root=root.right;
			newRoot.children.add(decode(root,false));
		}
	}else{
		while(root.left!=null){
			root=root.left;
			newRoot.children.add(decode(root,true));
		}
	}
	return newRoot;
    }
}
