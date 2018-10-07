package mobile.groupone.bookmanagergroupone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class BookView extends AppCompatActivity {
public int position;
EditText title;
EditText author;
EditText ISBN;
EditText price;
EditText course;

public SimpleBookManager library;
public Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);
        position = getIntent().getIntExtra("pos", 0);
        this.library = library.getBookManager();
        Book book = library.getBook(position);
        Log.d("TAG", book.getTitle());
        Log.d("TAG", book.getAuthor());
        title = (EditText) findViewById(R.id.input_title);
        author = (EditText) findViewById(R.id.input_author);
        ISBN = (EditText) findViewById(R.id.input_ISBN);
        price = (EditText) findViewById(R.id.input_price);
        course = (EditText) findViewById(R.id.input_course);

        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        ISBN.setText(book.getIsbn());
        price.setText(Integer.toString(book.getPrice()));
        course.setText(book.getCourse());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.button_delete) {
            library.removeBook(book);
            library.saveChanges();
            finish();
            return true;
        }
        if (id == R.id.button_edit) {
            book.setTitle(title.getText().toString());
            book.setAuthor(author.getText().toString());
            book.setCourse(course.getText().toString());
            book.setIsbn(ISBN.getText().toString());
            try {
                book.setPrice(Integer.parseInt(price.getText().toString()));
            }
            catch ( NumberFormatException e )
            {
                book.setPrice(0);
            }
            library.saveChanges();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
