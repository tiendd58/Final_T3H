package media.t3h.com.smartrestaurant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duyti on 9/6/2016.
 */
public class PagerFeatureAdapter extends FragmentPagerAdapter{

    private List<Fragment> listFeature = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public PagerFeatureAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listFeature.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    public void addFrag(Fragment feature, String title){
        listFeature.add(feature);
        titles.add(title);
    }
}
