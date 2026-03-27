package n2;

import l2.C2329m;

/* JADX INFO: renamed from: n2.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2416w extends AbstractRunnableC2413t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2329m f21599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractRunnableC2413t f21600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C2391D f21601d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2416w(C2391D c2391d, C2329m c2329m, C2329m c2329m2, AbstractRunnableC2413t abstractRunnableC2413t) {
        super(c2329m);
        this.f21601d = c2391d;
        this.f21599b = c2329m2;
        this.f21600c = abstractRunnableC2413t;
    }

    @Override // n2.AbstractRunnableC2413t
    public final void a() {
        synchronized (this.f21601d.f21567f) {
            try {
                C2391D.n(this.f21601d, this.f21599b);
                if (this.f21601d.f21572k.getAndIncrement() > 0) {
                    this.f21601d.f21563b.d("Already connected to the service.", new Object[0]);
                }
                C2391D.p(this.f21601d, this.f21600c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
