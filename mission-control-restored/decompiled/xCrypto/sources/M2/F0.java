package M2;

import K2.C0353a;
import K2.c0;
import M2.F0;
import M2.F0.a;

/* JADX INFO: loaded from: classes3.dex */
public final class F0 extends N {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0353a.c f1900e = C0353a.c.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K2.c0 f1901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E0 f1902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final K2.p0 f1903d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            F0.this.b();
        }
    }

    public class b {
        public b() {
        }

        public void a(K2.l0 l0Var) {
            if (l0Var.o()) {
                F0.this.f1902c.reset();
            } else {
                F0.this.f1902c.a(F0.this.new a());
            }
        }
    }

    public class c extends c0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0.d f1906a;

        public c(c0.d dVar) {
            this.f1906a = dVar;
        }

        @Override // K2.c0.d
        public void a(K2.l0 l0Var) {
            this.f1906a.a(l0Var);
            F0.this.f1903d.execute(new Runnable() { // from class: M2.G0
                @Override // java.lang.Runnable
                public final void run() {
                    F0.c cVar = this.f1912a;
                    F0.this.f1902c.a(F0.this.new a());
                }
            });
        }

        @Override // K2.c0.d
        public void b(c0.e eVar) {
            C0353a c0353aB = eVar.b();
            C0353a.c cVar = F0.f1900e;
            if (c0353aB.b(cVar) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            this.f1906a.b(eVar.e().c(eVar.b().d().d(cVar, F0.this.new b()).a()).a());
        }
    }

    public F0(K2.c0 c0Var, E0 e02, K2.p0 p0Var) {
        super(c0Var);
        this.f1901b = c0Var;
        this.f1902c = e02;
        this.f1903d = p0Var;
    }

    @Override // M2.N, K2.c0
    public void c() {
        super.c();
        this.f1902c.reset();
    }

    @Override // M2.N, K2.c0
    public void d(c0.d dVar) {
        super.d(new c(dVar));
    }
}
