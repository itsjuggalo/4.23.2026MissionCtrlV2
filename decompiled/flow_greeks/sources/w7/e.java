package w7;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23693a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23695c;

    public e(int i10, int i11) {
        this.f23694b = i10;
        this.f23695c = i11;
    }

    public static String c(String str, int i10) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i10 ? strTrim.substring(0, i10) : strTrim;
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f23693a));
    }

    public final String b(String str) {
        if (str != null) {
            return c(str, this.f23695c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public synchronized boolean d(String str, String str2) {
        String strB = b(str);
        if (this.f23693a.size() >= this.f23694b && !this.f23693a.containsKey(strB)) {
            r7.g.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f23694b);
            return false;
        }
        String strC = c(str2, this.f23695c);
        if (u7.i.z((String) this.f23693a.get(strB), strC)) {
            return false;
        }
        Map map = this.f23693a;
        if (str2 == null) {
            strC = "";
        }
        map.put(strB, strC);
        return true;
    }

    public synchronized void e(Map map) {
        try {
            int i10 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String strB = b((String) entry.getKey());
                if (this.f23693a.size() < this.f23694b || this.f23693a.containsKey(strB)) {
                    String str = (String) entry.getValue();
                    this.f23693a.put(strB, str == null ? "" : c(str, this.f23695c));
                } else {
                    i10++;
                }
            }
            if (i10 > 0) {
                r7.g.f().k("Ignored " + i10 + " entries when adding custom keys. Maximum allowable: " + this.f23694b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
