package n6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends w0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f16642g;

    public a1(f fVar) {
        this.f16642g = fVar;
    }

    @Override // n6.w0
    public final void b() {
        synchronized (this.f16642g.f16653f) {
            try {
                if (this.f16642g.f16659l.get() > 0 && this.f16642g.f16659l.decrementAndGet() > 0) {
                    this.f16642g.f16649b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                f fVar = this.f16642g;
                if (fVar.f16661n != null) {
                    fVar.f16649b.d("Unbind from service.", new Object[0]);
                    f fVar2 = this.f16642g;
                    fVar2.f16648a.unbindService(fVar2.f16660m);
                    this.f16642g.f16654g = false;
                    this.f16642g.f16661n = null;
                    this.f16642g.f16660m = null;
                }
                this.f16642g.x();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
