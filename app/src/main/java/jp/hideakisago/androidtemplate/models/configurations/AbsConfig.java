package jp.hideakisago.androidtemplate.models.configurations;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * 設定を SharedPreferences に保存するための抽象 wrapper class です。
 * <p>
 * usage:
 * <pre><code>
 * private static final BooleanEntry CONFIG1 = new BooleanEntry("config1", true);
 *
 * public void setConfig1(boolean config1) {
 *     set(CONFIG1, config1);
 * }
 *
 * public boolean getConfig1() {
 *     return get(CONFIG1);
 * }
 * </code></pre>
 */
public abstract class AbsConfig {

    /** Shared preferences。 */
    protected final SharedPreferences mPrefs;

    /**
     * Context から SharedPreferences の instance を取得して生成する constructor です。
     *
     * @param context SharedPreferences を取得するための context です。
     */
    public AbsConfig(Context context) {
        mPrefs = context.getSharedPreferences(
                context.getPackageName() + ":" + getClass().getName(),
                Context.MODE_PRIVATE);
    }

    /**
     * 保存している boolean の値を取得します。
     *
     * @param entry 取得する値の {@link BooleanEntry entry} です。
     * @return 保存している boolean の値を返却します。 値が設定されていない場合は entry に設定されている default value が返却されます。
     * @see SharedPreferences#getBoolean(String, boolean)
     */
    protected boolean get(BooleanEntry entry) {
        return mPrefs.getBoolean(entry.key, entry.defaultValue);
    }

    /**
     * 保存している int の値を取得します。
     *
     * @param entry 取得する値の {@link IntEntry entry} です。
     * @return 保存している int の値を返却します。 値が設定されていない場合は entry に設定されている default value が返却されます。
     * @see SharedPreferences#getInt(String, int)
     */
    protected int get(IntEntry entry) {
        return mPrefs.getInt(entry.key, entry.defaultValue);
    }

    /**
     * 保存している long の値を取得します。
     *
     * @param entry 取得する値の long の値を返却します。 値が設定されていない場合は entry に設定されている default value が返却されます。
     * @see SharedPreferences#getLong(String, long)
     */
    protected long get(LongEntry entry) {
        return mPrefs.getLong(entry.key, entry.defaultValue);
    }

    /**
     * 保存している float の値を取得します。
     *
     * @param entry 取得する値の {@link FloatEntry entry} です。
     * @return 保存している float の値を返却します。 値が設定されていない場合は entry に設定されている default value が返却されます。
     * @see SharedPreferences#getFloat(String, float)
     */
    protected float get(FloatEntry entry) {
        return mPrefs.getFloat(entry.key, entry.defaultValue);
    }

    /**
     * 保存している string の値を取得します。
     *
     * @param entry 取得する値の {@link StringEntry entry} です。
     * @return 保存している string の値を返却します。 値が設定されていない場合は entry に設定されている default value が返却されます。
     * @see SharedPreferences#getString(String, String)
     */
    protected String get(StringEntry entry) {
        return mPrefs.getString(entry.key, entry.defaultValue);
    }

    /**
     * 保存している string set の値を取得します。
     *
     * @param entry 取得する値の {@link StringSetEntry entry} です。
     * @return 保存している string set の値を返却します。 値が設定されていない場合は entry に設定されている default value が返却されます。
     * @see SharedPreferences#getStringSet(String, Set)
     */
    protected Set<String> get(StringSetEntry entry) {
        return mPrefs.getStringSet(entry.key, entry.defaultValue);
    }

    /**
     * Boolean の値を保存します。
     *
     * @param entry 保存する値の {@link BooleanEntry entry} です。
     * @param value 保存する値です。
     * @see #edit()
     * @see SharedPreferences.Editor#putBoolean(String, boolean)
     */
    protected void set(BooleanEntry entry, boolean value) {
        mPrefs.edit()
                .putBoolean(entry.key, value)
                .apply();
    }

    /**
     * Int の値を保存します。
     *
     * @param entry 保存する値の {@link IntEntry entry} です。
     * @param value 保存する値です。
     * @see #edit()
     * @see SharedPreferences.Editor#putInt(String, int)
     */
    protected void set(IntEntry entry, int value) {
        mPrefs.edit()
                .putInt(entry.key, value)
                .apply();
    }

    /**
     * Long の値を保存します。
     *
     * @param entry 保存する値の {@link LongEntry entry} です。
     * @param value 保存する値です。
     * @see #edit()
     * @see SharedPreferences.Editor#putLong(String, long)
     */
    protected void set(LongEntry entry, long value) {
        mPrefs.edit()
                .putLong(entry.key, value)
                .apply();
    }

