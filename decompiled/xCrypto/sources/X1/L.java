package X1;

/* JADX INFO: loaded from: classes.dex */
public final class L extends H {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0745f f5547g;

    public L(C0745f c0745f) {
        this.f5547g = c0745f;
    }

    @Override // X1.H
    public final void b() {
        synchronized (this.f5547g.f5560f) {
            try {
                if (this.f5547g.f5566l.get() > 0 && this.f5547g.f5566l.decrementAndGet() > 0) {
                    this.f5547g.f5556b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                C0745f c0745f = this.f5547g;
                if (c0745f.f5568n != null) {
                    c0745f.f5556b.d("Unbind from service.", new Object[0]);
                    C0745f c0745f2 = this.f5547g;
                    c0745f2.f5555a.unbindService(c0745f2.f5567m);
                    this.f5547g.f5561g = false;
                    this.f5547g.f5568n = null;
                    this.f5547g.f5567m = null;
                }
                this.f5547g.x();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
