package model.Implementations;

public class ChainHashTable <K,V>  implements IHashTable<K,V>{
    private int arrSize;
    private HNode<K,V>[] table;

    public ChainHashTable(int m) {
        this.arrSize = m;
        table = new HNode[m];
    }


    public int hash(Object key) {
        return (Math.abs(key.hashCode())) % arrSize;
    }

    @Override
    public void insert(K key, V value) throws Exception {
        int insertKey = hash(key);
        HNode<K,V> nodeInList = table[insertKey];

        if(nodeInList == null) {
            table[insertKey] = new HNode<>(key, value);
        } else {
            while (nodeInList != null) {
                if(nodeInList.getKey().equals(key)) {
                    break;
                }
                nodeInList = nodeInList.getNext();
            }
            HNode<K,V> newNode = new HNode<>(key, value);
            table[insertKey].setPrevious(newNode);
            newNode.setNext(table[insertKey]);
            table[insertKey] = newNode;
        }
    }

    @Override
    public V search(K key) {
        V value = null;
        int searchKey = hash(key);
        HNode<K,V> searchNode = table[searchKey];
        while (searchNode != null) {
            if(searchNode.getKey().equals(key)){
                value = searchNode.getValue();
            }
            searchNode = searchNode.getNext();
        }
        return value;
    }

    @Override
    public void delete(K key) {
        int deleteKey = hash(key);
        HNode<K,V> deleteNode = table[deleteKey];
        while (deleteNode != null){
            if(deleteNode.getKey().equals(key)){
                HNode<K,V> previous = deleteNode.getPrevious();
                HNode<K,V> next = deleteNode.getNext();
                if(deleteNode.getKey().equals(table[deleteKey])){
                    table[deleteKey]=next;
                }else {
                    if(previous != null){
                        previous.setNext(next);
                    }
                    if(next != null){
                        next.setPrevious(previous);
                    }
                }
            }
            deleteNode = deleteNode.getNext();
        }
    }



}
