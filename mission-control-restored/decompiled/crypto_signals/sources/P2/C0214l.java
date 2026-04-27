package P2;

import N2.RunnableC0153b;
import a.AbstractC0284a;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: P2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0214l implements M2.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f2454n = TimeUnit.MINUTES.toSeconds(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y5.a f2455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0207e f2456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0225x f2457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0203a f2458d;
    public final D e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e3.w f2459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final A f2460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final A.c f2461h;
    public final W i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final A.c f2462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SparseArray f2463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap f2464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final F1.l f2465m;

    public C0214l(y5.a aVar, A a6, L2.f fVar) {
        D1.b.w("LocalStore was passed an unstarted persistence implementation", aVar.C(), new Object[0]);
        this.f2455a = aVar;
        this.f2460g = a6;
        W wB = aVar.B();
        this.i = wB;
        this.f2462j = aVar.r();
        F1.l lVar = new F1.l(0, wB.j());
        lVar.f508a += 2;
        this.f2465m = lVar;
        this.e = aVar.A();
        A.c cVar = new A.c(18);
        this.f2461h = cVar;
        this.f2463k = new SparseArray();
        this.f2464l = new HashMap();
        aVar.z().e(cVar);
        c(fVar);
    }

    public static boolean e(X x6, X x7, T2.B b3) {
        if (x6.f2423g.isEmpty()) {
            return true;
        }
        long j4 = x7.e.f2688a.f3982a - x6.e.f2688a.f3982a;
        long j6 = f2454n;
        if (j4 >= j6) {
            return true;
        }
        if (x7.f2422f.f2688a.f3982a - x6.f2422f.f2688a.f3982a >= j6) {
            return true;
        }
        if (b3 == null) {
            return false;
        }
        return b3.e.f51a.size() + (b3.f2900d.f51a.size() + b3.f2899c.f51a.size()) > 0;
    }

    public final X a(N2.K k6) {
        int i;
        X xE = this.i.e(k6);
        if (xE != null) {
            i = xE.f2419b;
        } else {
            C0219q c0219q = new C0219q();
            this.f2455a.Q("Allocate target", new RunnableC0153b(this, c0219q, k6, 4));
            i = c0219q.f2477a;
            xE = (X) c0219q.f2478b;
        }
        SparseArray sparseArray = this.f2463k;
        if (sparseArray.get(i) == null) {
            sparseArray.put(i, xE);
            this.f2464l.put(k6, Integer.valueOf(i));
        }
        return xE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final A.c b(N2.E r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.C0214l.b(N2.E, boolean):A.c");
    }

    public final void c(L2.f fVar) {
        y5.a aVar = this.f2455a;
        InterfaceC0207e interfaceC0207eU = aVar.u(fVar);
        this.f2456b = interfaceC0207eU;
        this.f2457c = aVar.x(fVar, interfaceC0207eU);
        InterfaceC0203a interfaceC0203aT = aVar.t(fVar);
        this.f2458d = interfaceC0203aT;
        InterfaceC0225x interfaceC0225x = this.f2457c;
        InterfaceC0207e interfaceC0207e = this.f2456b;
        D d4 = this.e;
        this.f2459f = new e3.w(d4, interfaceC0225x, interfaceC0203aT, interfaceC0207e, 6);
        d4.z(interfaceC0207e);
        e3.w wVar = this.f2459f;
        InterfaceC0207e interfaceC0207e2 = this.f2456b;
        A a6 = this.f2460g;
        a6.f2350c = wVar;
        a6.f2351d = interfaceC0207e2;
        a6.f2348a = true;
    }

    public final A.c d(Map map) {
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Set setKeySet = map.keySet();
        D d4 = this.e;
        HashMap mapY = d4.y(setKeySet);
        for (Map.Entry entry : map.entrySet()) {
            Q2.h hVar = (Q2.h) entry.getKey();
            Q2.k kVar = (Q2.k) entry.getValue();
            Q2.k kVar2 = (Q2.k) mapY.get(hVar);
            if (kVar.d() != kVar2.d()) {
                hashSet.add(hVar);
            }
            if (kVar.e() && kVar.f2681c.equals(Q2.n.f2687b)) {
                arrayList.add(kVar.f2679a);
                map2.put(hVar, kVar);
            } else if (S.i.b(kVar2.f2680b, 1) || kVar.f2681c.compareTo(kVar2.f2681c) > 0 || (kVar.f2681c.compareTo(kVar2.f2681c) == 0 && (kVar2.c() || S.i.b(kVar2.f2683f, 2)))) {
                D1.b.w("Cannot add a document when the remote version is zero", !Q2.n.f2687b.equals(kVar.f2682d), new Object[0]);
                d4.r(kVar, kVar.f2682d);
                map2.put(hVar, kVar);
            } else {
                AbstractC0284a.f(1, "LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", hVar, kVar2.f2681c, kVar.f2681c);
            }
        }
        d4.a(arrayList);
        return new A.c(14, map2, hashSet);
    }
}