    /**
     * Float の値を保存します。
     *
     * @param entry 保存する値の {@link FloatEntry entry} です。
     * @param value 保存する値です。
     * @see #edit()
     * @see SharedPreferences.Editor#putFloat(String, float)
     */
    protected void set(FloatEntry entry, float value) {
        mPrefs.edit()
                .putFloat(entry.key, value)
                .apply();
    }

    /**
     * String の値を保存します。
     *
     * @param entry 保存する値の {@link StringEntry entry} です。
     * @param value 保存する値です。
     * @see #edit()
     * @see SharedPreferences.Editor#putString(String, String)
     */
    protected void set(StringEntry entry, String value) {
        mPrefs.edit()
                .putString(entry.key, value)
                .apply();
    }

    /**
     * String set の値を保存します。
     *
     * @param entry 保存する値の {@link StringSetEntry entry} です。
     * @param value 保存する値です。
     * @see #edit()
     * @see SharedPreferences.Editor#putStringSet(String, Set)
     */
    protected void set(StringSetEntry entry, Set<String> value) {
        mPrefs.edit()
                .putStringSet(entry.key, value)
                .apply();
    }

    /**
     * 指定した configuration entry を消去します。
     *
     * @see SharedPreferences.Editor#remove(String)
     */
    protected void remove(AbsEntry entry) {
        mPrefs.edit()
                .remove(entry.key)
                .apply();
    }


    /**
     * 全ての configuration entry を消去します。
     *
     * @see SharedPreferences.Editor#clear()
     */
    protected void clear() {
        mPrefs.edit()
                .clear()
                .apply();
    }

    /**
     * 複数の configuration entry の編集を開始します。
     * 複数の entry を保存する場合、 set method ではなく、この method を利用して一括保存してください。
     * <p>
     * usage:
     * <pre><code>
     * edit()
     *     .put(CONFIG1, true)
     *     .put(CONFIG2, 100)
     *     .apply();
     * </code></pre>
     *
     * @return 編集するための {@link Editor} を返却します。
     * @see SharedPreferences#edit()
     */
    protected Editor edit() {
        return new Editor();
    }

    /**
     * 複数の configuration entry を一括で編集するための class です。
     *
     * @see #edit()
     */
    protected class Editor {
        /** SharedPreferences editor。 */
        private final SharedPreferences.Editor mEditor = mPrefs.edit();

        /**
         * boolean の値を保存するように設定します。
         * 保存したい全ての値を設定したら {@link #apply()} で保存します。
         *
         * @param entry 保存するように設定する値の entry 情報です。
         * @param value 保存するように設定する値です。
         * @return Method chain で呼び出せるようにするため this を返却します。
         */
        public Editor put(BooleanEntry entry, boolean value) {
            mEditor.putBoolean(entry.key, value);
            return this;
        }

        /**
         * int の値を保存するように設定します。
         * 保存したい全ての値を設定したら {@link #apply()} で保存します。
         *
         * @param entry 保存するように設定する値の entry 情報です。
         * @param value 保存するように設定する値です。
         * @return Method chain で呼び出せるようにするため this を返却します。
         */
        public Editor put(IntEntry entry, int value) {
            mEditor.putInt(entry.key, value);
            return this;
        }

        /**
         * long の値を保存するように設定します。
         * 保存したい全ての値を設定したら {@link #apply()} で保存します。
         *
         * @param entry 保存するように設定する値の entry 情報です。
         * @param value 保存するように設定する値です。
         * @return Method chain で呼び出せるようにするため this を返却します。
         */
        public Editor put(LongEntry entry, long value) {
            mEditor.putLong(entry.key, value);
            return this;
        }

        /**
         * Float の値を保存するように設定します。
         * 保存したい全ての値を設定したら {@link #apply()} で保存します。
         *
         * @param entry 保存するように設定する値の entry 情報です。
         * @param value 保存するように設定する値です。
         * @return Method chain で呼び出せるようにするため this を返却します。
         */
        public Editor put(FloatEntry entry, float value) {
            mEditor.putFloat(entry.key, value);
            return this;
        }

        /**
         * String の値を保存するように設定します。
         * 保存したい全ての値を設定したら {@link #apply()} で保存します。
         *
         * @param entry 保存するように設定する値の entry 情報です。
         * @param value 保存するように設定する値です。
         * @return Method chain で呼び出せるようにするため this を返却します。
         */
        public Editor put(StringEntry entry, String value) {
            mEditor.putString(entry.key, value);
            return this;
        }

