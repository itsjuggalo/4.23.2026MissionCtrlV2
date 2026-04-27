package j3;

import e3.C1478g;
import h3.AbstractC1695i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: j3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2049e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f17385a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17387c;

    public C2049e(int i7, int i8) {
        this.f17386b = i7;
        this.f17387c = i8;
    }

    public static String c(String str, int i7) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i7 ? strTrim.substring(0, i7) : strTrim;
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f17385a));
    }

    public final String b(String str) {
        if (str != null) {
            return c(str, this.f17387c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public synchronized boolean d(String str, String str2) {
        String strB = b(str);
        if (this.f17385a.size() >= this.f17386b && !this.f17385a.containsKey(strB)) {
            C1478g.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f17386b);
            return false;
        }
        String strC = c(str2, this.f17387c);
        if (AbstractC1695i.z((String) this.f17385a.get(strB), strC)) {
            return false;
        }
        Map map = this.f17385a;
        if (str2 == null) {
            strC = "";
        }
        map.put(strB, strC);
        return true;
    }

    public synchronized void e(Map map) {
        try {
            int i7 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String strB = b((String) entry.getKey());
                if (this.f17385a.size() < this.f17386b || this.f17385a.containsKey(strB)) {
                    String str = (String) entry.getValue();
                    this.f17385a.put(strB, str == null ? "" : c(str, this.f17387c));
                } else {
                    i7++;
                }
            }
            if (i7 > 0) {
                C1478g.f().k("Ignored " + i7 + " entries when adding custom keys. Maximum allowable: " + this.f17386b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
