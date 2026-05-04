package tb;

import rb.a;
import rb.b1;
import tb.e2;
import tb.e2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e2 extends n0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.c f21212e = a.c.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.b1 f21213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2 f21214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rb.o1 f21215d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e2.this.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b {
        public b() {
        }

        public void a(rb.k1 k1Var) {
            if (k1Var.p()) {
                e2.this.f21214c.reset();
            } else {
                e2.this.f21214c.a(e2.this.new a());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends b1.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b1.d f21218a;

        public c(b1.d dVar) {
            this.f21218a = dVar;
        }

        @Override // rb.b1.d
        public void a(rb.k1 k1Var) {
            this.f21218a.a(k1Var);
            e2.this.f21215d.execute(new Runnable() { // from class: tb.f2
                @Override // java.lang.Runnable
                public final void run() {
                    e2.c cVar = this.f21235a;
                    e2.this.f21214c.a(e2.this.new a());
                }
            });
        }

        @Override // rb.b1.d
        public void b(b1.e eVar) {
            rb.a aVarB = eVar.b();
            a.c cVar = e2.f21212e;
            if (aVarB.b(cVar) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            this.f21218a.b(eVar.e().c(eVar.b().d().d(cVar, e2.this.new b()).a()).a());
        }
    }

    public e2(rb.b1 b1Var, d2 d2Var, rb.o1 o1Var) {
        super(b1Var);
        this.f21213b = b1Var;
        this.f21214c = d2Var;
        this.f21215d = o1Var;
    }

    @Override // tb.n0, rb.b1
    public void c() {
        super.c();
        this.f21214c.reset();
    }

    @Override // tb.n0, rb.b1
    public void d(b1.d dVar) {
        super.d(new c(dVar));
    }
}
