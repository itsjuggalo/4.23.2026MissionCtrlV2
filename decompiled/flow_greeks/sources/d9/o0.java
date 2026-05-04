package d9;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n9.t f7906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g9.q0 f7907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n9.g f7908c = new n9.g();

    public o0(n9.t tVar) {
        this.f7906a = tVar;
    }

    public synchronized Object b(n9.t tVar) {
        c();
        return tVar.apply(this.f7907b);
    }

    public synchronized void c() {
        if (!e()) {
            this.f7907b = (g9.q0) this.f7906a.apply(this.f7908c);
        }
    }

    public synchronized Object d(n9.t tVar, n9.t tVar2) {
        Executor executor = new Executor() { // from class: d9.n0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f7898a.f7908c.m(runnable);
            }
        };
        g9.q0 q0Var = this.f7907b;
        if (q0Var != null && !q0Var.I()) {
            return tVar2.apply(executor);
        }
        return tVar.apply(executor);
    }

    public boolean e() {
        return this.f7907b != null;
    }

    public synchronized void f(s0.a aVar) {
        c();
        aVar.accept(this.f7907b);
    }

    public synchronized Task g() {
        Task taskP;
        c();
        taskP = this.f7907b.P();
        this.f7908c.s();
        return taskP;
    }
}
