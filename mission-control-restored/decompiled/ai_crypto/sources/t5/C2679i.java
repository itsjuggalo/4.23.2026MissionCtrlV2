package t5;

import java.util.List;
import java.util.Map;
import r5.AbstractC2590f;
import r5.EnumC2600p;
import r5.S;
import r5.c0;
import t5.K0;

/* JADX INFO: renamed from: t5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2679i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.U f23935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23936b;

    /* JADX INFO: renamed from: t5.i$b */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.e f23937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r5.S f23938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public r5.T f23939c;

        public b(S.e eVar) {
            this.f23937a = eVar;
            r5.T tD = C2679i.this.f23935a.d(C2679i.this.f23936b);
            this.f23939c = tD;
            if (tD != null) {
                this.f23938b = tD.a(eVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + C2679i.this.f23936b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public r5.S a() {
            return this.f23938b;
        }

        public void b(r5.l0 l0Var) {
            a().c(l0Var);
        }

        public void c() {
            a().e();
        }

        public void d() {
            this.f23938b.f();
            this.f23938b = null;
        }

        public r5.l0 e(S.h hVar) {
            K0.b bVar = (K0.b) hVar.c();
            if (bVar == null) {
                try {
                    C2679i c2679i = C2679i.this;
                    bVar = new K0.b(c2679i.d(c2679i.f23936b, "using default policy"), null);
                } catch (f e7) {
                    this.f23937a.f(EnumC2600p.TRANSIENT_FAILURE, new d(r5.l0.f22719s.q(e7.getMessage())));
                    this.f23938b.f();
                    this.f23939c = null;
                    this.f23938b = new e();
                    return r5.l0.f22705e;
                }
            }
            if (this.f23939c == null || !bVar.f23481a.b().equals(this.f23939c.b())) {
                this.f23937a.f(EnumC2600p.CONNECTING, new c());
                this.f23938b.f();
                r5.T t7 = bVar.f23481a;
                this.f23939c = t7;
                r5.S s7 = this.f23938b;
                this.f23938b = t7.a(this.f23937a);
                this.f23937a.b().b(AbstractC2590f.a.INFO, "Load balancer changed from {0} to {1}", s7.getClass().getSimpleName(), this.f23938b.getClass().getSimpleName());
            }
            Object obj = bVar.f23482b;
            if (obj != null) {
                this.f23937a.b().b(AbstractC2590f.a.DEBUG, "Load-balancing config: {0}", bVar.f23482b);
            }
            return a().a(S.h.d().b(hVar.a()).c(hVar.b()).d(obj).a());
        }
    }

    /* JADX INFO: renamed from: t5.i$c */
    public static final class c extends S.j {
        public c() {
        }

        @Override // r5.S.j
        public S.f a(S.g gVar) {
            return S.f.g();
        }

        public String toString() {
            return H2.g.a(c.class).toString();
        }
    }

    /* JADX INFO: renamed from: t5.i$d */
    public static final class d extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r5.l0 f23941a;

        public d(r5.l0 l0Var) {
            this.f23941a = l0Var;
        }

        @Override // r5.S.j
        public S.f a(S.g gVar) {
            return S.f.f(this.f23941a);
        }
    }

    /* JADX INFO: renamed from: t5.i$f */
    public static final class f extends Exception {
        public f(String str) {
            super(str);
        }
    }

    public C2679i(String str) {
        this(r5.U.b(), str);
    }

    public final r5.T d(String str, String str2) throws f {
        r5.T tD = this.f23935a.d(str);
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
            } catch (RuntimeException e7) {
                return c0.b.b(r5.l0.f22707g.q("can't parse load balancer configuration").p(e7));
            }
        } else {
            listA = null;
        }
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return K0.y(listA, this.f23935a);
    }

    public C2679i(r5.U u7, String str) {
        this.f23935a = (r5.U) H2.m.o(u7, "registry");
        this.f23936b = (String) H2.m.o(str, "defaultPolicy");
    }

    /* JADX INFO: renamed from: t5.i$e */
    public static final class e extends r5.S {
        public e() {
        }

        @Override // r5.S
        public r5.l0 a(S.h hVar) {
            return r5.l0.f22705e;
        }

        @Override // r5.S
        public void f() {
        }

        @Override // r5.S
        public void c(r5.l0 l0Var) {
        }

        @Override // r5.S
        public void d(S.h hVar) {
        }
    }
}
