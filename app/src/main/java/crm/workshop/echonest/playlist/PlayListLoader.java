package crm.workshop.echonest.playlist;

import android.content.Context;

import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Playlist;

import server.ENWrapper;

/**
 * Created by lbeltramo on 14/10/2014.
 */
public class PlayListLoader extends android.support.v4.content
        .AsyncTaskLoader<Playlist> {
    private int mResults;
    private String mArtist;
    private Playlist mPlaylist;

    public PlayListLoader(Context context) {
        super(context);
    }

    @Override
    public Playlist loadInBackground() {
        try {
            mPlaylist = ENWrapper.with(getContext()).getArtistRadio(mResults,
                    mArtist);
        } catch (EchoNestException e) {
            mPlaylist = null;
            e.printStackTrace();
        }
        return mPlaylist;
    }

    @Override
    protected void onStartLoading() {
        if (mPlaylist != null) {
            deliverResult(mPlaylist);
        } else {
            forceLoad();
        }
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

    public void setResults(int results) {
        this.mResults = results;
    }
}
