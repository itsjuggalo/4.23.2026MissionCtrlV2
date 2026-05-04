package tb;

import java.util.List;
import java.util.Map;
import rb.b1;
import rb.f;
import rb.r0;
import tb.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.t0 f21414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21415b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.e f21416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public rb.r0 f21417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public rb.s0 f21418c;

        public b(r0.e eVar) {
            this.f21416a = eVar;
            rb.s0 s0VarD = i.this.f21414a.d(i.this.f21415b);
            this.f21418c = s0VarD;
            if (s0VarD != null) {
                this.f21417b = s0VarD.a(eVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + i.this.f21415b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public rb.r0 a() {
            return this.f21417b;
        }

        public void b(rb.k1 k1Var) {
            a().c(k1Var);
        }

        public void c() {
            a().e();
        }

        public void d() {
            this.f21417b.f();
            this.f21417b = null;
        }

        public rb.k1 e(r0.h hVar) {
            j2.b bVar = (j2.b) hVar.c();
            if (bVar == null) {
                try {
                    i iVar = i.this;
                    bVar = new j2.b(iVar.d(iVar.f21415b, "using default policy"), null);
                } catch (f e10) {
                    this.f21416a.f(rb.p.TRANSIENT_FAILURE, new d(rb.k1.f19606s.r(e10.getMessage())));
                    this.f21417b.f();
                    this.f21418c = null;
                    this.f21417b = new e();
                    return rb.k1.f19592e;
                }
            }
            if (this.f21418c == null || !bVar.f21454a.b().equals(this.f21418c.b())) {
                this.f21416a.f(rb.p.CONNECTING, new c());
                this.f21417b.f();
                rb.s0 s0Var = bVar.f21454a;
                this.f21418c = s0Var;
                rb.r0 r0Var = this.f21417b;
                this.f21417b = s0Var.a(this.f21416a);
                this.f21416a.b().b(f.a.INFO, "Load balancer changed from {0} to {1}", r0Var.getClass().getSimpleName(), this.f21417b.getClass().getSimpleName());
            }
            Object obj = bVar.f21455b;
            if (obj != null) {
                this.f21416a.b().b(f.a.DEBUG, "Load-balancing config: {0}", bVar.f21455b);
            }
            return a().a(r0.h.d().b(hVar.a()).c(hVar.b()).d(obj).a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends r0.j {
        public c() {
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return r0.f.g();
        }

        public String toString() {
            return p6.h.a(c.class).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rb.k1 f21420a;

        public d(rb.k1 k1Var) {
            this.f21420a = k1Var;
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return r0.f.f(this.f21420a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends Exception {
        public f(String str) {
            super(str);
        }
    }

    public i(String str) {
        this(rb.t0.b(), str);
    }

    public final rb.s0 d(String str, String str2) throws f {
        rb.s0 s0VarD = this.f21414a.d(str);
        if (s0VarD != null) {
            return s0VarD;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public b e(r0.e eVar) {
        return new b(eVar);
    }

    public b1.b f(Map map) {
        List listA;
        if (map != null) {
            try {
                listA = j2.A(j2.g(map));
            } catch (RuntimeException e10) {
                return b1.b.b(rb.k1.f19594g.r("can't parse load balancer configuration").q(e10));
            }
        } else {
            listA = null;
        }
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return j2.y(listA, this.f21414a);
    }

    public i(rb.t0 t0Var, String str) {
        this.f21414a = (rb.t0) p6.n.o(t0Var, "registry");
        this.f21415b = (String) p6.n.o(str, "defaultPolicy");
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends rb.r0 {
        public e() {
        }

        @Override // rb.r0
        public rb.k1 a(r0.h hVar) {
            return rb.k1.f19592e;
        }

        @Override // rb.r0
        public void f() {
        }

        @Override // rb.r0
        public void c(rb.k1 k1Var) {
        }

        @Override // rb.r0
        public void d(r0.h hVar) {
        }
    }
}
