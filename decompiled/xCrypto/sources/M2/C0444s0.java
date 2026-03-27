package M2;

import K2.C0369q;
import K2.C0375x;
import K2.EnumC0368p;
import K2.S;
import K2.p0;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0444s0 extends K2.S {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Logger f2606p = Logger.getLogger(C0444s0.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final S.e f2607g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f2609i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p0.d f2612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EnumC0368p f2613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EnumC0368p f2614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f2615o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f2608h = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2610j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2611k = true;

    /* JADX INFO: renamed from: M2.s0$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2616a;

        static {
            int[] iArr = new int[EnumC0368p.values().length];
            f2616a = iArr;
            try {
                iArr[EnumC0368p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2616a[EnumC0368p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2616a[EnumC0368p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2616a[EnumC0368p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2616a[EnumC0368p.SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: M2.s0$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0444s0.this.f2612l = null;
            if (C0444s0.this.f2609i.b()) {
                C0444s0.this.e();
            }
        }
    }

    /* JADX INFO: renamed from: M2.s0$d */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f2621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2623c;

        public d(List list) {
            this.f2621a = list == null ? Collections.EMPTY_LIST : list;
        }

        public SocketAddress a() {
            if (c()) {
                return (SocketAddress) ((C0375x) this.f2621a.get(this.f2622b)).a().get(this.f2623c);
            }
            throw new IllegalStateException("Index is past the end of the address group list");
        }

        public boolean b() {
            if (!c()) {
                return false;
            }
            C0375x c0375x = (C0375x) this.f2621a.get(this.f2622b);
            int i4 = this.f2623c + 1;
            this.f2623c = i4;
            if (i4 < c0375x.a().size()) {
                return true;
            }
            int i5 = this.f2622b + 1;
            this.f2622b = i5;
            this.f2623c = 0;
            return i5 < this.f2621a.size();
        }

        public boolean c() {
            return this.f2622b < this.f2621a.size();
        }

        public void d() {
            this.f2622b = 0;
            this.f2623c = 0;
        }

        public boolean e(SocketAddress socketAddress) {
            for (int i4 = 0; i4 < this.f2621a.size(); i4++) {
                int iIndexOf = ((C0375x) this.f2621a.get(i4)).a().indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f2622b = i4;
                    this.f2623c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public int f() {
            List list = this.f2621a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void g(a2.k kVar) {
            List list = kVar;
            if (kVar == null) {
                list = Collections.EMPTY_LIST;
            }
            this.f2621a = list;
            d();
        }
    }

    /* JADX INFO: renamed from: M2.s0$e */
    public static final class e extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.f f2624a;

        public e(S.f fVar) {
            this.f2624a = (S.f) Z1.m.o(fVar, "result");
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return this.f2624a;
        }

        public String toString() {
            return Z1.g.a(e.class).d("result", this.f2624a).toString();
        }
    }

    /* JADX INFO: renamed from: M2.s0$f */
    public final class f extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0444s0 f2625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f2626b = new AtomicBoolean(false);

        public f(C0444s0 c0444s0) {
            this.f2625a = (C0444s0) Z1.m.o(c0444s0, "pickFirstLeafLoadBalancer");
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            if (this.f2626b.compareAndSet(false, true)) {
                K2.p0 p0VarD = C0444s0.this.f2607g.d();
                final C0444s0 c0444s0 = this.f2625a;
                Objects.requireNonNull(c0444s0);
                p0VarD.execute(new Runnable() { // from class: M2.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0444s0.e();
                    }
                });
            }
            return S.f.g();
        }
    }

    /* JADX INFO: renamed from: M2.s0$g */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.i f2628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EnumC0368p f2629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f2630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2631d = false;

        public g(S.i iVar, EnumC0368p enumC0368p, c cVar) {
            this.f2628a = iVar;
            this.f2629b = enumC0368p;
            this.f2630c = cVar;
        }

        public final EnumC0368p f() {
            return this.f2630c.f2618a.c();
        }

        public EnumC0368p g() {
            return this.f2629b;
        }

        public S.i h() {
            return this.f2628a;
        }

        public boolean i() {
            return this.f2631d;
        }

        public final void j(EnumC0368p enumC0368p) {
            this.f2629b = enumC0368p;
            if (enumC0368p == EnumC0368p.READY || enumC0368p == EnumC0368p.TRANSIENT_FAILURE) {
                this.f2631d = true;
            } else if (enumC0368p == EnumC0368p.IDLE) {
                this.f2631d = false;
            }
        }
    }

    public C0444s0(S.e eVar) {
        EnumC0368p enumC0368p = EnumC0368p.IDLE;
        this.f2613m = enumC0368p;
        this.f2614n = enumC0368p;
        this.f2615o = S.g("GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS", false);
        this.f2607g = (S.e) Z1.m.o(eVar, "helper");
    }

    @Override // K2.S
    public K2.l0 a(S.h hVar) {
        EnumC0368p enumC0368p;
        if (this.f2613m == EnumC0368p.SHUTDOWN) {
            return K2.l0.f1225o.q("Already shut down");
        }
        List listA = hVar.a();
        if (listA.isEmpty()) {
            K2.l0 l0VarQ = K2.l0.f1230t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(l0VarQ);
            return l0VarQ;
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            if (((C0375x) it.next()) == null) {
                K2.l0 l0VarQ2 = K2.l0.f1230t.q("NameResolver returned address list with null endpoint. addrs=" + hVar.a() + ", attrs=" + hVar.b());
                c(l0VarQ2);
                return l0VarQ2;
            }
        }
        this.f2611k = true;
        hVar.c();
        a2.k kVarK = a2.k.p().j(listA).k();
        d dVar = this.f2609i;
        if (dVar == null) {
            this.f2609i = new d(kVarK);
        } else if (this.f2613m == EnumC0368p.READY) {
            SocketAddress socketAddressA = dVar.a();
            this.f2609i.g(kVarK);
            if (this.f2609i.e(socketAddressA)) {
                return K2.l0.f1215e;
            }
            this.f2609i.d();
        } else {
            dVar.g(kVarK);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.f2608h.keySet());
        HashSet hashSet2 = new HashSet();
        a2.B it2 = kVarK.iterator();
        while (it2.hasNext()) {
            hashSet2.addAll(((C0375x) it2.next()).a());
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                ((g) this.f2608h.remove(socketAddress)).h().g();
            }
        }
        if (hashSet.size() == 0 || (enumC0368p = this.f2613m) == EnumC0368p.CONNECTING || enumC0368p == EnumC0368p.READY) {
            EnumC0368p enumC0368p2 = EnumC0368p.CONNECTING;
            this.f2613m = enumC0368p2;
            u(enumC0368p2, new e(S.f.g()));
            n();
            e();
        } else {
            EnumC0368p enumC0368p3 = EnumC0368p.IDLE;
            if (enumC0368p == enumC0368p3) {
                u(enumC0368p3, new f(this));
            } else if (enumC0368p == EnumC0368p.TRANSIENT_FAILURE) {
                n();
                e();
            }
        }
        return K2.l0.f1215e;
    }

    @Override // K2.S
    public void c(K2.l0 l0Var) {
        Iterator it = this.f2608h.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).h().g();
        }
        this.f2608h.clear();
        u(EnumC0368p.TRANSIENT_FAILURE, new e(S.f.f(l0Var)));
    }

    @Override // K2.S
    public void e() {
        d dVar = this.f2609i;
        if (dVar == null || !dVar.c() || this.f2613m == EnumC0368p.SHUTDOWN) {
            return;
        }
        SocketAddress socketAddressA = this.f2609i.a();
        S.i iVarH = this.f2608h.containsKey(socketAddressA) ? ((g) this.f2608h.get(socketAddressA)).h() : o(socketAddressA);
        int i4 = a.f2616a[((g) this.f2608h.get(socketAddressA)).g().ordinal()];
        if (i4 == 1) {
            iVarH.f();
            ((g) this.f2608h.get(socketAddressA)).j(EnumC0368p.CONNECTING);
            s();
        } else {
            if (i4 == 2) {
                if (this.f2615o) {
                    s();
                    return;
                } else {
                    iVarH.f();
                    return;
                }
            }
            if (i4 == 3) {
                f2606p.warning("Requesting a connection even though we have a READY subchannel");
            } else {
                if (i4 != 4) {
                    return;
                }
                this.f2609i.b();
                e();
            }
        }
    }

    @Override // K2.S
    public void f() {
        f2606p.log(Level.FINE, "Shutting down, currently have {} subchannels created", Integer.valueOf(this.f2608h.size()));
        EnumC0368p enumC0368p = EnumC0368p.SHUTDOWN;
        this.f2613m = enumC0368p;
        this.f2614n = enumC0368p;
        n();
        Iterator it = this.f2608h.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).h().g();
        }
        this.f2608h.clear();
    }

    public final void n() {
        p0.d dVar = this.f2612l;
        if (dVar != null) {
            dVar.a();
            this.f2612l = null;
        }
    }

    public final S.i o(SocketAddress socketAddress) {
        c cVar = new c(this, null);
        final S.i iVarA = this.f2607g.a(S.b.d().e(a2.o.g(new C0375x(socketAddress))).b(K2.S.f1059c, cVar).c());
        if (iVarA == null) {
            f2606p.warning("Was not able to create subchannel for " + socketAddress);
            throw new IllegalStateException("Can't create subchannel");
        }
        g gVar = new g(iVarA, EnumC0368p.IDLE, cVar);
        cVar.f2619b = gVar;
        this.f2608h.put(socketAddress, gVar);
        if (iVarA.c().b(K2.S.f1060d) == null) {
            cVar.f2618a = C0369q.a(EnumC0368p.READY);
        }
        iVarA.h(new S.k() { // from class: M2.r0
            @Override // K2.S.k
            public final void a(C0369q c0369q) {
                this.f2599a.r(iVarA, c0369q);
            }
        });
        return iVarA;
    }

    public final SocketAddress p(S.i iVar) {
        return (SocketAddress) iVar.a().a().get(0);
    }

    public final boolean q() {
        d dVar = this.f2609i;
        if (dVar == null || dVar.c() || this.f2608h.size() < this.f2609i.f()) {
            return false;
        }
        Iterator it = this.f2608h.values().iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).i()) {
                return false;
            }
        }
        return true;
    }

    public void r(S.i iVar, C0369q c0369q) {
        EnumC0368p enumC0368pC = c0369q.c();
        g gVar = (g) this.f2608h.get(p(iVar));
        if (gVar == null || gVar.h() != iVar || enumC0368pC == EnumC0368p.SHUTDOWN) {
            return;
        }
        EnumC0368p enumC0368p = EnumC0368p.IDLE;
        if (enumC0368pC == enumC0368p) {
            this.f2607g.e();
        }
        gVar.j(enumC0368pC);
        EnumC0368p enumC0368p2 = this.f2613m;
        EnumC0368p enumC0368p3 = EnumC0368p.TRANSIENT_FAILURE;
        if (enumC0368p2 == enumC0368p3 || this.f2614n == enumC0368p3) {
            if (enumC0368pC == EnumC0368p.CONNECTING) {
                return;
            }
            if (enumC0368pC == enumC0368p) {
                e();
                return;
            }
        }
        int i4 = a.f2616a[enumC0368pC.ordinal()];
        if (i4 == 1) {
            this.f2609i.d();
            this.f2613m = enumC0368p;
            u(enumC0368p, new f(this));
            return;
        }
        if (i4 == 2) {
            EnumC0368p enumC0368p4 = EnumC0368p.CONNECTING;
            this.f2613m = enumC0368p4;
            u(enumC0368p4, new e(S.f.g()));
            return;
        }
        if (i4 == 3) {
            t(gVar);
            this.f2609i.e(p(iVar));
            this.f2613m = EnumC0368p.READY;
            v(gVar);
            return;
        }
        if (i4 != 4) {
            throw new IllegalArgumentException("Unsupported state:" + enumC0368pC);
        }
        if (this.f2609i.c() && ((g) this.f2608h.get(this.f2609i.a())).h() == iVar && this.f2609i.b()) {
            n();
            e();
        }
        if (q()) {
            this.f2613m = enumC0368p3;
            u(enumC0368p3, new e(S.f.f(c0369q.d())));
            int i5 = this.f2610j + 1;
            this.f2610j = i5;
            if (i5 >= this.f2609i.f() || this.f2611k) {
                this.f2611k = false;
                this.f2610j = 0;
                this.f2607g.e();
            }
        }
    }

    public final void s() {
        if (this.f2615o) {
            p0.d dVar = this.f2612l;
            if (dVar == null || !dVar.b()) {
                this.f2612l = this.f2607g.d().c(new b(), 250L, TimeUnit.MILLISECONDS, this.f2607g.c());
            }
        }
    }

    public final void t(g gVar) {
        n();
        for (g gVar2 : this.f2608h.values()) {
            if (!gVar2.h().equals(gVar.f2628a)) {
                gVar2.h().g();
            }
        }
        this.f2608h.clear();
        gVar.j(EnumC0368p.READY);
        this.f2608h.put(p(gVar.f2628a), gVar);
    }

    public final void u(EnumC0368p enumC0368p, S.j jVar) {
        if (enumC0368p == this.f2614n && (enumC0368p == EnumC0368p.IDLE || enumC0368p == EnumC0368p.CONNECTING)) {
            return;
        }
        this.f2614n = enumC0368p;
        this.f2607g.f(enumC0368p, jVar);
    }

    public final void v(g gVar) {
        EnumC0368p enumC0368p = gVar.f2629b;
        EnumC0368p enumC0368p2 = EnumC0368p.READY;
        if (enumC0368p != enumC0368p2) {
            return;
        }
        if (gVar.f() == enumC0368p2) {
            u(enumC0368p2, new S.d(S.f.h(gVar.f2628a)));
            return;
        }
        EnumC0368p enumC0368pF = gVar.f();
        EnumC0368p enumC0368p3 = EnumC0368p.TRANSIENT_FAILURE;
        if (enumC0368pF == enumC0368p3) {
            u(enumC0368p3, new e(S.f.f(gVar.f2630c.f2618a.d())));
        } else if (this.f2614n != enumC0368p3) {
            u(gVar.f(), new e(S.f.g()));
        }
    }

    /* JADX INFO: renamed from: M2.s0$c */
    public final class c implements S.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0369q f2618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f2619b;

        public c() {
            this.f2618a = C0369q.a(EnumC0368p.IDLE);
        }

        @Override // K2.S.k
        public void a(C0369q c0369q) {
            C0444s0.f2606p.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{c0369q, this.f2619b.f2628a});
            this.f2618a = c0369q;
            if (C0444s0.this.f2609i.c() && ((g) C0444s0.this.f2608h.get(C0444s0.this.f2609i.a())).f2630c == this) {
                C0444s0.this.v(this.f2619b);
            }
        }

        public /* synthetic */ c(C0444s0 c0444s0, a aVar) {
            this();
        }
    }
}
