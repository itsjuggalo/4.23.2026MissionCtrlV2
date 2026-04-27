package G3;

import K3.AbstractC0612b;
import K3.I;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2435a;

    public e(List list) {
        this.f2435a = list;
    }

    public static int h(String str, String str2) {
        boolean zO = o(str);
        boolean zO2 = o(str2);
        if (zO && !zO2) {
            return -1;
        }
        if (zO || !zO2) {
            return (zO && zO2) ? Long.compare(k(str), k(str2)) : I.o(str, str2);
        }
        return 1;
    }

    public static long k(String str) {
        return Long.parseLong(str.substring(4, str.length() - 2));
    }

    public static boolean o(String str) {
        return str.startsWith("__id") && str.endsWith("__");
    }

    public e a(e eVar) {
        ArrayList arrayList = new ArrayList(this.f2435a);
        arrayList.addAll(eVar.f2435a);
        return j(arrayList);
    }

    public e b(String str) {
        ArrayList arrayList = new ArrayList(this.f2435a);
        arrayList.add(str);
        return j(arrayList);
    }

    public abstract String c();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    public int hashCode() {
        return ((getClass().hashCode() + 37) * 37) + this.f2435a.hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        int iQ = q();
        int iQ2 = eVar.q();
        for (int i7 = 0; i7 < iQ && i7 < iQ2; i7++) {
            int iH = h(m(i7), eVar.m(i7));
            if (iH != 0) {
                return iH;
            }
        }
        return I.l(iQ, iQ2);
    }

    public abstract e j(List list);

    public String l() {
        return (String) this.f2435a.get(q() - 1);
    }

    public String m(int i7) {
        return (String) this.f2435a.get(i7);
    }

    public boolean n() {
        return q() == 0;
    }

    public boolean p(e eVar) {
        if (q() > eVar.q()) {
            return false;
        }
        for (int i7 = 0; i7 < q(); i7++) {
            if (!m(i7).equals(eVar.m(i7))) {
                return false;
            }
        }
        return true;
    }

    public int q() {
        return this.f2435a.size();
    }

    public e r(int i7) {
        int iQ = q();
        AbstractC0612b.d(iQ >= i7, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(i7), Integer.valueOf(iQ));
        return j(this.f2435a.subList(i7, iQ));
    }

    public e s() {
        return j(this.f2435a.subList(0, q() - 1));
    }

    public String toString() {
        return c();
    }
}
