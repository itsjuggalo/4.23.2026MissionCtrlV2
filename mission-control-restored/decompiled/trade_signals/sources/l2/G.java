package l2;

/* JADX INFO: loaded from: classes.dex */
public final class G implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC2328l f20550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ H f20551b;

    public G(H h8, AbstractC2328l abstractC2328l) {
        this.f20551b = h8;
        this.f20550a = abstractC2328l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f20551b.f20553b) {
            try {
                H h8 = this.f20551b;
                if (h8.f20554c != null) {
                    h8.f20554c.onSuccess(this.f20550a.k());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
