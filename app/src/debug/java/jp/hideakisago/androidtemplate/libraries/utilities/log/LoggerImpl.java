package jp.hideakisago.androidtemplate.libraries.utilities.log;

/**
 * Log 出力を行う class です。
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
}
