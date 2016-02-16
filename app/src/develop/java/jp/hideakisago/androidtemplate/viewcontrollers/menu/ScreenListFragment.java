package jp.hideakisago.androidtemplate.viewcontrollers.menu;

import java.util.List;

public class ScreenListFragment extends AbsMenuListFragment {

    @Override
    protected List<AbsMenuListFragment.Item> createItems() {

        return new ItemListBuilder()
                .add("hoge", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .add("hoge", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .add("hoge", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .items;
    }
}
