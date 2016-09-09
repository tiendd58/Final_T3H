package media.t3h.com.smartrestaurant.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import media.t3h.com.smartrestaurant.R;

/**
 * Created by Ngoc on 9/3/2016.
 */
public class MenuFragment extends Fragment {

    public MenuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        return rootView;
    }
}
