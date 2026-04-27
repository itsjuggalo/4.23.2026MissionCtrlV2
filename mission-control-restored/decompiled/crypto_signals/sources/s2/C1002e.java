package s2;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: s2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1002e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f9546a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9547b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9548c;

    public C1002e(int i) {
        this.f9548c = i;
    }

    public static String a(int i, String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() > i) {
                return str.substring(0, i);
            }
        }
        return str;
    }

    public final synchronized boolean b(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String strA = a(this.f9548c, str);
        if (this.f9546a.size() >= this.f9547b && !this.f9546a.containsKey(strA)) {
            Log.w("FirebaseCrashlytics", "Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f9547b, null);
            return false;
        }
        String strA2 = a(this.f9548c, str2);
        String str3 = (String) this.f9546a.get(strA);
        if (str3 == null ? strA2 == null : str3.equals(strA2)) {
            return false;
        }
        HashMap map = this.f9546a;
        if (str2 == null) {
            strA2 = "";
        }
        map.put(strA, strA2);
        return true;
    }

    public final synchronized void c(Map map) {
        try {
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                String strA = a(this.f9548c, str);
                if (this.f9546a.size() < this.f9547b || this.f9546a.containsKey(strA)) {
                    String str2 = (String) entry.getValue();
                    this.f9546a.put(strA, str2 == null ? "" : a(this.f9548c, str2));
                } else {
                    i++;
                }
            }
            if (i > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i + " entries when adding custom keys. Maximum allowable: " + this.f9547b, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
