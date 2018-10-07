package mobile.groupone.bookmanagergroupone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewBook extends AppCompatActivity {
    Button save;
    EditText title;;
    EditText author;
    EditText course;
    EditText ISBN;
    EditText price;
    SimpleBookManager library;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);

        this.library = library.getBookManager();
        save = (Button)findViewById(R.id.button_save);
        title   = (EditText)findViewById(R.id.input_title);
        author   = (EditText)findViewById(R.id.input_author);
        course   = (EditText)findViewById(R.id.input_course);
        ISBN   = (EditText)findViewById(R.id.input_ISBN);
        price   = (EditText)findViewById(R.id.input_price);
        error = (TextView) findViewById(R.id.error_input_new_book) ;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.button_save) {

            if (title.getText().toString().matches("")) {
                error.setVisibility(View.VISIBLE);
            }

            else{
                library.createBook();
                Book last = library.getBook(library.getAllBooks().size() -1);
                last.setTitle(title.getText().toString());
                last.setAuthor(author.getText().toString());
                last.setCourse(course.getText().toString());
                last.setIsbn(ISBN.getText().toString());
                try {
                    last.setPrice(Integer.parseInt(price.getText().toString()));
                }
                catch ( NumberFormatException e )
                {
                    last.setPrice(0);
                }
                library.saveChanges();
                finish();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


