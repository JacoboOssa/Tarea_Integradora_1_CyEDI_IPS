import model.Implementations.ChainHashTable;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ChainHashTableTest {

ChainHashTable<String,Integer> hashtable;



    public void setUp1(){
        hashtable=new ChainHashTable<>(10);
    }
    public void setUp2() throws Exception {
        hashtable=new ChainHashTable<>(10);
        hashtable.insert("2004", 2004);
        hashtable.insert("2003", 2003);
    }
    public void setUp3() throws Exception {
        hashtable=new ChainHashTable<>(10);
        hashtable.insert("2002", 2002);
        hashtable.insert("2002", 2001);
    }
    public void setUp4(){
        hashtable=new ChainHashTable<>(1);
    }
    public void setUp5() throws Exception {
        //misma hash
        hashtable=new ChainHashTable<>(2);
        hashtable.insert("33",33);
        hashtable.insert("323",323);
    }
    @Test
    public void insertTest1() throws Exception {

        setUp4();
        hashtable.insert("5678",1);
        hashtable.insert("1017",2);
        assertEquals(2,hashtable.search("1017"));
    }
    @Test
    public void insertTest2() throws Exception {
        setUp1();
        hashtable.insert("423423",4);
        assertEquals(4,hashtable.search("423423"));
    }
    @Test
    public void insertTest3() throws Exception {
        setUp1();
        hashtable.insert("123",1);
        hashtable.insert("234",2);
        assertEquals(2,hashtable.search("234"));

    }
    @Test
    public void searchTest1() throws Exception {
      setUp2();
      assertEquals(2004,hashtable.search("2004"));
    }
    @Test
    public void searchTest2() throws Exception {
      setUp2();
        assertNull(hashtable.search("454353"));
    }

    @Test
    public void searchTest3() throws Exception {
setUp3();
assertEquals(2002,hashtable.search("2002"));
    }

    @Test
    public void deleteTest1() throws Exception {
setUp2();
hashtable.delete("2002");
assertNull(hashtable.search("2002"));

    }
    @Test
    public void deleteTest2() throws Exception {
     setUp5();
     hashtable.delete("33");
     assertEquals(323,hashtable.search("323"));
    }
    @Test
    public void deleteTest3() throws Exception {
        setUp5();
        hashtable.delete("33");
        hashtable.delete("323");
        assertNull(hashtable.search("33"));
    }




}
