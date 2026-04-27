package S1;

/* JADX INFO: loaded from: classes.dex */
public final class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2.l f7360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ N f7361b;

    public L(N n8, j2.l lVar) {
        this.f7361b = n8;
        this.f7360a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        N.F(this.f7361b, this.f7360a);
    }
}
