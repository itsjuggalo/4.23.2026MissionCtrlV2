package s4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import m4.g;
import o4.c;
import u4.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m4.e f20010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t4.d f20011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f20012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f20013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u4.b f20014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v4.a f20015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v4.a f20016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t4.c f20017i;

    public r(Context context, m4.e eVar, t4.d dVar, x xVar, Executor executor, u4.b bVar, v4.a aVar, v4.a aVar2, t4.c cVar) {
        this.f20009a = context;
        this.f20010b = eVar;
        this.f20011c = dVar;
        this.f20012d = xVar;
        this.f20013e = executor;
        this.f20014f = bVar;
        this.f20015g = aVar;
        this.f20016h = aVar2;
        this.f20017i = cVar;
    }

    public static /* synthetic */ Object b(r rVar, Iterable iterable, l4.p pVar, long j10) {
        rVar.f20011c.S(iterable);
        rVar.f20011c.F(pVar, rVar.f20015g.a() + j10);
        return null;
    }

    public static /* synthetic */ Object c(r rVar) {
        rVar.f20017i.c();
        return null;
    }

    public static /* synthetic */ Object e(r rVar, Iterable iterable) {
        rVar.f20011c.i(iterable);
        return null;
    }

    public static /* synthetic */ Object f(r rVar, l4.p pVar, int i10) {
        rVar.f20012d.b(pVar, i10 + 1);
        return null;
    }

    public static /* synthetic */ Object g(r rVar, l4.p pVar, long j10) {
        rVar.f20011c.F(pVar, rVar.f20015g.a() + j10);
        return null;
    }

    public static /* synthetic */ Object h(r rVar, Map map) {
        rVar.getClass();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            rVar.f20017i.b(((Integer) r0.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    public static /* synthetic */ void i(final r rVar, final l4.p pVar, final int i10, Runnable runnable) {
        rVar.getClass();
        try {
            try {
                u4.b bVar = rVar.f20014f;
                final t4.d dVar = rVar.f20011c;
                Objects.requireNonNull(dVar);
                bVar.e(new b.a() { // from class: s4.i
                    @Override // u4.b.a
                    public final Object a() {
                        return Integer.valueOf(dVar.h());
                    }
                });
                if (rVar.k()) {
                    rVar.l(pVar, i10);
                } else {
                    rVar.f20014f.e(new b.a() { // from class: s4.j
                        @Override // u4.b.a
                        public final Object a() {
                            return r.f(this.f19990a, pVar, i10);
                        }
                    });
                }
                runnable.run();
            } catch (u4.a unused) {
                rVar.f20012d.b(pVar, i10 + 1);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public l4.i j(m4.m mVar) {
        u4.b bVar = this.f20014f;
        final t4.c cVar = this.f20017i;
        Objects.requireNonNull(cVar);
        return mVar.b(l4.i.a().i(this.f20015g.a()).o(this.f20016h.a()).n("GDT_CLIENT_METRICS").h(new l4.h(i4.c.b("proto"), ((o4.a) bVar.e(new b.a() { // from class: s4.h
            @Override // u4.b.a
            public final Object a() {
                return cVar.o();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f20009a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public m4.g l(final l4.p pVar, int i10) {
        m4.g gVarA;
        m4.m mVarA = this.f20010b.a(pVar.b());
        m4.g gVarE = m4.g.e(0L);
        final long j10 = 0;
        while (((Boolean) this.f20014f.e(new b.a() { // from class: s4.k
            @Override // u4.b.a
            public final Object a() {
                return Boolean.valueOf(this.f19993a.f20011c.y(pVar));
            }
        })).booleanValue()) {
            final Iterable iterable = (Iterable) this.f20014f.e(new b.a() { // from class: s4.l
                @Override // u4.b.a
                public final Object a() {
                    return this.f19995a.f20011c.A(pVar);
                }
            });
            if (!iterable.iterator().hasNext()) {
                return gVarE;
            }
            if (mVarA == null) {
                p4.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                gVarA = m4.g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((t4.k) it.next()).b());
                }
                if (pVar.e()) {
                    arrayList.add(j(mVarA));
                }
                gVarA = mVarA.a(m4.f.a().b(arrayList).c(pVar.c()).a());
            }
            gVarE = gVarA;
            if (gVarE.c() == g.a.TRANSIENT_ERROR) {
                final l4.p pVar2 = pVar;
                this.f20014f.e(new b.a() { // from class: s4.m
                    @Override // u4.b.a
                    public final Object a() {
                        return r.b(this.f19997a, iterable, pVar2, j10);
                    }
                });
                this.f20012d.a(pVar2, i10 + 1, true);
                return gVarE;
            }
            l4.p pVar3 = pVar;
            this.f20014f.e(new b.a() { // from class: s4.n
                @Override // u4.b.a
                public final Object a() {
                    return r.e(this.f20001a, iterable);
                }
            });
            if (gVarE.c() == g.a.OK) {
                long jMax = Math.max(j10, gVarE.b());
                if (pVar3.e()) {
                    this.f20014f.e(new b.a() { // from class: s4.o
                        @Override // u4.b.a
                        public final Object a() {
                            return r.c(this.f20003a);
                        }
                    });
                }
                j10 = jMax;
            } else if (gVarE.c() == g.a.INVALID_PAYLOAD) {
                final HashMap map = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String strN = ((t4.k) it2.next()).b().n();
                    if (map.containsKey(strN)) {
                        map.put(strN, Integer.valueOf(((Integer) map.get(strN)).intValue() + 1));
                    } else {
                        map.put(strN, 1);
                    }
                }
                this.f20014f.e(new b.a() { // from class: s4.p
                    @Override // u4.b.a
                    public final Object a() {
                        return r.h(this.f20004a, map);
                    }
                });
            }
            pVar = pVar3;
        }
        final l4.p pVar4 = pVar;
        this.f20014f.e(new b.a() { // from class: s4.q
            @Override // u4.b.a
            public final Object a() {
                return r.g(this.f20006a, pVar4, j10);
            }
        });
        return gVarE;
    }

    public void m(final l4.p pVar, final int i10, final Runnable runnable) {
        this.f20013e.execute(new Runnable() { // from class: s4.g
            @Override // java.lang.Runnable
            public final void run() {
                r.i(this.f19984a, pVar, i10, runnable);
            }
        });
    }
}
