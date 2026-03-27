package G4;

import F4.AbstractC0492f;
import F4.EnumC0502p;
import F4.P;
import F4.a0;
import G4.K0;
import java.util.List;
import java.util.Map;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0532i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.S f2962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2963b;

    /* JADX INFO: renamed from: G4.i$b */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P.e f2964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public F4.P f2965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public F4.Q f2966c;

        public b(P.e eVar) {
            this.f2964a = eVar;
            F4.Q qD = C0532i.this.f2962a.d(C0532i.this.f2963b);
            this.f2966c = qD;
            if (qD != null) {
                this.f2965b = qD.a(eVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + C0532i.this.f2963b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public F4.P a() {
            return this.f2965b;
        }

        public void b(F4.j0 j0Var) {
            a().c(j0Var);
        }

        public void c() {
            this.f2965b.f();
            this.f2965b = null;
        }

        public F4.j0 d(P.h hVar) {
            K0.b bVar = (K0.b) hVar.c();
            if (bVar == null) {
                try {
                    C0532i c0532i = C0532i.this;
                    bVar = new K0.b(c0532i.d(c0532i.f2963b, "using default policy"), null);
                } catch (f e8) {
                    this.f2964a.f(EnumC0502p.TRANSIENT_FAILURE, new d(F4.j0.f1811s.r(e8.getMessage())));
                    this.f2965b.f();
                    this.f2966c = null;
                    this.f2965b = new e();
                    return F4.j0.f1797e;
                }
            }
            if (this.f2966c == null || !bVar.f2518a.b().equals(this.f2966c.b())) {
                this.f2964a.f(EnumC0502p.CONNECTING, new c());
                this.f2965b.f();
                F4.Q q8 = bVar.f2518a;
                this.f2966c = q8;
                F4.P p8 = this.f2965b;
                this.f2965b = q8.a(this.f2964a);
                this.f2964a.b().b(AbstractC0492f.a.INFO, "Load balancer changed from {0} to {1}", p8.getClass().getSimpleName(), this.f2965b.getClass().getSimpleName());
            }
            Object obj = bVar.f2519b;
            if (obj != null) {
                this.f2964a.b().b(AbstractC0492f.a.DEBUG, "Load-balancing config: {0}", bVar.f2519b);
            }
            return a().a(P.h.d().b(hVar.a()).c(hVar.b()).d(obj).a());
        }
    }

    /* JADX INFO: renamed from: G4.i$c */
    public static final class c extends P.j {
        public c() {
        }

        @Override // F4.P.j
        public P.f a(P.g gVar) {
            return P.f.g();
        }

        public String toString() {
            return AbstractC2842h.a(c.class).toString();
        }
    }

    /* JADX INFO: renamed from: G4.i$d */
    public static final class d extends P.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final F4.j0 f2968a;

        public d(F4.j0 j0Var) {
            this.f2968a = j0Var;
        }

        @Override // F4.P.j
        public P.f a(P.g gVar) {
            return P.f.f(this.f2968a);
        }
    }

    /* JADX INFO: renamed from: G4.i$f */
    public static final class f extends Exception {
        public f(String str) {
            super(str);
        }
    }

    public C0532i(F4.S s8, String str) {
        this.f2962a = (F4.S) AbstractC2848n.o(s8, "registry");
        this.f2963b = (String) AbstractC2848n.o(str, "defaultPolicy");
    }

    public final F4.Q d(String str, String str2) throws f {
        F4.Q qD = this.f2962a.d(str);
        if (qD != null) {
            return qD;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public b e(P.e eVar) {
        return new b(eVar);
    }

    public a0.b f(Map map) {
        List listA;
        if (map != null) {
            try {
                listA = K0.A(K0.g(map));
            } catch (RuntimeException e8) {
                return a0.b.b(F4.j0.f1799g.r("can't parse load balancer configuration").q(e8));
            }
        } else {
            listA = null;
        }
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return K0.y(listA, this.f2962a);
    }

    public C0532i(String str) {
        this(F4.S.b(), str);
    }

    /* JADX INFO: renamed from: G4.i$e */
    public static final class e extends F4.P {
        public e() {
        }

        @Override // F4.P
        public F4.j0 a(P.h hVar) {
            return F4.j0.f1797e;
        }

        @Override // F4.P
        public void f() {
        }

        @Override // F4.P
        public void c(F4.j0 j0Var) {
        }

        @Override // F4.P
        public void d(P.h hVar) {
        }
    }
}
