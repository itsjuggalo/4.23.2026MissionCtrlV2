package G1;

import A1.g;
import C1.c;
import H1.AbstractC0593k;
import H1.InterfaceC0585c;
import H1.InterfaceC0586d;
import I1.b;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import w1.C2900c;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A1.e f2133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0586d f2134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f2135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f2136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final I1.b f2137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final J1.a f2138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final J1.a f2139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC0585c f2140i;

    public r(Context context, A1.e eVar, InterfaceC0586d interfaceC0586d, x xVar, Executor executor, I1.b bVar, J1.a aVar, J1.a aVar2, InterfaceC0585c interfaceC0585c) {
        this.f2132a = context;
        this.f2133b = eVar;
        this.f2134c = interfaceC0586d;
        this.f2135d = xVar;
        this.f2136e = executor;
        this.f2137f = bVar;
        this.f2138g = aVar;
        this.f2139h = aVar2;
        this.f2140i = interfaceC0585c;
    }

    public z1.i j(A1.m mVar) {
        I1.b bVar = this.f2137f;
        final InterfaceC0585c interfaceC0585c = this.f2140i;
        Objects.requireNonNull(interfaceC0585c);
        return mVar.a(z1.i.a().i(this.f2138g.a()).o(this.f2139h.a()).n("GDT_CLIENT_METRICS").h(new z1.h(C2900c.b("proto"), ((C1.a) bVar.c(new b.a() { // from class: G1.h
            @Override // I1.b.a
            public final Object a() {
                return interfaceC0585c.e();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2132a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final /* synthetic */ Boolean l(z1.p pVar) {
        return Boolean.valueOf(this.f2134c.L(pVar));
    }

    public final /* synthetic */ Iterable m(z1.p pVar) {
        return this.f2134c.o(pVar);
    }

    public final /* synthetic */ Object n(Iterable iterable, z1.p pVar, long j8) {
        this.f2134c.j0(iterable);
        this.f2134c.d0(pVar, this.f2138g.a() + j8);
        return null;
    }

    public final /* synthetic */ Object o(Iterable iterable) {
        this.f2134c.k(iterable);
        return null;
    }

    public final /* synthetic */ Object p() {
        this.f2140i.a();
        return null;
    }

    public final /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.f2140i.f(((Integer) r0.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    public final /* synthetic */ Object r(z1.p pVar, long j8) {
        this.f2134c.d0(pVar, this.f2138g.a() + j8);
        return null;
    }

    public final /* synthetic */ Object s(z1.p pVar, int i8) {
        this.f2135d.a(pVar, i8 + 1);
        return null;
    }

    public final /* synthetic */ void t(final z1.p pVar, final int i8, Runnable runnable) {
        try {
            try {
                I1.b bVar = this.f2137f;
                final InterfaceC0586d interfaceC0586d = this.f2134c;
                Objects.requireNonNull(interfaceC0586d);
                bVar.c(new b.a() { // from class: G1.i
                    @Override // I1.b.a
                    public final Object a() {
                        return Integer.valueOf(interfaceC0586d.i());
                    }
                });
                if (k()) {
                    u(pVar, i8);
                } else {
                    this.f2137f.c(new b.a() { // from class: G1.j
                        @Override // I1.b.a
                        public final Object a() {
                            return this.f2113a.s(pVar, i8);
                        }
                    });
                }
            } catch (I1.a unused) {
                this.f2135d.a(pVar, i8 + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public A1.g u(final z1.p pVar, int i8) {
        A1.g gVarB;
        A1.m mVarA = this.f2133b.a(pVar.b());
        long jMax = 0;
        A1.g gVarE = A1.g.e(0L);
        while (true) {
            final long j8 = jMax;
            while (((Boolean) this.f2137f.c(new b.a() { // from class: G1.k
                @Override // I1.b.a
                public final Object a() {
                    return this.f2116a.l(pVar);
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f2137f.c(new b.a() { // from class: G1.l
                    @Override // I1.b.a
                    public final Object a() {
                        return this.f2118a.m(pVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return gVarE;
                }
                if (mVarA == null) {
                    D1.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                    gVarB = A1.g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AbstractC0593k) it.next()).b());
                    }
                    if (pVar.e()) {
                        arrayList.add(j(mVarA));
                    }
                    gVarB = mVarA.b(A1.f.a().b(arrayList).c(pVar.c()).a());
                }
                gVarE = gVarB;
                if (gVarE.c() == g.a.TRANSIENT_ERROR) {
                    this.f2137f.c(new b.a() { // from class: G1.m
                        @Override // I1.b.a
                        public final Object a() {
                            return this.f2120a.n(iterable, pVar, j8);
                        }
                    });
                    this.f2135d.b(pVar, i8 + 1, true);
                    return gVarE;
                }
                this.f2137f.c(new b.a() { // from class: G1.n
                    @Override // I1.b.a
                    public final Object a() {
                        return this.f2124a.o(iterable);
                    }
                });
                if (gVarE.c() == g.a.OK) {
                    jMax = Math.max(j8, gVarE.b());
                    if (pVar.e()) {
                        this.f2137f.c(new b.a() { // from class: G1.o
                            @Override // I1.b.a
                            public final Object a() {
                                return this.f2126a.p();
                            }
                        });
                    }
                } else if (gVarE.c() == g.a.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strN = ((AbstractC0593k) it2.next()).b().n();
                        map.put(strN, !map.containsKey(strN) ? 1 : Integer.valueOf(((Integer) map.get(strN)).intValue() + 1));
                    }
                    this.f2137f.c(new b.a() { // from class: G1.p
                        @Override // I1.b.a
                        public final Object a() {
                            return this.f2127a.q(map);
                        }
                    });
                }
            }
            this.f2137f.c(new b.a() { // from class: G1.q
                @Override // I1.b.a
                public final Object a() {
                    return this.f2129a.r(pVar, j8);
                }
            });
            return gVarE;
        }
    }

    public void v(final z1.p pVar, final int i8, final Runnable runnable) {
        this.f2136e.execute(new Runnable() { // from class: G1.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f2107a.t(pVar, i8, runnable);
            }
        });
    }
}
