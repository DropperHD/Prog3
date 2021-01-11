package prog3.prak1.test;

import org.junit.*;
import prog3.prak1.source.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ShelfTest {

    Book book1 = new Book("me","book",12);
    Book book2 = new Book("you","book",13);
    Book book3 = new Book("he","book",14);
    Book book4 = new Book("she","book",15);



    @Test
    public void testConstructorNull(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        assertNull(shelf.getLowerLeft());
        assertNull(shelf.getLowerRight());
        assertNull(shelf.getUpperLeft());
        assertNull(shelf.getUpperRight());
    }

    @Test
    public void testSet(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        shelf.set(0,book1);
        assertEquals(shelf.getUpperLeft(),book1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIndexTooLarge(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        shelf.set(5,book1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIndexTooLow(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        shelf.set(-1,book1);
    }

    @Test
    public void testGet(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        shelf.setUpperLeft(book1);
        assertEquals(shelf.getUpperLeft(),book1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIndexTooLarge(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        shelf.set(5,book1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIndexTooLow(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        shelf.set(-1,book1);
    }

    @Test
    public void testIterator(){
        Shelf<?> shelf = createshelf();
        Iterator<?> it = shelf.iterator();

        assertEquals(book1,it.next());
        assertEquals(book2,it.next());
        assertEquals(book3,it.next());
        assertEquals(book4,it.next());


    }
    @Test(expected = NoSuchElementException.class)
    public void testIteratorHasNoNext(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        Iterator<ShelfItem> it = shelf.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
    }

    @Test
    public void testTakeFrom(){
        Shelf<?> shelf = createshelf();

        Shelf<ShelfItem> nullshelf = new Shelf<>();
        Iterator<ShelfItem> nullit = nullshelf.iterator();
        nullshelf.takeFrom(shelf);

        assertEquals(book1,nullit.next());
        assertEquals(book2,nullit.next());
        assertEquals(book3,nullit.next());
        assertEquals(book4,nullit.next());
    }

    public Shelf<?> createshelf(){
        Shelf<ShelfItem> shelf = new Shelf<>();
        shelf.set(0,book1);
        shelf.set(1,book2);
        shelf.set(2,book3);
        shelf.set(3,book4);

        return shelf;
    }

    @Test
    public void testMax(){
        Shelf<?> bookshelf = createshelf();
        assertEquals(book4,bookshelf.max((o1, o2) -> {
            return Integer.compare(((Book) o1).getPages(), ((Book) o2).getPages());
        }));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxNull(){
        Shelf<?> shelf = createshelf();
        shelf.max(null);
    }

    @Test
    public void testTransferAndTrim(){
        Shelf<Book> shelffrom = new Shelf<>();
        Shelf<Book> shelfto = new Shelf<>();
        shelffrom.set(0,book1);
        shelffrom.set(1,book2);
        shelffrom.set(3,book4);

        Shelf.transferAndTrim(shelffrom,shelfto);
        assertEquals(shelfto.get(0),book1);
        assertEquals(shelfto.get(1),book2);
        assertEquals(shelfto.get(2),book4);
        assertNull(shelfto.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferAndTrimNull(){
        Shelf.transferAndTrim(null,null);
    }

}
