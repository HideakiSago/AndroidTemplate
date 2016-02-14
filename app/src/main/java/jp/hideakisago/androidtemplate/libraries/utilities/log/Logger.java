package jp.hideakisago.androidtemplate.libraries.utilities.log;

import android.content.Intent;
import android.util.Log;

/**
 * Log 出力のための interface です。
 */
public interface Logger {

    /**
     * Method が実行されているか確認するための log を出力します。
     * <p>
     * usage:
     * <pre><code>
     * public void foo() {
     *     mLog.trace();
     *     super.foo();
     *     ...
     * }
     * </code></pre>
     */
    void trace();

    /**
     * Method が実行されているか確認するための log を出力します。
     * <p>
     * usage:
     * <pre><code>
     * public void foo(int a, int b) {
     *     mLog.trace(a, b);
     *     super.foo(a, b);
     *     ...
     * }
     * </code></pre>
     */
    void trace(Object... args);

    /**
     * Intent の内容を dump します。
     * <p/>
     * 次のように出力されます。
     * <pre>
     * intent: &lt;intentの内容>, extras: &lt;intent.getExtras()の内容>
     * </pre>
     *
     * @param intent logcat に dump する intent です。
     */
    void dump(Intent intent);

    /**
     * @param msg ログに出力するメッセージです。
     */
    void v(String msg);

    /**
     * メッセージの先頭に「&lt;呼び出し元の method name> - 」を付加してメッセージを出力します。
     * ログ レベルは {@link Log#DEBUG} です。
     *
     * @param msg ログに出力するメッセージです。
     */
    void m(String msg);

    /**
     * @param msg ログに出力するメッセージです。
     */
    void d(String msg);

    /**
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void d(Throwable e);

    /**
     * @param msg ログに出力するメッセージです。
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void d(String msg, Throwable e);

    /**
     * @param msg ログに出力するメッセージです。
     */
    void i(String msg);

    /**
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void i(Throwable e);

    /**
     * @param msg ログに出力するメッセージです。
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void i(String msg, Throwable e);

    /**
     * @param msg ログに出力するメッセージです。
     */
    void w(String msg);

    /**
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void w(Throwable e);

    /**
     * @param msg ログに出力するメッセージです。
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void w(String msg, Throwable e);

    /**
     * @param msg ログに出力するメッセージです。
     */
    void e(String msg);

    /**
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void e(Throwable e);

    /**
     * @param msg ログに出力するメッセージです。
     * @param e 発生した例外です。 例外の情報をダンプします。
     */
    void e(String msg, Throwable e);


    class Factory {
        /**
         * 引数で指定した instance (Class) の simple name を tag として設定し、 {@link Logger} instance を生成します。
         *
         * @param thiz Class の simple name を tag として設定する instance です。
         */
        public static Logger create(Object thiz) {
            return create(thiz.getClass());
        }

        /**
         * 引数で指定した Class の simple name を tag として設定し、 {@link Logger} instance を生成します。
         *
         * @param clazz simple name を tag として設定する Class です。
         */
        public static Logger create(Class<?> clazz) {
            return create(clazz.getSimpleName());
        }

        /**
         * 引数で指定した tag を log 出力時の tag として設定し、 {@link Logger} instance を生成します。
         *
         * @param tag Log 出力時の tag です。
         */
        public static Logger create(String tag) {
            return new LoggerImpl(tag);
        }
    }
}
