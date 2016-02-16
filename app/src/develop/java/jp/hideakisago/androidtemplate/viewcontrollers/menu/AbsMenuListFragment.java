package jp.hideakisago.androidtemplate.viewcontrollers.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jp.hideakisago.androidtemplate.R;
import jp.hideakisago.androidtemplate.libraries.utilities.ViewFinder;
import jp.hideakisago.androidtemplate.viewcontrollers.AbsUiFragment;

public abstract class AbsMenuListFragment extends AbsUiFragment {

    private ListView mListView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_screen_list;
    }

    @Override
    protected void onFindView(ViewFinder view) {
        super.onFindView(view);

        mListView = view.find(R.id.list);
    }

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        super.onInitView(savedInstanceState);

        mListView.setAdapter(new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                createItems()));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) parent.getAdapter().getItem(position);
                item.runner.run();
            }
        });
    }

    protected abstract List<Item> createItems();

    protected static class Item {

        public final String name;

        public final Runnable runner;

        public Item(String name, Runnable runner) {
            this.name = name;
            this.runner = runner;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    protected static class ItemListBuilder {

        public final ArrayList<Item> items;

        public ItemListBuilder() {
            this(new ArrayList<Item>());
        }

        public ItemListBuilder(ArrayList<Item> items) {
            this.items = items;
        }

        public ItemListBuilder add(String name, Runnable runner) {
            items.add(new Item(name, runner));
            return this;
        }
    }
}