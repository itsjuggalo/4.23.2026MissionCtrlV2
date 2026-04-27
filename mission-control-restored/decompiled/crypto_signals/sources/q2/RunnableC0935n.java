package q2;

/* JADX INFO: renamed from: q2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0935n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f9213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ X0.s f9214c;

    public /* synthetic */ RunnableC0935n(s sVar, X0.s sVar2, int i) {
        this.f9212a = i;
        this.f9213b = sVar;
        this.f9214c = sVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9212a) {
            case 0:
                this.f9213b.a(this.f9214c);
                break;
            default:
                this.f9213b.a(this.f9214c);
                break;
        }
    }
}
