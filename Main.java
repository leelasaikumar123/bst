public class Main{
    public static void main(String[] args) {
     BinaryTree tree=new BinaryTree();
int[] array={56,30,20,40,11,3,16,70,60,95,65,63,67};
for(int ele:array){
    tree.insert(ele);
}  
     System.out.println("Tree Has");
     tree.print();
     System.out.println();
     if(tree.size()==array.length){
        System.out.println("every element is inserted in the tree");
     }
     else{
        System.out.println("Not Inserted Completely");
     }
     if(tree.search(63)){
        System.out.println("Node is Present");
     }
     else{
        System.out.println("Node is not present");
     }
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
    public int size(){
        return sizeOfTree(root);
    }
  public int sizeOfTree(Node root){
    if(root == null){
        return 0;
    }
    else{
        int s1=sizeOfTree(root.left);
        int s2=sizeOfTree(root.right);
        return s1+s2+1;
    }
  }
  public boolean search(int data){
  return searchTree(data, root);
  } 
  public boolean searchTree(int data,Node root){
    if(root != null){
   if(root.data==data){
    return true;
   }
   else if(data<root.data){
   return  searchTree(data, root.left);
   }
      else if(data>root.data){
   return searchTree(data, root.right);
   }
    }
    return false;
  }
}