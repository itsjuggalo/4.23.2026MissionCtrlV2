package l6;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f15502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f15503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f15504d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(t tVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, j jVar) {
        super(taskCompletionSource);
        this.f15502b = taskCompletionSource2;
        this.f15503c = jVar;
        this.f15504d = tVar;
    }

    @Override // l6.j
    public final void a() {
        synchronized (this.f15504d.f15516f) {
            try {
                t.n(this.f15504d, this.f15502b);
                if (this.f15504d.f15521k.getAndIncrement() > 0) {
                    this.f15504d.f15512b.c("Already connected to the service.", new Object[0]);
                }
                t.p(this.f15504d, this.f15503c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
