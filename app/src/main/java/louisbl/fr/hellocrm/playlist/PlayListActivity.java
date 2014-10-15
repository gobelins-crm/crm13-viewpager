package louisbl.fr.hellocrm.playlist;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.echonest.api.v4.Song;

import louisbl.fr.hellocrm.R;
import server.EchoNestWrapper;

public class PlayListActivity extends FragmentActivity implements PlayListFragment
        .OnSongClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EchoNestWrapper.setApiKey(this);

        setContentView(R.layout.app_container);

        if (savedInstanceState == null) {
            changeLeftFragment(PlayListFragment.newInstance(10,
                    "Alec Empire"));
        }
    }

    protected void changeLeftFragment(Fragment fragment) {
        View container = findViewById(R.id.container);
        if (container != null) {
            // handset
            changeFragment(fragment, R.id.container);
        } else {
            // tablet
            changeFragment(fragment, R.id.container_left);
        }
    }

    protected void changeRightFragment(Fragment fragment) {
        View container = findViewById(R.id.container);
        if (container != null) {
            // handset
            changeFragment(fragment, R.id.container);
        } else {
            // tablet
            changeFragment(fragment, R.id.container_right);
        }
    }

    private void changeFragment(Fragment fragment, int id) {
        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(id, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSongClicked(Song song) {
        Log.d("APP", "song clicked: " + song.getTitle());
        SongFragment songFragment;

        songFragment = new SongFragment();
        songFragment.setArtistName(song.getArtistName());
        songFragment.setTitle(song.getTitle());

        changeRightFragment(songFragment);
    }
}
