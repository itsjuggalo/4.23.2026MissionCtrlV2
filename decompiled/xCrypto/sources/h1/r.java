package h1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import b1.InterfaceC0861e;
import b1.g;
import d1.C1210a;
import d1.C1212c;
import e1.AbstractC1228a;
import i1.AbstractC1304k;
import i1.InterfaceC1296c;
import i1.InterfaceC1297d;
import j1.C1561a;
import j1.InterfaceC1562b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0861e f12138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1297d f12139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f12140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f12141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC1562b f12142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC1567a f12143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC1567a f12144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC1296c f12145i;

    public r(Context context, InterfaceC0861e interfaceC0861e, InterfaceC1297d interfaceC1297d, x xVar, Executor executor, InterfaceC1562b interfaceC1562b, InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, InterfaceC1296c interfaceC1296c) {
        this.f12137a = context;
        this.f12138b = interfaceC0861e;
        this.f12139c = interfaceC1297d;
        this.f12140d = xVar;
        this.f12141e = executor;
        this.f12142f = interfaceC1562b;
        this.f12143g = interfaceC1567a;
        this.f12144h = interfaceC1567a2;
        this.f12145i = interfaceC1296c;
    }

    public static /* synthetic */ Object b(r rVar, Iterable iterable, a1.p pVar, long j4) {
        rVar.f12139c.U(iterable);
        rVar.f12139c.D(pVar, rVar.f12143g.a() + j4);
        return null;
    }

    public static /* synthetic */ Object c(r rVar) {
        rVar.f12145i.e();
        return null;
    }

    public static /* synthetic */ Object e(r rVar, Iterable iterable) {
        rVar.f12139c.i(iterable);
        return null;
    }

    public static /* synthetic */ Object f(r rVar, a1.p pVar, int i4) {
        rVar.f12140d.b(pVar, i4 + 1);
        return null;
    }

    public static /* synthetic */ Object g(r rVar, a1.p pVar, long j4) {
        rVar.f12139c.D(pVar, rVar.f12143g.a() + j4);
        return null;
    }

    public static /* synthetic */ Object h(r rVar, Map map) {
        rVar.getClass();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            rVar.f12145i.p(((Integer) r0.getValue()).intValue(), C1212c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    public static /* synthetic */ void i(final r rVar, final a1.p pVar, final int i4, Runnable runnable) {
        rVar.getClass();
        try {
            try {
                InterfaceC1562b interfaceC1562b = rVar.f12142f;
                final InterfaceC1297d interfaceC1297d = rVar.f12139c;
                Objects.requireNonNull(interfaceC1297d);
                interfaceC1562b.f(new InterfaceC1562b.a() { // from class: h1.q
                    @Override // j1.InterfaceC1562b.a
                    public final Object a() {
                        return Integer.valueOf(interfaceC1297d.h());
                    }
                });
                if (rVar.k()) {
                    rVar.l(pVar, i4);
                } else {
                    rVar.f12142f.f(new InterfaceC1562b.a() { // from class: h1.h
                        @Override // j1.InterfaceC1562b.a
                        public final Object a() {
                            return r.f(this.f12114a, pVar, i4);
                        }
                    });
                }
                runnable.run();
            } catch (C1561a unused) {
                rVar.f12140d.b(pVar, i4 + 1);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public a1.i j(b1.m mVar) {
        InterfaceC1562b interfaceC1562b = this.f12142f;
        final InterfaceC1296c interfaceC1296c = this.f12145i;
        Objects.requireNonNull(interfaceC1296c);
        return mVar.a(a1.i.a().i(this.f12143g.a()).o(this.f12144h.a()).n("GDT_CLIENT_METRICS").h(new a1.h(X0.c.b("proto"), ((C1210a) interfaceC1562b.f(new InterfaceC1562b.a() { // from class: h1.p
            @Override // j1.InterfaceC1562b.a
            public final Object a() {
                return interfaceC1296c.g();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12137a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public b1.g l(final a1.p pVar, int i4) {
        b1.g gVarB;
        b1.m mVarA = this.f12138b.a(pVar.b());
        b1.g gVarE = b1.g.e(0L);
        final long j4 = 0;
        while (((Boolean) this.f12142f.f(new InterfaceC1562b.a() { // from class: h1.g
            @Override // j1.InterfaceC1562b.a
            public final Object a() {
                return Boolean.valueOf(this.f12112a.f12139c.B(pVar));
            }
        })).booleanValue()) {
            final Iterable iterable = (Iterable) this.f12142f.f(new InterfaceC1562b.a() { // from class: h1.i
                @Override // j1.InterfaceC1562b.a
                public final Object a() {
                    return this.f12117a.f12139c.k(pVar);
                }
            });
            if (!iterable.iterator().hasNext()) {
                return gVarE;
            }
            if (mVarA == null) {
                AbstractC1228a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                gVarB = b1.g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC1304k) it.next()).b());
                }
                if (pVar.e()) {
                    arrayList.add(j(mVarA));
                }
                gVarB = mVarA.b(b1.f.a().b(arrayList).c(pVar.c()).a());
            }
            gVarE = gVarB;
            if (gVarE.c() == g.a.TRANSIENT_ERROR) {
                final a1.p pVar2 = pVar;
                this.f12142f.f(new InterfaceC1562b.a() { // from class: h1.j
                    @Override // j1.InterfaceC1562b.a
                    public final Object a() {
                        return r.b(this.f12119a, iterable, pVar2, j4);
                    }
                });
                this.f12140d.a(pVar2, i4 + 1, true);
                return gVarE;
            }
            a1.p pVar3 = pVar;
            this.f12142f.f(new InterfaceC1562b.a() { // from class: h1.k
                @Override // j1.InterfaceC1562b.a
                public final Object a() {
                    return r.e(this.f12123a, iterable);
                }
            });
            if (gVarE.c() == g.a.OK) {
                long jMax = Math.max(j4, gVarE.b());
                if (pVar3.e()) {
                    this.f12142f.f(new InterfaceC1562b.a() { // from class: h1.l
                        @Override // j1.InterfaceC1562b.a
                        public final Object a() {
                            return r.c(this.f12125a);
                        }
                    });
                }
                j4 = jMax;
            } else if (gVarE.c() == g.a.INVALID_PAYLOAD) {
                final HashMap map = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String strN = ((AbstractC1304k) it2.next()).b().n();
                    if (map.containsKey(strN)) {
                        map.put(strN, Integer.valueOf(((Integer) map.get(strN)).intValue() + 1));
                    } else {
                        map.put(strN, 1);
                    }
                }
                this.f12142f.f(new InterfaceC1562b.a() { // from class: h1.m
                    @Override // j1.InterfaceC1562b.a
                    public final Object a() {
                        return r.h(this.f12126a, map);
                    }
                });
            }
            pVar = pVar3;
        }
        final a1.p pVar4 = pVar;
        this.f12142f.f(new InterfaceC1562b.a() { // from class: h1.n
            @Override // j1.InterfaceC1562b.a
            public final Object a() {
                return r.g(this.f12128a, pVar4, j4);
            }
        });
        return gVarE;
    }

    public void m(final a1.p pVar, final int i4, final Runnable runnable) {
        this.f12141e.execute(new Runnable() { // from class: h1.o
            @Override // java.lang.Runnable
            public final void run() {
                r.i(this.f12131a, pVar, i4, runnable);
            }
        });
    }
}
