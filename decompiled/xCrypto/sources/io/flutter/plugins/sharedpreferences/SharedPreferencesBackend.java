package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import h0.AbstractC1272b;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferencesBackend implements SharedPreferencesAsyncApi {
    private Context context;
    private SharedPreferencesListEncoder listEncoder;
    private BinaryMessenger messenger;

    public SharedPreferencesBackend(BinaryMessenger messenger, Context context, SharedPreferencesListEncoder listEncoder) {
        kotlin.jvm.internal.r.f(messenger, "messenger");
        kotlin.jvm.internal.r.f(context, "context");
        kotlin.jvm.internal.r.f(listEncoder, "listEncoder");
        this.messenger = messenger;
        this.context = context;
        this.listEncoder = listEncoder;
        try {
            SharedPreferencesAsyncApi.Companion.setUp(messenger, this, "shared_preferences");
        } catch (Exception e4) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesBackend", e4);
        }
    }

    private final SharedPreferences createSharedPreferences(SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        if (sharedPreferencesPigeonOptions.getFileName() == null) {
            SharedPreferences sharedPreferencesA = AbstractC1272b.a(this.context);
            kotlin.jvm.internal.r.c(sharedPreferencesA);
            return sharedPreferencesA;
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(sharedPreferencesPigeonOptions.getFileName(), 0);
        kotlin.jvm.internal.r.c(sharedPreferences);
        return sharedPreferences;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> list, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(options, "options");
        SharedPreferences sharedPreferencesCreateSharedPreferences = createSharedPreferences(options);
        SharedPreferences.Editor editorEdit = sharedPreferencesCreateSharedPreferences.edit();
        kotlin.jvm.internal.r.e(editorEdit, "edit(...)");
        Map<String, ?> all = sharedPreferencesCreateSharedPreferences.getAll();
        kotlin.jvm.internal.r.e(all, "getAll(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            if (SharedPreferencesPluginKt.preferencesFilter(str, all.get(str), list != null ? X2.x.l0(list) : null)) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.r.e(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.r.e(next, "next(...)");
            editorEdit.remove((String) next);
        }
        editorEdit.apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> list, SharedPreferencesPigeonOptions options) {
        Object value;
        kotlin.jvm.internal.r.f(options, "options");
        Map<String, ?> all = createSharedPreferences(options).getAll();
        kotlin.jvm.internal.r.e(all, "getAll(...)");
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (SharedPreferencesPluginKt.preferencesFilter(entry.getKey(), entry.getValue(), list != null ? X2.x.l0(list) : null) && (value = entry.getValue()) != null) {
                String key = entry.getKey();
                Object objTransformPref = SharedPreferencesPluginKt.transformPref(value, this.listEncoder);
                kotlin.jvm.internal.r.d(objTransformPref, "null cannot be cast to non-null type kotlin.Any");
                map.put(key, objTransformPref);
            }
        }
        return map;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        SharedPreferences sharedPreferencesCreateSharedPreferences = createSharedPreferences(options);
        if (sharedPreferencesCreateSharedPreferences.contains(key)) {
            return Boolean.valueOf(sharedPreferencesCreateSharedPreferences.getBoolean(key, true));
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        SharedPreferences sharedPreferencesCreateSharedPreferences = createSharedPreferences(options);
        if (!sharedPreferencesCreateSharedPreferences.contains(key)) {
            return null;
        }
        Object objTransformPref = SharedPreferencesPluginKt.transformPref(sharedPreferencesCreateSharedPreferences.getString(key, ""), this.listEncoder);
        kotlin.jvm.internal.r.d(objTransformPref, "null cannot be cast to non-null type kotlin.Double");
        return (Double) objTransformPref;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        long j4;
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        SharedPreferences sharedPreferencesCreateSharedPreferences = createSharedPreferences(options);
        if (!sharedPreferencesCreateSharedPreferences.contains(key)) {
            return null;
        }
        try {
            j4 = sharedPreferencesCreateSharedPreferences.getLong(key, 0L);
        } catch (ClassCastException unused) {
            j4 = sharedPreferencesCreateSharedPreferences.getInt(key, 0);
        }
        return Long.valueOf(j4);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getKeys(List<String> list, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(options, "options");
        Map<String, ?> all = createSharedPreferences(options).getAll();
        kotlin.jvm.internal.r.e(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            kotlin.jvm.internal.r.e(key, "<get-key>(...)");
            if (SharedPreferencesPluginKt.preferencesFilter(key, entry.getValue(), list != null ? X2.x.l0(list) : null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return X2.x.g0(linkedHashMap.keySet());
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        SharedPreferences sharedPreferencesCreateSharedPreferences = createSharedPreferences(options);
        if (sharedPreferencesCreateSharedPreferences.contains(key)) {
            String string = sharedPreferencesCreateSharedPreferences.getString(key, "");
            kotlin.jvm.internal.r.c(string);
            if (r3.x.C(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) && !r3.x.C(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null) && (list = (List) SharedPreferencesPluginKt.transformPref(sharedPreferencesCreateSharedPreferences.getString(key, ""), this.listEncoder)) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof String) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public String getString(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        SharedPreferences sharedPreferencesCreateSharedPreferences = createSharedPreferences(options);
        if (sharedPreferencesCreateSharedPreferences.contains(key)) {
            return sharedPreferencesCreateSharedPreferences.getString(key, "");
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        SharedPreferences sharedPreferencesCreateSharedPreferences = createSharedPreferences(options);
        if (!sharedPreferencesCreateSharedPreferences.contains(key)) {
            return null;
        }
        String string = sharedPreferencesCreateSharedPreferences.getString(key, "");
        kotlin.jvm.internal.r.c(string);
        return r3.x.C(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, null) ? new StringListResult(string, StringListLookupResultType.JSON_ENCODED) : r3.x.C(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, null) ? new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED) : new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean z4, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        createSharedPreferences(options).edit().putBoolean(key, z4).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(options, "options");
        createSharedPreferences(options).edit().putString(key, SharedPreferencesPluginKt.LIST_PREFIX + this.listEncoder.encode(value)).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double d4, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        createSharedPreferences(options).edit().putString(key, SharedPreferencesPluginKt.DOUBLE_PREFIX + d4).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(options, "options");
        createSharedPreferences(options).edit().putString(key, value).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long j4, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(options, "options");
        createSharedPreferences(options).edit().putLong(key, j4).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(options, "options");
        createSharedPreferences(options).edit().putString(key, value).apply();
    }

    public final void tearDown() {
        SharedPreferencesAsyncApi.Companion.setUp(this.messenger, null, "shared_preferences");
    }

    public /* synthetic */ SharedPreferencesBackend(BinaryMessenger binaryMessenger, Context context, SharedPreferencesListEncoder sharedPreferencesListEncoder, int i4, AbstractC1585j abstractC1585j) {
        this(binaryMessenger, context, (i4 & 4) != 0 ? new ListEncoder() : sharedPreferencesListEncoder);
    }
}
