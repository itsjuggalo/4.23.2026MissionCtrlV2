package ba;

import aa.i3;
import aa.j3;
import aa.k3;
import aa.l3;
import aa.n2;
import aa.o;
import aa.r2;
import aa.s0;
import aa.s2;
import aa.t0;
import android.app.Application;
import ca.e0;
import ca.f0;
import ca.g0;
import ca.h0;
import ca.i0;
import ca.j0;
import ca.k;
import ca.k0;
import ca.l;
import ca.l0;
import ca.m0;
import ca.n;
import ca.n0;
import ca.o0;
import ca.p;
import ca.p0;
import ca.q;
import ca.q0;
import ca.r;
import ca.r0;
import ca.s;
import ca.t;
import ca.u;
import ca.v;
import ca.w;
import ca.x;
import ca.y;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import ea.m;
import java.util.concurrent.Executor;
import r9.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w f3112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n0 f3113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n f3114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public u f3115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e0 f3116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ca.a f3117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public h0 f3118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public r0 f3119h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public l0 f3120i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public k f3121j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public q f3122k;

        public b a(ca.a aVar) {
            this.f3117f = (ca.a) r9.d.b(aVar);
            return this;
        }

        public b b(k kVar) {
            this.f3121j = (k) r9.d.b(kVar);
            return this;
        }

        public b c(n nVar) {
            this.f3114c = (n) r9.d.b(nVar);
            return this;
        }

        public d d() {
            if (this.f3112a == null) {
                this.f3112a = new w();
            }
            if (this.f3113b == null) {
                this.f3113b = new n0();
            }
            r9.d.a(this.f3114c, n.class);
            if (this.f3115d == null) {
                this.f3115d = new u();
            }
            r9.d.a(this.f3116e, e0.class);
            if (this.f3117f == null) {
                this.f3117f = new ca.a();
            }
            if (this.f3118g == null) {
                this.f3118g = new h0();
            }
            if (this.f3119h == null) {
                this.f3119h = new r0();
            }
            if (this.f3120i == null) {
                this.f3120i = new l0();
            }
            r9.d.a(this.f3121j, k.class);
            r9.d.a(this.f3122k, q.class);
            return new C0053c(this.f3112a, this.f3113b, this.f3114c, this.f3115d, this.f3116e, this.f3117f, this.f3118g, this.f3119h, this.f3120i, this.f3121j, this.f3122k);
        }

        public b e(q qVar) {
            this.f3122k = (q) r9.d.b(qVar);
            return this;
        }

        public b f(e0 e0Var) {
            this.f3116e = (e0) r9.d.b(e0Var);
            return this;
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: ba.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0053c implements d {
        public e A;
        public e B;
        public e C;
        public e D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0 f3123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l0 f3124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0053c f3125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f3126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f3127e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e f3128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e f3129g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e f3130h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public e f3131i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public e f3132j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public e f3133k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public e f3134l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public e f3135m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public e f3136n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public e f3137o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public e f3138p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public e f3139q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public e f3140r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public e f3141s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public e f3142t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public e f3143u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public e f3144v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public e f3145w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public e f3146x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public e f3147y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public e f3148z;

        @Override // ba.d
        public Application a() {
            return (Application) this.f3126d.get();
        }

        @Override // ba.d
        public n2 b() {
            return (n2) this.f3136n.get();
        }

        @Override // ba.d
        public Executor c() {
            return (Executor) this.D.get();
        }

        @Override // ba.d
        public m d() {
            return m0.a(this.f3124b);
        }

        @Override // ba.d
        public aa.c e() {
            return (aa.c) this.f3138p.get();
        }

        @Override // ba.d
        public c9.d f() {
            return (c9.d) this.f3140r.get();
        }

        @Override // ba.d
        public o g() {
            return (o) this.B.get();
        }

        @Override // ba.d
        public s0 h() {
            return (s0) this.f3145w.get();
        }

        @Override // ba.d
        public k3 i() {
            return (k3) this.f3133k.get();
        }

        @Override // ba.d
        public aa.k j() {
            return (aa.k) this.f3143u.get();
        }

        @Override // ba.d
        public Executor k() {
            return (Executor) this.C.get();
        }

        @Override // ba.d
        public r2 l() {
            return (r2) this.f3127e.get();
        }

        @Override // ba.d
        public i3 m() {
            return (i3) this.f3148z.get();
        }

        @Override // ba.d
        public hc.a n() {
            return (hc.a) this.f3134l.get();
        }

        @Override // ba.d
        public da.a o() {
            return ca.s0.c(this.f3123a);
        }

        @Override // ba.d
        public hc.a p() {
            return (hc.a) this.f3135m.get();
        }

        @Override // ba.d
        public rb.d q() {
            return (rb.d) this.f3129g.get();
        }

        @Override // ba.d
        public AnalyticsConnector r() {
            return (AnalyticsConnector) this.f3137o.get();
        }

        public final void s(w wVar, n0 n0Var, n nVar, u uVar, e0 e0Var, ca.a aVar, h0 h0Var, r0 r0Var, l0 l0Var, k kVar, q qVar) {
            e eVarA = r9.a.a(p.a(nVar));
            this.f3126d = eVarA;
            this.f3127e = r9.a.a(s2.a(eVarA));
            e eVarA2 = r9.a.a(y.a(wVar));
            this.f3128f = eVarA2;
            this.f3129g = r9.a.a(x.a(wVar, eVarA2));
            this.f3130h = r9.a.a(p0.a(n0Var));
            this.f3131i = r9.a.a(o0.a(n0Var));
            e eVarA3 = r9.a.a(q0.a(n0Var));
            this.f3132j = eVarA3;
            this.f3133k = r9.a.a(l3.a(this.f3130h, this.f3131i, eVarA3));
            this.f3134l = r9.a.a(v.a(uVar, this.f3126d));
            this.f3135m = r9.a.a(f0.a(e0Var));
            this.f3136n = r9.a.a(g0.a(e0Var));
            e eVarA4 = r9.a.a(l.a(kVar));
            this.f3137o = eVarA4;
            e eVarA5 = r9.a.a(ca.c.a(aVar, eVarA4));
            this.f3138p = eVarA5;
            this.f3139q = r9.a.a(ca.b.a(aVar, eVarA5));
            this.f3140r = r9.a.a(ca.m.a(kVar));
            this.f3141s = r9.a.a(i0.a(h0Var, this.f3126d));
            ca.s0 s0VarA = ca.s0.a(r0Var);
            this.f3142t = s0VarA;
            this.f3143u = r9.a.a(aa.l.a(this.f3141s, this.f3126d, s0VarA));
            e eVarA6 = r9.a.a(j0.a(h0Var, this.f3126d));
            this.f3144v = eVarA6;
            this.f3145w = r9.a.a(t0.a(eVarA6));
            this.f3146x = r9.a.a(ea.l.a());
            e eVarA7 = r9.a.a(k0.a(h0Var, this.f3126d));
            this.f3147y = eVarA7;
            this.f3148z = r9.a.a(j3.a(eVarA7, this.f3142t));
            e eVarA8 = r9.a.a(r.a(qVar));
            this.A = eVarA8;
            this.B = r9.a.a(ca.o.a(nVar, eVarA8));
            this.C = r9.a.a(t.a(qVar));
            this.D = r9.a.a(s.a(qVar));
        }

        public C0053c(w wVar, n0 n0Var, n nVar, u uVar, e0 e0Var, ca.a aVar, h0 h0Var, r0 r0Var, l0 l0Var, k kVar, q qVar) {
            this.f3125c = this;
            this.f3123a = r0Var;
            this.f3124b = l0Var;
            s(wVar, n0Var, nVar, uVar, e0Var, aVar, h0Var, r0Var, l0Var, kVar, qVar);
        }
    }

    public static b a() {
        return new b();
    }
}
