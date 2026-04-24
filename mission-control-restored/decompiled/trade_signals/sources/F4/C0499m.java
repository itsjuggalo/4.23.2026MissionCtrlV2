package F4;

import F4.AbstractC0488b;
import java.util.concurrent.Executor;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: F4.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0499m extends AbstractC0488b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0488b f1855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0488b f1856b;

    /* JADX INFO: renamed from: F4.m$a */
    public final class a extends AbstractC0488b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0488b.AbstractC0028b f1857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f1858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC0488b.a f1859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r f1860d;

        public a(AbstractC0488b.AbstractC0028b abstractC0028b, Executor executor, AbstractC0488b.a aVar, r rVar) {
            this.f1857a = abstractC0028b;
            this.f1858b = executor;
            this.f1859c = (AbstractC0488b.a) AbstractC2848n.o(aVar, "delegate");
            this.f1860d = (r) AbstractC2848n.o(rVar, "context");
        }
    }

    public C0499m(AbstractC0488b abstractC0488b, AbstractC0488b abstractC0488b2) {
        this.f1855a = (AbstractC0488b) AbstractC2848n.o(abstractC0488b, "creds1");
        this.f1856b = (AbstractC0488b) AbstractC2848n.o(abstractC0488b2, "creds2");
    }

    @Override // F4.AbstractC0488b
    public void a(AbstractC0488b.AbstractC0028b abstractC0028b, Executor executor, AbstractC0488b.a aVar) {
        this.f1855a.a(abstractC0028b, executor, new a(abstractC0028b, executor, aVar, r.e()));
    }
}
