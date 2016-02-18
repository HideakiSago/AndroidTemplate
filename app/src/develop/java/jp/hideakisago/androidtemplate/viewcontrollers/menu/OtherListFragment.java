package jp.hideakisago.androidtemplate.viewcontrollers.menu;

import java.util.List;

/**
 * 特に分類されない処理を実行するための menu list 画面です。
 */
public class OtherListFragment extends AbsMenuListFragment {

    @Override
    protected List<Item> createItems() {

        return new ItemListBuilder()
                .add("Other", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .add("Other", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .add("Other", new Runnable() {
                    @Override
                    public void run() {
                        mLog.trace();
                    }
                })
                .items;
    }
}
