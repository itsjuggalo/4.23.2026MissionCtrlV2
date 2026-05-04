package tb;

import io.flutter.plugins.firebase.database.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.p2;
import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f21082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f21083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f21084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public rb.k1 f21085d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f21087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f21088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f21089h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f21086e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f21090i = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21091a;

        public a(int i10) {
            this.f21091a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.b(this.f21091a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.n f21094a;

        public c(rb.n nVar) {
            this.f21094a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.a(this.f21094a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21096a;

        public d(boolean z10) {
            this.f21096a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.p(this.f21096a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.v f21098a;

        public e(rb.v vVar) {
            this.f21098a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.k(this.f21098a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21100a;

        public f(int i10) {
            this.f21100a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.c(this.f21100a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21102a;

        public g(int i10) {
            this.f21102a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.d(this.f21102a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.t f21104a;

        public h(rb.t tVar) {
            this.f21104a = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.g(this.f21104a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.s();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21107a;

        public j(String str) {
            this.f21107a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.h(this.f21107a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f21109a;

        public k(InputStream inputStream) {
            this.f21109a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.n(this.f21109a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.flush();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.k1 f21112a;

        public m(rb.k1 k1Var) {
            this.f21112a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.e(this.f21112a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f21084c.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class o implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f21115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f21116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f21117c = new ArrayList();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p2.a f21118a;

            public a(p2.a aVar) {
                this.f21118a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f21115a.a(this.f21118a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f21115a.b();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f21121a;

            public c(rb.y0 y0Var) {
                this.f21121a = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f21115a.c(this.f21121a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.k1 f21123a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s.a f21124b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f21125c;

            public d(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
                this.f21123a = k1Var;
                this.f21124b = aVar;
                this.f21125c = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f21115a.d(this.f21123a, this.f21124b, this.f21125c);
            }
        }

        public o(s sVar) {
            this.f21115a = sVar;
        }

        @Override // tb.p2
        public void a(p2.a aVar) {
            if (this.f21116b) {
                this.f21115a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // tb.p2
        public void b() {
            if (this.f21116b) {
                this.f21115a.b();
            } else {
                f(new b());
            }
        }

        @Override // tb.s
        public void c(rb.y0 y0Var) {
            f(new c(y0Var));
        }

        @Override // tb.s
        public void d(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
            f(new d(k1Var, aVar, y0Var));
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f21116b) {
                        runnable.run();
                    } else {
                        this.f21117c.add(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.f21117c.isEmpty()) {
                            this.f21117c = null;
                            this.f21116b = true;
                            return;
                        } else {
                            list = this.f21117c;
                            this.f21117c = arrayList;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    @Override // tb.o2
    public void a(rb.n nVar) {
        p6.n.u(this.f21083b == null, "May only be called before start");
        p6.n.o(nVar, "compressor");
        this.f21090i.add(new c(nVar));
    }

    @Override // tb.o2
    public void b(int i10) {
        p6.n.u(this.f21083b != null, "May only be called after start");
        if (this.f21082a) {
            this.f21084c.b(i10);
        } else {
            r(new a(i10));
        }
    }

    @Override // tb.r
    public void c(int i10) {
        p6.n.u(this.f21083b == null, "May only be called before start");
        this.f21090i.add(new f(i10));
    }

    @Override // tb.r
    public void d(int i10) {
        p6.n.u(this.f21083b == null, "May only be called before start");
        this.f21090i.add(new g(i10));
    }

    @Override // tb.r
    public void e(rb.k1 k1Var) {
        boolean z10 = false;
        p6.n.u(this.f21083b != null, "May only be called after start");
        p6.n.o(k1Var, "reason");
        synchronized (this) {
            try {
                if (this.f21084c == null) {
                    v(o1.f21564a);
                    this.f21085d = k1Var;
                } else {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            r(new m(k1Var));
            return;
        }
        s();
        u(k1Var);
        this.f21083b.d(k1Var, s.a.PROCESSED, new rb.y0());
    }

    @Override // tb.o2
    public boolean f() {
        if (this.f21082a) {
            return this.f21084c.f();
        }
        return false;
    }

    @Override // tb.o2
    public void flush() {
        p6.n.u(this.f21083b != null, "May only be called after start");
        if (this.f21082a) {
            this.f21084c.flush();
        } else {
            r(new l());
        }
    }

    @Override // tb.r
    public void g(rb.t tVar) {
        p6.n.u(this.f21083b == null, "May only be called before start");
        this.f21090i.add(new h(tVar));
    }

    @Override // tb.r
    public void h(String str) {
        p6.n.u(this.f21083b == null, "May only be called before start");
        p6.n.o(str, "authority");
        this.f21090i.add(new j(str));
    }

    @Override // tb.r
    public void i() {
        p6.n.u(this.f21083b != null, "May only be called after start");
        r(new n());
    }

    @Override // tb.r
    public void j(s sVar) {
        rb.k1 k1Var;
        boolean z10;
        p6.n.o(sVar, "listener");
        p6.n.u(this.f21083b == null, "already started");
        synchronized (this) {
            try {
                k1Var = this.f21085d;
                z10 = this.f21082a;
                if (!z10) {
                    o oVar = new o(sVar);
                    this.f21087f = oVar;
                    sVar = oVar;
                }
                this.f21083b = sVar;
                this.f21088g = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (k1Var != null) {
            sVar.d(k1Var, s.a.PROCESSED, new rb.y0());
        } else if (z10) {
            t(sVar);
        }
    }

    @Override // tb.r
    public void k(rb.v vVar) {
        p6.n.u(this.f21083b == null, "May only be called before start");
        p6.n.o(vVar, "decompressorRegistry");
        this.f21090i.add(new e(vVar));
    }

    @Override // tb.r
    public void l(x0 x0Var) {
        synchronized (this) {
            try {
                if (this.f21083b == null) {
                    return;
                }
                if (this.f21084c != null) {
                    x0Var.b("buffered_nanos", Long.valueOf(this.f21089h - this.f21088g));
                    this.f21084c.l(x0Var);
                } else {
                    x0Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f21088g));
                    x0Var.a("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // tb.o2
    public void n(InputStream inputStream) {
        p6.n.u(this.f21083b != null, "May only be called after start");
        p6.n.o(inputStream, Constants.ERROR_MESSAGE);
        if (this.f21082a) {
            this.f21084c.n(inputStream);
        } else {
            r(new k(inputStream));
        }
    }

    @Override // tb.o2
    public void o() {
        p6.n.u(this.f21083b == null, "May only be called before start");
        this.f21090i.add(new b());
    }

    @Override // tb.r
    public void p(boolean z10) {
        p6.n.u(this.f21083b == null, "May only be called before start");
        this.f21090i.add(new d(z10));
    }

    public final void r(Runnable runnable) {
        p6.n.u(this.f21083b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f21082a) {
                    runnable.run();
                } else {
                    this.f21086e.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f21086e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.f21086e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f21082a = r0     // Catch: java.lang.Throwable -> L1d
            tb.c0$o r0 = r3.f21087f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.g()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List r1 = r3.f21086e     // Catch: java.lang.Throwable -> L1d
            r3.f21086e = r0     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            java.util.Iterator r0 = r1.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L38
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L28
        L38:
            r1.clear()
            r0 = r1
            goto L5
        L3d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.c0.s():void");
    }

    public final void t(s sVar) {
        Iterator it = this.f21090i.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f21090i = null;
        this.f21084c.j(sVar);
    }

    public final void v(r rVar) {
        r rVar2 = this.f21084c;
        p6.n.x(rVar2 == null, "realStream already set to %s", rVar2);
        this.f21084c = rVar;
        this.f21089h = System.nanoTime();
    }

    public final Runnable w(r rVar) {
        synchronized (this) {
            try {
                if (this.f21084c != null) {
                    return null;
                }
                v((r) p6.n.o(rVar, "stream"));
                s sVar = this.f21083b;
                if (sVar == null) {
                    this.f21086e = null;
                    this.f21082a = true;
                }
                if (sVar == null) {
                    return null;
                }
                t(sVar);
                return new i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void u(rb.k1 k1Var) {
    }
}