        /**
         * String set の値を保存するように設定します。
         * 保存したい全ての値を設定したら {@link #apply()} で保存します。
         *
         * @param entry 保存するように設定する値の entry 情報です。
         * @param value 保存するように設定する値です。
         * @return Method chain で呼び出せるようにするため this を返却します。
         */
        public Editor put(StringSetEntry entry, Set<String> value) {
            mEditor.putStringSet(entry.key, value);
            return this;
        }

        /**
         * 指定した entry の値を削除するように設定します。
         * 保存したい全ての値を設定したら {@link #apply()} で保存します。
         *
         * @param entry 削除するように設定する値の entry 情報です。
         * @return Method chain で呼び出せるようにするため this を返却します。
         */
        public Editor remove(AbsEntry entry) {
            mEditor.remove(entry.key);
            return this;
        }

        /**
         * put や remove で設定した値を {@link SharedPreferences} に反映します。
         *
         * @see SharedPreferences.Editor#apply()
         */
        public void apply() {
            mEditor.apply();
        }
    }

    /**
     * Configuration の1要素を表す抽象 class です。
     *
     * SharedPreferences の key 情報を、派生 class で default 値を持ち、1項目に必要な情報を保持します。
     */
    private static abstract class AbsEntry {
        /** Preference key。 */
        public final String key;

        /**
         * SharedPreferences の key を指定して entry を作成します。
         *
         * @param key Preference を取得、保存するためにつける名前です。
         */
        public AbsEntry(String key) {
            this.key = key;
        }
    }

    /**
     * boolean 型の default 値を持つ configuration entry です。
     */
    protected static class BooleanEntry extends AbsEntry {
        /** Default 値。 */
        public final boolean defaultValue;

        /**
         * SharedPreferences の key と default 値を指定して entry を作成します。
         *
         * @param key Preference を取得、保存するためにつける名前です。
         * @param defaultValue 値が保存されていない場合に利用する default 値です。
         */
        public BooleanEntry(String key, boolean defaultValue) {
            super(key);
            this.defaultValue = defaultValue;
        }
    }

    /**
     * int 型の default 値を持つ configuration entry です。
     */
    protected static class IntEntry extends AbsEntry {
        /** Default 値。 */
        public final int defaultValue;

        /**
         * SharedPreferences の key と default 値を指定して entry を作成します。
         *
         * @param key Preference を取得、保存するためにつける名前です。
         * @param defaultValue 値が保存されていない場合に利用する default 値です。
         */
        public IntEntry(String key, int defaultValue) {
            super(key);
            this.defaultValue = defaultValue;
        }
    }

    /**
     * long 型の default 値を持つ configuration entry です。
     */
    protected static class LongEntry extends AbsEntry {
        /** Default 値。 */
        public final long defaultValue;

        /**
         * SharedPreferences の key と default 値を指定して entry を作成します。
         *
         * @param key Preference を取得、保存するためにつける名前です。
         * @param defaultValue 値が保存されていない場合に利用する default 値です。
         */
        public LongEntry(String key, long defaultValue) {
            super(key);
            this.defaultValue = defaultValue;
        }
    }

    /**
     * float 型の default 値を持つ configuration entry です。
     */
    protected static class FloatEntry extends AbsEntry {
        /** Default 値。 */
        public final float defaultValue;

        /**
         * SharedPreferences の key と default 値を指定して entry を作成します。
         *
         * @param key Preference を取得、保存するためにつける名前です。
         * @param defaultValue 値が保存されていない場合に利用する default 値です。
         */
        public FloatEntry(String key, float defaultValue) {
            super(key);
            this.defaultValue = defaultValue;
        }
    }

    /**
     * String 型の default 値を持つ configuration entry です。
     */
    protected static class StringEntry extends AbsEntry {
        /** Default 値。 */
        public final String defaultValue;

        /**
         * SharedPreferences の key と default 値を指定して entry を作成します。
         *
         * @param key Preference を取得、保存するためにつける名前です。
         * @param defaultValue 値が保存されていない場合に利用する default 値です。
         */
        public StringEntry(String key, String defaultValue) {
            super(key);
            this.defaultValue = defaultValue;
        }
    }

    /**
     * String set 型の default 値を持つ configuration entry です。
     */
    protected static class StringSetEntry extends AbsEntry {
        /** Default 値。 */
        public final Set<String> defaultValue;

        /**
         * SharedPreferences の key と default 値を指定して entry を作成します。
         *
         * @param key Preference を取得、保存するためにつける名前です。
         * @param defaultValue 値が保存されていない場合に利用する default 値です。
         */
        public StringSetEntry(String key, Set<String> defaultValue) {
            super(key);
            this.defaultValue = defaultValue;
        }
    }
}
