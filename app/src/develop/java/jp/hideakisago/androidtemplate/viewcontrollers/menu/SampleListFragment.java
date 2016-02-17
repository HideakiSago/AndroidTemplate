package jp.hideakisago.androidtemplate.viewcontrollers.menu;

import java.util.List;

public class SampleListFragment extends AbsMenuListFragment {

    @Override
    protected List<Item> createItems() {

        return new ItemListBuilder()
                .add("Sample", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .add("Sample", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .add("Sample", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .items;
    }
}
