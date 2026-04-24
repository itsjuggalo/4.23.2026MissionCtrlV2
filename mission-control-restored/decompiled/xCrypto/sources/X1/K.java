package X1;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class K extends H {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ H f5545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C0745f f5546i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(C0745f c0745f, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, H h4) {
        super(taskCompletionSource);
        this.f5546i = c0745f;
        this.f5544g = taskCompletionSource2;
        this.f5545h = h4;
    }

    @Override // X1.H
    public final void b() {
        synchronized (this.f5546i.f5560f) {
            try {
                C0745f.o(this.f5546i, this.f5544g);
                if (this.f5546i.f5566l.getAndIncrement() > 0) {
                    this.f5546i.f5556b.d("Already connected to the service.", new Object[0]);
                }
                C0745f.q(this.f5546i, this.f5545h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
