package j8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13967a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13968b;

    public d0(l lVar) {
        this.f13968b = 0;
        Iterator it = lVar.iterator();
        while (it.hasNext()) {
            this.f13967a.add(((r8.b) it.next()).b());
        }
        this.f13968b = Math.max(1, this.f13967a.size());
        for (int i10 = 0; i10 < this.f13967a.size(); i10++) {
            this.f13968b += f((CharSequence) this.f13967a.get(i10));
        }
        a();
    }

    public static String b(String str, List list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 > 0) {
                sb2.append(str);
            }
            sb2.append((String) list.get(i10));
        }
        return sb2.toString();
    }

    public static int f(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt <= 127) {
                i11++;
            } else if (cCharAt <= 2047) {
                i11 += 2;
            } else if (Character.isHighSurrogate(cCharAt)) {
                i11 += 4;
                i10++;
            } else {
                i11 += 3;
            }
            i10++;
        }
        return i11;
    }

    public static void g(l lVar, Object obj) {
        new d0(lVar).h(obj);
    }

    public final void a() {
        if (this.f13968b > 768) {
            throw new e8.d("Data has a key path longer than 768 bytes (" + this.f13968b + ").");
        }
        if (this.f13967a.size() <= 32) {
            return;
        }
        throw new e8.d("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle " + e());
    }

    public final String c() {
        String str = (String) this.f13967a.remove(r0.size() - 1);
        this.f13968b -= f(str);
        if (this.f13967a.size() > 0) {
            this.f13968b--;
        }
        return str;
    }

    public final void d(String str) {
        if (this.f13967a.size() > 0) {
            this.f13968b++;
        }
        this.f13967a.add(str);
        this.f13968b += f(str);
        a();
    }

    public final String e() {
        if (this.f13967a.size() == 0) {
            return "";
        }
        return "in path '" + b("/", this.f13967a) + "'";
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
            for (int i10 = 0; i10 < list.size(); i10++) {
                d(Integer.toString(i10));
                h(list.get(i10));
                c();
            }
        }
    }
}
