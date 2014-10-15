package server;

import android.app.Activity;
import android.content.Context;

import com.echonest.api.v4.BasicPlaylistParams;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Playlist;

import louisbl.fr.hellocrm.R;

/**
 * Created by lbeltramo on 14/10/2014.
 */
public class EchoNestWrapper {
    private static String ECHO_NEST_API_KEY = "";
    private static EchoNestAPI mInstance;

    public static void setApiKey(Context context) {
        ECHO_NEST_API_KEY = context.getString(R.string.echo_nest_api);
    }
    
    public static EchoNestAPI getInstance() throws EchoNestWrapperException {
        if (ECHO_NEST_API_KEY.equals("")) {
            throw new EchoNestWrapperException("must be called after setApiKey");
        }
        if (mInstance == null) {
            mInstance = new EchoNestAPI(ECHO_NEST_API_KEY);
        }
        return mInstance;
    }

    public static Playlist getArtistRadio(int results, String artist) throws
            EchoNestException, EchoNestWrapperException {
        BasicPlaylistParams params = new BasicPlaylistParams();
        params.addArtist(artist);
        params.setType(BasicPlaylistParams.PlaylistType.ARTIST_RADIO);
        params.setResults(results);
        return getInstance().createBasicPlaylist(params);
    }
}

