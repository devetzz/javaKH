package connectdb;

public class Books {
    private int bookId;
    private String title;
    private String publisher;
    private String year;
    private int price;

    public Books() {
    }

    public Books(int bookId, String title, String publisher, String year, int price) {
        this.bookId = bookId;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bookId + "," +  title + "," + publisher + "," + year + "," + price;
    }
    

}
