package n2;

/* JADX INFO: renamed from: n2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2417x extends AbstractRunnableC2413t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2391D f21602b;

    public C2417x(C2391D c2391d) {
        this.f21602b = c2391d;
    }

    @Override // n2.AbstractRunnableC2413t
    public final void a() {
        synchronized (this.f21602b.f21567f) {
            try {
                if (this.f21602b.f21572k.get() > 0 && this.f21602b.f21572k.decrementAndGet() > 0) {
                    this.f21602b.f21563b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                C2391D c2391d = this.f21602b;
                if (c2391d.f21574m != null) {
                    c2391d.f21563b.d("Unbind from service.", new Object[0]);
                    C2391D c2391d2 = this.f21602b;
                    c2391d2.f21562a.unbindService(c2391d2.f21573l);
                    this.f21602b.f21568g = false;
                    this.f21602b.f21574m = null;
                    this.f21602b.f21573l = null;
                }
                this.f21602b.w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
