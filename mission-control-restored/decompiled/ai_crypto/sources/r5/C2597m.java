package r5;

import java.util.concurrent.Executor;
import r5.AbstractC2586b;

/* JADX INFO: renamed from: r5.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2597m extends AbstractC2586b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2586b f22749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2586b f22750b;

    /* JADX INFO: renamed from: r5.m$a */
    public static final class a extends AbstractC2586b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2586b.a f22751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Z f22752b;

        public a(AbstractC2586b.a aVar, Z z7) {
            this.f22751a = aVar;
            this.f22752b = z7;
        }

        @Override // r5.AbstractC2586b.a
        public void a(Z z7) {
            H2.m.o(z7, "headers");
            Z z8 = new Z();
            z8.m(this.f22752b);
            z8.m(z7);
            this.f22751a.a(z8);
        }

        @Override // r5.AbstractC2586b.a
        public void b(l0 l0Var) {
            this.f22751a.b(l0Var);
        }
    }

    /* JADX INFO: renamed from: r5.m$b */
    public final class b extends AbstractC2586b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2586b.AbstractC0350b f22753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f22754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC2586b.a f22755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r f22756d;

        public b(AbstractC2586b.AbstractC0350b abstractC0350b, Executor executor, AbstractC2586b.a aVar, r rVar) {
            this.f22753a = abstractC0350b;
            this.f22754b = executor;
            this.f22755c = (AbstractC2586b.a) H2.m.o(aVar, "delegate");
            this.f22756d = (r) H2.m.o(rVar, "context");
        }

        @Override // r5.AbstractC2586b.a
        public void a(Z z7) {
            H2.m.o(z7, "headers");
            r rVarB = this.f22756d.b();
            try {
                C2597m.this.f22750b.a(this.f22753a, this.f22754b, new a(this.f22755c, z7));
            } finally {
                this.f22756d.f(rVarB);
            }
        }

        @Override // r5.AbstractC2586b.a
        public void b(l0 l0Var) {
            this.f22755c.b(l0Var);
        }
    }

    public C2597m(AbstractC2586b abstractC2586b, AbstractC2586b abstractC2586b2) {
        this.f22749a = (AbstractC2586b) H2.m.o(abstractC2586b, "creds1");
        this.f22750b = (AbstractC2586b) H2.m.o(abstractC2586b2, "creds2");
    }

    @Override // r5.AbstractC2586b
    public void a(AbstractC2586b.AbstractC0350b abstractC0350b, Executor executor, AbstractC2586b.a aVar) {
        this.f22749a.a(abstractC0350b, executor, new b(abstractC0350b, executor, aVar, r.e()));
    }
}
