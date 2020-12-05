/*
	Given 2 very large binary trees T1 and T2. Create an algorithm to deter-mine if T2 is a subtree of T1.
    Assume T1 is always much larger than T2.
 */

public class SubTreeProblem {
    public static void main(String[] args){
/*   this will be T1 (biggest tree)
                  32
                  /\
              28     30
              /\     /\
            15 19   22 27
 */
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(32);
        t1.root.left = new Node(28);
        t1.root.left.left = new Node(15);
        t1.root.left.right = new Node(19);
        t1.root.right = new Node(30);
        t1.root.right.left = new Node(22);
        t1.root.right.right = new Node(27);

/*
     this will be T2 (smaller subtree)
              30
              /\
            22   27
 */
        BinaryTree t2 = new BinaryTree();
        t2.root = new Node(30);
        t2.root.left = new Node(22);
        t2.root.right = new Node(27);

/*
     this will be T3 (invalid subtree)
              28
              /\
            14  52
 */
        BinaryTree t3 = new BinaryTree();
        t3.root = new Node(28);
        t3.root.left = new Node(14);
        t3.root.right = new Node(52);


        System.out.println("is T2 a subtree of T1?");
        checker(t1, t2);
        System.out.println("\nis T3 a subtree of T1?");
        checker(t1, t3);
    }

    public static void checker(BinaryTree one, BinaryTree two){
        if(one.checkSubtree(one.root, two.root))
            System.out.println("Yes, it is a subtree");
        else
            System.out.println("No, it is not a subtree");
    }
}

//this is a class to create a node
class Node{
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
        right = null;
        left = null;
    }
}

//this is the class to create a tree, utilizes the Node class
class BinaryTree{
    Node root;

    /*
    the time complexity of this recursive algorithm would be O(n * m) with n being the number of nodes in the
    main tree and comparing it to m being the number of nodes in the subtree

    the space complexity would of this recursive algorithm would be O(log(n) + log(m))
    */
    boolean checkSubtree(Node tree, Node subTree){
        //base case, if the subtree is empty, that is fine
        if(subTree == null)
            return true;
        //base case, if the main tree is empty, return false. the main tree should not be empty
        if(tree == null)
            return false;
        //check if the trees with the current node as a roots are identical
        if(identical(tree, subTree))
            return true;
        //recursive call to go to the next level(node) of the two trees
        return checkSubtree(tree.left, subTree) || checkSubtree(tree.right, subTree);
    }
    boolean identical(Node root1, Node root2){
        //these are the base cases, return true if both are null
        if(root1 == null && root2 == null)
            return true;
        /*
        base case, return false if one of them is not null.
        that case it cannot be a subtree if only one of them are null
         */
        if(root1 == null || root2 == null)
            return false;
        /*
        checks if the values in the roots are both the same, and if values
        in each of the leaves are the same
         */
        return(root1.value == root2.value && identical(root1.left, root2.left)
                && identical(root1.right, root2.right));
    }
}