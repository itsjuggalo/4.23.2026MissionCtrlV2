package M2;

/* JADX INFO: renamed from: M2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRunnableC0454y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.r f2674a;

    public AbstractRunnableC0454y(K2.r rVar) {
        this.f2674a = rVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        K2.r rVarB = this.f2674a.b();
        try {
            a();
        } finally {
            this.f2674a.f(rVarB);
        }
    }
}
