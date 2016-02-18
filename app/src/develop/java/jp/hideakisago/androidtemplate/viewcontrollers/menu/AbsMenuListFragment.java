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

/**
 * 開発 menu 画面の抽象 class です。
 *
 * 画面や API などの開発項目を {@link ListView} で表示し、各項目に設定された処理を実行します。
 */
public abstract class AbsMenuListFragment extends AbsUiFragment {

    /** 項目 list。 */
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

        onInitListView(mListView, savedInstanceState);
    }

    /**
     * {@link ListView} を初期化します。
     *
     * @param listView 初期化する {@link ListView} です。
     * @param savedInstanceState null でないの場合、この fragment は以前に保存した状態から再構築されています。
     */
    protected void onInitListView(ListView listView, @Nullable Bundle savedInstanceState) {

        listView.setAdapter(new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                createItems()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AbsMenuListFragment.this.onItemClick(parent, view, position, id);
            }
        });
    }

    /**
     * List に表示する item を作成します。
     *
     * @return 作成した item を返します。
     * @see ItemListBuilder
     */
    protected abstract List<Item> createItems();

    /**
     * List 項目を click した時に呼び出されます。
     *
     * 該当項目の {@link Item#runner} が設定されている場合は実行します。
     */
    protected void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = (Item) parent.getAdapter().getItem(position);
        if (item.runner != null) {
            item.runner.run();
        }
    }

    /**
     * List に表示する1要素です。
     */
    protected static class Item {
        /** 項目名。 */
        public final String name;
        /** 項目選択時に実行される処理。 */
        public final Runnable runner;

        /**
         * 項目名のみ指定して生成します。
         * 項目選択時に実行される処理は null を設定します。
         *
         * @param name 項目名です。
         */
        public Item(String name) {
            this(name, null);
        }

        /**
         * 項目名 及び 項目選択時に実行される処理 を指定して生成します。
         *
         * @param name 項目名です。
         * @param runner 項目選択時に実行される処理です。
         */
        public Item(String name, @Nullable Runnable runner) {
            this.name = name;
            this.runner = runner;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Item list を構築するための helper です。
     *
     * {@link #createItems()} にて、以下のように使うことができます。
     * <pre><code>
     * return new ItemListBuilder()
     *         .add("Sample", this::foo)
     *         .add("Sample", this::bar)
     *         .items;
     * </code></pre>
     */
    protected static class ItemListBuilder {
        /** Item list。 */
        public final List<Item> items;
        /** 項目選択時に実行される default の処理。 */
        private Runnable mDefaultRunner;

        /**
         * 構築する list の base になる任意の list を設定して生成します。
         */
        public ItemListBuilder() {
            this(new ArrayList<Item>());
        }

        /**
         * 構築する list の base になる任意の list を設定して生成します。
         *
         * @param items 構築する list の base になる任意の list です。
         */
        public ItemListBuilder(List<Item> items) {
            this.items = items;
        }

        /**
         * {@link #add(String)} 時に設定する default の {@link Runnable} を設定します。
         *
         * @param runner {@link #add(String)} 時に設定する default の処理です。
         * @return this を返します。
         */
        public ItemListBuilder setDefaultRunnable(@Nullable Runnable runner) {
            mDefaultRunner = runner;
            return this;
        }

        /**
         * 引数で指定する項目名と {@link #setDefaultRunnable(Runnable)} で指定された処理の item を生成して項目に追加します。
         *
         * @param name 項目名です。
         * @return this を返します。
         */
        public ItemListBuilder add(String name) {
            return add(name, mDefaultRunner);
        }

        /**
         * 引数で指定する項目名と {@link Runnable} の item を生成して項目に追加します。
         *
         * @param name 項目名です。
         * @param runner 項目選択時に実行される処理です。
         * @return this を返します。
         */
        public ItemListBuilder add(String name, @Nullable Runnable runner) {
            items.add(new Item(name, runner));
            return this;
        }
    }
}
