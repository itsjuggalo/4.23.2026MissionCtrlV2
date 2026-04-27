package N2;

import N1.C0094g0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f1969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1970b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Q2.i f1972d;
    public A2.e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public A2.e f1973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public A2.e f1974g;

    public Q(E e, A2.e eVar) {
        this.f1969a = e;
        this.f1972d = new Q2.i(Q2.g.f2671a, new A2.e(Collections.EMPTY_LIST, new P(e.a(), 1)));
        this.e = eVar;
        A2.e eVar2 = Q2.h.f2673c;
        this.f1973f = eVar2;
        this.f1974g = eVar2;
    }

    public static int b(C0158g c0158g) {
        int iOrdinal = c0158g.f1999a.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return 2;
                }
                throw new IllegalArgumentException("Unknown change type: " + c0158g.f1999a);
            }
        }
        return i;
    }

    public final A.c a(C0094g0 c0094g0, T2.B b3, boolean z6) {
        List list;
        Q2.k kVar;
        S s6;
        D1.b.w("Cannot apply changes that need a refill", !c0094g0.f1613d, new Object[0]);
        Q2.i iVar = this.f1972d;
        this.f1972d = (Q2.i) c0094g0.f1611b;
        this.f1974g = (A2.e) c0094g0.e;
        Q3.h hVar = (Q3.h) c0094g0.f1612c;
        hVar.getClass();
        ArrayList arrayList = new ArrayList(((TreeMap) hVar.f2742b).values());
        Collections.sort(arrayList, new P(this, 0));
        if (b3 != null) {
            Iterator it = b3.f2899c.iterator();
            while (true) {
                A2.d dVar = (A2.d) it;
                if (!((Iterator) dVar.f50b).hasNext()) {
                    break;
                }
                this.e = this.e.a((Q2.h) dVar.next());
            }
            Iterator it2 = b3.f2900d.iterator();
            while (true) {
                A2.d dVar2 = (A2.d) it2;
                if (!((Iterator) dVar2.f50b).hasNext()) {
                    break;
                }
                Q2.h hVar2 = (Q2.h) dVar2.next();
                D1.b.w("Modified document %s not found in view.", this.e.f51a.a(hVar2), hVar2);
            }
            Iterator it3 = b3.e.iterator();
            while (true) {
                A2.d dVar3 = (A2.d) it3;
                if (!((Iterator) dVar3.f50b).hasNext()) {
                    break;
                }
                this.e = this.e.c((Q2.h) dVar3.next());
            }
            this.f1971c = b3.f2898b;
        }
        if (!z6 && this.f1971c) {
            A2.e eVar = this.f1973f;
            this.f1973f = Q2.h.f2673c;
            Iterator it4 = this.f1972d.f2676b.iterator();
            while (true) {
                A2.d dVar4 = (A2.d) it4;
                if (!((Iterator) dVar4.f50b).hasNext()) {
                    break;
                }
                Q2.k kVar2 = (Q2.k) dVar4.next();
                Q2.h hVar3 = kVar2.f2679a;
                if (!this.e.f51a.a(hVar3) && (kVar = (Q2.k) this.f1972d.f2675a.b(hVar3)) != null && !kVar.c()) {
                    this.f1973f = this.f1973f.a(kVar2.f2679a);
                }
            }
            ArrayList arrayList2 = new ArrayList(this.f1973f.f51a.size() + eVar.f51a.size());
            Iterator it5 = eVar.iterator();
            while (true) {
                A2.d dVar5 = (A2.d) it5;
                if (!((Iterator) dVar5.f50b).hasNext()) {
                    break;
                }
                Q2.h hVar4 = (Q2.h) dVar5.next();
                if (!this.f1973f.f51a.a(hVar4)) {
                    arrayList2.add(new z(y.f2060b, hVar4));
                }
            }
            Iterator it6 = this.f1973f.iterator();
            while (true) {
                A2.d dVar6 = (A2.d) it6;
                if (!((Iterator) dVar6.f50b).hasNext()) {
                    break;
                }
                Q2.h hVar5 = (Q2.h) dVar6.next();
                if (!eVar.f51a.a(hVar5)) {
                    arrayList2.add(new z(y.f2059a, hVar5));
                }
            }
            list = arrayList2;
        } else {
            list = Collections.EMPTY_LIST;
        }
        int i = (this.f1973f.f51a.size() == 0 && this.f1971c && !z6) ? 3 : 2;
        boolean z7 = i != this.f1970b;
        this.f1970b = i;
        if (arrayList.size() != 0 || z7) {
            s6 = new S(this.f1969a, (Q2.i) c0094g0.f1611b, iVar, arrayList, i == 2, (A2.e) c0094g0.e, z7, false, (b3 == null || b3.f2897a.isEmpty()) ? false : true);
        } else {
            s6 = null;
        }
        return new A.c(12, s6, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f9, code lost:
    
        if (r1.c() == false) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014f A[PHI: r5
      0x014f: PHI (r5v7 char) = (r5v5 char), (r5v5 char), (r5v15 char), (r5v15 char) binds: [B:78:0x014b, B:79:0x014d, B:65:0x011d, B:62:0x0111] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N1.C0094g0 c(A2.c r20, N1.C0094g0 r21) {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.Q.c(A2.c, N1.g0):N1.g0");
    }
}
