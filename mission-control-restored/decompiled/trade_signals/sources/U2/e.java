package U2;

import S2.AbstractC0903j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8107a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8109c;

    public e(int i8, int i9) {
        this.f8108b = i8;
        this.f8109c = i9;
    }

    public static String c(String str, int i8) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i8 ? strTrim.substring(0, i8) : strTrim;
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f8107a));
    }

    public final String b(String str) {
        if (str != null) {
            return c(str, this.f8109c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public synchronized boolean d(String str, String str2) {
        String strB = b(str);
        if (this.f8107a.size() >= this.f8108b && !this.f8107a.containsKey(strB)) {
            P2.g.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f8108b);
            return false;
        }
        String strC = c(str2, this.f8109c);
        if (AbstractC0903j.z((String) this.f8107a.get(strB), strC)) {
            return false;
        }
        Map map = this.f8107a;
        if (str2 == null) {
            strC = "";
        }
        map.put(strB, strC);
        return true;
    }

    public synchronized void e(Map map) {
        try {
            int i8 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String strB = b((String) entry.getKey());
                if (this.f8107a.size() < this.f8108b || this.f8107a.containsKey(strB)) {
                    String str = (String) entry.getValue();
                    this.f8107a.put(strB, str == null ? "" : c(str, this.f8109c));
                } else {
                    i8++;
                }
            }
            if (i8 > 0) {
                P2.g.f().k("Ignored " + i8 + " entries when adding custom keys. Maximum allowable: " + this.f8108b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
