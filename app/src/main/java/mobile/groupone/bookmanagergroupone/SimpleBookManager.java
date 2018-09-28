package mobile.groupone.bookmanagergroupone;

import android.util.Log;

import java.util.ArrayList;

public class SimpleBookManager implements BookManager {

    private ArrayList<Book> books;

    public SimpleBookManager() {
        this.books = new ArrayList<Book>();
        this.createNonEmptyBook("J.K Rolling", "Harry Potter", 199, "12345", "Fiction for Engineers");
        this.createNonEmptyBook("Baudelaire", "Les Fleurs du Mal", 110, "12346", "French");
        this.createNonEmptyBook("Isaac Asimov", "Foundation", 230, "12347", "Fiction for Engineers");
        this.createNonEmptyBook("Amélie Nothomb", "Stupeur et tremblements", 190, "12348", "French");
        this.createNonEmptyBook("Daniel Keyes", "Flowers for Algernon", 190, "12349", "Philosophy");
        Log.d("first book",this.getBook(0).getTitle());
    }

    @Override
    public int count() {
        return books.size();
    }

    @Override
    public Book getBook(int index) {
        try {
            Book res = books.get( index );
            return res;
        } catch ( IndexOutOfBoundsException e ) {
            return null;
        }
    }

    @Override
    public Book createBook() {
        Book book = new Book();
        books.add(book);
        return book;
    }

    public Book createNonEmptyBook(String author, String title, int price, String isbn, String course) {
        Book book = new Book(author, title, price, isbn, course);
        books.add(book);
        return book;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return books;
    }

    @Override
    public void removeBook(Book book) {
        boolean success = books.remove(book);
        //should return a boolean not void to check if the book was there in the first place
    }

    @Override
    public void moveBook(int from, int to) {
        try {
            Book first = books.get(from);
            Book second = books.get(to);

            books.set(from, second);
            books.set(to, first);
        } catch ( IndexOutOfBoundsException e ) {
            //error
        }
    }

    @Override
    public int getMinPrice() {

        if(books.size() == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<books.size(); i++)
        {
            if(books.get(i).getPrice() < min){
                min = books.get(i).getPrice();
            }
        }
        return min;
    }

    @Override
    public int getMaxPrice() {
        if(books.size() == 0){
            return 0;
        }

        int max = 0;
        for (int i=0; i<books.size(); i++)
        {
            if(books.get(i).getPrice()>max){
                max = books.get(i).getPrice();
            }
        }
        return max;
    }

    @Override
    public float getMeanPrice() {
        if(books.size() == 0){
            return 0;
        }

        float total = (float) books.size();
        float cost = (float)getTotalCost();

        return cost/total;
    }

    @Override
    public int getTotalCost() {
        if(books.size() == 0){
            return 0;
        }

        int total = 0;
        for (int i=0; i<books.size(); i++)
        {
            total += books.get(i).getPrice();
        }
        return total;
    }

    @Override
    public void saveChanges() {

    }
}
