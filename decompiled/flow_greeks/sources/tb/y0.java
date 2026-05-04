package tb;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import rb.f;
import rb.o1;
import tb.j;
import tb.k1;
import tb.s;
import tb.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements rb.j0, s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.k0 f21806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j.a f21809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f21810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f21811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f21812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final rb.e0 f21813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f21814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p f21815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final rb.f f21816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f21817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final rb.o1 f21818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f21819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile List f21820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public tb.j f21821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p6.q f21822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public o1.d f21823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public o1.d f21824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k1 f21825t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public w f21828w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile k1 f21829x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public rb.k1 f21831z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Collection f21826u = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w0 f21827v = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile rb.q f21830y = rb.q.a(rb.p.IDLE);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends w0 {
        public a() {
        }

        @Override // tb.w0
        public void b() {
            y0.this.f21810e.a(y0.this);
        }

        @Override // tb.w0
        public void c() {
            y0.this.f21810e.b(y0.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.f21823r = null;
            y0.this.f21816k.a(f.a.INFO, "CONNECTING after backoff");
            y0.this.N(rb.p.CONNECTING);
            y0.this.T();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y0.this.f21830y.c() == rb.p.IDLE) {
                y0.this.f21816k.a(f.a.INFO, "CONNECTING as requested");
                y0.this.N(rb.p.CONNECTING);
                y0.this.T();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f21835a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k1 k1Var = y0.this.f21825t;
                y0.this.f21824s = null;
                y0.this.f21825t = null;
                k1Var.c(rb.k1.f19607t.r("InternalSubchannel closed transport due to address change"));
            }
        }

        public d(List list) {
            this.f21835a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            k1 k1Var;
            SocketAddress socketAddressA = y0.this.f21819n.a();
            y0.this.f21819n.h(this.f21835a);
            y0.this.f21820o = this.f21835a;
            rb.p pVarC = y0.this.f21830y.c();
            rb.p pVar = rb.p.READY;
            if ((pVarC != pVar && y0.this.f21830y.c() != rb.p.CONNECTING) || y0.this.f21819n.g(socketAddressA)) {
                k1Var = null;
            } else if (y0.this.f21830y.c() == pVar) {
                k1Var = y0.this.f21829x;
                y0.this.f21829x = null;
                y0.this.f21819n.f();
                y0.this.N(rb.p.IDLE);
            } else {
                y0.this.f21828w.c(rb.k1.f19607t.r("InternalSubchannel closed pending transport due to address change"));
                y0.this.f21828w = null;
                y0.this.f21819n.f();
                y0.this.T();
                k1Var = null;
            }
            if (k1Var != null) {
                if (y0.this.f21824s != null) {
                    y0.this.f21825t.c(rb.k1.f19607t.r("InternalSubchannel closed transport early due to address change"));
                    y0.this.f21824s.a();
                    y0.this.f21824s = null;
                    y0.this.f21825t = null;
                }
                y0.this.f21825t = k1Var;
                y0 y0Var = y0.this;
                y0Var.f21824s = y0Var.f21818m.d(new a(), 5L, TimeUnit.SECONDS, y0.this.f21812g);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.k1 f21838a;

        public e(rb.k1 k1Var) {
            this.f21838a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            rb.p pVarC = y0.this.f21830y.c();
            rb.p pVar = rb.p.SHUTDOWN;
            if (pVarC == pVar) {
                return;
            }
            y0.this.f21831z = this.f21838a;
            k1 k1Var = y0.this.f21829x;
            w wVar = y0.this.f21828w;
            y0.this.f21829x = null;
            y0.this.f21828w = null;
            y0.this.N(pVar);
            y0.this.f21819n.f();
            if (y0.this.f21826u.isEmpty()) {
                y0.this.P();
            }
            y0.this.L();
            if (y0.this.f21824s != null) {
                y0.this.f21824s.a();
                y0.this.f21825t.c(this.f21838a);
                y0.this.f21824s = null;
                y0.this.f21825t = null;
            }
            if (k1Var != null) {
                k1Var.c(this.f21838a);
            }
            if (wVar != null) {
                wVar.c(this.f21838a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.f21816k.a(f.a.INFO, "Terminated");
            y0.this.f21810e.d(y0.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f21841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f21842b;

        public g(w wVar, boolean z10) {
            this.f21841a = wVar;
            this.f21842b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.f21827v.e(this.f21841a, this.f21842b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.k1 f21844a;

        public h(rb.k1 k1Var) {
            this.f21844a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(y0.this.f21826u).iterator();
            while (it.hasNext()) {
                ((k1) it.next()).h(this.f21844a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f21846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f21847b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends i0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r f21848a;

            /* JADX INFO: renamed from: tb.y0$i$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class C0376a extends j0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ s f21850a;

                public C0376a(s sVar) {
                    this.f21850a = sVar;
                }

                @Override // tb.j0, tb.s
                public void d(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
                    i.this.f21847b.a(k1Var.p());
                    super.d(k1Var, aVar, y0Var);
                }

                @Override // tb.j0
                public s e() {
                    return this.f21850a;
                }
            }

            public a(r rVar) {
                this.f21848a = rVar;
            }

            @Override // tb.i0, tb.r
            public void j(s sVar) {
                i.this.f21847b.b();
                super.j(new C0376a(sVar));
            }

            @Override // tb.i0
            public r m() {
                return this.f21848a;
            }
        }

        public /* synthetic */ i(w wVar, n nVar, a aVar) {
            this(wVar, nVar);
        }

        @Override // tb.k0
        public w a() {
            return this.f21846a;
        }

        @Override // tb.k0, tb.t
        public r g(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, rb.k[] kVarArr) {
            return new a(super.g(z0Var, y0Var, cVar, kVarArr));
        }

        public i(w wVar, n nVar) {
            this.f21846a = wVar;
            this.f21847b = nVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class j {
        public abstract void a(y0 y0Var);

        public abstract void b(y0 y0Var);

        public abstract void c(y0 y0Var, rb.q qVar);

        public abstract void d(y0 y0Var);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f21852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21854c;

        public k(List list) {
            this.f21852a = list;
        }

        public SocketAddress a() {
            return (SocketAddress) ((rb.x) this.f21852a.get(this.f21853b)).a().get(this.f21854c);
        }

        public rb.a b() {
            return ((rb.x) this.f21852a.get(this.f21853b)).b();
        }

        public void c() {
            rb.x xVar = (rb.x) this.f21852a.get(this.f21853b);
            int i10 = this.f21854c + 1;
            this.f21854c = i10;
            if (i10 >= xVar.a().size()) {
                this.f21853b++;
                this.f21854c = 0;
            }
        }

        public boolean d() {
            return this.f21853b == 0 && this.f21854c == 0;
        }

        public boolean e() {
            return this.f21853b < this.f21852a.size();
        }

        public void f() {
            this.f21853b = 0;
            this.f21854c = 0;
        }

        public boolean g(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f21852a.size(); i10++) {
                int iIndexOf = ((rb.x) this.f21852a.get(i10)).a().indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f21853b = i10;
                    this.f21854c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List list) {
            this.f21852a = list;
            f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class l implements k1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f21855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f21856b = false;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y0.this.f21821p = null;
                if (y0.this.f21831z != null) {
                    p6.n.u(y0.this.f21829x == null, "Unexpected non-null activeTransport");
                    l lVar = l.this;
                    lVar.f21855a.c(y0.this.f21831z);
                    return;
                }
                w wVar = y0.this.f21828w;
                l lVar2 = l.this;
                w wVar2 = lVar2.f21855a;
                if (wVar == wVar2) {
                    y0.this.f21829x = wVar2;
                    y0.this.f21828w = null;
                    y0.this.N(rb.p.READY);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.k1 f21859a;

            public b(rb.k1 k1Var) {
                this.f21859a = k1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (y0.this.f21830y.c() == rb.p.SHUTDOWN) {
                    return;
                }
                k1 k1Var = y0.this.f21829x;
                l lVar = l.this;
                if (k1Var == lVar.f21855a) {
                    y0.this.f21829x = null;
                    y0.this.f21819n.f();
                    y0.this.N(rb.p.IDLE);
                    return;
                }
                w wVar = y0.this.f21828w;
                l lVar2 = l.this;
                if (wVar == lVar2.f21855a) {
                    p6.n.x(y0.this.f21830y.c() == rb.p.CONNECTING, "Expected state is CONNECTING, actual state is %s", y0.this.f21830y.c());
                    y0.this.f21819n.c();
                    if (y0.this.f21819n.e()) {
                        y0.this.T();
                        return;
                    }
                    y0.this.f21828w = null;
                    y0.this.f21819n.f();
                    y0.this.S(this.f21859a);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y0.this.f21826u.remove(l.this.f21855a);
                if (y0.this.f21830y.c() == rb.p.SHUTDOWN && y0.this.f21826u.isEmpty()) {
                    y0.this.P();
                }
            }
        }

        public l(w wVar) {
            this.f21855a = wVar;
        }

        @Override // tb.k1.a
        public void a() {
            y0.this.f21816k.a(f.a.INFO, "READY");
            y0.this.f21818m.execute(new a());
        }

        @Override // tb.k1.a
        public void b() {
            p6.n.u(this.f21856b, "transportShutdown() must be called before transportTerminated().");
            y0.this.f21816k.b(f.a.INFO, "{0} Terminated", this.f21855a.f());
            y0.this.f21813h.i(this.f21855a);
            y0.this.Q(this.f21855a, false);
            Iterator it = y0.this.f21817l.iterator();
            if (!it.hasNext()) {
                y0.this.f21818m.execute(new c());
            } else {
                android.support.v4.media.session.b.a(it.next());
                this.f21855a.getAttributes();
                throw null;
            }
        }

        @Override // tb.k1.a
        public void c(rb.k1 k1Var) {
            y0.this.f21816k.b(f.a.INFO, "{0} SHUTDOWN with {1}", this.f21855a.f(), y0.this.R(k1Var));
            this.f21856b = true;
            y0.this.f21818m.execute(new b(k1Var));
        }

        @Override // tb.k1.a
        public void d(boolean z10) {
            y0.this.Q(this.f21855a, z10);
        }

        @Override // tb.k1.a
        public rb.a e(rb.a aVar) {
            Iterator it = y0.this.f21817l.iterator();
            if (!it.hasNext()) {
                return aVar;
            }
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class m extends rb.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public rb.k0 f21862a;

        @Override // rb.f
        public void a(f.a aVar, String str) {
            o.d(this.f21862a, aVar, str);
        }

        @Override // rb.f
        public void b(f.a aVar, String str, Object... objArr) {
            o.e(this.f21862a, aVar, str, objArr);
        }
    }

    public y0(List list, String str, String str2, j.a aVar, u uVar, ScheduledExecutorService scheduledExecutorService, p6.s sVar, rb.o1 o1Var, j jVar, rb.e0 e0Var, n nVar, p pVar, rb.k0 k0Var, rb.f fVar, List list2) {
        p6.n.o(list, "addressGroups");
        p6.n.e(!list.isEmpty(), "addressGroups is empty");
        M(list, "addressGroups contains null entry");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f21820o = listUnmodifiableList;
        this.f21819n = new k(listUnmodifiableList);
        this.f21807b = str;
        this.f21808c = str2;
        this.f21809d = aVar;
        this.f21811f = uVar;
        this.f21812g = scheduledExecutorService;
        this.f21822q = (p6.q) sVar.get();
        this.f21818m = o1Var;
        this.f21810e = jVar;
        this.f21813h = e0Var;
        this.f21814i = nVar;
        this.f21815j = (p) p6.n.o(pVar, "channelTracer");
        this.f21806a = (rb.k0) p6.n.o(k0Var, "logId");
        this.f21816k = (rb.f) p6.n.o(fVar, "channelLogger");
        this.f21817l = list2;
    }

    public static void M(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p6.n.o(it.next(), str);
        }
    }

    public final void L() {
        this.f21818m.f();
        o1.d dVar = this.f21823r;
        if (dVar != null) {
            dVar.a();
            this.f21823r = null;
            this.f21821p = null;
        }
    }

    public final void N(rb.p pVar) {
        this.f21818m.f();
        O(rb.q.a(pVar));
    }

    public final void O(rb.q qVar) {
        this.f21818m.f();
        if (this.f21830y.c() != qVar.c()) {
            p6.n.u(this.f21830y.c() != rb.p.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + qVar);
            this.f21830y = qVar;
            this.f21810e.c(this, qVar);
        }
    }

    public final void P() {
        this.f21818m.execute(new f());
    }

    public final void Q(w wVar, boolean z10) {
        this.f21818m.execute(new g(wVar, z10));
    }

    public final String R(rb.k1 k1Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(k1Var.n());
        if (k1Var.o() != null) {
            sb2.append("(");
            sb2.append(k1Var.o());
            sb2.append(")");
        }
        if (k1Var.m() != null) {
            sb2.append("[");
            sb2.append(k1Var.m());
            sb2.append("]");
        }
        return sb2.toString();
    }

    public final void S(rb.k1 k1Var) {
        this.f21818m.f();
        O(rb.q.b(k1Var));
        if (this.f21821p == null) {
            this.f21821p = this.f21809d.get();
        }
        long jA = this.f21821p.a();
        p6.q qVar = this.f21822q;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jD = jA - qVar.d(timeUnit);
        this.f21816k.b(f.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", R(k1Var), Long.valueOf(jD));
        p6.n.u(this.f21823r == null, "previous reconnectTask is not done");
        this.f21823r = this.f21818m.d(new b(), jD, timeUnit, this.f21812g);
    }

    public final void T() {
        SocketAddress socketAddressC;
        rb.d0 d0Var;
        this.f21818m.f();
        p6.n.u(this.f21823r == null, "Should have no reconnectTask scheduled");
        if (this.f21819n.d()) {
            this.f21822q.f().g();
        }
        SocketAddress socketAddressA = this.f21819n.a();
        a aVar = null;
        if (socketAddressA instanceof rb.d0) {
            d0Var = (rb.d0) socketAddressA;
            socketAddressC = d0Var.c();
        } else {
            socketAddressC = socketAddressA;
            d0Var = null;
        }
        rb.a aVarB = this.f21819n.b();
        String str = (String) aVarB.b(rb.x.f19736d);
        u.a aVar2 = new u.a();
        if (str == null) {
            str = this.f21807b;
        }
        u.a aVarG = aVar2.e(str).f(aVarB).h(this.f21808c).g(d0Var);
        m mVar = new m();
        mVar.f21862a = f();
        i iVar = new i(this.f21811f.I(socketAddressC, aVarG, mVar), this.f21814i, aVar);
        mVar.f21862a = iVar.f();
        this.f21813h.c(iVar);
        this.f21828w = iVar;
        this.f21826u.add(iVar);
        Runnable runnableD = iVar.d(new l(iVar));
        if (runnableD != null) {
            this.f21818m.b(runnableD);
        }
        this.f21816k.b(f.a.INFO, "Started transport {0}", mVar.f21862a);
    }

    public void U(List list) {
        p6.n.o(list, "newAddressGroups");
        M(list, "newAddressGroups contains null entry");
        p6.n.e(!list.isEmpty(), "newAddressGroups is empty");
        this.f21818m.execute(new d(Collections.unmodifiableList(new ArrayList(list))));
    }

    @Override // tb.s2
    public t a() {
        k1 k1Var = this.f21829x;
        if (k1Var != null) {
            return k1Var;
        }
        this.f21818m.execute(new c());
        return null;
    }

    public void c(rb.k1 k1Var) {
        this.f21818m.execute(new e(k1Var));
    }

    @Override // rb.p0
    public rb.k0 f() {
        return this.f21806a;
    }

    public void h(rb.k1 k1Var) {
        c(k1Var);
        this.f21818m.execute(new h(k1Var));
    }

    public String toString() {
        return p6.h.b(this).c("logId", this.f21806a.d()).d("addressGroups", this.f21820o).toString();
    }
}
