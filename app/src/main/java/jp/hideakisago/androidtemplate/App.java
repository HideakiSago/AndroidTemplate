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

        AppConfig.create(this, new PrivateBridge<AppConfig>() {
            @Override
            public void pass(AppConfig data) {
                mAppConfig = data;
            }
        });
    }

    /**
     * @return {@link AppConfig} の instance を返します。
     */
    public AppConfig getConfig() {
        return mAppConfig;
    }


    /**
     * 任意の data を private に橋渡しするための class です。
     *
     * @param <Data> 橋渡しする任意の data の型です。
     */
    public abstract class PrivateBridge<Data> {

        /**
         * App class でしか生成できないようにするための private constructor です。
         */
        private PrivateBridge() {
        }

        /**
         * 任意の data を 渡します。
         *
         * @param data 橋渡しする任意の data です。
         */
        public abstract void pass(Data data);
    }
}
