package jp.hideakisago.androidtemplate.libraries.utilities;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * View を見つけるための helper class です。
 *
 * {@link View#findViewById(int)} は method 名が長い上に cast も行う必要が有るため非常に冗長な記述になります。
 * {@link ViewFinder} はその問題を解消します。
 *
 * <p>
 * Usage:
 * <pre><code>
 * private TextView mTitle;
 * private Button mButton;
 *
 * ViewFinder vf = new ViewFinder(rootView);
 * mTitle = vf.find(R.id.button);
 * mButton = vf.find(R.id.button);
 * ...
 * </code></pre>
 */
public class ViewFinder {

    /** Root view。 */
    private final View mRootView;

    /**
     * @param rootView 見つけるすべての view を子孫に持つ root view です。
     */
    public ViewFinder(@NonNull View rootView) {
        mRootView = rootView;
    }

    /**
     * 指定した viewId に該当する view を見つけ、指定された型に cast して view を返します。
     *
     * @param parent 見つける view を子孫に持つ親 view です。
     * @param viewId 見つける view の ID です。
     * @param <V> 見つける view の型です。
     * @return viewId で指定された view を返します。
     */
    public static <V extends View> V find(View parent, @IdRes int viewId) {
        //noinspection unchecked
        return (V) parent.findViewById(viewId);
    }

    /**
     * 指定した viewId に該当する view を見つけ、指定された型に cast して view を返します。
     *
     * @param viewId 見つける view の ID です。
     * @param <V> 見つける view の型です。
     * @return viewId で指定された view を返します。
     */
    public <V extends View> V find(@IdRes int viewId) {
        //noinspection unchecked
        return (V) mRootView.findViewById(viewId);
    }
}
