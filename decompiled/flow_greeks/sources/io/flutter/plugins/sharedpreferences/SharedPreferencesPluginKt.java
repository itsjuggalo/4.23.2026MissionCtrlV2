package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u000f\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e\"\u0014\u0010\u0011\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e\"\u0014\u0010\u0012\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e\"%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"", "key", "", "value", "", "allowList", "", "preferencesFilter", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Set;)Z", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "listEncoder", "transformPref", "(Ljava/lang/Object;Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "SHARED_PREFERENCES_NAME", "LIST_PREFIX", "JSON_LIST_PREFIX", "DOUBLE_PREFIX", "Landroid/content/Context;", "Ll1/i;", "Lp1/f;", "sharedPreferencesDataStore$delegate", "Lsd/c;", "getSharedPreferencesDataStore", "(Landroid/content/Context;)Ll1/i;", "sharedPreferencesDataStore", "shared_preferences_android_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SharedPreferencesPluginKt {
    public static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    public static final String JSON_LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!";
    public static final String LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    public static final String TAG = "SharedPreferencesPlugin";
    static final /* synthetic */ wd.m[] $$delegatedProperties = {n0.g(new g0(SharedPreferencesPluginKt.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    private static final sd.c sharedPreferencesDataStore$delegate = o1.a.b(SHARED_PREFERENCES_NAME, null, null, null, 14, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final l1.i getSharedPreferencesDataStore(Context context) {
        return (l1.i) sharedPreferencesDataStore$delegate.a(context, $$delegatedProperties[0]);
    }

    public static final boolean preferencesFilter(String key, Object obj, Set<String> set) {
        kotlin.jvm.internal.t.f(key, "key");
        return set == null ? (obj instanceof Boolean) || (obj instanceof Long) || (obj instanceof String) || (obj instanceof Double) : set.contains(key);
    }

    public static final Object transformPref(Object obj, SharedPreferencesListEncoder listEncoder) {
        kotlin.jvm.internal.t.f(listEncoder, "listEncoder");
        if (!(obj instanceof String)) {
            return obj;
        }
        String str = (String) obj;
        if (!kg.z.J(str, LIST_PREFIX, false, 2, null)) {
            if (!kg.z.J(str, DOUBLE_PREFIX, false, 2, null)) {
                return obj;
            }
            String strSubstring = str.substring(40);
            kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
            return Double.valueOf(Double.parseDouble(strSubstring));
        }
        if (kg.z.J(str, JSON_LIST_PREFIX, false, 2, null)) {
            return obj;
        }
        String strSubstring2 = str.substring(40);
        kotlin.jvm.internal.t.e(strSubstring2, "substring(...)");
        List<String> listDecode = listEncoder.decode(strSubstring2);
        kotlin.jvm.internal.t.c(listDecode);
        return listDecode;
    }
}
