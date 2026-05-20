public class HashMapProgram {
    public static void main(String[] args) {
        String sentence="To be or not to be";
        String[] words=sentence.toLowerCase().split(" ");
        MyHashMap<String,Integer> map=new MyHashMap<>();
        for(String word:words){
            Integer count=map.get(word);
            if(count==null){
                map.put(word,1);
            }
            else{
                map.put(word,count+1);
            }
        }

        map.print();
    }
}
class MyMapNode<K,V>{
    K key;
    V value;
    MyMapNode<K,V> next;
    MyMapNode(K key,V value){
        this.key=key;
        this.value=value;
    }
}
class MyHashMap<K,V>{
   MyMapNode<K,V> head;
   public void put(K key,V value){
      if(head==null){
            head=new MyMapNode<>(key,value);
            return;
        }
      MyMapNode<K,V> temp=head;
      while(temp != null){
        if(temp.key.equals(key)){
            temp.value=value;
            return;
        }
          if(temp.next==null){
                break;
            }
        temp=temp.next;
      } 
      temp.next=new MyMapNode(key, value); 
   } 
   public V get(K key){
    MyMapNode<K,V> temp=head;

        while(temp!=null){

            if(temp.key.equals(key)){
                return temp.value;
            }

            temp=temp.next;
        }
        return null;
   }
       public void print(){

        MyMapNode<K,V> temp=head;

        while(temp!=null){

            System.out.println(temp.key+" -> "+temp.value);

            temp=temp.next;
        }
    }
}
