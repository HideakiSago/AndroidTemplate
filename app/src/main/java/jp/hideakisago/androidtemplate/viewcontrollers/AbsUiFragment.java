package jp.hideakisago.androidtemplate.viewcontrollers;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.hideakisago.androidtemplate.App;
import jp.hideakisago.androidtemplate.libraries.utilities.ViewFinder;
import jp.hideakisago.androidtemplate.models.configurations.AppConfig;

/**
 * 画面を持つ fragment の抽象 class です。
 */
public abstract class AbsUiFragment extends LoggerFragment {

    /**
     * この画面の title を取得します。
     *
     * Title は GA や toolbar への表示に利用できます。
     *
     * @return この画面の title を返します。
     */
    protected String getTitle() {
        return null;
    }

    /**
     * この画面の layout id を取得します。
     *
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} で呼び出され、 layout を inflate します。
     *
     * @return この画面の layout id を返します。
     * @see #onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @LayoutRes
    protected abstract int getLayoutId();

    @CallSuper
    @NonNull
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(getLayoutId(), container, false);
    }

    @CallSuper
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onFindView(new ViewFinder(view));

        onInitView(savedInstanceState);
    }

    /**
     * この画面で利用する view を全て探し、 field に保持します。
     *
     * @param view View を見つけるための helper です。
     */
    @CallSuper
    protected void onFindView(ViewFinder view) {
        mLog.trace(view);
    }

    /**
     * この画面で利用する view を初期化します。
     *
     * @param savedInstanceState null でないの場合、この fragment は以前に保存した状態から再構築されています。
     */
    @CallSuper
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        mLog.trace(savedInstanceState);
    }

    /**
     * @return {@link App} の instance を返します。
     */
    protected final App getApp() {
        return (App) getActivity().getApplication();
    }

    /**
     * @return {@link AppConfig} の instance を返します。
     */
    protected final AppConfig getAppConfig() {
        return getApp().getConfig();
    }
}
