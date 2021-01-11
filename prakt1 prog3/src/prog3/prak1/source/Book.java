package prog3.prak1.source;

public class Book extends ShelfItem{

    private String author;
    private String title;
    private int pages;

    public Book(String author,String title,int pages){
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
}
