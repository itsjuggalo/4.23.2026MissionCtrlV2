package i3;

import d4.a;
import i3.h;
import i3.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l implements h.b, a.f {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c f11696z = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d4.c f11698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.a f11699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s0.c f11700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f11701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f11702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l3.b f11703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l3.b f11704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l3.b f11705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l3.b f11706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f11707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g3.f f11708l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11709m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11710n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f11711o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11712p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v f11713q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public g3.a f11714r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q f11716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11717u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p f11718v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f11719w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f11720x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11721y;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y3.g f11722a;

        public a(y3.g gVar) {
            this.f11722a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f11722a.f()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f11697a.c(this.f11722a)) {
                            l.this.e(this.f11722a);
                        }
                        l.this.h();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y3.g f11724a;

        public b(y3.g gVar) {
            this.f11724a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f11724a.f()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f11697a.c(this.f11724a)) {
                            l.this.f11718v.a();
                            l.this.f(this.f11724a);
                            l.this.r(this.f11724a);
                        }
                        l.this.h();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
        public p a(v vVar, boolean z10, g3.f fVar, p.a aVar) {
            return new p(vVar, z10, true, fVar, aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y3.g f11726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f11727b;

        public d(y3.g gVar, Executor executor) {
            this.f11726a = gVar;
            this.f11727b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f11726a.equals(((d) obj).f11726a);
            }
            return false;
        }

        public int hashCode() {
            return this.f11726a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f11728a;

        public e() {
            this(new ArrayList(2));
        }

        public static d e(y3.g gVar) {
            return new d(gVar, c4.e.a());
        }

        public void a(y3.g gVar, Executor executor) {
            this.f11728a.add(new d(gVar, executor));
        }

        public boolean c(y3.g gVar) {
            return this.f11728a.contains(e(gVar));
        }

        public void clear() {
            this.f11728a.clear();
        }

        public e d() {
            return new e(new ArrayList(this.f11728a));
        }

        public void f(y3.g gVar) {
            this.f11728a.remove(e(gVar));
        }

        public boolean isEmpty() {
            return this.f11728a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f11728a.iterator();
        }

        public int size() {
            return this.f11728a.size();
        }

        public e(List list) {
            this.f11728a = list;
        }
    }

    public l(l3.b bVar, l3.b bVar2, l3.b bVar3, l3.b bVar4, m mVar, p.a aVar, s0.c cVar) {
        this(bVar, bVar2, bVar3, bVar4, mVar, aVar, cVar, f11696z);
    }

    private synchronized void q() {
        if (this.f11708l == null) {
            throw new IllegalArgumentException();
        }
        this.f11697a.clear();
        this.f11708l = null;
        this.f11718v = null;
        this.f11713q = null;
        this.f11717u = false;
        this.f11720x = false;
        this.f11715s = false;
        this.f11721y = false;
        this.f11719w.M(false);
        this.f11719w = null;
        this.f11716t = null;
        this.f11714r = null;
        this.f11700d.a(this);
    }

    @Override // i3.h.b
    public void a(q qVar) {
        synchronized (this) {
            this.f11716t = qVar;
        }
        n();
    }

    public synchronized void b(y3.g gVar, Executor executor) {
        try {
            this.f11698b.c();
            this.f11697a.a(gVar, executor);
            if (this.f11715s) {
                k(1);
                executor.execute(new b(gVar));
            } else if (this.f11717u) {
                k(1);
                executor.execute(new a(gVar));
            } else {
                c4.k.b(!this.f11720x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // i3.h.b
    public void c(v vVar, g3.a aVar, boolean z10) {
        synchronized (this) {
            this.f11713q = vVar;
            this.f11714r = aVar;
            this.f11721y = z10;
        }
        o();
    }

    @Override // i3.h.b
    public void d(h hVar) {
        j().execute(hVar);
    }

    public void e(y3.g gVar) {
        try {
            gVar.a(this.f11716t);
        } catch (Throwable th) {
            throw new i3.b(th);
        }
    }

    public void f(y3.g gVar) {
        try {
            gVar.c(this.f11718v, this.f11714r, this.f11721y);
        } catch (Throwable th) {
            throw new i3.b(th);
        }
    }

    public void g() {
        if (m()) {
            return;
        }
        this.f11720x = true;
        this.f11719w.b();
        this.f11702f.c(this, this.f11708l);
    }

    public void h() {
        p pVar;
        synchronized (this) {
            try {
                this.f11698b.c();
                c4.k.b(m(), "Not yet complete!");
                int iDecrementAndGet = this.f11707k.decrementAndGet();
                c4.k.b(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    pVar = this.f11718v;
                    q();
                } else {
                    pVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (pVar != null) {
            pVar.g();
        }
    }

    @Override // d4.a.f
    public d4.c i() {
        return this.f11698b;
    }

    public final l3.b j() {
        return this.f11710n ? this.f11705i : this.f11711o ? this.f11706j : this.f11704h;
    }

    public synchronized void k(int i10) {
        p pVar;
        c4.k.b(m(), "Not yet complete!");
        if (this.f11707k.getAndAdd(i10) == 0 && (pVar = this.f11718v) != null) {
            pVar.a();
        }
    }

    public synchronized l l(g3.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f11708l = fVar;
        this.f11709m = z10;
        this.f11710n = z11;
        this.f11711o = z12;
        this.f11712p = z13;
        return this;
    }

    public final boolean m() {
        return this.f11717u || this.f11715s || this.f11720x;
    }

    public void n() {
        synchronized (this) {
            try {
                this.f11698b.c();
                if (this.f11720x) {
                    q();
                    return;
                }
                if (this.f11697a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f11717u) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f11717u = true;
                g3.f fVar = this.f11708l;
                e<d> eVarD = this.f11697a.d();
                k(eVarD.size() + 1);
                this.f11702f.b(this, fVar, null);
                for (d dVar : eVarD) {
                    dVar.f11727b.execute(new a(dVar.f11726a));
                }
                h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o() {
        synchronized (this) {
            try {
                this.f11698b.c();
                if (this.f11720x) {
                    this.f11713q.b();
                    q();
                    return;
                }
                if (this.f11697a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f11715s) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f11718v = this.f11701e.a(this.f11713q, this.f11709m, this.f11708l, this.f11699c);
                this.f11715s = true;
                e<d> eVarD = this.f11697a.d();
                k(eVarD.size() + 1);
                this.f11702f.b(this, this.f11708l, this.f11718v);
                for (d dVar : eVarD) {
                    dVar.f11727b.execute(new b(dVar.f11726a));
                }
                h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean p() {
        return this.f11712p;
    }

    public synchronized void r(y3.g gVar) {
        try {
            this.f11698b.c();
            this.f11697a.f(gVar);
            if (this.f11697a.isEmpty()) {
                g();
                if (this.f11715s || this.f11717u) {
                    if (this.f11707k.get() == 0) {
                        q();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(h hVar) {
        try {
            this.f11719w = hVar;
            (hVar.Y() ? this.f11703g : j()).execute(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public l(l3.b bVar, l3.b bVar2, l3.b bVar3, l3.b bVar4, m mVar, p.a aVar, s0.c cVar, c cVar2) {
        this.f11697a = new e();
        this.f11698b = d4.c.a();
        this.f11707k = new AtomicInteger();
        this.f11703g = bVar;
        this.f11704h = bVar2;
        this.f11705i = bVar3;
        this.f11706j = bVar4;
        this.f11702f = mVar;
        this.f11699c = aVar;
        this.f11700d = cVar;
        this.f11701e = cVar2;
    }
}
