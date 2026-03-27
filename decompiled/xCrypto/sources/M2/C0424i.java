package M2;

import K2.AbstractC0358f;
import K2.EnumC0368p;
import K2.S;
import K2.c0;
import M2.K0;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: M2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0424i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.U f2384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2385b;

    /* JADX INFO: renamed from: M2.i$b */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.e f2386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public K2.S f2387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public K2.T f2388c;

        public b(S.e eVar) {
            this.f2386a = eVar;
            K2.T tD = C0424i.this.f2384a.d(C0424i.this.f2385b);
            this.f2388c = tD;
            if (tD != null) {
                this.f2387b = tD.a(eVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + C0424i.this.f2385b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public K2.S a() {
            return this.f2387b;
        }

        public void b(K2.l0 l0Var) {
            a().c(l0Var);
        }

        public void c() {
            a().e();
        }

        public void d() {
            this.f2387b.f();
            this.f2387b = null;
        }

        public K2.l0 e(S.h hVar) {
            K0.b bVar = (K0.b) hVar.c();
            if (bVar == null) {
                try {
                    C0424i c0424i = C0424i.this;
                    bVar = new K0.b(c0424i.d(c0424i.f2385b, "using default policy"), null);
                } catch (f e4) {
                    this.f2386a.f(EnumC0368p.TRANSIENT_FAILURE, new d(K2.l0.f1229s.q(e4.getMessage())));
                    this.f2387b.f();
                    this.f2388c = null;
                    this.f2387b = new e();
                    return K2.l0.f1215e;
                }
            }
            if (this.f2388c == null || !bVar.f1930a.b().equals(this.f2388c.b())) {
                this.f2386a.f(EnumC0368p.CONNECTING, new c());
                this.f2387b.f();
                K2.T t4 = bVar.f1930a;
                this.f2388c = t4;
                K2.S s4 = this.f2387b;
                this.f2387b = t4.a(this.f2386a);
                this.f2386a.b().b(AbstractC0358f.a.INFO, "Load balancer changed from {0} to {1}", s4.getClass().getSimpleName(), this.f2387b.getClass().getSimpleName());
            }
            Object obj = bVar.f1931b;
            if (obj != null) {
                this.f2386a.b().b(AbstractC0358f.a.DEBUG, "Load-balancing config: {0}", bVar.f1931b);
            }
            return a().a(S.h.d().b(hVar.a()).c(hVar.b()).d(obj).a());
        }
    }

    /* JADX INFO: renamed from: M2.i$c */
    public static final class c extends S.j {
        public c() {
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return S.f.g();
        }

        public String toString() {
            return Z1.g.a(c.class).toString();
        }
    }

    /* JADX INFO: renamed from: M2.i$d */
    public static final class d extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K2.l0 f2390a;

        public d(K2.l0 l0Var) {
            this.f2390a = l0Var;
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return S.f.f(this.f2390a);
        }
    }

    /* JADX INFO: renamed from: M2.i$f */
    public static final class f extends Exception {
        public f(String str) {
            super(str);
        }
    }

    public C0424i(String str) {
        this(K2.U.b(), str);
    }

    public final K2.T d(String str, String str2) throws f {
        K2.T tD = this.f2384a.d(str);
        if (tD != null) {
            return tD;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public b e(S.e eVar) {
        return new b(eVar);
    }

    public c0.b f(Map map) {
        List listA;
        if (map != null) {
            try {
                listA = K0.A(K0.g(map));
            } catch (RuntimeException e4) {
                return c0.b.b(K2.l0.f1217g.q("can't parse load balancer configuration").p(e4));
            }
        } else {
            listA = null;
        }
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return K0.y(listA, this.f2384a);
    }

    public C0424i(K2.U u4, String str) {
        this.f2384a = (K2.U) Z1.m.o(u4, "registry");
        this.f2385b = (String) Z1.m.o(str, "defaultPolicy");
    }

    /* JADX INFO: renamed from: M2.i$e */
    public static final class e extends K2.S {
        public e() {
        }

        @Override // K2.S
        public K2.l0 a(S.h hVar) {
            return K2.l0.f1215e;
        }

        @Override // K2.S
        public void f() {
        }

        @Override // K2.S
        public void c(K2.l0 l0Var) {
        }

        @Override // K2.S
        public void d(S.h hVar) {
        }
    }
}
