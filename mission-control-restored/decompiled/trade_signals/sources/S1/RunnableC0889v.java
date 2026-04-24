package S1;

/* JADX INFO: renamed from: S1.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0889v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0892y f7444b;

    public RunnableC0889v(C0892y c0892y, int i8) {
        this.f7444b = c0892y;
        this.f7443a = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7444b.i(this.f7443a);
    }
}
