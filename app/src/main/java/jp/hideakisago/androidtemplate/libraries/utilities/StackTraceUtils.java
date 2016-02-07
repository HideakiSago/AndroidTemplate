package jp.hideakisago.androidtemplate.libraries.utilities;

import android.support.annotation.IntRange;

/**
 * Stack trace に関する utility class です。
 */
public class StackTraceUtils {

    /** 現在の method の要素番号。 */
    private static final int CURRENT_METHOD_INDEX = 3;

    /**
     * Instance を生成させないための private constructor です。
     */
    private StackTraceUtils() {
        // 空実装
    }

    /**
     * 指定した index に該当する method の stack trace element を取得します。
     *
     * @param index 取得する method の index です。
     * index に対応する method は以下の通りです。
     * <ul>
     * <li>+3: VMStack.getThreadStackTrace</li>
     * <li>+2: {@link Thread#getStackTrace()}</li>
     * <li>+1: getStackTraceElement(int) (This method)</li>
     * <li> 0: Current method</li>
     * <li>-1: One previous method</li>
     * <li>-2: Two previous method</li>
     * <li>-3: Three previous method</li>
     * <li>...</li>
     * </ul>
     * @return 指定した method の stack trace element を返します。
     */
    public static StackTraceElement getStackTraceElement(@IntRange(to = CURRENT_METHOD_INDEX) int index) {
        return Thread.currentThread().getStackTrace()[CURRENT_METHOD_INDEX - index];
    }
}
