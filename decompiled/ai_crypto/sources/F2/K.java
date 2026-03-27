package F2;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class K extends H {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f1901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ H f1902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C0468f f1903i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(C0468f c0468f, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, H h7) {
        super(taskCompletionSource);
        this.f1903i = c0468f;
        this.f1901g = taskCompletionSource2;
        this.f1902h = h7;
    }

    @Override // F2.H
    public final void b() {
        synchronized (this.f1903i.f1917f) {
            try {
                C0468f.o(this.f1903i, this.f1901g);
                if (this.f1903i.f1923l.getAndIncrement() > 0) {
                    this.f1903i.f1913b.d("Already connected to the service.", new Object[0]);
                }
                C0468f.q(this.f1903i, this.f1902h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
