package THE_PACKAGE;


import org.omg.CORBA.Any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private class BinaryNode<AnyType> {

        //constructors
        BinaryNode(AnyType theElement){
            this( theElement, null,null);
        }
        BinaryNode(AnyType theElement, BinaryNode lt, BinaryNode<AnyType> rt){
            element = theElement;
            left  = lt;
            right = rt;
        }

        AnyType element;            //the data in the node
        BinaryNode<AnyType> left;   //left child
        BinaryNode<AnyType> right;  //right child
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
    }

    public void madeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public AnyType findMin() throws UnderflowException{
        if(isEmpty()) throw new UnderflowException("The Tree doesn't exist!");
        return findMin(root).element;
    }
    public AnyType findMax()throws UnderflowException{
        if(isEmpty()) throw new UnderflowException("The Tree doesn't exist!");
        return findMax(root).element;
    }
    public void insert(AnyType x){
        root = insert(x,root);
    }
    public void remove(AnyType x){
        root = remove(x,root);
    }
    public void printTree() throws UnderflowException{
        if(isEmpty()) throw new UnderflowException("The Tree doesn't exist!");
       //print the tree;
    }

    /**
     * Internal method to find an item in a subtree
     * @param x is item to search for.
     * @param t the node that roots the subtree
     * @return true if the item is found; false otherwise.
     */
    private boolean contains(AnyType x,BinaryNode<AnyType> t){
       if(t == null)
           return false;

       int compareResult = x.compareTo(t.element);

       if(compareResult < 0)
           return contains(x, t.left);
       else if(compareResult > 0)
           return contains(x, t.right);
       else
           return true; //match
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t == null)
            return null;
        else if(t.left == null)
            return t;
        return findMin(t.left);
    }
    /*
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t != null)
            while(t.Left != null)
                t = t.Left;

        return t;
    }
    */

    /**
     * Internal method to find the largest item in a subtree
     * @param t the node that roots the subtree
     * @return node containing the largest item
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if(t == null)
            return null;
        else if(t.right == null)
            return t;
        return findMin(t.right);
    }
    /*
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if(t != null)
            while(t.right != null)
                t = t.right;

        return t;
    }
    */

    /**
     * Internal method to insert into a subtree
     * @param x the item to insert
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
        if(t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0)
            t.left = insert(x, t.left);
        else if(compareResult > 0)
            t.right = insert(x, t.right);
        else
            ; //Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree
     * @param x the item to remove
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        if(t == null)
            return t; //item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0)
            t.left = remove(x, t.left);
        else if(compareResult > 0)
            t.right = remove(x, t.right);
        else if(t.left != null && t.right != null) {// Two children
            t.element = removeMin(t.right).element;
        }
        else t = (t.left != null) ? t.left : t.right; //if there's a subtree on either side, use it to replace r
        return t;
    }

    /**
     * Internal method to remove the smallest node from the subtree
     * @param t the node that roots the subtree
     * @return the removed node
     */
    private BinaryNode<AnyType> removeMin(BinaryNode<AnyType> t){
        BinaryNode<AnyType> removedNode = null;
        if(t == null){
           return null;
        }else if(t.left == null) {
           removedNode = t;
           t = t.right;
        }else{
           removeMin(t.left);
        }
        return removedNode;
    }

    /**
     * Internal method to print each node in the tree according to it's depth
     * @param depth of the node
     * @param t the node that will be print
     */


    /**
     * Internal method to calculate the depth of the tree.
     * @param root of the tree(subtree)
     * @return depth of the tree
     */
    public int getHeight(BinaryNode<AnyType> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
//jsp

    
    //fjewiojfow
}
