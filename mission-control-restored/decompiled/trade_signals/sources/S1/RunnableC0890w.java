package S1;

/* JADX INFO: renamed from: S1.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0890w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0891x f7445a;

    public RunnableC0890w(C0891x c0891x) {
        this.f7445a = c0891x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0892y c0892y = this.f7445a.f7446a;
        c0892y.f7448b.disconnect(c0892y.f7448b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
