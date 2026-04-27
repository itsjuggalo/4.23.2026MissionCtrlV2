package P2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y4.C1432b;
import y4.EnumC1431a;
import y4.EnumC1442l;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2351d;

    public A(boolean z6) {
        this.f2348a = z6;
    }

    public static A2.e b(N2.E e, A2.c cVar) {
        A2.e eVar = new A2.e(Collections.EMPTY_LIST, e.a());
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Q2.k kVar = (Q2.k) ((Map.Entry) it.next()).getValue();
            if (e.g(kVar)) {
                eVar = eVar.a(kVar);
            }
        }
        return eVar;
    }

    public static boolean d(N2.E e, int i, A2.e eVar, Q2.n nVar) {
        if (e.f1919h != -1) {
            A2.c cVar = eVar.f51a;
            if (i == cVar.size()) {
                Q2.k kVar = e.i == 1 ? (Q2.k) cVar.f() : (Q2.k) cVar.h();
                if (kVar != null && (kVar.c() || S.i.b(kVar.f2683f, 2) || kVar.f2681c.compareTo(nVar) > 0)) {
                }
            }
            return true;
        }
        return false;
    }

    public A2.c a(A2.e eVar, N2.E e, Q2.b bVar) {
        A2.c cVarQ = ((e3.w) this.f2350c).q(e, bVar, null);
        Iterator it = eVar.iterator();
        while (true) {
            A2.d dVar = (A2.d) it;
            if (!((Iterator) dVar.f50b).hasNext()) {
                return cVarQ;
            }
            Q2.k kVar = (Q2.k) dVar.next();
            cVarQ = cVarQ.l(kVar.f2679a, kVar);
        }
    }

    public void c(EnumC1431a... enumC1431aArr) {
        if (!this.f2348a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[enumC1431aArr.length];
        for (int i = 0; i < enumC1431aArr.length; i++) {
            strArr[i] = enumC1431aArr[i].f11679a;
        }
        this.f2350c = strArr;
    }

    public A2.c e(N2.E e) {
        if (e.h()) {
            return null;
        }
        N2.K kI = e.i();
        int iN = ((InterfaceC0207e) this.f2351d).n(kI);
        if (S.i.b(iN, 1)) {
            return null;
        }
        if ((e.f1919h != -1) && S.i.b(iN, 2)) {
            return e(e.f(-1L));
        }
        List listC = ((InterfaceC0207e) this.f2351d).c(kI);
        D1.b.w("index manager must return results for partial and full indexes.", listC != null, new Object[0]);
        A2.c cVarO = ((e3.w) this.f2350c).o(listC);
        Q2.b bVarT = ((InterfaceC0207e) this.f2351d).t(kI);
        A2.e eVarB = b(e, cVarO);
        return d(e, ((ArrayList) listC).size(), eVarB, bVarT.f2661a) ? e(e.f(-1L)) : a(eVarB, e, bVarT);
    }

    public void f(EnumC1442l... enumC1442lArr) {
        if (!this.f2348a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (enumC1442lArr.length == 0) {
            throw new IllegalArgumentException("At least one TlsVersion is required");
        }
        String[] strArr = new String[enumC1442lArr.length];
        for (int i = 0; i < enumC1442lArr.length; i++) {
            strArr[i] = enumC1442lArr[i].f11717a;
        }
        this.f2351d = strArr;
    }

    public A(C1432b c1432b) {
        this.f2348a = c1432b.f11680a;
        this.f2350c = c1432b.f11681b;
        this.f2351d = c1432b.f11682c;
        this.f2349b = c1432b.f11683d;
    }
}
