package N2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Q2.m f1946d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0155d f1948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0155d f1949h;

    public K(Q2.m mVar, String str, List list, List list2, long j4, C0155d c0155d, C0155d c0155d2) {
        this.f1946d = mVar;
        this.e = str;
        this.f1944b = list2;
        this.f1945c = list;
        this.f1947f = j4;
        this.f1948g = c0155d;
        this.f1949h = c0155d2;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x000e A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair a(Q2.d r11, N2.C0155d r12) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.K.a(Q2.d, N2.d):android.util.Pair");
    }

    public final String b() {
        String str = this.f1943a;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1946d.c());
        String str2 = this.e;
        if (str2 != null) {
            sb.append("|cg:");
            sb.append(str2);
        }
        sb.append("|f:");
        Iterator it = this.f1945c.iterator();
        while (it.hasNext()) {
            sb.append(((AbstractC0163l) it.next()).a());
        }
        sb.append("|ob:");
        for (C c6 : this.f1944b) {
            sb.append(c6.f1908b.c());
            sb.append(S.i.b(c6.f1907a, 1) ? "asc" : "desc");
        }
        long j4 = this.f1947f;
        if (j4 != -1) {
            sb.append("|l:");
            sb.append(j4);
        }
        C0155d c0155d = this.f1948g;
        if (c0155d != null) {
            sb.append("|lb:");
            sb.append(c0155d.f1990a ? "b:" : "a:");
            sb.append(c0155d.b());
        }
        C0155d c0155d2 = this.f1949h;
        if (c0155d2 != null) {
            sb.append("|ub:");
            sb.append(c0155d2.f1990a ? "a:" : "b:");
            sb.append(c0155d2.b());
        }
        String string = sb.toString();
        this.f1943a = string;
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x000e A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair c(Q2.d r11, N2.C0155d r12) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.K.c(Q2.d, N2.d):android.util.Pair");
    }

    public final ArrayList d(Q2.j jVar) {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0163l abstractC0163l : this.f1945c) {
            if (abstractC0163l instanceof C0162k) {
                C0162k c0162k = (C0162k) abstractC0163l;
                if (c0162k.f2020c.equals(jVar)) {
                    arrayList.add(c0162k);
                }
            }
        }
        return arrayList;
    }

    public final boolean e() {
        return Q2.h.e(this.f1946d) && this.e == null && this.f1945c.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && K.class == obj.getClass()) {
            K k6 = (K) obj;
            String str = k6.e;
            String str2 = this.e;
            if (str2 == null ? str != null : !str2.equals(str)) {
                return false;
            }
            if (this.f1947f != k6.f1947f || !this.f1944b.equals(k6.f1944b) || !this.f1945c.equals(k6.f1945c) || !this.f1946d.equals(k6.f1946d)) {
                return false;
            }
            C0155d c0155d = k6.f1948g;
            C0155d c0155d2 = this.f1948g;
            if (c0155d2 == null ? c0155d != null : !c0155d2.equals(c0155d)) {
                return false;
            }
            C0155d c0155d3 = k6.f1949h;
            C0155d c0155d4 = this.f1949h;
            if (c0155d4 != null) {
                return c0155d4.equals(c0155d3);
            }
            if (c0155d3 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f1944b.hashCode() * 31;
        String str = this.e;
        int iHashCode2 = (this.f1946d.hashCode() + ((this.f1945c.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31;
        long j4 = this.f1947f;
        int i = (iHashCode2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        C0155d c0155d = this.f1948g;
        int iHashCode3 = (i + (c0155d != null ? c0155d.hashCode() : 0)) * 31;
        C0155d c0155d2 = this.f1949h;
        return iHashCode3 + (c0155d2 != null ? c0155d2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Query(");
        sb.append(this.f1946d.c());
        String str = this.e;
        if (str != null) {
            sb.append(" collectionGroup=");
            sb.append(str);
        }
        List list = this.f1945c;
        if (!list.isEmpty()) {
            sb.append(" where ");
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(" and ");
                }
                sb.append(list.get(i));
            }
        }
        List list2 = this.f1944b;
        if (!list2.isEmpty()) {
            sb.append(" order by ");
            for (int i6 = 0; i6 < list2.size(); i6++) {
                if (i6 > 0) {
                    sb.append(", ");
                }
                sb.append(list2.get(i6));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
