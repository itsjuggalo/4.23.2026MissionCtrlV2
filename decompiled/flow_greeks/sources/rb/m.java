package rb;

import java.util.concurrent.Executor;
import rb.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends rb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.b f19640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.b f19641b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.a f19642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y0 f19643b;

        public a(b.a aVar, y0 y0Var) {
            this.f19642a = aVar;
            this.f19643b = y0Var;
        }

        @Override // rb.b.a
        public void a(y0 y0Var) {
            p6.n.o(y0Var, "headers");
            y0 y0Var2 = new y0();
            y0Var2.m(this.f19643b);
            y0Var2.m(y0Var);
            this.f19642a.a(y0Var2);
        }

        @Override // rb.b.a
        public void b(k1 k1Var) {
            this.f19642a.b(k1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b extends b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.AbstractC0342b f19644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f19645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b.a f19646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r f19647d;

        public b(b.AbstractC0342b abstractC0342b, Executor executor, b.a aVar, r rVar) {
            this.f19644a = abstractC0342b;
            this.f19645b = executor;
            this.f19646c = (b.a) p6.n.o(aVar, "delegate");
            this.f19647d = (r) p6.n.o(rVar, "context");
        }

        @Override // rb.b.a
        public void a(y0 y0Var) {
            p6.n.o(y0Var, "headers");
            r rVarB = this.f19647d.b();
            try {
                m.this.f19641b.a(this.f19644a, this.f19645b, new a(this.f19646c, y0Var));
            } finally {
                this.f19647d.f(rVarB);
            }
        }

        @Override // rb.b.a
        public void b(k1 k1Var) {
            this.f19646c.b(k1Var);
        }
    }

    public m(rb.b bVar, rb.b bVar2) {
        this.f19640a = (rb.b) p6.n.o(bVar, "creds1");
        this.f19641b = (rb.b) p6.n.o(bVar2, "creds2");
    }

    @Override // rb.b
    public void a(b.AbstractC0342b abstractC0342b, Executor executor, b.a aVar) {
        this.f19640a.a(abstractC0342b, executor, new b(abstractC0342b, executor, aVar, r.e()));
    }
}
