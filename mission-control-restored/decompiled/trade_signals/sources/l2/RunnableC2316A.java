package l2;

/* JADX INFO: renamed from: l2.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC2316A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f20536a;

    public RunnableC2316A(B b8) {
        this.f20536a = b8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f20536a.f20538b) {
            try {
                B b8 = this.f20536a;
                if (b8.f20539c != null) {
                    b8.f20539c.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
