package b0;

/* JADX INFO: renamed from: b0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0373b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0376e f4815b;

    public /* synthetic */ RunnableC0373b(C0376e c0376e, int i) {
        this.f4814a = i;
        this.f4815b = c0376e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4814a) {
            case 0:
                this.f4815b.h();
                break;
            default:
                this.f4815b.j();
                break;
        }
    }
}
