package m9;

import android.content.Context;
import bb.r;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static n9.y f16171h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Task f16172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n9.g f16173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rb.c f16174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.b f16175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f16176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g9.l f16177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rb.b f16178g;

    public h0(n9.g gVar, Context context, g9.l lVar, rb.b bVar) {
        this.f16173b = gVar;
        this.f16176e = context;
        this.f16177f = lVar;
        this.f16178g = bVar;
        k();
    }

    public static /* synthetic */ void a(h0 h0Var, rb.u0 u0Var) {
        h0Var.getClass();
        u0Var.n();
        h0Var.k();
    }

    public static /* synthetic */ void e(h0 h0Var, rb.u0 u0Var) {
        h0Var.getClass();
        n9.v.a("GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        h0Var.h();
        h0Var.m(u0Var);
    }

    public static /* synthetic */ Task f(h0 h0Var, rb.z0 z0Var, Task task) {
        h0Var.getClass();
        return Tasks.forResult(((rb.u0) task.getResult()).e(z0Var, h0Var.f16174c));
    }

    public static /* synthetic */ rb.u0 g(final h0 h0Var) {
        final rb.u0 u0VarJ = h0Var.j(h0Var.f16176e, h0Var.f16177f);
        h0Var.f16173b.l(new Runnable() { // from class: m9.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f16121a.l(u0VarJ);
            }
        });
        h0Var.f16174c = ((r.b) ((r.b) bb.r.f(u0VarJ).d(h0Var.f16178g)).f(h0Var.f16173b.o())).b();
        n9.v.a("GrpcCallProvider", "Channel successfully reset.", new Object[0]);
        return u0VarJ;
    }

    public final void h() {
        if (this.f16175d != null) {
            n9.v.a("GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.f16175d.c();
            this.f16175d = null;
        }
    }

    public Task i(final rb.z0 z0Var) {
        return this.f16172a.continueWithTask(this.f16173b.o(), new Continuation() { // from class: m9.e0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return h0.f(this.f16160a, z0Var, task);
            }
        });
    }

    public final rb.u0 j(Context context, g9.l lVar) {
        rb.v0 v0Var;
        try {
            f6.a.a(context);
        } catch (IllegalStateException | m5.g | m5.h e10) {
            n9.v.e("GrpcCallProvider", "Failed to update ssl context: %s", e10);
        }
        n9.y yVar = f16171h;
        if (yVar != null) {
            v0Var = (rb.v0) yVar.get();
        } else {
            rb.v0 v0VarB = rb.v0.b(lVar.b());
            if (!lVar.d()) {
                v0VarB.d();
            }
            v0Var = v0VarB;
        }
        v0Var.c(30L, TimeUnit.SECONDS);
        return sb.a.k(v0Var).i(context).a();
    }

    public final void k() {
        this.f16172a = Tasks.call(n9.p.f16964c, new Callable() { // from class: m9.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return h0.g(this.f16117a);
            }
        });
    }

    public final void l(final rb.u0 u0Var) {
        rb.p pVarK = u0Var.k(true);
        n9.v.a("GrpcCallProvider", "Current gRPC connectivity state: " + pVarK, new Object[0]);
        h();
        if (pVarK == rb.p.CONNECTING) {
            n9.v.a("GrpcCallProvider", "Setting the connectivityAttemptTimer", new Object[0]);
            this.f16175d = this.f16173b.k(g.d.CONNECTIVITY_ATTEMPT_TIMER, 15000L, new Runnable() { // from class: m9.c0
                @Override // java.lang.Runnable
                public final void run() {
                    h0.e(this.f16151a, u0Var);
                }
            });
        }
        u0Var.l(pVarK, new Runnable() { // from class: m9.d0
            @Override // java.lang.Runnable
            public final void run() {
                h0 h0Var = this.f16156a;
                h0Var.f16173b.l(new Runnable() { // from class: m9.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        h0Var.l(u0Var);
                    }
                });
            }
        });
    }

    public final void m(final rb.u0 u0Var) {
        this.f16173b.l(new Runnable() { // from class: m9.g0
            @Override // java.lang.Runnable
            public final void run() {
                h0.a(this.f16167a, u0Var);
            }
        });
    }

    public void n() {
        try {
            rb.u0 u0Var = (rb.u0) Tasks.await(this.f16172a);
            u0Var.m();
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (u0Var.i(1L, timeUnit)) {
                    return;
                }
                n9.v.a(y.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
                u0Var.n();
                if (u0Var.i(60L, timeUnit)) {
                    return;
                }
                n9.v.e(y.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]);
            } catch (InterruptedException unused) {
                u0Var.n();
                n9.v.e(y.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused2) {
            n9.v.e(y.class.getSimpleName(), "Interrupted while retrieving the gRPC Managed Channel", new Object[0]);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e10) {
            n9.v.e(y.class.getSimpleName(), "Channel is not initialized, shutdown will just do nothing. Channel initializing run into exception: %s", e10);
        }
    }
}
