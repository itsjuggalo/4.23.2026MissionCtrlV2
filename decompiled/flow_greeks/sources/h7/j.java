package h7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import e7.e;
import i7.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends e7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f11057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fa.b f11058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f11059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f11061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f11062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f11063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f11064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f11065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Task f11066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i7.a f11067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e7.b f11068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e7.a f11069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e7.c f11070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Task f11071o;

    public j(a7.g gVar, fa.b bVar, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService) {
        com.google.android.gms.common.internal.s.k(gVar);
        com.google.android.gms.common.internal.s.k(bVar);
        this.f11057a = gVar;
        this.f11058b = bVar;
        this.f11059c = new ArrayList();
        this.f11060d = new ArrayList();
        this.f11061e = new r(gVar.m(), gVar.s());
        this.f11062f = new s(gVar.m(), this, executor2, scheduledExecutorService);
        this.f11063g = executor;
        this.f11064h = executor2;
        this.f11065i = executor3;
        this.f11066j = u(executor3);
        this.f11067k = new a.C0224a();
    }

    public static /* synthetic */ Task l(Task task) {
        return task.isSuccessful() ? Tasks.forResult(c.c((e7.c) task.getResult())) : Tasks.forResult(c.d(new a7.m(task.getException().getMessage(), task.getException())));
    }

    public static /* synthetic */ Task m(j jVar, e7.c cVar) {
        jVar.w(cVar);
        Iterator it = jVar.f11060d.iterator();
        while (it.hasNext()) {
            ((e.a) it.next()).a(cVar);
        }
        c cVarC = c.c(cVar);
        Iterator it2 = jVar.f11059c.iterator();
        while (it2.hasNext()) {
            ((j7.a) it2.next()).a(cVarC);
        }
        return Tasks.forResult(cVar);
    }

    public static /* synthetic */ Task n(j jVar, boolean z10, Task task) {
        if (!z10 && jVar.s()) {
            return Tasks.forResult(c.c(jVar.f11070n));
        }
        if (jVar.f11069m == null) {
            return Tasks.forResult(c.d(new a7.m("No AppCheckProvider installed.")));
        }
        Task task2 = jVar.f11071o;
        if (task2 == null || task2.isComplete() || jVar.f11071o.isCanceled()) {
            jVar.f11071o = jVar.q();
        }
        return jVar.f11071o.continueWithTask(jVar.f11064h, new Continuation() { // from class: h7.g
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                return j.l(task3);
            }
        });
    }

    public static /* synthetic */ Task o(j jVar, boolean z10, Task task) {
        if (!z10 && jVar.s()) {
            return Tasks.forResult(jVar.f11070n);
        }
        if (jVar.f11069m == null) {
            return Tasks.forException(new a7.m("No AppCheckProvider installed."));
        }
        Task task2 = jVar.f11071o;
        if (task2 == null || task2.isComplete() || jVar.f11071o.isCanceled()) {
            jVar.f11071o = jVar.q();
        }
        return jVar.f11071o;
    }

    public static /* synthetic */ void p(j jVar, TaskCompletionSource taskCompletionSource) {
        e7.c cVarC = jVar.f11061e.c();
        if (cVarC != null) {
            jVar.v(cVarC);
        }
        taskCompletionSource.setResult(null);
    }

    @Override // j7.b
    public Task a(final boolean z10) {
        return this.f11066j.continueWithTask(this.f11064h, new Continuation() { // from class: h7.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return j.n(this.f11052a, z10, task);
            }
        });
    }

    @Override // j7.b
    public void b(j7.a aVar) {
        com.google.android.gms.common.internal.s.k(aVar);
        this.f11059c.remove(aVar);
        this.f11062f.e(this.f11059c.size() + this.f11060d.size());
    }

    @Override // j7.b
    public void c(j7.a aVar) {
        com.google.android.gms.common.internal.s.k(aVar);
        this.f11059c.add(aVar);
        this.f11062f.e(this.f11059c.size() + this.f11060d.size());
        if (s()) {
            aVar.a(c.c(this.f11070n));
        }
    }

    @Override // e7.e
    public void d(e.a aVar) {
        com.google.android.gms.common.internal.s.k(aVar);
        this.f11060d.add(aVar);
        this.f11062f.e(this.f11059c.size() + this.f11060d.size());
        if (s()) {
            aVar.a(this.f11070n);
        }
    }

    @Override // e7.e
    public Task e(final boolean z10) {
        return this.f11066j.continueWithTask(this.f11064h, new Continuation() { // from class: h7.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return j.o(this.f11050a, z10, task);
            }
        });
    }

    @Override // e7.e
    public Task g() {
        e7.a aVar = this.f11069m;
        return aVar == null ? Tasks.forException(new a7.m("No AppCheckProvider installed.")) : aVar.a();
    }

    @Override // e7.e
    public void h(e7.b bVar) {
        t(bVar, this.f11057a.x());
    }

    @Override // e7.e
    public void i(e.a aVar) {
        com.google.android.gms.common.internal.s.k(aVar);
        this.f11060d.remove(aVar);
        this.f11062f.e(this.f11059c.size() + this.f11060d.size());
    }

    @Override // e7.e
    public void j(boolean z10) {
        this.f11062f.f(z10);
    }

    public Task q() {
        return this.f11069m.a().onSuccessTask(this.f11063g, new SuccessContinuation() { // from class: h7.h
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return j.m(this.f11054a, (e7.c) obj);
            }
        });
    }

    public fa.b r() {
        return this.f11058b;
    }

    public final boolean s() {
        e7.c cVar = this.f11070n;
        return cVar != null && cVar.a() - this.f11067k.a() > 300000;
    }

    public void t(e7.b bVar, boolean z10) {
        com.google.android.gms.common.internal.s.k(bVar);
        this.f11068l = bVar;
        this.f11069m = bVar.a(this.f11057a);
        this.f11062f.f(z10);
    }

    public final Task u(Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: h7.d
            @Override // java.lang.Runnable
            public final void run() {
                j.p(this.f11048a, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void v(e7.c cVar) {
        this.f11070n = cVar;
    }

    public final void w(final e7.c cVar) {
        this.f11065i.execute(new Runnable() { // from class: h7.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f11055a.f11061e.d(cVar);
            }
        });
        v(cVar);
        this.f11062f.d(cVar);
    }
}
