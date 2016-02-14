package jp.hideakisago.androidtemplate.models.configurations;

import android.content.Context;

/**
 * Application 全体で共有する global な config class です。
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
