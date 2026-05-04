package g9;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.f;
import g9.j;
import g9.o;
import i9.l;
import i9.l4;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f10342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e9.a f10343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e9.a f10344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n9.g f10345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f9.g f10346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i9.h1 f10347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i9.k0 f10348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m9.s0 f10349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f1 f10350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o f10351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l4 f10352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l4 f10353l;

    public q0(final Context context, l lVar, e9.a aVar, e9.a aVar2, final n9.g gVar, final m9.i0 i0Var, final j jVar) {
        this.f10342a = lVar;
        this.f10343b = aVar;
        this.f10344c = aVar2;
        this.f10345d = gVar;
        this.f10346e = new f9.g(new m9.o0(lVar.a()));
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        gVar.l(new Runnable() { // from class: g9.v
            @Override // java.lang.Runnable
            public final void run() {
                q0.t(this.f10381a, taskCompletionSource, context, jVar, i0Var);
            }
        });
        aVar.d(new n9.u() { // from class: g9.w
            @Override // n9.u
            public final void a(Object obj) {
                q0.a(this.f10392a, atomicBoolean, taskCompletionSource, gVar, (e9.j) obj);
            }
        });
        aVar2.d(new n9.u() { // from class: g9.x
            @Override // n9.u
            public final void a(Object obj) {
                q0.m((String) obj);
            }
        });
    }

    public static /* synthetic */ void a(final q0 q0Var, AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, n9.g gVar, final e9.j jVar) {
        q0Var.getClass();
        if (!atomicBoolean.compareAndSet(false, true)) {
            gVar.l(new Runnable() { // from class: g9.g0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.u(this.f10211a, jVar);
                }
            });
        } else {
            n9.b.d(!taskCompletionSource.getTask().isComplete(), "Already fulfilled first user task", new Object[0]);
            taskCompletionSource.setResult(jVar);
        }
    }

    public static /* synthetic */ y1 g(q0 q0Var, b1 b1Var) {
        i9.l1 l1VarC = q0Var.f10348g.C(b1Var, true);
        w1 w1Var = new w1(b1Var, l1VarC.b());
        return w1Var.b(w1Var.h(l1VarC.a())).b();
    }

    public static /* synthetic */ j9.h h(Task task) throws com.google.firebase.firestore.f {
        j9.h hVar = (j9.h) task.getResult();
        if (hVar.b()) {
            return hVar;
        }
        if (hVar.i()) {
            return null;
        }
        throw new com.google.firebase.firestore.f("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", f.a.UNAVAILABLE);
    }

    public static /* synthetic */ void i(q0 q0Var, String str, TaskCompletionSource taskCompletionSource) {
        f9.j jVarJ = q0Var.f10348g.J(str);
        if (jVarJ == null) {
            taskCompletionSource.setResult(null);
        } else {
            g1 g1VarB = jVarJ.a().b();
            taskCompletionSource.setResult(new b1(g1VarB.n(), g1VarB.d(), g1VarB.h(), g1VarB.m(), g1VarB.j(), jVarJ.a().a(), g1VarB.p(), g1VarB.f()));
        }
    }

    public static /* synthetic */ void t(q0 q0Var, TaskCompletionSource taskCompletionSource, Context context, j jVar, m9.i0 i0Var) {
        q0Var.getClass();
        try {
            q0Var.H(context, (e9.j) Tasks.await(taskCompletionSource.getTask()), jVar, i0Var);
        } catch (InterruptedException | ExecutionException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static /* synthetic */ void u(q0 q0Var, e9.j jVar) {
        n9.b.d(q0Var.f10350i != null, "SyncEngine not yet initialized", new Object[0]);
        n9.v.a("FirestoreClient", "Credential changed. Current user: %s", jVar.a());
        q0Var.f10350i.l(jVar);
    }

    public static /* synthetic */ void y(q0 q0Var) {
        q0Var.f10349h.M();
        q0Var.f10347f.m();
        l4 l4Var = q0Var.f10353l;
        if (l4Var != null) {
            l4Var.stop();
        }
        l4 l4Var2 = q0Var.f10352k;
        if (l4Var2 != null) {
            l4Var2.stop();
        }
    }

    public Task A(final List list) {
        R();
        return this.f10345d.i(new Runnable() { // from class: g9.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f10362a.f10348g.A(list);
            }
        });
    }

    public void B() {
        R();
        this.f10345d.l(new Runnable() { // from class: g9.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10275a.f10348g.B();
            }
        });
    }

    public Task C() {
        R();
        return this.f10345d.i(new Runnable() { // from class: g9.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f10412a.f10349h.q();
            }
        });
    }

    public Task D() {
        R();
        return this.f10345d.i(new Runnable() { // from class: g9.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f10368a.f10349h.s();
            }
        });
    }

    public Task E(final j9.k kVar) {
        R();
        return this.f10345d.j(new Callable() { // from class: g9.n0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f10290a.f10348g.S(kVar);
            }
        }).continueWith(new Continuation() { // from class: g9.o0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return q0.h(task);
            }
        });
    }

    public Task F(final b1 b1Var) {
        R();
        return this.f10345d.j(new Callable() { // from class: g9.r
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q0.g(this.f10357a, b1Var);
            }
        });
    }

    public Task G(final String str) {
        R();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10345d.l(new Runnable() { // from class: g9.i0
            @Override // java.lang.Runnable
            public final void run() {
                q0.i(this.f10231a, str, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final void H(Context context, e9.j jVar, j jVar2, m9.i0 i0Var) {
        n9.v.a("FirestoreClient", "Initializing. user=%s", jVar.a());
        jVar2.s(new j.a(context, this.f10345d, this.f10342a, jVar, 100, this.f10343b, this.f10344c, i0Var));
        this.f10347f = jVar2.o();
        this.f10353l = jVar2.l();
        this.f10348g = jVar2.n();
        this.f10349h = jVar2.q();
        this.f10350i = jVar2.r();
        this.f10351j = jVar2.k();
        i9.l lVarM = jVar2.m();
        l4 l4Var = this.f10353l;
        if (l4Var != null) {
            l4Var.start();
        }
        if (lVarM != null) {
            l.a aVarF = lVarM.f();
            this.f10352k = aVarF;
            aVarF.start();
        }
    }

    public boolean I() {
        return this.f10345d.p();
    }

    public c1 J(b1 b1Var, o.b bVar, d9.r rVar) {
        R();
        final c1 c1Var = new c1(b1Var, bVar, rVar);
        this.f10345d.l(new Runnable() { // from class: g9.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10225a.f10351j.d(c1Var);
            }
        });
        return c1Var;
    }

    public void K(InputStream inputStream, final d9.v0 v0Var) {
        R();
        final f9.f fVar = new f9.f(this.f10346e, inputStream);
        this.f10345d.l(new Runnable() { // from class: g9.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10284a.f10350i.p(fVar, v0Var);
            }
        });
    }

    public void L(final d9.r rVar) {
        this.f10345d.l(new Runnable() { // from class: g9.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10140a.f10351j.h(rVar);
            }
        });
    }

    public Task M(final b1 b1Var, final List list) {
        R();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10345d.l(new Runnable() { // from class: g9.z
            @Override // java.lang.Runnable
            public final void run() {
                q0 q0Var = this.f10426a;
                b1 b1Var2 = b1Var;
                List list2 = list;
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                q0Var.f10350i.x(b1Var2, list2).addOnSuccessListener(new OnSuccessListener() { // from class: g9.d0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        taskCompletionSource2.setResult((Map) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: g9.e0
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        taskCompletionSource2.setException(exc);
                    }
                });
            }
        });
        return taskCompletionSource.getTask();
    }

    public void N(final boolean z10) {
        R();
        this.f10345d.l(new Runnable() { // from class: g9.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10252a.f10348g.V(z10);
            }
        });
    }

    public void O(final c1 c1Var) {
        this.f10345d.l(new Runnable() { // from class: g9.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10150a.f10351j.g(c1Var);
            }
        });
    }

    public Task P() {
        this.f10343b.c();
        this.f10344c.c();
        return this.f10345d.n(new Runnable() { // from class: g9.u
            @Override // java.lang.Runnable
            public final void run() {
                q0.y(this.f10373a);
            }
        });
    }

    public Task Q(final d9.w1 w1Var, final n9.t tVar) {
        R();
        return n9.g.g(this.f10345d.o(), new Callable() { // from class: g9.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 q0Var = this.f10261a;
                return q0Var.f10350i.C(q0Var.f10345d, w1Var, tVar);
            }
        });
    }

    public final void R() {
        if (I()) {
            throw new IllegalStateException("The client has already been terminated");
        }
    }

    public Task S() {
        R();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10345d.l(new Runnable() { // from class: g9.p0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10339a.f10350i.t(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task T(final List list) {
        R();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10345d.l(new Runnable() { // from class: g9.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10171a.f10350i.E(list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void z(final d9.r rVar) {
        R();
        this.f10345d.l(new Runnable() { // from class: g9.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10188a.f10351j.e(rVar);
            }
        });
    }

    public static /* synthetic */ void m(String str) {
    }
}
