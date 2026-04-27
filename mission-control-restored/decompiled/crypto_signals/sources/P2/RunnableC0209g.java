package P2;

/* JADX INFO: renamed from: P2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0209g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0214l f2440b;

    public /* synthetic */ RunnableC0209g(C0214l c0214l, int i) {
        this.f2439a = i;
        this.f2440b = c0214l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2439a) {
            case 0:
                this.f2440b.f2456b.start();
                break;
            case 1:
                this.f2440b.f2457c.start();
                break;
            default:
                this.f2440b.f2456b.e();
                break;
        }
    }
}
