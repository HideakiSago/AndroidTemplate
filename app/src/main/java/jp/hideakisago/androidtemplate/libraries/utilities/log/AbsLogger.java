package jp.hideakisago.androidtemplate.libraries.utilities.log;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

import jp.hideakisago.androidtemplate.libraries.utilities.StackTraceUtils;

/**
 * Log 出力を行う class です。
 */
abstract class AbsLogger implements Logger {

    /** Tag。 */
    private final String mTag;

    /**
     * Log 出力時の tag を指定して生成します。
     *
     * @param tag Log 出力時の tag です。
     */
    public AbsLogger(String tag) {
        mTag = tag;
    }

    @Override
    public void trace() {
        v(getTraceMessage(StackTraceUtils.getStackTraceElement(-1)));
    }

    @Override
    public void trace(Object... args) {
        v(getTraceMessage(StackTraceUtils.getStackTraceElement(-1))
                + " args:" + Arrays.toString(args));
    }

    /**
     * {@link #trace()} で出力する message を取得します。
     *
     * @param element Trace log として出力したい method の stack element です。
     * @return 以下の format の文字列を返却します。<br>
     * &lt;Simple class name>.&lt;Method name>(&lt;File name>:&lt;Line number>)
     * 例: <pre><code>SampleFragment.onCreate(SampleFragment:120)</code></pre>
     */
    private static String getTraceMessage(StackTraceElement element) {
        return getSimpleName(element.getClassName()) + "." + element.getMethodName()
                + "(" + element.getFileName() + ":" + element.getLineNumber() + ")";
    }

    /**
     * クラスの正式名称（jp...SampleClass）から単純なクラス名（SimpleClass）を取得します。
     *
     * @param className 単純なクラス名を取得する、クラスの正式名称を指定します。
     * @return パッケージ名を除いた、単純なクラス名を返却します。
     */
    private static String getSimpleName(String className) {
        final int lastIndexOfDot = className.lastIndexOf(".");
        if (lastIndexOfDot < 0) {
            return className;
        }
        return className.substring(lastIndexOfDot + 1);
    }

    @Override
    public void dump(Intent intent) {
        Bundle extras = intent.getExtras();
        v("intent: " + intent + ", extras: " + extras);
    }

    @Override
    public void v(String msg) {
        Log.v(mTag, msg);
    }

    @Override
    public void m(String msg) {
        final String methodName = StackTraceUtils.getStackTraceElement(-1).getMethodName();
        Log.d(mTag, methodName + " - " + msg);
    }

    @Override
    public void d(String msg) {
        Log.d(mTag, msg);
    }

    @Override
    public void d(Throwable e) {
        Log.d(mTag, e.getMessage(), e);
    }

    @Override
    public void d(String msg, Throwable e) {
        Log.d(mTag, msg, e);
    }

    @Override
    public void i(String msg) {
        Log.i(mTag, msg);
    }

    @Override
    public void i(Throwable e) {
        Log.i(mTag, e.getMessage(), e);
    }

    @Override
    public void i(String msg, Throwable e) {
        Log.i(mTag, msg, e);
    }

    @Override
    public void w(String msg) {
        Log.w(mTag, msg);
    }

    @Override
    public void w(Throwable e) {
        Log.w(mTag, e.getMessage(), e);
    }

    @Override
    public void w(String msg, Throwable e) {
        Log.w(mTag, msg, e);
    }

    @Override
    public void e(String msg) {
        Log.e(mTag, msg);
    }

    @Override
    public void e(Throwable e) {
        Log.e(mTag, e.getMessage(), e);
    }

    @Override
    public void e(String msg, Throwable e) {
        Log.e(mTag, msg, e);
    }
}
