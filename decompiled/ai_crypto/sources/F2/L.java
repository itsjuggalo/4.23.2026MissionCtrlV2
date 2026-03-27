package F2;

/* JADX INFO: loaded from: classes.dex */
public final class L extends H {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0468f f1904g;

    public L(C0468f c0468f) {
        this.f1904g = c0468f;
    }

    @Override // F2.H
    public final void b() {
        synchronized (this.f1904g.f1917f) {
            try {
                if (this.f1904g.f1923l.get() > 0 && this.f1904g.f1923l.decrementAndGet() > 0) {
                    this.f1904g.f1913b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                C0468f c0468f = this.f1904g;
                if (c0468f.f1925n != null) {
                    c0468f.f1913b.d("Unbind from service.", new Object[0]);
                    C0468f c0468f2 = this.f1904g;
                    c0468f2.f1912a.unbindService(c0468f2.f1924m);
                    this.f1904g.f1918g = false;
                    this.f1904g.f1925n = null;
                    this.f1904g.f1924m = null;
                }
                this.f1904g.x();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
