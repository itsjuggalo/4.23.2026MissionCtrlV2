package t5;

/* JADX INFO: renamed from: t5.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractRunnableC2709y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.r f24225a;

    public AbstractRunnableC2709y(r5.r rVar) {
        this.f24225a = rVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        r5.r rVarB = this.f24225a.b();
        try {
            a();
        } finally {
            this.f24225a.f(rVarB);
        }
    }
}
