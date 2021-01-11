package prog3.prak1.source;

import java.util.Iterator;

public class ShelfMain {

    public static void main(String[] args) {
        Book book0 = new Book("Ullenbloom","Java ist auch eine Insel",1246);
        Book book1 = new Book("Schirach","Schuld",208);
        Book book3 = new Book("Börnstädt","Bibi und Tina",34);

        Shelf<Book> bookShelf = new Shelf<>();

        bookShelf.set(0,book0);
        bookShelf.set(1,book1);
        bookShelf.set(3,book3);

        printshelf(bookShelf);

        Tool tool0 = new Tool("Schraubenzieher");
        Tool tool3 = new Tool("Säge");

        Shelf<Tool> toolShelf = new Shelf<>();

        toolShelf.set(0,tool0);
        toolShelf.set(3,tool3);

        printshelf(toolShelf);

        Shelf<Book> newBookShelf = new Shelf<>();
        newBookShelf.takeFrom(bookShelf);

        printshelf(newBookShelf);

        Shelf<ShelfItem> generalShelf = new Shelf<>();
        generalShelf.takeFrom(newBookShelf);

        printshelf(generalShelf);
    }

    static void printshelf(Shelf<?> shelf){
        Iterator<?> it = shelf.iterator();
        for(var item : shelf)
            System.out.println(item);
    }
}
