package mobile.groupone.bookmanagergroupone;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SummaryFragment extends Fragment {
    private boolean shouldRefreshOnResume = false;
    public SimpleBookManager library;
    public TextView total;
    public TextView cost;
    public TextView max;
    public TextView least;
    public TextView mean;

    public SummaryFragment() {
    }

    public static SummaryFragment newInstance() {
        SummaryFragment fragment = new SummaryFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        library = library.getBookManager();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        total = (TextView) view.findViewById(R.id.input_title);
        total.setText("       " + Integer.toString(library.count()) + " Books");

        cost = (TextView) view.findViewById(R.id.input_cost);
        cost.setText("       " + Integer.toString(library.getTotalCost()) + " SEK");

        max = (TextView) view.findViewById(R.id.input_exp);
        max.setText("      " + Integer.toString(library.getMaxPrice())+ " SEK");

        least = (TextView) view.findViewById(R.id.input_least);
        least.setText("      " + Integer.toString(library.getMinPrice())+ " SEK");

        mean = (TextView) view.findViewById(R.id.input_mean);
        mean.setText("      " + Float.toString(library.getMeanPrice())+ " SEK");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Check should we need to refresh the fragment
        if(shouldRefreshOnResume){

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        shouldRefreshOnResume = true;
    }

}
