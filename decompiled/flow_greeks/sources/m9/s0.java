package m9;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.f;
import i9.n4;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import m9.a1;
import m9.b1;
import m9.l0;
import m9.n;
import m9.y0;
import m9.z0;
import rb.k1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements z0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.f f16266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f16267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i9.k0 f16268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f16269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f16270e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l0 f16272g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a1 f16274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b1 f16275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z0 f16276k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16273h = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f16271f = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Deque f16277l = new ArrayDeque();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements a1.a {
        public a() {
        }

        @Override // m9.u0
        public void a() {
            s0.this.x();
        }

        @Override // m9.u0
        public void b(k1 k1Var) {
            s0.this.w(k1Var);
        }

        @Override // m9.a1.a
        public void e(j9.v vVar, y0 y0Var) {
            s0.this.v(vVar, y0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements b1.a {
        public b() {
        }

        @Override // m9.u0
        public void a() {
            s0.this.f16275j.C();
        }

        @Override // m9.u0
        public void b(k1 k1Var) {
            s0.this.A(k1Var);
        }

        @Override // m9.b1.a
        public void c(j9.v vVar, List list) {
            s0.this.C(vVar, list);
        }

        @Override // m9.b1.a
        public void d() {
            s0.this.B();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        void a(g9.z0 z0Var);

        g8.e b(int i10);

        void c(k9.h hVar);

        void d(n0 n0Var);

        void e(int i10, k1 k1Var);

        void f(int i10, k1 k1Var);
    }

    public s0(j9.f fVar, final c cVar, i9.k0 k0Var, q qVar, final n9.g gVar, n nVar) {
        this.f16266a = fVar;
        this.f16267b = cVar;
        this.f16268c = k0Var;
        this.f16269d = qVar;
        this.f16270e = nVar;
        Objects.requireNonNull(cVar);
        this.f16272g = new l0(gVar, new l0.a() { // from class: m9.p0
            @Override // m9.l0.a
            public final void a(g9.z0 z0Var) {
                cVar.a(z0Var);
            }
        });
        this.f16274i = qVar.e(new a());
        this.f16275j = qVar.f(new b());
        nVar.a(new n9.n() { // from class: m9.q0
            @Override // n9.n
            public final void accept(Object obj) {
                s0.d(this.f16254a, gVar, (n.a) obj);
            }
        });
    }

    public static /* synthetic */ void c(s0 s0Var, n.a aVar) {
        s0Var.getClass();
        if (aVar.equals(n.a.REACHABLE) && s0Var.f16272g.c().equals(g9.z0.ONLINE)) {
            return;
        }
        if (!(aVar.equals(n.a.UNREACHABLE) && s0Var.f16272g.c().equals(g9.z0.OFFLINE)) && s0Var.n()) {
            n9.v.a("RemoteStore", "Restarting streams for network reachability change.", new Object[0]);
            s0Var.G();
        }
    }

    public static /* synthetic */ void d(final s0 s0Var, n9.g gVar, final n.a aVar) {
        s0Var.getClass();
        gVar.l(new Runnable() { // from class: m9.r0
            @Override // java.lang.Runnable
            public final void run() {
                s0.c(this.f16258a, aVar);
            }
        });
    }

    public final void A(k1 k1Var) {
        if (k1Var.p()) {
            n9.b.d(!L(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!k1Var.p() && !this.f16277l.isEmpty()) {
            if (this.f16275j.y()) {
                y(k1Var);
            } else {
                z(k1Var);
            }
        }
        if (L()) {
            P();
        }
    }

    public final void B() {
        this.f16268c.W(this.f16275j.x());
        Iterator it = this.f16277l.iterator();
        while (it.hasNext()) {
            this.f16275j.D(((k9.g) it.next()).h());
        }
    }

    public final void C(j9.v vVar, List list) {
        this.f16267b.c(k9.h.a((k9.g) this.f16277l.poll(), vVar, list, this.f16275j.x()));
        t();
    }

    public void D(n4 n4Var) {
        Integer numValueOf = Integer.valueOf(n4Var.h());
        if (this.f16271f.containsKey(numValueOf)) {
            return;
        }
        this.f16271f.put(numValueOf, n4Var);
        if (K()) {
            O();
        } else if (this.f16274i.m()) {
            J(n4Var);
        }
    }

    public final void E(y0.d dVar) {
        n9.b.d(dVar.a() != null, "Processing target error without a cause", new Object[0]);
        for (Integer num : dVar.d()) {
            if (this.f16271f.containsKey(num)) {
                this.f16271f.remove(num);
                this.f16276k.q(num.intValue());
                this.f16267b.e(num.intValue(), dVar.a());
            }
        }
    }

    public final void F(j9.v vVar) {
        n9.b.d(!vVar.equals(j9.v.f14278b), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        n0 n0VarC = this.f16276k.c(vVar);
        for (Map.Entry entry : n0VarC.d().entrySet()) {
            v0 v0Var = (v0) entry.getValue();
            if (!v0Var.e().isEmpty()) {
                Integer num = (Integer) entry.getKey();
                num.intValue();
                n4 n4Var = (n4) this.f16271f.get(num);
                if (n4Var != null) {
                    this.f16271f.put(num, n4Var.k(v0Var.e(), vVar));
                }
            }
        }
        for (Map.Entry entry2 : n0VarC.e().entrySet()) {
            Integer num2 = (Integer) entry2.getKey();
            int iIntValue = num2.intValue();
            n4 n4Var2 = (n4) this.f16271f.get(num2);
            if (n4Var2 != null) {
                this.f16271f.put(num2, n4Var2.k(com.google.protobuf.i.f6998b, n4Var2.f()));
                I(iIntValue);
                J(new n4(n4Var2.g(), iIntValue, n4Var2.e(), (i9.k1) entry2.getValue()));
            }
        }
        this.f16267b.d(n0VarC);
    }

    public final void G() {
        this.f16273h = false;
        r();
        this.f16272g.h(g9.z0.UNKNOWN);
        this.f16275j.l();
        this.f16274i.l();
        s();
    }

    public Task H(g9.b1 b1Var, List list) {
        return n() ? this.f16269d.l(b1Var, list) : Tasks.forException(new com.google.firebase.firestore.f("Failed to get result from server.", f.a.UNAVAILABLE));
    }

    public final void I(int i10) {
        this.f16276k.o(i10);
        this.f16274i.z(i10);
    }

    public final void J(n4 n4Var) {
        this.f16276k.o(n4Var.h());
        if (!n4Var.d().isEmpty() || n4Var.f().compareTo(j9.v.f14278b) > 0) {
            n4Var = n4Var.i(Integer.valueOf(b(n4Var.h()).size()));
        }
        this.f16274i.A(n4Var);
    }

    public final boolean K() {
        return (!n() || this.f16274i.n() || this.f16271f.isEmpty()) ? false : true;
    }

    public final boolean L() {
        return (!n() || this.f16275j.n() || this.f16277l.isEmpty()) ? false : true;
    }

    public void M() {
        n9.v.a("RemoteStore", "Shutting down", new Object[0]);
        this.f16270e.shutdown();
        this.f16273h = false;
        r();
        this.f16269d.m();
        this.f16272g.h(g9.z0.UNKNOWN);
    }

    public void N() {
        s();
    }

    public final void O() {
        n9.b.d(K(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.f16276k = new z0(this.f16266a, this);
        this.f16274i.t();
        this.f16272g.e();
    }

    public final void P() {
        n9.b.d(L(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.f16275j.t();
    }

    public void Q(int i10) {
        n9.b.d(((n4) this.f16271f.remove(Integer.valueOf(i10))) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(i10));
        if (this.f16274i.m()) {
            I(i10);
        }
        if (this.f16271f.isEmpty()) {
            if (this.f16274i.m()) {
                this.f16274i.o();
            } else if (n()) {
                this.f16272g.h(g9.z0.UNKNOWN);
            }
        }
    }

    @Override // m9.z0.c
    public n4 a(int i10) {
        return (n4) this.f16271f.get(Integer.valueOf(i10));
    }

    @Override // m9.z0.c
    public g8.e b(int i10) {
        return this.f16267b.b(i10);
    }

    public final void l(k9.g gVar) {
        n9.b.d(m(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.f16277l.add(gVar);
        if (this.f16275j.m() && this.f16275j.y()) {
            this.f16275j.D(gVar.h());
        }
    }

    public final boolean m() {
        return n() && this.f16277l.size() < 10;
    }

    public boolean n() {
        return this.f16273h;
    }

    public final void o() {
        this.f16276k = null;
    }

    public g9.k1 p() {
        return new g9.k1(this.f16269d);
    }

    public void q() {
        this.f16273h = false;
        r();
        this.f16272g.h(g9.z0.OFFLINE);
    }

    public final void r() {
        this.f16274i.u();
        this.f16275j.u();
        if (!this.f16277l.isEmpty()) {
            n9.v.a("RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.f16277l.size()));
            this.f16277l.clear();
        }
        o();
    }

    public void s() {
        this.f16273h = true;
        if (n()) {
            this.f16275j.B(this.f16268c.H());
            if (K()) {
                O();
            } else {
                this.f16272g.h(g9.z0.UNKNOWN);
            }
            t();
        }
    }

    public void t() {
        int iE = this.f16277l.isEmpty() ? -1 : ((k9.g) this.f16277l.getLast()).e();
        while (true) {
            if (!m()) {
                break;
            }
            k9.g gVarK = this.f16268c.K(iE);
            if (gVarK != null) {
                l(gVarK);
                iE = gVarK.e();
            } else if (this.f16277l.size() == 0) {
                this.f16275j.o();
            }
        }
        if (L()) {
            P();
        }
    }

    public void u() {
        if (n()) {
            n9.v.a("RemoteStore", "Restarting streams for new credential.", new Object[0]);
            G();
        }
    }

    public final void v(j9.v vVar, y0 y0Var) {
        this.f16272g.h(g9.z0.ONLINE);
        n9.b.d((this.f16274i == null || this.f16276k == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        boolean z10 = y0Var instanceof y0.d;
        y0.d dVar = z10 ? (y0.d) y0Var : null;
        if (dVar != null && dVar.b().equals(y0.e.Removed) && dVar.a() != null) {
            E(dVar);
            return;
        }
        if (y0Var instanceof y0.b) {
            this.f16276k.i((y0.b) y0Var);
        } else if (y0Var instanceof y0.c) {
            this.f16276k.j((y0.c) y0Var);
        } else {
            n9.b.d(z10, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
            this.f16276k.k((y0.d) y0Var);
        }
        if (vVar.equals(j9.v.f14278b) || vVar.compareTo(this.f16268c.G()) < 0) {
            return;
        }
        F(vVar);
    }

    public final void w(k1 k1Var) {
        if (k1Var.p()) {
            n9.b.d(!K(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        o();
        if (!K()) {
            this.f16272g.h(g9.z0.UNKNOWN);
        } else {
            this.f16272g.d(k1Var);
            O();
        }
    }

    public final void x() {
        Iterator it = this.f16271f.values().iterator();
        while (it.hasNext()) {
            J((n4) it.next());
        }
    }

    public final void y(k1 k1Var) {
        n9.b.d(!k1Var.p(), "Handling write error with status OK.", new Object[0]);
        if (q.j(k1Var)) {
            k9.g gVar = (k9.g) this.f16277l.poll();
            this.f16275j.l();
            this.f16267b.f(gVar.e(), k1Var);
            t();
        }
    }

    public final void z(k1 k1Var) {
        n9.b.d(!k1Var.p(), "Handling write error with status OK.", new Object[0]);
        if (q.i(k1Var)) {
            n9.v.a("RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", n9.g0.v(this.f16275j.x()), k1Var);
            b1 b1Var = this.f16275j;
            com.google.protobuf.i iVar = b1.f16123v;
            b1Var.B(iVar);
            this.f16268c.W(iVar);
        }
    }
}
