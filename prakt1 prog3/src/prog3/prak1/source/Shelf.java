package prog3.prak1.source;

import java.util.*;

public class Shelf<T extends ShelfItem> implements Iterable<T> {

    private T upperLeft;
    private T upperRight;
    private T lowerLeft;
    private T lowerRight;

    public Shelf() {
        upperLeft = null;
        upperRight = null;
        lowerLeft = null;
        lowerRight = null;
    }

    public void takeFrom(Shelf<? extends T> other) {
        if (other == null)
            throw new IllegalArgumentException("other cant be null!");
        for (int i = 0; i < 4; i++) {
            this.set(i, other.get(i));
            other.set(i, null);
        }
    }

    public T get(int index) {
        return switch (index) {
            case 0 -> upperLeft;
            case 1 -> upperRight;
            case 2 -> lowerLeft;
            case 3 -> lowerRight;
            default -> throw new IllegalArgumentException("index > 0 & < 5");
        };
    }

    public void set(int index, T item) {
        switch (index) {
            case 0 -> upperLeft = item;
            case 1 -> upperRight = item;
            case 2 -> lowerLeft = item;
            case 3 -> lowerRight = item;
            default -> throw new IllegalArgumentException("index > 0 & < 5");
        }

    }

    public T max(Comparator<T> comparator){
        if(comparator == null)
            throw new IllegalArgumentException();
        ArrayList<T> list = new ArrayList<>();
        for(int i = 0;i < 4;i++)
            list.add(this.get(i));
        return Collections.max(list,comparator);
    }

    public static <S extends ShelfItem> void transferAndTrim(Shelf<S> shelf1,Shelf<? super S> shelf2){
        if(shelf1 == null || shelf2 == null)
            throw new IllegalArgumentException();
        int counter = 0;
        for(int i = 0;i < 4;i++) {
            shelf2.set(i,null);
            if (shelf1.get(i) != null) {
                shelf2.set(counter, shelf1.get(i));
                counter++;
            }
        }
    }


    public void setUpperLeft(T Item) {
        upperLeft = Item;
    }

    public void setUpperRight(T Item) {
        upperRight = Item;
    }

    public void setLowerLeft(T Item) {
        lowerLeft = Item;
    }

    public void setLowerRight(T Item) {
        lowerRight = Item;
    }

    public ShelfItem getUpperLeft() {
        return upperLeft;
    }

    public ShelfItem getUpperRight() {
        return upperRight;
    }

    public ShelfItem getLowerLeft() {
        return lowerLeft;
    }

    public ShelfItem getLowerRight() {
        return lowerRight;
    }

    @Override
    public Iterator<T> iterator() {
        return new ShelfIterator();
    }

    private class ShelfIterator implements Iterator<T>{
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < 4;
            }

            @Override
            public T next() {
                if(hasNext())
                    return get(index++);
                else throw new NoSuchElementException();
            }
        }
}



