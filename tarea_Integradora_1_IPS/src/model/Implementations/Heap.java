package model.Implementations;
import java.util.ArrayList;


public class Heap<T> implements IPriorityQueue<T>{
    private ArrayList<Node<T>> arr;
    public Heap() {
        arr = new ArrayList<>();
        arr.add(null);
    }
    public void addElement(int value, Object element) {
        arr.add(new Node(value,element));
        buildMaxHeapify();
    }
    public void maxHeapify(int index) {
        int l = 2*index;
        int r = 2*index + 1;
        int largest;
        if(l <= arr.size()-1 && arr.get(l).getValue() > arr.get(index).getValue()) {
            largest = l;
        } else {
            largest = index;
        }
        if(r<= arr.size()-1 && arr.get(r).getValue()  > arr.get(largest).getValue() ) {
            largest = r;
        }
        if(largest != index) {
            Node<T> temp1= arr.get(index);
            Node<T> temp2= arr.get(largest);
            arr.set(index,temp2);
            arr.set(largest,temp1);
            maxHeapify(largest);
        }
    }
    public void buildMaxHeapify() {
        for(int i= arr.size()-1; i >=1;i--){
            maxHeapify(i);
        }
    }

    public ArrayList<T> heapSort(){
        Heap<T> heap = new Heap<>();
        heap.setArr((ArrayList<Node<T>>) this.arr.clone());
        ArrayList<T> arrayList = new ArrayList<>();
        while (true) {
            T element = heap.extractMax();
            if(element == null) break;
            arrayList.add(element);
        }
        return arrayList;
    }

    public String print() {
        String ans = "";
        for (int i = 1; i <arr.size(); i++) {
            ans += arr.get(i).getValue() + " ";
        }
        return ans;
    }
    public ArrayList<Node<T>> getArr() {
        return arr;
    }
    public void setArr(ArrayList<Node<T>> arr) {
        this.arr = arr;
    }

    @Override
    public void insertElement(int priorityValue, T element) {
        addElement(priorityValue, element);
    }

    @Override
    public T extractMax() {
        if(arr.size() <2) {

        }
        T max = arr.get(1).getElement();
        arr.set(1,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        maxHeapify(1);
        return max;
    }

    @Override
    public void increaseKey(T element, int newValue) {
        int index = -1;
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i).getElement().equals(element)) index = i;
        }
        if(newValue < arr.get(index).getValue()) {

        }
        while (index>1 && arr.get(index/2).getValue() <arr.get(index).getValue()){
            Node<T> temp1 = arr.get(index/2);
            Node<T> temp2 = arr.get(index);
            arr.set(index, temp1);
            arr.set(index/2, temp2);
            index = index/2;
        }
    }

    @Override
    public String showElements() {
        String ans = "";
        for (int i = 1; i < arr.size() ; i++) {
            ans+= arr.get(i).getValue() + " "+ arr.get(i).getElement() + "\n";
        }
        return ans;
    }

    @Override
    public T showMaximum() {
        return arr.get(1).getElement();
    }

    public T getElement(int index) {
        return arr.get(index).getElement();
    }
}
