package crm.workshop.echonest.playlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by lbeltramo on 15/10/2014.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return PlayListFragment.newInstance(10, "Alec Empire");
    }

    @Override
    public int getCount() {
        return 3;
    }
}
