package media.t3h.com.smartrestaurant.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import media.t3h.com.smartrestaurant.R;
import media.t3h.com.smartrestaurant.adapter.PagerFeatureAdapter;
import media.t3h.com.smartrestaurant.fragment.ChatFragment;
import media.t3h.com.smartrestaurant.fragment.ChoseTableFragment;
import media.t3h.com.smartrestaurant.fragment.MenuFragment;
import media.t3h.com.smartrestaurant.fragment.ReceiptFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAB_MENU = "MENU";
    private static final String TAB_CHOSE_TABLE = "BOOK";
    private static final String TAB_CHAT = "CHAT";
    private static final String TAB_RECEIPT = "RECEIPT";
    private TabLayout tabs;

    private PagerFeatureAdapter featureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
        initView();
        initToolbar();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initAdapter() {
        featureAdapter = new PagerFeatureAdapter(getSupportFragmentManager());
        featureAdapter.addFrag(new MenuFragment(), TAB_MENU);
        featureAdapter.addFrag(new ChoseTableFragment(), TAB_CHOSE_TABLE);
        featureAdapter.addFrag(new ChatFragment(), TAB_CHAT);
        featureAdapter.addFrag(new ReceiptFragment(), TAB_RECEIPT);
    }

    private void initView() {
        ViewPager vpFeature = (ViewPager) findViewById(R.id.vp_feature);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(vpFeature,true);
        vpFeature.setAdapter(featureAdapter);
        for(int i = 0 ; i< tabs.getTabCount(); i++){
            switch (tabs.getTabAt(i).getText().toString()){
                case TAB_CHAT:
                    tabs.getTabAt(i).setIcon(R.drawable.wechat);
                    break;
                case TAB_RECEIPT:
                    tabs.getTabAt(i).setIcon(R.drawable.receipt);
                    break;
                case TAB_MENU:
                    tabs.getTabAt(i).setIcon(R.drawable.menu);
                    break;
                case TAB_CHOSE_TABLE:
                    tabs.getTabAt(i).setIcon(R.drawable.books);
                    break;
            }
        }
    }
}
