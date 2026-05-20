public class HashMapProgram {
    public static void main(String[] args) {    
        String sentence= "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
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
        System.out.println("Before Removing");
        map.print();
        map.remove("avoidable");
        System.out.println();
        System.out.println("After Removing");
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
   MyMapNode<K,V>[] buckets;
     MyHashMap(){
  buckets=new MyMapNode[10];
    }
   public  int getIndex(K key) {
    return Math.abs(key.hashCode()) % buckets.length;
}
   public void put(K key,V value){
 int index=getIndex(key);
 MyMapNode<K,V> temp=buckets[index];
         if(buckets[index]==null){

            buckets[index]=new MyMapNode<>(key,value);
            return;
        }
               while(temp!=null){

            if(temp.key.equals(key)){
                temp.value=value;
                return;
            }

            if(temp.next==null){
                break;
            }

            temp=temp.next;
        }

        temp.next=new MyMapNode<>(key,value);
   } 
   public V get(K key){
        int index=getIndex(key);
MyMapNode<K,V> temp=buckets[index];

        while(temp!=null){

            if(temp.key.equals(key)){
                return temp.value;
            }

            temp=temp.next;
        }

        return null;
   }
       public void print(){
for(int i=0;i<buckets.length;i++){

        MyMapNode<K,V> temp=buckets[i];

        if(temp!=null){

            System.out.println("Bucket "+i);
        }

        while(temp!=null){

            System.out.println(temp.key+" -> "+temp.value);

            temp=temp.next;
        }
    }
    }
    public void remove(K key){
    int index=getIndex(key);
    MyMapNode<K,V> temp=buckets[index];
    MyMapNode<K,V> prev=null;
    while(temp!=null){
        if(temp.key.equals(key)){
        if(prev==null){
        buckets[index]=temp.next;
       }
        else{
       prev.next=temp.next;
        }
     return;
        }
        prev=temp;
        temp=temp.next;
    }
}
}
