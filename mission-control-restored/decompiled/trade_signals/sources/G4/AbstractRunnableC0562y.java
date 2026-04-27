package G4;

/* JADX INFO: renamed from: G4.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractRunnableC0562y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.r f3250a;

    public AbstractRunnableC0562y(F4.r rVar) {
        this.f3250a = rVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        F4.r rVarB = this.f3250a.b();
        try {
            a();
        } finally {
            this.f3250a.f(rVarB);
        }
    }
}
