package M2;

import K2.AbstractC0358f;
import K2.AbstractC0363k;
import K2.C0353a;
import K2.C0355c;
import K2.C0369q;
import K2.C0375x;
import K2.EnumC0368p;
import K2.p0;
import M2.InterfaceC0426j;
import M2.InterfaceC0431l0;
import M2.InterfaceC0443s;
import M2.InterfaceC0447u;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class Z implements K2.J, T0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.K f2063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0426j.a f2066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f2067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC0447u f2068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f2069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final K2.E f2070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C0434n f2071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0438p f2072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AbstractC0358f f2073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f2074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final K2.p0 f2075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f2076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile List f2077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public InterfaceC0426j f2078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Z1.p f2079q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p0.d f2080r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public p0.d f2081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public InterfaceC0431l0 f2082t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public InterfaceC0451w f2085w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile InterfaceC0431l0 f2086x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public K2.l0 f2088z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Collection f2083u = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final X f2084v = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile C0369q f2087y = C0369q.a(EnumC0368p.IDLE);

    public class a extends X {
        public a() {
        }

        @Override // M2.X
        public void b() {
            Z.this.f2067e.a(Z.this);
        }

        @Override // M2.X
        public void c() {
            Z.this.f2067e.b(Z.this);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Z.this.f2080r = null;
            Z.this.f2073k.a(AbstractC0358f.a.INFO, "CONNECTING after backoff");
            Z.this.O(EnumC0368p.CONNECTING);
            Z.this.U();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Z.this.f2087y.c() == EnumC0368p.IDLE) {
                Z.this.f2073k.a(AbstractC0358f.a.INFO, "CONNECTING as requested");
                Z.this.O(EnumC0368p.CONNECTING);
                Z.this.U();
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f2092a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0431l0 interfaceC0431l0 = Z.this.f2082t;
                Z.this.f2081s = null;
                Z.this.f2082t = null;
                interfaceC0431l0.e(K2.l0.f1230t.q("InternalSubchannel closed transport due to address change"));
            }
        }

        public d(List list) {
            this.f2092a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0431l0 interfaceC0431l0;
            SocketAddress socketAddressA = Z.this.f2076n.a();
            Z.this.f2076n.h(this.f2092a);
            Z.this.f2077o = this.f2092a;
            EnumC0368p enumC0368pC = Z.this.f2087y.c();
            EnumC0368p enumC0368p = EnumC0368p.READY;
            if ((enumC0368pC != enumC0368p && Z.this.f2087y.c() != EnumC0368p.CONNECTING) || Z.this.f2076n.g(socketAddressA)) {
                interfaceC0431l0 = null;
            } else if (Z.this.f2087y.c() == enumC0368p) {
                interfaceC0431l0 = Z.this.f2086x;
                Z.this.f2086x = null;
                Z.this.f2076n.f();
                Z.this.O(EnumC0368p.IDLE);
            } else {
                Z.this.f2085w.e(K2.l0.f1230t.q("InternalSubchannel closed pending transport due to address change"));
                Z.this.f2085w = null;
                Z.this.f2076n.f();
                Z.this.U();
                interfaceC0431l0 = null;
            }
            if (interfaceC0431l0 != null) {
                if (Z.this.f2081s != null) {
                    Z.this.f2082t.e(K2.l0.f1230t.q("InternalSubchannel closed transport early due to address change"));
                    Z.this.f2081s.a();
                    Z.this.f2081s = null;
                    Z.this.f2082t = null;
                }
                Z.this.f2082t = interfaceC0431l0;
                Z z4 = Z.this;
                z4.f2081s = z4.f2075m.c(new a(), 5L, TimeUnit.SECONDS, Z.this.f2069g);
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.l0 f2095a;

        public e(K2.l0 l0Var) {
            this.f2095a = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            EnumC0368p enumC0368pC = Z.this.f2087y.c();
            EnumC0368p enumC0368p = EnumC0368p.SHUTDOWN;
            if (enumC0368pC == enumC0368p) {
                return;
            }
            Z.this.f2088z = this.f2095a;
            InterfaceC0431l0 interfaceC0431l0 = Z.this.f2086x;
            InterfaceC0451w interfaceC0451w = Z.this.f2085w;
            Z.this.f2086x = null;
            Z.this.f2085w = null;
            Z.this.O(enumC0368p);
            Z.this.f2076n.f();
            if (Z.this.f2083u.isEmpty()) {
                Z.this.Q();
            }
            Z.this.M();
            if (Z.this.f2081s != null) {
                Z.this.f2081s.a();
                Z.this.f2082t.e(this.f2095a);
                Z.this.f2081s = null;
                Z.this.f2082t = null;
            }
            if (interfaceC0431l0 != null) {
                interfaceC0431l0.e(this.f2095a);
            }
            if (interfaceC0451w != null) {
                interfaceC0451w.e(this.f2095a);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Z.this.f2073k.a(AbstractC0358f.a.INFO, "Terminated");
            Z.this.f2067e.d(Z.this);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0451w f2098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f2099b;

        public g(InterfaceC0451w interfaceC0451w, boolean z4) {
            this.f2098a = interfaceC0451w;
            this.f2099b = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Z.this.f2084v.e(this.f2098a, this.f2099b);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.l0 f2101a;

        public h(K2.l0 l0Var) {
            this.f2101a = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(Z.this.f2083u).iterator();
            while (it.hasNext()) {
                ((InterfaceC0431l0) it.next()).b(this.f2101a);
            }
        }
    }

    public static final class i extends K {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0451w f2103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0434n f2104b;

        public class a extends I {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r f2105a;

            /* JADX INFO: renamed from: M2.Z$i$a$a, reason: collision with other inner class name */
            public class C0040a extends J {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ InterfaceC0443s f2107a;

                public C0040a(InterfaceC0443s interfaceC0443s) {
                    this.f2107a = interfaceC0443s;
                }

                @Override // M2.J, M2.InterfaceC0443s
                public void b(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
                    i.this.f2104b.a(l0Var.o());
                    super.b(l0Var, aVar, z4);
                }

                @Override // M2.J
                public InterfaceC0443s e() {
                    return this.f2107a;
                }
            }

            public a(r rVar) {
                this.f2105a = rVar;
            }

            @Override // M2.I, M2.r
            public void i(InterfaceC0443s interfaceC0443s) {
                i.this.f2104b.b();
                super.i(new C0040a(interfaceC0443s));
            }

            @Override // M2.I
            public r k() {
                return this.f2105a;
            }
        }

        public /* synthetic */ i(InterfaceC0451w interfaceC0451w, C0434n c0434n, a aVar) {
            this(interfaceC0451w, c0434n);
        }

        @Override // M2.K
        public InterfaceC0451w a() {
            return this.f2103a;
        }

        @Override // M2.K, M2.InterfaceC0445t
        public r c(K2.a0 a0Var, K2.Z z4, C0355c c0355c, AbstractC0363k[] abstractC0363kArr) {
            return new a(super.c(a0Var, z4, c0355c, abstractC0363kArr));
        }

        public i(InterfaceC0451w interfaceC0451w, C0434n c0434n) {
            this.f2103a = interfaceC0451w;
            this.f2104b = c0434n;
        }
    }

    public static abstract class j {
        public abstract void a(Z z4);

        public abstract void b(Z z4);

        public abstract void c(Z z4, C0369q c0369q);

        public abstract void d(Z z4);
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f2109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2111c;

        public k(List list) {
            this.f2109a = list;
        }

        public SocketAddress a() {
            return (SocketAddress) ((C0375x) this.f2109a.get(this.f2110b)).a().get(this.f2111c);
        }

        public C0353a b() {
            return ((C0375x) this.f2109a.get(this.f2110b)).b();
        }

        public void c() {
            C0375x c0375x = (C0375x) this.f2109a.get(this.f2110b);
            int i4 = this.f2111c + 1;
            this.f2111c = i4;
            if (i4 >= c0375x.a().size()) {
                this.f2110b++;
                this.f2111c = 0;
            }
        }

        public boolean d() {
            return this.f2110b == 0 && this.f2111c == 0;
        }

        public boolean e() {
            return this.f2110b < this.f2109a.size();
        }

        public void f() {
            this.f2110b = 0;
            this.f2111c = 0;
        }

        public boolean g(SocketAddress socketAddress) {
            for (int i4 = 0; i4 < this.f2109a.size(); i4++) {
                int iIndexOf = ((C0375x) this.f2109a.get(i4)).a().indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f2110b = i4;
                    this.f2111c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List list) {
            this.f2109a = list;
            f();
        }
    }

    public class l implements InterfaceC0431l0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0451w f2112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2113b = false;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Z.this.f2078p = null;
                if (Z.this.f2088z != null) {
                    Z1.m.u(Z.this.f2086x == null, "Unexpected non-null activeTransport");
                    l lVar = l.this;
                    lVar.f2112a.e(Z.this.f2088z);
                    return;
                }
                InterfaceC0451w interfaceC0451w = Z.this.f2085w;
                l lVar2 = l.this;
                InterfaceC0451w interfaceC0451w2 = lVar2.f2112a;
                if (interfaceC0451w == interfaceC0451w2) {
                    Z.this.f2086x = interfaceC0451w2;
                    Z.this.f2085w = null;
                    Z.this.O(EnumC0368p.READY);
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.l0 f2116a;

            public b(K2.l0 l0Var) {
                this.f2116a = l0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Z.this.f2087y.c() == EnumC0368p.SHUTDOWN) {
                    return;
                }
                InterfaceC0431l0 interfaceC0431l0 = Z.this.f2086x;
                l lVar = l.this;
                if (interfaceC0431l0 == lVar.f2112a) {
                    Z.this.f2086x = null;
                    Z.this.f2076n.f();
                    Z.this.O(EnumC0368p.IDLE);
                    return;
                }
                InterfaceC0451w interfaceC0451w = Z.this.f2085w;
                l lVar2 = l.this;
                if (interfaceC0451w == lVar2.f2112a) {
                    Z1.m.w(Z.this.f2087y.c() == EnumC0368p.CONNECTING, "Expected state is CONNECTING, actual state is %s", Z.this.f2087y.c());
                    Z.this.f2076n.c();
                    if (Z.this.f2076n.e()) {
                        Z.this.U();
                        return;
                    }
                    Z.this.f2085w = null;
                    Z.this.f2076n.f();
                    Z.this.T(this.f2116a);
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Z.this.f2083u.remove(l.this.f2112a);
                if (Z.this.f2087y.c() == EnumC0368p.SHUTDOWN && Z.this.f2083u.isEmpty()) {
                    Z.this.Q();
                }
            }
        }

        public l(InterfaceC0451w interfaceC0451w) {
            this.f2112a = interfaceC0451w;
        }

        @Override // M2.InterfaceC0431l0.a
        public void a() {
            Z.this.f2073k.a(AbstractC0358f.a.INFO, "READY");
            Z.this.f2075m.execute(new a());
        }

        @Override // M2.InterfaceC0431l0.a
        public void b() {
            Z1.m.u(this.f2113b, "transportShutdown() must be called before transportTerminated().");
            Z.this.f2073k.b(AbstractC0358f.a.INFO, "{0} Terminated", this.f2112a.h());
            Z.this.f2070h.i(this.f2112a);
            Z.this.R(this.f2112a, false);
            Iterator it = Z.this.f2074l.iterator();
            if (!it.hasNext()) {
                Z.this.f2075m.execute(new c());
            } else {
                android.support.v4.media.session.b.a(it.next());
                this.f2112a.d();
                throw null;
            }
        }

        @Override // M2.InterfaceC0431l0.a
        public void c(boolean z4) {
            Z.this.R(this.f2112a, z4);
        }

        @Override // M2.InterfaceC0431l0.a
        public void d(K2.l0 l0Var) {
            Z.this.f2073k.b(AbstractC0358f.a.INFO, "{0} SHUTDOWN with {1}", this.f2112a.h(), Z.this.S(l0Var));
            this.f2113b = true;
            Z.this.f2075m.execute(new b(l0Var));
        }

        @Override // M2.InterfaceC0431l0.a
        public C0353a e(C0353a c0353a) {
            Iterator it = Z.this.f2074l.iterator();
            if (!it.hasNext()) {
                return c0353a;
            }
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public static final class m extends AbstractC0358f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public K2.K f2119a;

        @Override // K2.AbstractC0358f
        public void a(AbstractC0358f.a aVar, String str) {
            C0436o.d(this.f2119a, aVar, str);
        }

        @Override // K2.AbstractC0358f
        public void b(AbstractC0358f.a aVar, String str, Object... objArr) {
            C0436o.e(this.f2119a, aVar, str, objArr);
        }
    }

    public Z(List list, String str, String str2, InterfaceC0426j.a aVar, InterfaceC0447u interfaceC0447u, ScheduledExecutorService scheduledExecutorService, Z1.r rVar, K2.p0 p0Var, j jVar, K2.E e4, C0434n c0434n, C0438p c0438p, K2.K k4, AbstractC0358f abstractC0358f, List list2) {
        Z1.m.o(list, "addressGroups");
        Z1.m.e(!list.isEmpty(), "addressGroups is empty");
        N(list, "addressGroups contains null entry");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f2077o = listUnmodifiableList;
        this.f2076n = new k(listUnmodifiableList);
        this.f2064b = str;
        this.f2065c = str2;
        this.f2066d = aVar;
        this.f2068f = interfaceC0447u;
        this.f2069g = scheduledExecutorService;
        this.f2079q = (Z1.p) rVar.get();
        this.f2075m = p0Var;
        this.f2067e = jVar;
        this.f2070h = e4;
        this.f2071i = c0434n;
        this.f2072j = (C0438p) Z1.m.o(c0438p, "channelTracer");
        this.f2063a = (K2.K) Z1.m.o(k4, "logId");
        this.f2073k = (AbstractC0358f) Z1.m.o(abstractC0358f, "channelLogger");
        this.f2074l = list2;
    }

    public static void N(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Z1.m.o(it.next(), str);
        }
    }

    public final void M() {
        this.f2075m.e();
        p0.d dVar = this.f2080r;
        if (dVar != null) {
            dVar.a();
            this.f2080r = null;
            this.f2078p = null;
        }
    }

    public final void O(EnumC0368p enumC0368p) {
        this.f2075m.e();
        P(C0369q.a(enumC0368p));
    }

    public final void P(C0369q c0369q) {
        this.f2075m.e();
        if (this.f2087y.c() != c0369q.c()) {
            Z1.m.u(this.f2087y.c() != EnumC0368p.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + c0369q);
            this.f2087y = c0369q;
            this.f2067e.c(this, c0369q);
        }
    }

    public final void Q() {
        this.f2075m.execute(new f());
    }

    public final void R(InterfaceC0451w interfaceC0451w, boolean z4) {
        this.f2075m.execute(new g(interfaceC0451w, z4));
    }

    public final String S(K2.l0 l0Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(l0Var.m());
        if (l0Var.n() != null) {
            sb.append("(");
            sb.append(l0Var.n());
            sb.append(")");
        }
        if (l0Var.l() != null) {
            sb.append("[");
            sb.append(l0Var.l());
            sb.append("]");
        }
        return sb.toString();
    }

    public final void T(K2.l0 l0Var) {
        this.f2075m.e();
        P(C0369q.b(l0Var));
        if (this.f2078p == null) {
            this.f2078p = this.f2066d.get();
        }
        long jA = this.f2078p.a();
        Z1.p pVar = this.f2079q;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jD = jA - pVar.d(timeUnit);
        this.f2073k.b(AbstractC0358f.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", S(l0Var), Long.valueOf(jD));
        Z1.m.u(this.f2080r == null, "previous reconnectTask is not done");
        this.f2080r = this.f2075m.c(new b(), jD, timeUnit, this.f2069g);
    }

    public final void U() {
        SocketAddress socketAddressC;
        K2.D d4;
        this.f2075m.e();
        Z1.m.u(this.f2080r == null, "Should have no reconnectTask scheduled");
        if (this.f2076n.d()) {
            this.f2079q.f().g();
        }
        SocketAddress socketAddressA = this.f2076n.a();
        a aVar = null;
        if (socketAddressA instanceof K2.D) {
            d4 = (K2.D) socketAddressA;
            socketAddressC = d4.c();
        } else {
            socketAddressC = socketAddressA;
            d4 = null;
        }
        C0353a c0353aB = this.f2076n.b();
        String str = (String) c0353aB.b(C0375x.f1322d);
        InterfaceC0447u.a aVar2 = new InterfaceC0447u.a();
        if (str == null) {
            str = this.f2064b;
        }
        InterfaceC0447u.a aVarG = aVar2.e(str).f(c0353aB).h(this.f2065c).g(d4);
        m mVar = new m();
        mVar.f2119a = h();
        i iVar = new i(this.f2068f.I(socketAddressC, aVarG, mVar), this.f2071i, aVar);
        mVar.f2119a = iVar.h();
        this.f2070h.c(iVar);
        this.f2085w = iVar;
        this.f2083u.add(iVar);
        Runnable runnableI = iVar.i(new l(iVar));
        if (runnableI != null) {
            this.f2075m.b(runnableI);
        }
        this.f2073k.b(AbstractC0358f.a.INFO, "Started transport {0}", mVar.f2119a);
    }

    public void V(List list) {
        Z1.m.o(list, "newAddressGroups");
        N(list, "newAddressGroups contains null entry");
        Z1.m.e(!list.isEmpty(), "newAddressGroups is empty");
        this.f2075m.execute(new d(Collections.unmodifiableList(new ArrayList(list))));
    }

    @Override // M2.T0
    public InterfaceC0445t a() {
        InterfaceC0431l0 interfaceC0431l0 = this.f2086x;
        if (interfaceC0431l0 != null) {
            return interfaceC0431l0;
        }
        this.f2075m.execute(new c());
        return null;
    }

    public void b(K2.l0 l0Var) {
        e(l0Var);
        this.f2075m.execute(new h(l0Var));
    }

    public void e(K2.l0 l0Var) {
        this.f2075m.execute(new e(l0Var));
    }

    @Override // K2.P
    public K2.K h() {
        return this.f2063a;
    }

    public String toString() {
        return Z1.g.b(this).c("logId", this.f2063a.d()).d("addressGroups", this.f2077o).toString();
    }
}
