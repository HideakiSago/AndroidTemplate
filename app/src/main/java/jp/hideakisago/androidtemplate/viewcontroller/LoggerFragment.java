package jp.hideakisago.androidtemplate.viewcontroller;

import android.animation.Animator;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import jp.hideakisago.androidtemplate.libraries.utilities.log.Logger;

/**
 * 各 method で trace log を出力する fragment です。
 *
 * onXxx のうち、非推奨を除いた method で log を出力します。
 */
public class LoggerFragment extends Fragment {

    /** Log。 */
    protected final Logger mLog = Logger.Factory.create(this);

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        mLog.trace(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mLog.trace(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttach(Context context) {
        mLog.trace(context);
        super.onAttach(context);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        mLog.trace(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        mLog.trace(item);
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mLog.trace(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        mLog.trace(transit, enter, nextAnim);
        return super.onCreateAnimator(transit, enter, nextAnim);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        mLog.trace(menu, v, menuInfo);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mLog.trace(menu, inflater);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mLog.trace(inflater, container, savedInstanceState);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        mLog.trace();
        super.onDestroy();
    }

    @Override
    public void onDestroyOptionsMenu() {
        mLog.trace();
        super.onDestroyOptionsMenu();
    }

    @Override
    public void onDestroyView() {
        mLog.trace();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        mLog.trace();
        super.onDetach();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        mLog.trace(hidden);
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        mLog.trace(context, attrs, savedInstanceState);
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onLowMemory() {
        mLog.trace();
        super.onLowMemory();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mLog.trace(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        mLog.trace(menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onPause() {
        mLog.trace();
        super.onPause();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        mLog.trace(menu);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLog.trace(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onResume() {
        mLog.trace();
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mLog.trace(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        mLog.trace();
        super.onStart();
    }

    @Override
    public void onStop() {
        mLog.trace();
        super.onStop();
    }

    @Override
    public void onTrimMemory(int level) {
        mLog.trace(level);
        super.onTrimMemory(level);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mLog.trace(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        mLog.trace(savedInstanceState);
        super.onViewStateRestored(savedInstanceState);
    }
}
