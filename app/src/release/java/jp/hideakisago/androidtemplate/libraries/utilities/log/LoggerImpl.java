package jp.hideakisago.androidtemplate.libraries.utilities.log;

import android.content.Intent;
import android.util.Log;

/**
 * Log 出力を行う class です。
 * release 時は {@link Log#VERBOSE}, {@link Log#DEBUG} level の log は出力しません。
 */
class LoggerImpl extends AbsLogger {

    /**
     * Log 出力時の tag を指定して生成します。
     *
     * @param tag Log 出力時の tag です。
     */
    public LoggerImpl(String tag) {
        super(tag);
    }

    @Override
    public void trace() {
        // nothing
    }

    @Override
    public void trace(Object... args) {
        // nothing
    }

    @Override
    public void dump(Intent intent) {
        // nothing
    }

    @Override
    public void v(String msg) {
        // nothing
    }

    @Override
    public void m(String msg) {
        // nothing
    }

    @Override
    public void d(String msg) {
        // nothing
    }

    @Override
    public void d(Throwable e) {
        // nothing
    }

    @Override
    public void d(String msg, Throwable e) {
        // nothing
    }
}
