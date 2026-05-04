package n6;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends w0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f16688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ w0 f16689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f f16690i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(f fVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, w0 w0Var) {
        super(taskCompletionSource);
        this.f16688g = taskCompletionSource2;
        this.f16689h = w0Var;
        this.f16690i = fVar;
    }

    @Override // n6.w0
    public final void b() {
        synchronized (this.f16690i.f16653f) {
            try {
                f.o(this.f16690i, this.f16688g);
                if (this.f16690i.f16659l.getAndIncrement() > 0) {
                    this.f16690i.f16649b.d("Already connected to the service.", new Object[0]);
                }
                f.q(this.f16690i, this.f16689h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
