public class Main{
    public static void main(String[] args) {
     BinaryTree tree=new BinaryTree();
     tree.insert(56);
     tree.insert(30);
     tree.insert(70);   
     System.out.println("Tree Has");
     tree.print();
    }
}
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
    }
    
}
class BinaryTree{
    Node root;
    public void insert(int data){
        root=insertRec(root, data);
    }


    public Node insertRec(Node root,int data){
     if(root == null){
        root=new Node(data);
     }
    else if(data<root.data){
        root.left=insertRec(root.left,data);
    }
        else if(data>root.data){
        root.right=insertRec(root.right,data);
    }
     return root;
    }

    public void print(){
      printRec(root);
    }

    public void printRec(Node root){
      if(root != null){
        printRec(root.left);
        System.out.print(root.data+" ");
        printRec(root.right);
      }
    }
}