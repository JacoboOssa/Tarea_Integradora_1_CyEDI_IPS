import model.Implementations.Heap;
import model.Patient;
import org.junit.Test;

import javax.swing.plaf.PanelUI;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    Heap<String> priorityQueue;

    public void setUpStage1(){
        priorityQueue = new Heap<>();
        priorityQueue.insertElement(2,"1107836152");
        priorityQueue.insertElement(1,"16703429");
        priorityQueue.insertElement(0,"31978268");
        priorityQueue.insertElement(3,"7813145");
        priorityQueue.insertElement(2,"5413187");
    }
    public void setUpStage2(){
        priorityQueue = new Heap<>();
        priorityQueue.insertElement(5,"6524245");
        priorityQueue.insertElement(1,"8329235");
        priorityQueue.insertElement(2,"7329360");
        priorityQueue.insertElement(3,"7329364");
        priorityQueue.insertElement(1,"6524245");
        priorityQueue.insertElement(5,"9863213");
    }
    public void setUpStage3(){
        priorityQueue = new Heap<>();
        priorityQueue.insertElement(5,"652489");
        priorityQueue.insertElement(5,"3203482");
        priorityQueue.insertElement(0,"183561");
        priorityQueue.insertElement(0,"5203543");
        priorityQueue.insertElement(1,"1375935");
        priorityQueue.insertElement(4,"1024943");
    }

    @Test
    public void insertElementTest1(){
        setUpStage1();
        assertEquals("7813145",priorityQueue.getElementA(1));
    }
    @Test
    public void insertElementTest2(){
        setUpStage2();
        assertEquals("7329364",priorityQueue.getElementA(2));
    }
    @Test
    public void insertElementTest3(){
        setUpStage2();
        assertEquals("6524245",priorityQueue.getElementA(1));
    }

    @Test
    public void extractMaxTest1(){
        setUpStage1();
        System.out.println("Maximo antes del metodo Extract");
        System.out.println(priorityQueue.showMaximum());
        priorityQueue.extractMax();
        System.out.println("El nuevo Maximo cambia");
        assertEquals("5413187",priorityQueue.getElementA(1));
        System.out.println(priorityQueue.showMaximum());
    }

    @Test
    public void extractMaxTest2(){
        setUpStage2();
        System.out.println("Maximo antes del metodo Extract");
        System.out.println(priorityQueue.showMaximum());
        priorityQueue.extractMax();
        System.out.println("El nuevo Maximo cambia");
        assertEquals("9863213",priorityQueue.getElementA(1));
        System.out.println(priorityQueue.showMaximum());
    }

    @Test
    public void extractMaxTest3(){
        setUpStage3();
        System.out.println("Maximo antes del metodo Extract");
        System.out.println(priorityQueue.showMaximum());
        priorityQueue.extractMax();
        System.out.println("El nuevo Maximo cambia");
        assertEquals("3203482",priorityQueue.getElementA(1));
        System.out.println(priorityQueue.showMaximum());
    }

    @Test
    public void increaseKeyTest1(){
        setUpStage1();
        priorityQueue.increaseKey("31978268",5);
        assertEquals("31978268",priorityQueue.getElementA(1));
        System.out.println(priorityQueue.showMaximum());
    }

    @Test
    public void increaseKeyTest2(){
        setUpStage2();
        priorityQueue.increaseKey("8329235",4);
        assertEquals("8329235",priorityQueue.getElementA(2));
    }

    @Test
    public void increaseKeyTest3(){
        setUpStage3();
        priorityQueue.increaseKey("5203543",6);
        assertEquals("5203543",priorityQueue.getElementA(1));

    }

    @Test
    public void showMaximumTest1(){
        setUpStage1();
        assertEquals("7813145",priorityQueue.showMaximum());

    }

    @Test
    public void showMaximumTest2(){
        setUpStage2();
        assertEquals("6524245",priorityQueue.showMaximum());

    }

    @Test
    public void showMaximumTest3(){
        setUpStage3();
        assertEquals("652489",priorityQueue.showMaximum());

    }
}
