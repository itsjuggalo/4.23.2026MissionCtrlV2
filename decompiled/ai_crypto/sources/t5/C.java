package t5;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r5.C2603t;
import r5.C2605v;
import r5.InterfaceC2598n;
import t5.InterfaceC2698s;
import t5.Q0;

/* JADX INFO: loaded from: classes2.dex */
public class C implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f23244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC2698s f23245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f23246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r5.l0 f23247d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f23249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f23250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f23251h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f23248e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f23252i = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23253a;

        public a(int i7) {
            this.f23253a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.h(this.f23253a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.g();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2598n f23256a;

        public c(InterfaceC2598n interfaceC2598n) {
            this.f23256a = interfaceC2598n;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.a(this.f23256a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f23258a;

        public d(boolean z7) {
            this.f23258a = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.q(this.f23258a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2605v f23260a;

        public e(C2605v c2605v) {
            this.f23260a = c2605v;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.o(this.f23260a);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23262a;

        public f(int i7) {
            this.f23262a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.i(this.f23262a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23264a;

        public g(int i7) {
            this.f23264a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.j(this.f23264a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2603t f23266a;

        public h(C2603t c2603t) {
            this.f23266a = c2603t;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.p(this.f23266a);
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
        public final /* synthetic */ String f23269a;

        public j(String str) {
            this.f23269a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.l(this.f23269a);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f23271a;

        public k(InputStream inputStream) {
            this.f23271a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.e(this.f23271a);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.flush();
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r5.l0 f23274a;

        public m(r5.l0 l0Var) {
            this.f23274a = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.b(this.f23274a);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C.this.f23246c.m();
        }
    }

    public static class o implements InterfaceC2698s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2698s f23277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f23278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f23279c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Q0.a f23280a;

            public a(Q0.a aVar) {
                this.f23280a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f23277a.a(this.f23280a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f23277a.c();
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r5.Z f23283a;

            public c(r5.Z z7) {
                this.f23283a = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f23277a.d(this.f23283a);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r5.l0 f23285a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InterfaceC2698s.a f23286b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ r5.Z f23287c;

            public d(r5.l0 l0Var, InterfaceC2698s.a aVar, r5.Z z7) {
                this.f23285a = l0Var;
                this.f23286b = aVar;
                this.f23287c = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f23277a.b(this.f23285a, this.f23286b, this.f23287c);
            }
        }

        public o(InterfaceC2698s interfaceC2698s) {
            this.f23277a = interfaceC2698s;
        }

        @Override // t5.Q0
        public void a(Q0.a aVar) {
            if (this.f23278b) {
                this.f23277a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // t5.InterfaceC2698s
        public void b(r5.l0 l0Var, InterfaceC2698s.a aVar, r5.Z z7) {
            f(new d(l0Var, aVar, z7));
        }

        @Override // t5.Q0
        public void c() {
            if (this.f23278b) {
                this.f23277a.c();
            } else {
                f(new b());
            }
        }

        @Override // t5.InterfaceC2698s
        public void d(r5.Z z7) {
            f(new c(z7));
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f23278b) {
                        runnable.run();
                    } else {
                        this.f23279c.add(runnable);
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
                        if (this.f23279c.isEmpty()) {
                            this.f23279c = null;
                            this.f23278b = true;
                            return;
                        } else {
                            list = this.f23279c;
                            this.f23279c = arrayList;
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

    @Override // t5.P0
    public void a(InterfaceC2598n interfaceC2598n) {
        H2.m.u(this.f23245b == null, "May only be called before start");
        H2.m.o(interfaceC2598n, "compressor");
        this.f23252i.add(new c(interfaceC2598n));
    }

    @Override // t5.r
    public void b(r5.l0 l0Var) {
        boolean z7 = false;
        H2.m.u(this.f23245b != null, "May only be called after start");
        H2.m.o(l0Var, "reason");
        synchronized (this) {
            try {
                if (this.f23246c == null) {
                    w(C2694p0.f24104a);
                    this.f23247d = l0Var;
                } else {
                    z7 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            s(new m(l0Var));
            return;
        }
        t();
        v(l0Var);
        this.f23245b.b(l0Var, InterfaceC2698s.a.PROCESSED, new r5.Z());
    }

    @Override // t5.P0
    public boolean d() {
        if (this.f23244a) {
            return this.f23246c.d();
        }
        return false;
    }

    @Override // t5.P0
    public void e(InputStream inputStream) {
        H2.m.u(this.f23245b != null, "May only be called after start");
        H2.m.o(inputStream, "message");
        if (this.f23244a) {
            this.f23246c.e(inputStream);
        } else {
            s(new k(inputStream));
        }
    }

    @Override // t5.P0
    public void flush() {
        H2.m.u(this.f23245b != null, "May only be called after start");
        if (this.f23244a) {
            this.f23246c.flush();
        } else {
            s(new l());
        }
    }

    @Override // t5.P0
    public void g() {
        H2.m.u(this.f23245b == null, "May only be called before start");
        this.f23252i.add(new b());
    }

    @Override // t5.P0
    public void h(int i7) {
        H2.m.u(this.f23245b != null, "May only be called after start");
        if (this.f23244a) {
            this.f23246c.h(i7);
        } else {
            s(new a(i7));
        }
    }

    @Override // t5.r
    public void i(int i7) {
        H2.m.u(this.f23245b == null, "May only be called before start");
        this.f23252i.add(new f(i7));
    }

    @Override // t5.r
    public void j(int i7) {
        H2.m.u(this.f23245b == null, "May only be called before start");
        this.f23252i.add(new g(i7));
    }

    @Override // t5.r
    public void k(Y y7) {
        synchronized (this) {
            try {
                if (this.f23245b == null) {
                    return;
                }
                if (this.f23246c != null) {
                    y7.b("buffered_nanos", Long.valueOf(this.f23251h - this.f23250g));
                    this.f23246c.k(y7);
                } else {
                    y7.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f23250g));
                    y7.a("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t5.r
    public void l(String str) {
        H2.m.u(this.f23245b == null, "May only be called before start");
        H2.m.o(str, "authority");
        this.f23252i.add(new j(str));
    }

    @Override // t5.r
    public void m() {
        H2.m.u(this.f23245b != null, "May only be called after start");
        s(new n());
    }

    @Override // t5.r
    public void n(InterfaceC2698s interfaceC2698s) {
        r5.l0 l0Var;
        boolean z7;
        H2.m.o(interfaceC2698s, "listener");
        H2.m.u(this.f23245b == null, "already started");
        synchronized (this) {
            try {
                l0Var = this.f23247d;
                z7 = this.f23244a;
                if (!z7) {
                    o oVar = new o(interfaceC2698s);
                    this.f23249f = oVar;
                    interfaceC2698s = oVar;
                }
                this.f23245b = interfaceC2698s;
                this.f23250g = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (l0Var != null) {
            interfaceC2698s.b(l0Var, InterfaceC2698s.a.PROCESSED, new r5.Z());
        } else if (z7) {
            u(interfaceC2698s);
        }
    }

    @Override // t5.r
    public void o(C2605v c2605v) {
        H2.m.u(this.f23245b == null, "May only be called before start");
        H2.m.o(c2605v, "decompressorRegistry");
        this.f23252i.add(new e(c2605v));
    }

    @Override // t5.r
    public void p(C2603t c2603t) {
        H2.m.u(this.f23245b == null, "May only be called before start");
        this.f23252i.add(new h(c2603t));
    }

    @Override // t5.r
    public void q(boolean z7) {
        H2.m.u(this.f23245b == null, "May only be called before start");
        this.f23252i.add(new d(z7));
    }

    public final void s(Runnable runnable) {
        H2.m.u(this.f23245b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f23244a) {
                    runnable.run();
                } else {
                    this.f23248e.add(runnable);
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
            java.util.List r1 = r3.f23248e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.f23248e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f23244a = r0     // Catch: java.lang.Throwable -> L1d
            t5.C$o r0 = r3.f23249f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.g()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List r1 = r3.f23248e     // Catch: java.lang.Throwable -> L1d
            r3.f23248e = r0     // Catch: java.lang.Throwable -> L1d
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
        throw new UnsupportedOperationException("Method not decompiled: t5.C.t():void");
    }

    public final void u(InterfaceC2698s interfaceC2698s) {
        Iterator it = this.f23252i.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f23252i = null;
        this.f23246c.n(interfaceC2698s);
    }

    public final void w(r rVar) {
        r rVar2 = this.f23246c;
        H2.m.w(rVar2 == null, "realStream already set to %s", rVar2);
        this.f23246c = rVar;
        this.f23251h = System.nanoTime();
    }

    public final Runnable x(r rVar) {
        synchronized (this) {
            try {
                if (this.f23246c != null) {
                    return null;
                }
                w((r) H2.m.o(rVar, "stream"));
                InterfaceC2698s interfaceC2698s = this.f23245b;
                if (interfaceC2698s == null) {
                    this.f23248e = null;
                    this.f23244a = true;
                }
                if (interfaceC2698s == null) {
                    return null;
                }
                u(interfaceC2698s);
                return new i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v(r5.l0 l0Var) {
    }
}
