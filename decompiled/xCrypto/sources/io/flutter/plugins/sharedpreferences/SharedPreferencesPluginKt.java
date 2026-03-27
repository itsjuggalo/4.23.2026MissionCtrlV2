package io.flutter.plugins.sharedpreferences;

import S.InterfaceC0523i;
import android.content.Context;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.G;
import l3.InterfaceC1591a;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferencesPluginKt {
    public static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    public static final String JSON_LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!";
    public static final String LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    public static final String TAG = "SharedPreferencesPlugin";
    static final /* synthetic */ p3.h[] $$delegatedProperties = {G.f(new B(SharedPreferencesPluginKt.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    private static final InterfaceC1591a sharedPreferencesDataStore$delegate = U.a.b(SHARED_PREFERENCES_NAME, null, null, null, 14, null);

    public static final InterfaceC0523i getSharedPreferencesDataStore(Context context) {
        kotlin.jvm.internal.r.f(context, "<this>");
        return (InterfaceC0523i) sharedPreferencesDataStore$delegate.a(context, $$delegatedProperties[0]);
    }

    public static final boolean preferencesFilter(String key, Object obj, Set<String> set) {
        kotlin.jvm.internal.r.f(key, "key");
        return set == null ? (obj instanceof Boolean) || (obj instanceof Long) || (obj instanceof String) || (obj instanceof Double) : set.contains(key);
    }

    public static final Object transformPref(Object obj, SharedPreferencesListEncoder listEncoder) {
        kotlin.jvm.internal.r.f(listEncoder, "listEncoder");
        if (!(obj instanceof String)) {
            return obj;
        }
        String str = (String) obj;
        if (!r3.x.C(str, LIST_PREFIX, false, 2, null)) {
            if (!r3.x.C(str, DOUBLE_PREFIX, false, 2, null)) {
                return obj;
            }
            String strSubstring = str.substring(40);
            kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
            return Double.valueOf(Double.parseDouble(strSubstring));
        }
        if (r3.x.C(str, JSON_LIST_PREFIX, false, 2, null)) {
            return obj;
        }
        String strSubstring2 = str.substring(40);
        kotlin.jvm.internal.r.e(strSubstring2, "substring(...)");
        List<String> listDecode = listEncoder.decode(strSubstring2);
        kotlin.jvm.internal.r.c(listDecode);
        return listDecode;
    }
}
