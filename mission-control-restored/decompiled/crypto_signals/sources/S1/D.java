package S1;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class D extends A {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2849k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ A f2850l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0236e f2851m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(C0236e c0236e, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, A a6) {
        super(taskCompletionSource);
        this.f2851m = c0236e;
        this.f2849k = taskCompletionSource2;
        this.f2850l = a6;
    }

    @Override // S1.A
    public final void b() {
        synchronized (this.f2851m.f2864f) {
            try {
                C0236e c0236e = this.f2851m;
                TaskCompletionSource taskCompletionSource = this.f2849k;
                c0236e.e.add(taskCompletionSource);
                taskCompletionSource.getTask().addOnCompleteListener(new C(c0236e, taskCompletionSource));
                if (this.f2851m.f2869l.getAndIncrement() > 0) {
                    this.f2851m.f2861b.b("Already connected to the service.", new Object[0]);
                }
                C0236e.b(this.f2851m, this.f2850l);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
