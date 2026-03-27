package K2;

import K2.AbstractC0354b;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: K2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0365m extends AbstractC0354b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0354b f1259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0354b f1260b;

    /* JADX INFO: renamed from: K2.m$a */
    public static final class a extends AbstractC0354b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0354b.a f1261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Z f1262b;

        public a(AbstractC0354b.a aVar, Z z4) {
            this.f1261a = aVar;
            this.f1262b = z4;
        }

        @Override // K2.AbstractC0354b.a
        public void a(Z z4) {
            Z1.m.o(z4, "headers");
            Z z5 = new Z();
            z5.m(this.f1262b);
            z5.m(z4);
            this.f1261a.a(z5);
        }

        @Override // K2.AbstractC0354b.a
        public void b(l0 l0Var) {
            this.f1261a.b(l0Var);
        }
    }

    /* JADX INFO: renamed from: K2.m$b */
    public final class b extends AbstractC0354b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0354b.AbstractC0030b f1263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f1264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC0354b.a f1265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r f1266d;

        public b(AbstractC0354b.AbstractC0030b abstractC0030b, Executor executor, AbstractC0354b.a aVar, r rVar) {
            this.f1263a = abstractC0030b;
            this.f1264b = executor;
            this.f1265c = (AbstractC0354b.a) Z1.m.o(aVar, "delegate");
            this.f1266d = (r) Z1.m.o(rVar, "context");
        }

        @Override // K2.AbstractC0354b.a
        public void a(Z z4) {
            Z1.m.o(z4, "headers");
            r rVarB = this.f1266d.b();
            try {
                C0365m.this.f1260b.applyRequestMetadata(this.f1263a, this.f1264b, new a(this.f1265c, z4));
            } finally {
                this.f1266d.f(rVarB);
            }
        }

        @Override // K2.AbstractC0354b.a
        public void b(l0 l0Var) {
            this.f1265c.b(l0Var);
        }
    }

    public C0365m(AbstractC0354b abstractC0354b, AbstractC0354b abstractC0354b2) {
        this.f1259a = (AbstractC0354b) Z1.m.o(abstractC0354b, "creds1");
        this.f1260b = (AbstractC0354b) Z1.m.o(abstractC0354b2, "creds2");
    }

    @Override // K2.AbstractC0354b
    public void applyRequestMetadata(AbstractC0354b.AbstractC0030b abstractC0030b, Executor executor, AbstractC0354b.a aVar) {
        this.f1259a.applyRequestMetadata(abstractC0030b, executor, new b(abstractC0030b, executor, aVar, r.e()));
    }
}
