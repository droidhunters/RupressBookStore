package th.ac.ru.rupress.bookstore.rupressbooksstore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by PLAN-NB on 6/26/2016.
 */
public class BookAdapter extends BaseAdapter {

    //Explicit
    private Context context;
    private String[] nameStrings, priceStrings, coverStrings;

    public BookAdapter(Context context, String[] nameStrings, String[] priceStrings, String[] coverStrings) {
        this.context = context;
        this.nameStrings = nameStrings;
        this.priceStrings = priceStrings;
        this.coverStrings = coverStrings;
    }

    @Override
    public int getCount() {
        return nameStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
} //Main Class
