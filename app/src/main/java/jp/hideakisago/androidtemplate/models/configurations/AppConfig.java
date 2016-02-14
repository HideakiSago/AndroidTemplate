package jp.hideakisago.androidtemplate.models.configurations;

import android.content.Context;

import jp.hideakisago.androidtemplate.App;

/**
 * Application 全体で共有する global な config class です。
 *
 * @see App
 */
public class AppConfig extends AbsConfig {

    /**
     * Context から SharedPreferences の instance を取得して生成する constructor です。
     *
     * @param context SharedPreferences を取得するための context です。
     */
    public AppConfig(Context context) {
        super(context);
    }
}
