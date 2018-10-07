package mobile.groupone.bookmanagergroupone;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CollectionView extends Fragment {
    ArrayAdapter<String> itemsAdapter;
    SimpleBookManager library;
    Book books;


    public CollectionView() {
    }

    public static CollectionView newInstance() {
        CollectionView fragment = new CollectionView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection_view, container, false);

        ArrayList<String> lists = new ArrayList<String>();
        this.library = library.getBookManager();
        for (Book book : library.getAllBooks())
        {
            lists.add(book.getTitle());
        }
        final ListView listView = (ListView) view.findViewById(R.id.listView);

        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = listView.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), BookView.class);
                intent.putExtra("pos", position);
                startActivity(intent);

            }
        });

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1, lists);
        listView.setAdapter(adapter);

        return view;
    }

}
