package h3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p3.C2548b;

/* JADX INFO: renamed from: h3.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1859C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18395a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18396b;

    public C1859C(C1875k c1875k) {
        this.f18396b = 0;
        Iterator it = c1875k.iterator();
        while (it.hasNext()) {
            this.f18395a.add(((C2548b) it.next()).b());
        }
        this.f18396b = Math.max(1, this.f18395a.size());
        for (int i8 = 0; i8 < this.f18395a.size(); i8++) {
            this.f18396b += f((CharSequence) this.f18395a.get(i8));
        }
        a();
    }

    public static String b(String str, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < list.size(); i8++) {
            if (i8 > 0) {
                sb.append(str);
            }
            sb.append((String) list.get(i8));
        }
        return sb.toString();
    }

    public static int f(CharSequence charSequence) {
        int length = charSequence.length();
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            char cCharAt = charSequence.charAt(i8);
            if (cCharAt <= 127) {
                i9++;
            } else if (cCharAt <= 2047) {
                i9 += 2;
            } else if (Character.isHighSurrogate(cCharAt)) {
                i9 += 4;
                i8++;
            } else {
                i9 += 3;
            }
            i8++;
        }
        return i9;
    }

    public static void g(C1875k c1875k, Object obj) {
        new C1859C(c1875k).h(obj);
    }

    public final void a() {
        if (this.f18396b > 768) {
            throw new c3.d("Data has a key path longer than 768 bytes (" + this.f18396b + ").");
        }
        if (this.f18395a.size() <= 32) {
            return;
        }
        throw new c3.d("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle " + e());
    }

    public final String c() {
        String str = (String) this.f18395a.remove(r0.size() - 1);
        this.f18396b -= f(str);
        if (this.f18395a.size() > 0) {
            this.f18396b--;
        }
        return str;
    }

    public final void d(String str) {
        if (this.f18395a.size() > 0) {
            this.f18396b++;
        }
        this.f18395a.add(str);
        this.f18396b += f(str);
        a();
    }

    public final String e() {
        if (this.f18395a.size() == 0) {
            return "";
        }
        return "in path '" + b("/", this.f18395a) + "'";
    }

    public final void h(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    d(str);
                    h(map.get(str));
                    c();
                }
            }
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i8 = 0; i8 < list.size(); i8++) {
                d(Integer.toString(i8));
                h(list.get(i8));
                c();
            }
        }
    }
}
