package louisbl.fr.hellocrm.playlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.echonest.api.v4.Song;

/**
 * Created by lbeltramo on 14/10/2014.
 */
public class PlayListAdapter extends ArrayAdapter<Song> {

    private final LayoutInflater mInflater;

    public PlayListAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_2);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = mInflater.inflate(android.R.layout.simple_list_item_2,
                    parent, false);
        } else {
            view = convertView;
        }

        Song song = getItem(position);
        ((TextView)view.findViewById(android.R.id.text1)).setText(song.getArtistName());
        ((TextView)view.findViewById(android.R.id.text2)).setText(song.getTitle());

        return view;
    }
}
