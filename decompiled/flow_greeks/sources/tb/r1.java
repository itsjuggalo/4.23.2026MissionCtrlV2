package tb;

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
import rb.o1;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r1 extends rb.r0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Logger f21667p = Logger.getLogger(r1.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r0.e f21668g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f21670i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o1.d f21673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public rb.p f21674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public rb.p f21675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f21676o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f21669h = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21671j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f21672k = true;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21677a;

        static {
            int[] iArr = new int[rb.p.values().length];
            f21677a = iArr;
            try {
                iArr[rb.p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21677a[rb.p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21677a[rb.p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21677a[rb.p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21677a[rb.p.SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r1.this.f21673l = null;
            if (r1.this.f21670i.b()) {
                r1.this.e();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f21682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21684c;

        public d(List list) {
            this.f21682a = list == null ? Collections.EMPTY_LIST : list;
        }

        public SocketAddress a() {
            if (c()) {
                return (SocketAddress) ((rb.x) this.f21682a.get(this.f21683b)).a().get(this.f21684c);
            }
            throw new IllegalStateException("Index is past the end of the address group list");
        }

        public boolean b() {
            if (!c()) {
                return false;
            }
            rb.x xVar = (rb.x) this.f21682a.get(this.f21683b);
            int i10 = this.f21684c + 1;
            this.f21684c = i10;
            if (i10 < xVar.a().size()) {
                return true;
            }
            int i11 = this.f21683b + 1;
            this.f21683b = i11;
            this.f21684c = 0;
            return i11 < this.f21682a.size();
        }

        public boolean c() {
            return this.f21683b < this.f21682a.size();
        }

        public void d() {
            this.f21683b = 0;
            this.f21684c = 0;
        }

        public boolean e(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f21682a.size(); i10++) {
                int iIndexOf = ((rb.x) this.f21682a.get(i10)).a().indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f21683b = i10;
                    this.f21684c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public int f() {
            List list = this.f21682a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void g(q6.k kVar) {
            List list = kVar;
            if (kVar == null) {
                list = Collections.EMPTY_LIST;
            }
            this.f21682a = list;
            d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.f f21685a;

        public e(r0.f fVar) {
            this.f21685a = (r0.f) p6.n.o(fVar, "result");
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return this.f21685a;
        }

        public String toString() {
            return p6.h.a(e.class).d("result", this.f21685a).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class f extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r1 f21686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f21687b = new AtomicBoolean(false);

        public f(r1 r1Var) {
            this.f21686a = (r1) p6.n.o(r1Var, "pickFirstLeafLoadBalancer");
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            if (this.f21687b.compareAndSet(false, true)) {
                rb.o1 o1VarD = r1.this.f21668g.d();
                final r1 r1Var = this.f21686a;
                Objects.requireNonNull(r1Var);
                o1VarD.execute(new Runnable() { // from class: tb.s1
                    @Override // java.lang.Runnable
                    public final void run() {
                        r1Var.e();
                    }
                });
            }
            return r0.f.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.i f21689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public rb.p f21690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f21691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f21692d = false;

        public g(r0.i iVar, rb.p pVar, c cVar) {
            this.f21689a = iVar;
            this.f21690b = pVar;
            this.f21691c = cVar;
        }

        public final rb.p f() {
            return this.f21691c.f21679a.c();
        }

        public rb.p g() {
            return this.f21690b;
        }

        public r0.i h() {
            return this.f21689a;
        }

        public boolean i() {
            return this.f21692d;
        }

        public final void j(rb.p pVar) {
            this.f21690b = pVar;
            if (pVar == rb.p.READY || pVar == rb.p.TRANSIENT_FAILURE) {
                this.f21692d = true;
            } else if (pVar == rb.p.IDLE) {
                this.f21692d = false;
            }
        }
    }

    public r1(r0.e eVar) {
        rb.p pVar = rb.p.IDLE;
        this.f21674m = pVar;
        this.f21675n = pVar;
        this.f21676o = r0.g("GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS", false);
        this.f21668g = (r0.e) p6.n.o(eVar, "helper");
    }

    @Override // rb.r0
    public rb.k1 a(r0.h hVar) {
        rb.p pVar;
        if (this.f21674m == rb.p.SHUTDOWN) {
            return rb.k1.f19602o.r("Already shut down");
        }
        List listA = hVar.a();
        if (listA.isEmpty()) {
            rb.k1 k1VarR = rb.k1.f19607t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(k1VarR);
            return k1VarR;
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            if (((rb.x) it.next()) == null) {
                rb.k1 k1VarR2 = rb.k1.f19607t.r("NameResolver returned address list with null endpoint. addrs=" + hVar.a() + ", attrs=" + hVar.b());
                c(k1VarR2);
                return k1VarR2;
            }
        }
        this.f21672k = true;
        hVar.c();
        q6.k kVarK = q6.k.r().j(listA).k();
        d dVar = this.f21670i;
        if (dVar == null) {
            this.f21670i = new d(kVarK);
        } else if (this.f21674m == rb.p.READY) {
            SocketAddress socketAddressA = dVar.a();
            this.f21670i.g(kVarK);
            if (this.f21670i.e(socketAddressA)) {
                return rb.k1.f19592e;
            }
            this.f21670i.d();
        } else {
            dVar.g(kVarK);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.f21669h.keySet());
        HashSet hashSet2 = new HashSet();
        q6.b0 it2 = kVarK.iterator();
        while (it2.hasNext()) {
            hashSet2.addAll(((rb.x) it2.next()).a());
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                ((g) this.f21669h.remove(socketAddress)).h().g();
            }
        }
        if (hashSet.size() == 0 || (pVar = this.f21674m) == rb.p.CONNECTING || pVar == rb.p.READY) {
            rb.p pVar2 = rb.p.CONNECTING;
            this.f21674m = pVar2;
            u(pVar2, new e(r0.f.g()));
            n();
            e();
        } else {
            rb.p pVar3 = rb.p.IDLE;
            if (pVar == pVar3) {
                u(pVar3, new f(this));
            } else if (pVar == rb.p.TRANSIENT_FAILURE) {
                n();
                e();
            }
        }
        return rb.k1.f19592e;
    }

    @Override // rb.r0
    public void c(rb.k1 k1Var) {
        Iterator it = this.f21669h.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).h().g();
        }
        this.f21669h.clear();
        u(rb.p.TRANSIENT_FAILURE, new e(r0.f.f(k1Var)));
    }

    @Override // rb.r0
    public void e() {
        d dVar = this.f21670i;
        if (dVar == null || !dVar.c() || this.f21674m == rb.p.SHUTDOWN) {
            return;
        }
        SocketAddress socketAddressA = this.f21670i.a();
        r0.i iVarH = this.f21669h.containsKey(socketAddressA) ? ((g) this.f21669h.get(socketAddressA)).h() : o(socketAddressA);
        int i10 = a.f21677a[((g) this.f21669h.get(socketAddressA)).g().ordinal()];
        if (i10 == 1) {
            iVarH.f();
            ((g) this.f21669h.get(socketAddressA)).j(rb.p.CONNECTING);
            s();
        } else {
            if (i10 == 2) {
                if (this.f21676o) {
                    s();
                    return;
                } else {
                    iVarH.f();
                    return;
                }
            }
            if (i10 == 3) {
                f21667p.warning("Requesting a connection even though we have a READY subchannel");
            } else {
                if (i10 != 4) {
                    return;
                }
                this.f21670i.b();
                e();
            }
        }
    }

    @Override // rb.r0
    public void f() {
        f21667p.log(Level.FINE, "Shutting down, currently have {} subchannels created", Integer.valueOf(this.f21669h.size()));
        rb.p pVar = rb.p.SHUTDOWN;
        this.f21674m = pVar;
        this.f21675n = pVar;
        n();
        Iterator it = this.f21669h.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).h().g();
        }
        this.f21669h.clear();
    }

    public final void n() {
        o1.d dVar = this.f21673l;
        if (dVar != null) {
            dVar.a();
            this.f21673l = null;
        }
    }

    public final r0.i o(SocketAddress socketAddress) {
        c cVar = new c(this, null);
        final r0.i iVarA = this.f21668g.a(r0.b.d().e(q6.o.g(new rb.x(socketAddress))).b(rb.r0.f19692c, cVar).c());
        if (iVarA == null) {
            f21667p.warning("Was not able to create subchannel for " + socketAddress);
            throw new IllegalStateException("Can't create subchannel");
        }
        g gVar = new g(iVarA, rb.p.IDLE, cVar);
        cVar.f21680b = gVar;
        this.f21669h.put(socketAddress, gVar);
        if (iVarA.c().b(rb.r0.f19693d) == null) {
            cVar.f21679a = rb.q.a(rb.p.READY);
        }
        iVarA.h(new r0.k() { // from class: tb.q1
            @Override // rb.r0.k
            public final void a(rb.q qVar) {
                this.f21621a.r(iVarA, qVar);
            }
        });
        return iVarA;
    }

    public final SocketAddress p(r0.i iVar) {
        return (SocketAddress) iVar.a().a().get(0);
    }

    public final boolean q() {
        d dVar = this.f21670i;
        if (dVar == null || dVar.c() || this.f21669h.size() < this.f21670i.f()) {
            return false;
        }
        Iterator it = this.f21669h.values().iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).i()) {
                return false;
            }
        }
        return true;
    }

    public void r(r0.i iVar, rb.q qVar) {
        rb.p pVarC = qVar.c();
        g gVar = (g) this.f21669h.get(p(iVar));
        if (gVar == null || gVar.h() != iVar || pVarC == rb.p.SHUTDOWN) {
            return;
        }
        rb.p pVar = rb.p.IDLE;
        if (pVarC == pVar) {
            this.f21668g.e();
        }
        gVar.j(pVarC);
        rb.p pVar2 = this.f21674m;
        rb.p pVar3 = rb.p.TRANSIENT_FAILURE;
        if (pVar2 == pVar3 || this.f21675n == pVar3) {
            if (pVarC == rb.p.CONNECTING) {
                return;
            }
            if (pVarC == pVar) {
                e();
                return;
            }
        }
        int i10 = a.f21677a[pVarC.ordinal()];
        if (i10 == 1) {
            this.f21670i.d();
            this.f21674m = pVar;
            u(pVar, new f(this));
            return;
        }
        if (i10 == 2) {
            rb.p pVar4 = rb.p.CONNECTING;
            this.f21674m = pVar4;
            u(pVar4, new e(r0.f.g()));
            return;
        }
        if (i10 == 3) {
            t(gVar);
            this.f21670i.e(p(iVar));
            this.f21674m = rb.p.READY;
            v(gVar);
            return;
        }
        if (i10 != 4) {
            throw new IllegalArgumentException("Unsupported state:" + pVarC);
        }
        if (this.f21670i.c() && ((g) this.f21669h.get(this.f21670i.a())).h() == iVar && this.f21670i.b()) {
            n();
            e();
        }
        if (q()) {
            this.f21674m = pVar3;
            u(pVar3, new e(r0.f.f(qVar.d())));
            int i11 = this.f21671j + 1;
            this.f21671j = i11;
            if (i11 >= this.f21670i.f() || this.f21672k) {
                this.f21672k = false;
                this.f21671j = 0;
                this.f21668g.e();
            }
        }
    }

    public final void s() {
        if (this.f21676o) {
            o1.d dVar = this.f21673l;
            if (dVar == null || !dVar.b()) {
                this.f21673l = this.f21668g.d().d(new b(), 250L, TimeUnit.MILLISECONDS, this.f21668g.c());
            }
        }
    }

    public final void t(g gVar) {
        n();
        for (g gVar2 : this.f21669h.values()) {
            if (!gVar2.h().equals(gVar.f21689a)) {
                gVar2.h().g();
            }
        }
        this.f21669h.clear();
        gVar.j(rb.p.READY);
        this.f21669h.put(p(gVar.f21689a), gVar);
    }

    public final void u(rb.p pVar, r0.j jVar) {
        if (pVar == this.f21675n && (pVar == rb.p.IDLE || pVar == rb.p.CONNECTING)) {
            return;
        }
        this.f21675n = pVar;
        this.f21668g.f(pVar, jVar);
    }

    public final void v(g gVar) {
        rb.p pVar = gVar.f21690b;
        rb.p pVar2 = rb.p.READY;
        if (pVar != pVar2) {
            return;
        }
        if (gVar.f() == pVar2) {
            u(pVar2, new r0.d(r0.f.h(gVar.f21689a)));
            return;
        }
        rb.p pVarF = gVar.f();
        rb.p pVar3 = rb.p.TRANSIENT_FAILURE;
        if (pVarF == pVar3) {
            u(pVar3, new e(r0.f.f(gVar.f21691c.f21679a.d())));
        } else if (this.f21675n != pVar3) {
            u(gVar.f(), new e(r0.f.g()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c implements r0.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public rb.q f21679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f21680b;

        public c() {
            this.f21679a = rb.q.a(rb.p.IDLE);
        }

        @Override // rb.r0.k
        public void a(rb.q qVar) {
            r1.f21667p.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{qVar, this.f21680b.f21689a});
            this.f21679a = qVar;
            if (r1.this.f21670i.c() && ((g) r1.this.f21669h.get(r1.this.f21670i.a())).f21691c == this) {
                r1.this.v(this.f21680b);
            }
        }

        public /* synthetic */ c(r1 r1Var, a aVar) {
            this();
        }
    }
}
