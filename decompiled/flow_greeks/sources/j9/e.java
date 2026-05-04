package j9;

import java.util.ArrayList;
import java.util.List;
import n9.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14236a;

    public e(List list) {
        this.f14236a = list;
    }

    public static int h(String str, String str2) {
        boolean zQ = q(str);
        boolean zQ2 = q(str2);
        if (zQ && !zQ2) {
            return -1;
        }
        if (zQ || !zQ2) {
            return (zQ && zQ2) ? Long.compare(l(str), l(str2)) : g0.m(str, str2);
        }
        return 1;
    }

    public static long l(String str) {
        return Long.parseLong(str.substring(4, str.length() - 2));
    }

    public static boolean q(String str) {
        return str.startsWith("__id") && str.endsWith("__");
    }

    public e a(e eVar) {
        ArrayList arrayList = new ArrayList(this.f14236a);
        arrayList.addAll(eVar.f14236a);
        return k(arrayList);
    }

    public e b(String str) {
        ArrayList arrayList = new ArrayList(this.f14236a);
        arrayList.add(str);
        return k(arrayList);
    }

    public abstract String c();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    public int hashCode() {
        return ((getClass().hashCode() + 37) * 37) + this.f14236a.hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        int iU = u();
        int iU2 = eVar.u();
        for (int i10 = 0; i10 < iU && i10 < iU2; i10++) {
            int iH = h(o(i10), eVar.o(i10));
            if (iH != 0) {
                return iH;
            }
        }
        return Integer.compare(iU, iU2);
    }

    public boolean isEmpty() {
        return u() == 0;
    }

    public abstract e k(List list);

    public String m() {
        return (String) this.f14236a.get(u() - 1);
    }

    public String o(int i10) {
        return (String) this.f14236a.get(i10);
    }

    public boolean s(e eVar) {
        if (u() > eVar.u()) {
            return false;
        }
        for (int i10 = 0; i10 < u(); i10++) {
            if (!o(i10).equals(eVar.o(i10))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return c();
    }

    public int u() {
        return this.f14236a.size();
    }

    public e v(int i10) {
        int iU = u();
        n9.b.d(iU >= i10, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(i10), Integer.valueOf(iU));
        return k(this.f14236a.subList(i10, iU));
    }

    public e w() {
        return k(this.f14236a.subList(0, u() - 1));
    }
}
