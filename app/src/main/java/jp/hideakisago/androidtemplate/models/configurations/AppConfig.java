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
     * Context から SharedPreferences の instance を取得して AppConfig を生成し、
     * 生成した instance を bridge で渡します。
     *
     * @param context SharedPreferences を取得するための context です。
     * @param bridge 生成した instance を橋渡しします。
     */
    public static void create(Context context, App.PrivateBridge<AppConfig> bridge) {
        bridge.pass(new AppConfig(context));
    }

    /**
     * Context から SharedPreferences の instance を取得して生成する constructor です。
     *
     * @param context SharedPreferences を取得するための context です。
     */
    private AppConfig(Context context) {
        super(context);
    }
}
