package W2;

import Q2.m;
import X2.a;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class e extends V2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.g f5394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N3.b f5395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f5396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f5398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f5399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f5400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f5401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f5402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Task f5403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final X2.a f5404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public V2.a f5405l;

    public e(Q2.g gVar, N3.b bVar, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService) {
        AbstractC1207s.k(gVar);
        AbstractC1207s.k(bVar);
        this.f5394a = gVar;
        this.f5395b = bVar;
        this.f5396c = new ArrayList();
        this.f5397d = new ArrayList();
        this.f5398e = new j(gVar.m(), gVar.s());
        this.f5399f = new k(gVar.m(), this, executor2, scheduledExecutorService);
        this.f5400g = executor;
        this.f5401h = executor2;
        this.f5402i = executor3;
        this.f5403j = j(executor3);
        this.f5404k = new a.C0098a();
    }

    @Override // Y2.b
    public Task a(final boolean z7) {
        return this.f5403j.continueWithTask(this.f5401h, new Continuation() { // from class: W2.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f5392a.h(z7, task);
            }
        });
    }

    @Override // Y2.b
    public void b(Y2.a aVar) {
        AbstractC1207s.k(aVar);
        this.f5396c.remove(aVar);
        this.f5399f.d(this.f5396c.size() + this.f5397d.size());
    }

    @Override // Y2.b
    public void c(Y2.a aVar) {
        AbstractC1207s.k(aVar);
        this.f5396c.add(aVar);
        this.f5399f.d(this.f5396c.size() + this.f5397d.size());
        if (g()) {
            aVar.a(b.c(this.f5405l));
        }
    }

    public Task f() {
        throw null;
    }

    public final boolean g() {
        V2.a aVar = this.f5405l;
        return aVar != null && aVar.a() - this.f5404k.a() > 300000;
    }

    public final /* synthetic */ Task h(boolean z7, Task task) {
        return (z7 || !g()) ? Tasks.forResult(b.d(new m("No AppCheckProvider installed."))) : Tasks.forResult(b.c(this.f5405l));
    }

    public final /* synthetic */ void i(TaskCompletionSource taskCompletionSource) {
        V2.a aVarD = this.f5398e.d();
        if (aVarD != null) {
            k(aVarD);
        }
        taskCompletionSource.setResult(null);
    }

    public final Task j(Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: W2.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f5390a.i(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void k(V2.a aVar) {
        this.f5405l = aVar;
    }
}
