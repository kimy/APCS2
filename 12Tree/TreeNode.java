import java.util.*;
import java.io.*;


public class TreeNode<T>{

    private T data;
    private TreeNode<T> left, right;


    public TreeNode(T data){
	setData(data);
    }

    public void setData(T value){
	data = value;
    }

    public T getData(){
	return data;
    }

    public TreeNode<T> getLeft(){
	return left;
    }

    public void setLeft(TreeNode<T> lef){
	left = lef;
    }

    public TreeNode<T> getRight(){
	return right;
    }

    public void setRight(TreeNode<T> righ){
	right = righ;
    }

    public String toString(){
	return "" + data;
    }

}