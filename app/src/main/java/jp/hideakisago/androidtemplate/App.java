package jp.hideakisago.androidtemplate;

import android.app.Application;

import jp.hideakisago.androidtemplate.models.configurations.AppConfig;

/**
 * Application 全体から access 可能な global な class です。
 */
public class App extends Application {

    /** App global configuration。 */
    private AppConfig mAppConfig;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppConfig = new AppConfig(this);
    }

    /**
     * @return {@link AppConfig} の instance を返却します。
     */
    public AppConfig getConfig() {
        return mAppConfig;
    }
}
