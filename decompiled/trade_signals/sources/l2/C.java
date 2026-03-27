package l2;

/* JADX INFO: loaded from: classes.dex */
public final class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC2328l f20540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ D f20541b;

    public C(D d8, AbstractC2328l abstractC2328l) {
        this.f20541b = d8;
        this.f20540a = abstractC2328l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f20541b.f20543b) {
            try {
                D d8 = this.f20541b;
                if (d8.f20544c != null) {
                    d8.f20544c.a(this.f20540a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
