package jp.hideakisago.androidtemplate.viewcontrollers.menu;

import java.util.List;

/**
 * 画面表示確認用の menu list 画面です。
 */
public class ScreenListFragment extends AbsMenuListFragment {

    @Override
    protected List<AbsMenuListFragment.Item> createItems() {

        return new ItemListBuilder()
                .add("Screen", mLog::trace)
                .add("Screen", mLog::trace)
                .add("Screen", mLog::trace)
                .items;
    }
}
