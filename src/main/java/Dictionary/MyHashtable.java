package Dictionary;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

import List.ListInterface;
import List.MyLinkedList;

public class MyHashtable implements DictionaryInterface {

    protected int tableSize;
    protected int size;

    protected MyLinkedList[] table;

    public MyHashtable(int tableSize) {
        table = new MyLinkedList[tableSize];
        this.tableSize = tableSize;
    }

    public int biggestBucket()
    {
        int biggestBucket = 0;
        for(int i = 0; i < table.length; i++) {

            if (table[i] != null) {

                MyLinkedList bucket = table[i];
                if (biggestBucket < bucket.size())
                    biggestBucket = bucket.size();
            }
        }
        return biggestBucket; 
    }
 
    public float averageBucket() {
        float bucketCount = 0; 
        float bucketSizeSum = 0; 
        for(int i = 0; i < table.length; i++) {
            if (table[i] != null) {
             
                MyLinkedList bucket = table[i];
                bucketSizeSum += bucket.size();
                bucketCount++;
            }
        }
        return bucketSizeSum/bucketCount;
    }

    public String toString()
    {
        String s = "";
        for(int tableIndex = 0; tableIndex < tableSize; tableIndex++) {
            if (table[tableIndex] != null) {
                MyLinkedList bucket = table[tableIndex];
                for(int listIndex = 0; listIndex < bucket.size(); listIndex++) {
                    Entry e = (Entry)bucket.get(listIndex);
                    s = s + "key: " + e.key + ", value: " + e.value + "\n";
                }
            }
        }
        return s;
    }

    protected class Entry
    {
        String key;
        Object value;

        Entry(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    // Implement these methods
    public boolean isEmpty() {
        if (size == 0)
        return true;
        else
        return false;
        } 

    public int size(){
         return size;
    
    } 

    public Object put(String key, Object value){
      int n = Math.abs(key.hashCode()) % tableSize;
    if (table[n] == null) {
        table[n] = new MyLinkedList();
        table[n].add(0, new Entry(key, value));
        size++;
        return null;
    } else if (table[n] != null ){
        MyLinkedList bucket = table[n];
        for (int i = 0; i < bucket.size(); i++) {
            Entry e = (Entry) bucket.get(i);
            if (e.key.equals(key)) {
                Entry oldValue = new Entry(key, e.value);
                e.value = value;
                
                return oldValue.value;
            }
        }
        
        bucket.add(0, new Entry(key, value));
        size++;
              return null;        
    }
    else
    {   
        return null;
    }
 }
    
    public Object get(String key){
       int n = Math.abs(key.hashCode()) % tableSize;
        if (table[n] == null)
            return null;
        else {
            MyLinkedList bucket = table[n];
            for (int i = 0; i < bucket.size(); i++) {
                Entry entry = (Entry) bucket.get(i);
                if (entry.key.equals(key))
                    return entry.value;
            }
            return null;
        }      
    } 

    public void remove(String key){     
      
    int n = Math.abs(key.hashCode()) % tableSize;
        if (table[n] != null) {
            MyLinkedList bucket = table[n];
            for (int i = 0; i < bucket.size(); i++) {
                Entry e = (Entry) bucket.get(i);
                if (e.key.equals(key)) {
                    bucket.remove(i);
                    size--;
                    break;
                }
            }
        }
   }
       

    public void clear(){
    table = new MyLinkedList[tableSize];
    size = 0;
    } 

    public String[] getKeys(){
       String[] k = new String[size];
        int n = 0;
        for (MyLinkedList bucket : table) {
            if (bucket != null) {
                for (int i = 0; i < bucket.size(); i++) {
                    Entry e = (Entry) bucket.get(i);
                    k[n++] = e.key;
                }
            }
        }
        return k;
    }     
}
