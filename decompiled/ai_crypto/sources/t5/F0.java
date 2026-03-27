package t5;

import r5.C2585a;
import r5.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class F0 extends N {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2585a.c f23451e = C2585a.c.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.c0 f23452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E0 f23453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r5.p0 f23454d;

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

        public void a(r5.l0 l0Var) {
            if (l0Var.o()) {
                F0.this.f23453c.reset();
            } else {
                F0.this.f23453c.a(F0.this.new a());
            }
        }
    }

    public class c extends c0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0.d f23457a;

        public c(c0.d dVar) {
            this.f23457a = dVar;
        }

        @Override // r5.c0.d
        public void a(r5.l0 l0Var) {
            this.f23457a.a(l0Var);
            F0.this.f23454d.execute(new Runnable() { // from class: t5.G0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23463a.d();
                }
            });
        }

        @Override // r5.c0.d
        public void b(c0.e eVar) {
            C2585a c2585aB = eVar.b();
            C2585a.c cVar = F0.f23451e;
            if (c2585aB.b(cVar) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            this.f23457a.b(eVar.e().c(eVar.b().d().d(cVar, F0.this.new b()).a()).a());
        }

        public final /* synthetic */ void d() {
            F0.this.f23453c.a(F0.this.new a());
        }
    }

    public F0(r5.c0 c0Var, E0 e02, r5.p0 p0Var) {
        super(c0Var);
        this.f23452b = c0Var;
        this.f23453c = e02;
        this.f23454d = p0Var;
    }

    @Override // t5.N, r5.c0
    public void c() {
        super.c();
        this.f23453c.reset();
    }

    @Override // t5.N, r5.c0
    public void d(c0.d dVar) {
        super.d(new c(dVar));
    }
}
