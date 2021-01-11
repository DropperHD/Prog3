package prog3.prak1.source;

public class Tool extends  ShelfItem{
    private final String name;

    public Tool(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
