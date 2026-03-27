package M2;

import K2.C0353a;
import K2.C0371t;
import K2.C0373v;
import K2.InterfaceC0366n;
import M2.InterfaceC0443s;
import M2.Q0;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class C implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f1689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0443s f1690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f1691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public K2.l0 f1692d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f1694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1696h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f1693e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f1697i = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1698a;

        public a(int i4) {
            this.f1698a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.e(this.f1698a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.q();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0366n f1701a;

        public c(InterfaceC0366n interfaceC0366n) {
            this.f1701a = interfaceC0366n;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.b(this.f1701a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1703a;

        public d(boolean z4) {
            this.f1703a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.r(this.f1703a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0373v f1705a;

        public e(C0373v c0373v) {
            this.f1705a = c0373v;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.o(this.f1705a);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1707a;

        public f(boolean z4) {
            this.f1707a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.a(this.f1707a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1709a;

        public g(int i4) {
            this.f1709a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.f(this.f1709a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1711a;

        public h(int i4) {
            this.f1711a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.g(this.f1711a);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0371t f1713a;

        public i(C0371t c0371t) {
            this.f1713a = c0371t;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.h(this.f1713a);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.u();
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1716a;

        public k(String str) {
            this.f1716a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.l(this.f1716a);
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f1718a;

        public l(InputStream inputStream) {
            this.f1718a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.p(this.f1718a);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.flush();
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.l0 f1721a;

        public n(K2.l0 l0Var) {
            this.f1721a = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.c(this.f1721a);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f1691c.m();
        }
    }

    public static class p implements InterfaceC0443s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0443s f1724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f1725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f1726c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Q0.a f1727a;

            public a(Q0.a aVar) {
                this.f1727a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f1724a.a(this.f1727a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f1724a.c();
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.Z f1730a;

            public c(K2.Z z4) {
                this.f1730a = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f1724a.d(this.f1730a);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.l0 f1732a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InterfaceC0443s.a f1733b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ K2.Z f1734c;

            public d(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
                this.f1732a = l0Var;
                this.f1733b = aVar;
                this.f1734c = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f1724a.b(this.f1732a, this.f1733b, this.f1734c);
            }
        }

        public p(InterfaceC0443s interfaceC0443s) {
            this.f1724a = interfaceC0443s;
        }

        @Override // M2.Q0
        public void a(Q0.a aVar) {
            if (this.f1725b) {
                this.f1724a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // M2.InterfaceC0443s
        public void b(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
            f(new d(l0Var, aVar, z4));
        }

        @Override // M2.Q0
        public void c() {
            if (this.f1725b) {
                this.f1724a.c();
            } else {
                f(new b());
            }
        }

        @Override // M2.InterfaceC0443s
        public void d(K2.Z z4) {
            f(new c(z4));
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f1725b) {
                        runnable.run();
                    } else {
                        this.f1726c.add(runnable);
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
                        if (this.f1726c.isEmpty()) {
                            this.f1726c = null;
                            this.f1725b = true;
                            return;
                        } else {
                            list = this.f1726c;
                            this.f1726c = arrayList;
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

    @Override // M2.P0
    public void a(boolean z4) {
        Z1.m.u(this.f1690b != null, "May only be called after start");
        if (this.f1689a) {
            this.f1691c.a(z4);
        } else {
            t(new f(z4));
        }
    }

    @Override // M2.P0
    public void b(InterfaceC0366n interfaceC0366n) {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        Z1.m.o(interfaceC0366n, "compressor");
        this.f1697i.add(new c(interfaceC0366n));
    }

    @Override // M2.r
    public void c(K2.l0 l0Var) {
        boolean z4 = false;
        Z1.m.u(this.f1690b != null, "May only be called after start");
        Z1.m.o(l0Var, Constants.REASON);
        synchronized (this) {
            try {
                if (this.f1691c == null) {
                    x(C0439p0.f2553a);
                    this.f1692d = l0Var;
                } else {
                    z4 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            t(new n(l0Var));
            return;
        }
        u();
        w(l0Var);
        this.f1690b.b(l0Var, InterfaceC0443s.a.PROCESSED, new K2.Z());
    }

    @Override // M2.r
    public C0353a d() {
        r rVar;
        synchronized (this) {
            rVar = this.f1691c;
        }
        return rVar != null ? rVar.d() : C0353a.f1111c;
    }

    @Override // M2.P0
    public void e(int i4) {
        Z1.m.u(this.f1690b != null, "May only be called after start");
        if (this.f1689a) {
            this.f1691c.e(i4);
        } else {
            t(new a(i4));
        }
    }

    @Override // M2.r
    public void f(int i4) {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        this.f1697i.add(new g(i4));
    }

    @Override // M2.P0
    public void flush() {
        Z1.m.u(this.f1690b != null, "May only be called after start");
        if (this.f1689a) {
            this.f1691c.flush();
        } else {
            t(new m());
        }
    }

    @Override // M2.r
    public void g(int i4) {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        this.f1697i.add(new h(i4));
    }

    @Override // M2.r
    public void h(C0371t c0371t) {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        this.f1697i.add(new i(c0371t));
    }

    @Override // M2.r
    public void i(InterfaceC0443s interfaceC0443s) {
        K2.l0 l0Var;
        boolean z4;
        Z1.m.o(interfaceC0443s, "listener");
        Z1.m.u(this.f1690b == null, "already started");
        synchronized (this) {
            try {
                l0Var = this.f1692d;
                z4 = this.f1689a;
                if (!z4) {
                    p pVar = new p(interfaceC0443s);
                    this.f1694f = pVar;
                    interfaceC0443s = pVar;
                }
                this.f1690b = interfaceC0443s;
                this.f1695g = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (l0Var != null) {
            interfaceC0443s.b(l0Var, InterfaceC0443s.a.PROCESSED, new K2.Z());
        } else if (z4) {
            v(interfaceC0443s);
        }
    }

    @Override // M2.P0
    public boolean j() {
        if (this.f1689a) {
            return this.f1691c.j();
        }
        return false;
    }

    @Override // M2.r
    public void l(String str) {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        Z1.m.o(str, "authority");
        this.f1697i.add(new k(str));
    }

    @Override // M2.r
    public void m() {
        Z1.m.u(this.f1690b != null, "May only be called after start");
        t(new o());
    }

    @Override // M2.r
    public void n(Y y4) {
        synchronized (this) {
            try {
                if (this.f1690b == null) {
                    return;
                }
                if (this.f1691c != null) {
                    y4.b("buffered_nanos", Long.valueOf(this.f1696h - this.f1695g));
                    this.f1691c.n(y4);
                } else {
                    y4.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f1695g));
                    y4.a("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // M2.r
    public void o(C0373v c0373v) {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        Z1.m.o(c0373v, "decompressorRegistry");
        this.f1697i.add(new e(c0373v));
    }

    @Override // M2.P0
    public void p(InputStream inputStream) {
        Z1.m.u(this.f1690b != null, "May only be called after start");
        Z1.m.o(inputStream, Constants.MESSAGE);
        if (this.f1689a) {
            this.f1691c.p(inputStream);
        } else {
            t(new l(inputStream));
        }
    }

    @Override // M2.P0
    public void q() {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        this.f1697i.add(new b());
    }

    @Override // M2.r
    public void r(boolean z4) {
        Z1.m.u(this.f1690b == null, "May only be called before start");
        this.f1697i.add(new d(z4));
    }

    public final void t(Runnable runnable) {
        Z1.m.u(this.f1690b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f1689a) {
                    runnable.run();
                } else {
                    this.f1693e.add(runnable);
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
    public final void u() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f1693e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.f1693e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f1689a = r0     // Catch: java.lang.Throwable -> L1d
            M2.C$p r0 = r3.f1694f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.g()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List r1 = r3.f1693e     // Catch: java.lang.Throwable -> L1d
            r3.f1693e = r0     // Catch: java.lang.Throwable -> L1d
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
        throw new UnsupportedOperationException("Method not decompiled: M2.C.u():void");
    }

    public final void v(InterfaceC0443s interfaceC0443s) {
        Iterator it = this.f1697i.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f1697i = null;
        this.f1691c.i(interfaceC0443s);
    }

    public final void x(r rVar) {
        r rVar2 = this.f1691c;
        Z1.m.w(rVar2 == null, "realStream already set to %s", rVar2);
        this.f1691c = rVar;
        this.f1696h = System.nanoTime();
    }

    public final Runnable y(r rVar) {
        synchronized (this) {
            try {
                if (this.f1691c != null) {
                    return null;
                }
                x((r) Z1.m.o(rVar, "stream"));
                InterfaceC0443s interfaceC0443s = this.f1690b;
                if (interfaceC0443s == null) {
                    this.f1693e = null;
                    this.f1689a = true;
                }
                if (interfaceC0443s == null) {
                    return null;
                }
                v(interfaceC0443s);
                return new j();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w(K2.l0 l0Var) {
    }
}
