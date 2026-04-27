package W0;

import W0.h;
import W0.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import q1.AbstractC2622e;
import q1.AbstractC2628k;
import r1.AbstractC2670a;
import r1.AbstractC2672c;

/* JADX INFO: loaded from: classes.dex */
public class l implements h.b, AbstractC2670a.f {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c f9157z = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f9158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2672c f9159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.a f9160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final S.d f9161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f9162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f9163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Z0.a f9164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Z0.a f9165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Z0.a f9166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Z0.a f9167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f9168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public U0.f f9169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v f9174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public U0.a f9175r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9176s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q f9177t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9178u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p f9179v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f9180w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f9181x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9182y;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1.g f9183a;

        public a(m1.g gVar) {
            this.f9183a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f9183a.f()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f9158a.d(this.f9183a)) {
                            l.this.f(this.f9183a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1.g f9185a;

        public b(m1.g gVar) {
            this.f9185a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f9185a.f()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f9158a.d(this.f9185a)) {
                            l.this.f9179v.a();
                            l.this.g(this.f9185a);
                            l.this.r(this.f9185a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public static class c {
        public p a(v vVar, boolean z7, U0.f fVar, p.a aVar) {
            return new p(vVar, z7, true, fVar, aVar);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1.g f9187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f9188b;

        public d(m1.g gVar, Executor executor) {
            this.f9187a = gVar;
            this.f9188b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f9187a.equals(((d) obj).f9187a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9187a.hashCode();
        }
    }

    public static final class e implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f9189a;

        public e() {
            this(new ArrayList(2));
        }

        public static d f(m1.g gVar) {
            return new d(gVar, AbstractC2622e.a());
        }

        public void a(m1.g gVar, Executor executor) {
            this.f9189a.add(new d(gVar, executor));
        }

        public void clear() {
            this.f9189a.clear();
        }

        public boolean d(m1.g gVar) {
            return this.f9189a.contains(f(gVar));
        }

        public e e() {
            return new e(new ArrayList(this.f9189a));
        }

        public void h(m1.g gVar) {
            this.f9189a.remove(f(gVar));
        }

        public boolean isEmpty() {
            return this.f9189a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f9189a.iterator();
        }

        public int size() {
            return this.f9189a.size();
        }

        public e(List list) {
            this.f9189a = list;
        }
    }

    public l(Z0.a aVar, Z0.a aVar2, Z0.a aVar3, Z0.a aVar4, m mVar, p.a aVar5, S.d dVar) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, dVar, f9157z);
    }

    private synchronized void q() {
        if (this.f9169l == null) {
            throw new IllegalArgumentException();
        }
        this.f9158a.clear();
        this.f9169l = null;
        this.f9179v = null;
        this.f9174q = null;
        this.f9178u = false;
        this.f9181x = false;
        this.f9176s = false;
        this.f9182y = false;
        this.f9180w.Q(false);
        this.f9180w = null;
        this.f9177t = null;
        this.f9175r = null;
        this.f9161d.a(this);
    }

    @Override // r1.AbstractC2670a.f
    public AbstractC2672c a() {
        return this.f9159b;
    }

    @Override // W0.h.b
    public void b(q qVar) {
        synchronized (this) {
            this.f9177t = qVar;
        }
        n();
    }

    @Override // W0.h.b
    public void c(v vVar, U0.a aVar, boolean z7) {
        synchronized (this) {
            this.f9174q = vVar;
            this.f9175r = aVar;
            this.f9182y = z7;
        }
        o();
    }

    @Override // W0.h.b
    public void d(h hVar) {
        j().execute(hVar);
    }

    public synchronized void e(m1.g gVar, Executor executor) {
        Runnable aVar;
        try {
            this.f9159b.c();
            this.f9158a.a(gVar, executor);
            if (this.f9176s) {
                k(1);
                aVar = new b(gVar);
            } else if (this.f9178u) {
                k(1);
                aVar = new a(gVar);
            } else {
                AbstractC2628k.a(!this.f9181x, "Cannot add callbacks to a cancelled EngineJob");
            }
            executor.execute(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void f(m1.g gVar) {
        try {
            gVar.b(this.f9177t);
        } catch (Throwable th) {
            throw new W0.b(th);
        }
    }

    public void g(m1.g gVar) {
        try {
            gVar.c(this.f9179v, this.f9175r, this.f9182y);
        } catch (Throwable th) {
            throw new W0.b(th);
        }
    }

    public void h() {
        if (m()) {
            return;
        }
        this.f9181x = true;
        this.f9180w.k();
        this.f9163f.b(this, this.f9169l);
    }

    public void i() {
        p pVar;
        synchronized (this) {
            try {
                this.f9159b.c();
                AbstractC2628k.a(m(), "Not yet complete!");
                int iDecrementAndGet = this.f9168k.decrementAndGet();
                AbstractC2628k.a(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    pVar = this.f9179v;
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

    public final Z0.a j() {
        return this.f9171n ? this.f9166i : this.f9172o ? this.f9167j : this.f9165h;
    }

    public synchronized void k(int i8) {
        p pVar;
        AbstractC2628k.a(m(), "Not yet complete!");
        if (this.f9168k.getAndAdd(i8) == 0 && (pVar = this.f9179v) != null) {
            pVar.a();
        }
    }

    public synchronized l l(U0.f fVar, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f9169l = fVar;
        this.f9170m = z7;
        this.f9171n = z8;
        this.f9172o = z9;
        this.f9173p = z10;
        return this;
    }

    public final boolean m() {
        return this.f9178u || this.f9176s || this.f9181x;
    }

    public void n() {
        synchronized (this) {
            try {
                this.f9159b.c();
                if (this.f9181x) {
                    q();
                    return;
                }
                if (this.f9158a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f9178u) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f9178u = true;
                U0.f fVar = this.f9169l;
                e<d> eVarE = this.f9158a.e();
                k(eVarE.size() + 1);
                this.f9163f.a(this, fVar, null);
                for (d dVar : eVarE) {
                    dVar.f9188b.execute(new a(dVar.f9187a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o() {
        synchronized (this) {
            try {
                this.f9159b.c();
                if (this.f9181x) {
                    this.f9174q.b();
                    q();
                    return;
                }
                if (this.f9158a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f9176s) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f9179v = this.f9162e.a(this.f9174q, this.f9170m, this.f9169l, this.f9160c);
                this.f9176s = true;
                e<d> eVarE = this.f9158a.e();
                k(eVarE.size() + 1);
                this.f9163f.a(this, this.f9169l, this.f9179v);
                for (d dVar : eVarE) {
                    dVar.f9188b.execute(new b(dVar.f9187a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean p() {
        return this.f9173p;
    }

    public synchronized void r(m1.g gVar) {
        try {
            this.f9159b.c();
            this.f9158a.h(gVar);
            if (this.f9158a.isEmpty()) {
                h();
                if (this.f9176s || this.f9178u) {
                    if (this.f9168k.get() == 0) {
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
            this.f9180w = hVar;
            (hVar.X() ? this.f9164g : j()).execute(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public l(Z0.a aVar, Z0.a aVar2, Z0.a aVar3, Z0.a aVar4, m mVar, p.a aVar5, S.d dVar, c cVar) {
        this.f9158a = new e();
        this.f9159b = AbstractC2672c.a();
        this.f9168k = new AtomicInteger();
        this.f9164g = aVar;
        this.f9165h = aVar2;
        this.f9166i = aVar3;
        this.f9167j = aVar4;
        this.f9163f = mVar;
        this.f9160c = aVar5;
        this.f9161d = dVar;
        this.f9162e = cVar;
    }
}
