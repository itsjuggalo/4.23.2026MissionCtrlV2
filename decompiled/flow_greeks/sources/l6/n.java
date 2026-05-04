package l6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f15505b;

    public n(t tVar) {
        this.f15505b = tVar;
    }

    @Override // l6.j
    public final void a() {
        synchronized (this.f15505b.f15516f) {
            try {
                if (this.f15505b.f15521k.get() > 0 && this.f15505b.f15521k.decrementAndGet() > 0) {
                    this.f15505b.f15512b.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                t tVar = this.f15505b;
                if (tVar.f15523m != null) {
                    tVar.f15512b.c("Unbind from service.", new Object[0]);
                    t tVar2 = this.f15505b;
                    tVar2.f15511a.unbindService(tVar2.f15522l);
                    this.f15505b.f15517g = false;
                    this.f15505b.f15523m = null;
                    this.f15505b.f15522l = null;
                }
                this.f15505b.w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
