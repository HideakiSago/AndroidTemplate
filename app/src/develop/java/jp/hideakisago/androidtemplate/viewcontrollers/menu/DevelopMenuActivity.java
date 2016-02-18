package jp.hideakisago.androidtemplate.viewcontrollers.menu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import jp.hideakisago.androidtemplate.R;
import jp.hideakisago.androidtemplate.libraries.utilities.log.Logger;

public class DevelopMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /** ログ。 */
    private final Logger mLog = Logger.Factory.create(this);

    /** バックスタック監視。 */
    private final BackStackTracer mBackStackTracer = new BackStackTracer();

    /** ナビゲーション。 */
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        initBackStackTracer();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, new ScreenListFragment())
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyBackStackTracer();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (!getSupportFragmentManager()
                .findFragmentById(R.id.content_frame)
                .getClass()
                .equals(ScreenListFragment.class)) {
            getSupportFragmentManager().popBackStack(
                    ScreenListFragment.class.getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mNavigationView.getMenu().getItem(0).setChecked(true);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        final Class<?> nextClass;

        switch (id) {
            case R.id.nav_screens:
                nextClass = ScreenListFragment.class;
                break;
            case R.id.nav_rest_apis:
                nextClass = ApiListFragment.class;
                break;
            case R.id.nav_samples:
                nextClass = SampleListFragment.class;
                break;
            case R.id.nav_others:
                nextClass = OtherListFragment.class;
                break;
            default:
                throw new RuntimeException("Unknown ID.");
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment current = fm.findFragmentById(R.id.content_frame);
        Class<? extends Fragment> currentClass = current.getClass();
        if (nextClass.equals(currentClass)) {
            return true;
        }

        final String nextFragmentName = nextClass.getName();
        final int count = fm.getBackStackEntryCount();
        for (int index = 0; index < count; index++) {
            FragmentManager.BackStackEntry entry = fm.getBackStackEntryAt(index);
            if (entry.getName().equals(nextFragmentName)) {
                fm.popBackStack(nextFragmentName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                return true;
            }
        }

        try {
            fm.beginTransaction()
                    .replace(R.id.content_frame, (Fragment) nextClass.newInstance())
                    .addToBackStack(currentClass.getName())
                    .commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return true;
    }

    /** バックスタック監視を開始します。 */
    private void initBackStackTracer() {
        getSupportFragmentManager().addOnBackStackChangedListener(mBackStackTracer);
    }

    /** バックスタック監視を終了します。 */
    private void destroyBackStackTracer() {
        getSupportFragmentManager().removeOnBackStackChangedListener(mBackStackTracer);
    }

    /** バックスタック変更リスナ。 */
    private class BackStackTracer implements FragmentManager.OnBackStackChangedListener {
        @Override
        public void onBackStackChanged() {
            FragmentManager fm = getSupportFragmentManager();
            final int count = fm.getBackStackEntryCount();
            for (int index = 0; index < count; index++) {
                FragmentManager.BackStackEntry entry = fm.getBackStackEntryAt(index);
                mLog.d("" + index + " " + entry);
            }
        }
    }
}
