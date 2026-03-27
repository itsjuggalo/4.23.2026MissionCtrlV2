package G4;

import F4.C0505t;
import F4.C0507v;
import F4.InterfaceC0500n;
import G4.InterfaceC0551s;
import G4.Q0;
import io.flutter.plugins.firebase.database.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class C implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f2281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0551s f2282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f2283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public F4.j0 f2284d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f2286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2288h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f2285e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f2289i = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2290a;

        public a(int i8) {
            this.f2290a = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.e(this.f2290a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.p();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0500n f2293a;

        public c(InterfaceC0500n interfaceC0500n) {
            this.f2293a = interfaceC0500n;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.b(this.f2293a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2295a;

        public d(boolean z7) {
            this.f2295a = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.q(this.f2295a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0507v f2297a;

        public e(C0507v c0507v) {
            this.f2297a = c0507v;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.l(this.f2297a);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2299a;

        public f(int i8) {
            this.f2299a = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.f(this.f2299a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2301a;

        public g(int i8) {
            this.f2301a = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.g(this.f2301a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0505t f2303a;

        public h(C0505t c0505t) {
            this.f2303a = c0505t;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.h(this.f2303a);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.t();
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2306a;

        public j(String str) {
            this.f2306a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.j(this.f2306a);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f2308a;

        public k(InputStream inputStream) {
            this.f2308a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.o(this.f2308a);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.flush();
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ F4.j0 f2311a;

        public m(F4.j0 j0Var) {
            this.f2311a = j0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.a(this.f2311a);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f2283c.k();
        }
    }

    public static class o implements InterfaceC0551s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0551s f2314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f2315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f2316c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Q0.a f2317a;

            public a(Q0.a aVar) {
                this.f2317a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f2314a.a(this.f2317a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f2314a.d();
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ F4.X f2320a;

            public c(F4.X x8) {
                this.f2320a = x8;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f2314a.b(this.f2320a);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ F4.j0 f2322a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InterfaceC0551s.a f2323b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ F4.X f2324c;

            public d(F4.j0 j0Var, InterfaceC0551s.a aVar, F4.X x8) {
                this.f2322a = j0Var;
                this.f2323b = aVar;
                this.f2324c = x8;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f2314a.c(this.f2322a, this.f2323b, this.f2324c);
            }
        }

        public o(InterfaceC0551s interfaceC0551s) {
            this.f2314a = interfaceC0551s;
        }

        @Override // G4.Q0
        public void a(Q0.a aVar) {
            if (this.f2315b) {
                this.f2314a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // G4.InterfaceC0551s
        public void b(F4.X x8) {
            f(new c(x8));
        }

        @Override // G4.InterfaceC0551s
        public void c(F4.j0 j0Var, InterfaceC0551s.a aVar, F4.X x8) {
            f(new d(j0Var, aVar, x8));
        }

        @Override // G4.Q0
        public void d() {
            if (this.f2315b) {
                this.f2314a.d();
            } else {
                f(new b());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f2315b) {
                        runnable.run();
                    } else {
                        this.f2316c.add(runnable);
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
                        if (this.f2316c.isEmpty()) {
                            this.f2316c = null;
                            this.f2315b = true;
                            return;
                        } else {
                            list = this.f2316c;
                            this.f2316c = arrayList;
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

    @Override // G4.r
    public void a(F4.j0 j0Var) {
        boolean z7 = false;
        AbstractC2848n.u(this.f2282b != null, "May only be called after start");
        AbstractC2848n.o(j0Var, "reason");
        synchronized (this) {
            try {
                if (this.f2283c == null) {
                    w(C0547p0.f3131a);
                    this.f2284d = j0Var;
                } else {
                    z7 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            s(new m(j0Var));
            return;
        }
        t();
        v(j0Var);
        this.f2282b.c(j0Var, InterfaceC0551s.a.PROCESSED, new F4.X());
    }

    @Override // G4.P0
    public void b(InterfaceC0500n interfaceC0500n) {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        AbstractC2848n.o(interfaceC0500n, "compressor");
        this.f2289i.add(new c(interfaceC0500n));
    }

    @Override // G4.P0
    public boolean d() {
        if (this.f2281a) {
            return this.f2283c.d();
        }
        return false;
    }

    @Override // G4.P0
    public void e(int i8) {
        AbstractC2848n.u(this.f2282b != null, "May only be called after start");
        if (this.f2281a) {
            this.f2283c.e(i8);
        } else {
            s(new a(i8));
        }
    }

    @Override // G4.r
    public void f(int i8) {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        this.f2289i.add(new f(i8));
    }

    @Override // G4.P0
    public void flush() {
        AbstractC2848n.u(this.f2282b != null, "May only be called after start");
        if (this.f2281a) {
            this.f2283c.flush();
        } else {
            s(new l());
        }
    }

    @Override // G4.r
    public void g(int i8) {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        this.f2289i.add(new g(i8));
    }

    @Override // G4.r
    public void h(C0505t c0505t) {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        this.f2289i.add(new h(c0505t));
    }

    @Override // G4.r
    public void i(InterfaceC0551s interfaceC0551s) {
        F4.j0 j0Var;
        boolean z7;
        AbstractC2848n.o(interfaceC0551s, "listener");
        AbstractC2848n.u(this.f2282b == null, "already started");
        synchronized (this) {
            try {
                j0Var = this.f2284d;
                z7 = this.f2281a;
                if (!z7) {
                    o oVar = new o(interfaceC0551s);
                    this.f2286f = oVar;
                    interfaceC0551s = oVar;
                }
                this.f2282b = interfaceC0551s;
                this.f2287g = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (j0Var != null) {
            interfaceC0551s.c(j0Var, InterfaceC0551s.a.PROCESSED, new F4.X());
        } else if (z7) {
            u(interfaceC0551s);
        }
    }

    @Override // G4.r
    public void j(String str) {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        AbstractC2848n.o(str, "authority");
        this.f2289i.add(new j(str));
    }

    @Override // G4.r
    public void k() {
        AbstractC2848n.u(this.f2282b != null, "May only be called after start");
        s(new n());
    }

    @Override // G4.r
    public void l(C0507v c0507v) {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        AbstractC2848n.o(c0507v, "decompressorRegistry");
        this.f2289i.add(new e(c0507v));
    }

    @Override // G4.r
    public void m(Y y7) {
        synchronized (this) {
            try {
                if (this.f2282b == null) {
                    return;
                }
                if (this.f2283c != null) {
                    y7.b("buffered_nanos", Long.valueOf(this.f2288h - this.f2287g));
                    this.f2283c.m(y7);
                } else {
                    y7.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f2287g));
                    y7.a("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // G4.P0
    public void o(InputStream inputStream) {
        AbstractC2848n.u(this.f2282b != null, "May only be called after start");
        AbstractC2848n.o(inputStream, Constants.ERROR_MESSAGE);
        if (this.f2281a) {
            this.f2283c.o(inputStream);
        } else {
            s(new k(inputStream));
        }
    }

    @Override // G4.P0
    public void p() {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        this.f2289i.add(new b());
    }

    @Override // G4.r
    public void q(boolean z7) {
        AbstractC2848n.u(this.f2282b == null, "May only be called before start");
        this.f2289i.add(new d(z7));
    }

    public final void s(Runnable runnable) {
        AbstractC2848n.u(this.f2282b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f2281a) {
                    runnable.run();
                } else {
                    this.f2285e.add(runnable);
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
    public final void t() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f2285e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.f2285e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f2281a = r0     // Catch: java.lang.Throwable -> L1d
            G4.C$o r0 = r3.f2286f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.g()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List r1 = r3.f2285e     // Catch: java.lang.Throwable -> L1d
            r3.f2285e = r0     // Catch: java.lang.Throwable -> L1d
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
        throw new UnsupportedOperationException("Method not decompiled: G4.C.t():void");
    }

    public final void u(InterfaceC0551s interfaceC0551s) {
        Iterator it = this.f2289i.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f2289i = null;
        this.f2283c.i(interfaceC0551s);
    }

    public final void w(r rVar) {
        r rVar2 = this.f2283c;
        AbstractC2848n.x(rVar2 == null, "realStream already set to %s", rVar2);
        this.f2283c = rVar;
        this.f2288h = System.nanoTime();
    }

    public final Runnable x(r rVar) {
        synchronized (this) {
            try {
                if (this.f2283c != null) {
                    return null;
                }
                w((r) AbstractC2848n.o(rVar, "stream"));
                InterfaceC0551s interfaceC0551s = this.f2282b;
                if (interfaceC0551s == null) {
                    this.f2285e = null;
                    this.f2281a = true;
                }
                if (interfaceC0551s == null) {
                    return null;
                }
                u(interfaceC0551s);
                return new i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v(F4.j0 j0Var) {
    }
}
