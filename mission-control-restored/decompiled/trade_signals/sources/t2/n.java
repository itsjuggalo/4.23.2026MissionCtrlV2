package t2;

/* JADX INFO: loaded from: classes.dex */
public final class n extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f23302b;

    public n(t tVar) {
        this.f23302b = tVar;
    }

    @Override // t2.j
    public final void a() {
        synchronized (this.f23302b.f23313f) {
            try {
                if (this.f23302b.f23318k.get() > 0 && this.f23302b.f23318k.decrementAndGet() > 0) {
                    this.f23302b.f23309b.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                t tVar = this.f23302b;
                if (tVar.f23320m != null) {
                    tVar.f23309b.c("Unbind from service.", new Object[0]);
                    t tVar2 = this.f23302b;
                    tVar2.f23308a.unbindService(tVar2.f23319l);
                    this.f23302b.f23314g = false;
                    this.f23302b.f23320m = null;
                    this.f23302b.f23319l = null;
                }
                this.f23302b.w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
