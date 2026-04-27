package y1;

import A1.b;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import o1.C2291c;
import s1.g;
import u1.C2745a;
import u1.C2747c;
import v1.AbstractC2763a;
import z1.AbstractC2866k;
import z1.InterfaceC2858c;
import z1.InterfaceC2859d;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f25501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.e f25502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2859d f25503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f25504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f25505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A1.b f25506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final B1.a f25507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final B1.a f25508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC2858c f25509i;

    public r(Context context, s1.e eVar, InterfaceC2859d interfaceC2859d, x xVar, Executor executor, A1.b bVar, B1.a aVar, B1.a aVar2, InterfaceC2858c interfaceC2858c) {
        this.f25501a = context;
        this.f25502b = eVar;
        this.f25503c = interfaceC2859d;
        this.f25504d = xVar;
        this.f25505e = executor;
        this.f25506f = bVar;
        this.f25507g = aVar;
        this.f25508h = aVar2;
        this.f25509i = interfaceC2858c;
    }

    public r1.i j(s1.m mVar) {
        A1.b bVar = this.f25506f;
        final InterfaceC2858c interfaceC2858c = this.f25509i;
        Objects.requireNonNull(interfaceC2858c);
        return mVar.b(r1.i.a().i(this.f25507g.a()).o(this.f25508h.a()).n("GDT_CLIENT_METRICS").h(new r1.h(C2291c.b("proto"), ((C2745a) bVar.h(new b.a() { // from class: y1.h
            @Override // A1.b.a
            public final Object a() {
                return interfaceC2858c.G();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f25501a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final /* synthetic */ Boolean l(r1.p pVar) {
        return Boolean.valueOf(this.f25503c.g0(pVar));
    }

    public final /* synthetic */ Iterable m(r1.p pVar) {
        return this.f25503c.x(pVar);
    }

    public final /* synthetic */ Object n(Iterable iterable, r1.p pVar, long j7) {
        this.f25503c.l0(iterable);
        this.f25503c.Z(pVar, this.f25507g.a() + j7);
        return null;
    }

    public final /* synthetic */ Object o(Iterable iterable) {
        this.f25503c.l(iterable);
        return null;
    }

    public final /* synthetic */ Object p() {
        this.f25509i.A();
        return null;
    }

    public final /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.f25509i.i(((Integer) r0.getValue()).intValue(), C2747c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    public final /* synthetic */ Object r(r1.p pVar, long j7) {
        this.f25503c.Z(pVar, this.f25507g.a() + j7);
        return null;
    }

    public final /* synthetic */ Object s(r1.p pVar, int i7) {
        this.f25504d.b(pVar, i7 + 1);
        return null;
    }

    public final /* synthetic */ void t(final r1.p pVar, final int i7, Runnable runnable) {
        try {
            try {
                A1.b bVar = this.f25506f;
                final InterfaceC2859d interfaceC2859d = this.f25503c;
                Objects.requireNonNull(interfaceC2859d);
                bVar.h(new b.a() { // from class: y1.i
                    @Override // A1.b.a
                    public final Object a() {
                        return Integer.valueOf(interfaceC2859d.j());
                    }
                });
                if (k()) {
                    u(pVar, i7);
                } else {
                    this.f25506f.h(new b.a() { // from class: y1.j
                        @Override // A1.b.a
                        public final Object a() {
                            return this.f25482a.s(pVar, i7);
                        }
                    });
                }
            } catch (A1.a unused) {
                this.f25504d.b(pVar, i7 + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public s1.g u(final r1.p pVar, int i7) {
        s1.g gVarA;
        s1.m mVarA = this.f25502b.a(pVar.b());
        long jMax = 0;
        s1.g gVarE = s1.g.e(0L);
        while (true) {
            final long j7 = jMax;
            while (((Boolean) this.f25506f.h(new b.a() { // from class: y1.k
                @Override // A1.b.a
                public final Object a() {
                    return this.f25485a.l(pVar);
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f25506f.h(new b.a() { // from class: y1.l
                    @Override // A1.b.a
                    public final Object a() {
                        return this.f25487a.m(pVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return gVarE;
                }
                if (mVarA == null) {
                    AbstractC2763a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                    gVarA = s1.g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AbstractC2866k) it.next()).b());
                    }
                    if (pVar.e()) {
                        arrayList.add(j(mVarA));
                    }
                    gVarA = mVarA.a(s1.f.a().b(arrayList).c(pVar.c()).a());
                }
                gVarE = gVarA;
                if (gVarE.c() == g.a.TRANSIENT_ERROR) {
                    this.f25506f.h(new b.a() { // from class: y1.m
                        @Override // A1.b.a
                        public final Object a() {
                            return this.f25489a.n(iterable, pVar, j7);
                        }
                    });
                    this.f25504d.a(pVar, i7 + 1, true);
                    return gVarE;
                }
                this.f25506f.h(new b.a() { // from class: y1.n
                    @Override // A1.b.a
                    public final Object a() {
                        return this.f25493a.o(iterable);
                    }
                });
                if (gVarE.c() == g.a.OK) {
                    jMax = Math.max(j7, gVarE.b());
                    if (pVar.e()) {
                        this.f25506f.h(new b.a() { // from class: y1.o
                            @Override // A1.b.a
                            public final Object a() {
                                return this.f25495a.p();
                            }
                        });
                    }
                } else if (gVarE.c() == g.a.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strN = ((AbstractC2866k) it2.next()).b().n();
                        if (map.containsKey(strN)) {
                            map.put(strN, Integer.valueOf(((Integer) map.get(strN)).intValue() + 1));
                        } else {
                            map.put(strN, 1);
                        }
                    }
                    this.f25506f.h(new b.a() { // from class: y1.p
                        @Override // A1.b.a
                        public final Object a() {
                            return this.f25496a.q(map);
                        }
                    });
                }
            }
            this.f25506f.h(new b.a() { // from class: y1.q
                @Override // A1.b.a
                public final Object a() {
                    return this.f25498a.r(pVar, j7);
                }
            });
            return gVarE;
        }
    }

    public void v(final r1.p pVar, final int i7, final Runnable runnable) {
        this.f25505e.execute(new Runnable() { // from class: y1.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f25476a.t(pVar, i7, runnable);
            }
        });
    }
}
