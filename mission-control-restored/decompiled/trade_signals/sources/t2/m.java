package t2;

import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public final class m extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2329m f23299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f23300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f23301d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(t tVar, C2329m c2329m, C2329m c2329m2, j jVar) {
        super(c2329m);
        this.f23299b = c2329m2;
        this.f23300c = jVar;
        this.f23301d = tVar;
    }

    @Override // t2.j
    public final void a() {
        synchronized (this.f23301d.f23313f) {
            try {
                t.n(this.f23301d, this.f23299b);
                if (this.f23301d.f23318k.getAndIncrement() > 0) {
                    this.f23301d.f23309b.c("Already connected to the service.", new Object[0]);
                }
                t.p(this.f23301d, this.f23300c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
