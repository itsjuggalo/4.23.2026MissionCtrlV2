package G4;

import F4.C0487a;
import F4.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class F0 extends N {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0487a.c f2488e = C0487a.c.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F4.a0 f2489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E0 f2490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final F4.n0 f2491d;

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

        public void a(F4.j0 j0Var) {
            if (j0Var.p()) {
                F0.this.f2490c.reset();
            } else {
                F0.this.f2490c.a(F0.this.new a());
            }
        }
    }

    public class c extends a0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a0.d f2494a;

        public c(a0.d dVar) {
            this.f2494a = dVar;
        }

        @Override // F4.a0.d
        public void a(F4.j0 j0Var) {
            this.f2494a.a(j0Var);
            F0.this.f2491d.execute(new Runnable() { // from class: G4.G0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2500a.d();
                }
            });
        }

        @Override // F4.a0.d
        public void b(a0.e eVar) {
            C0487a c0487aB = eVar.b();
            C0487a.c cVar = F0.f2488e;
            if (c0487aB.b(cVar) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            this.f2494a.b(eVar.e().c(eVar.b().d().d(cVar, F0.this.new b()).a()).a());
        }

        public final /* synthetic */ void d() {
            F0.this.f2490c.a(F0.this.new a());
        }
    }

    public F0(F4.a0 a0Var, E0 e02, F4.n0 n0Var) {
        super(a0Var);
        this.f2489b = a0Var;
        this.f2490c = e02;
        this.f2491d = n0Var;
    }

    @Override // G4.N, F4.a0
    public void c() {
        super.c();
        this.f2490c.reset();
    }

    @Override // G4.N, F4.a0
    public void d(a0.d dVar) {
        super.d(new c(dVar));
    }
}
