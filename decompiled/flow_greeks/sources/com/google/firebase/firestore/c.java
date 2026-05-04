package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.f;
import d9.q1;
import d9.r;
import d9.r1;
import d9.s0;
import d9.t0;
import d9.t1;
import g9.b1;
import g9.c1;
import g9.o;
import g9.q0;
import g9.y1;
import j9.t;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import n9.g0;
import n9.p;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.k f6138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseFirestore f6139b;

    public c(j9.k kVar, FirebaseFirestore firebaseFirestore) {
        this.f6138a = (j9.k) x.b(kVar);
        this.f6139b = firebaseFirestore;
    }

    public static /* synthetic */ void a(g9.h hVar, q0 q0Var, c1 c1Var) {
        hVar.c();
        q0Var.O(c1Var);
    }

    public static /* synthetic */ d b(c cVar, Task task) {
        cVar.getClass();
        j9.h hVar = (j9.h) task.getResult();
        return new d(cVar.f6139b, cVar.f6138a, hVar, true, hVar != null && hVar.d());
    }

    public static /* synthetic */ t0 c(b1 b1Var, o.b bVar, final g9.h hVar, Activity activity, final q0 q0Var) {
        final c1 c1VarJ = q0Var.J(b1Var, bVar, hVar);
        return g9.d.c(activity, new t0() { // from class: d9.q
            @Override // d9.t0
            public final void remove() {
                com.google.firebase.firestore.c.a(hVar, q0Var, c1VarJ);
            }
        });
    }

    public static /* synthetic */ void d(c cVar, r rVar, y1 y1Var, f fVar) {
        cVar.getClass();
        if (fVar != null) {
            rVar.a(null, fVar);
            return;
        }
        n9.b.d(y1Var != null, "Got event without value or error set", new Object[0]);
        n9.b.d(y1Var.e().size() <= 1, "Too many documents returned on a document query", new Object[0]);
        j9.h hVarE = y1Var.e().e(cVar.f6138a);
        rVar.a(hVarE != null ? d.b(cVar.f6139b, hVarE, y1Var.k(), y1Var.f().contains(hVarE.getKey())) : d.c(cVar.f6139b, cVar.f6138a, y1Var.k()), null);
    }

    public static /* synthetic */ void i(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, t1 t1Var, d dVar, f fVar) {
        if (fVar != null) {
            taskCompletionSource.setException(fVar);
            return;
        }
        try {
            ((t0) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (!dVar.a() && dVar.f().b()) {
                taskCompletionSource.setException(new f("Failed to get document because the client is offline.", f.a.UNAVAILABLE));
            } else if (dVar.a() && dVar.f().b() && t1Var == t1.SERVER) {
                taskCompletionSource.setException(new f("Failed to get document from server. (However, this document does exist in the local cache. Run again without setting source to SERVER to retrieve the cached document.)", f.a.UNAVAILABLE));
            } else {
                taskCompletionSource.setResult(dVar);
            }
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw n9.b.b(e10, "Failed to register a listener for a single document", new Object[0]);
        } catch (ExecutionException e11) {
            throw n9.b.b(e11, "Failed to register a listener for a single document", new Object[0]);
        }
    }

    public static c n(t tVar, FirebaseFirestore firebaseFirestore) {
        if (tVar.u() % 2 == 0) {
            return new c(j9.k.k(tVar), firebaseFirestore);
        }
        throw new IllegalArgumentException("Invalid document reference. Document references must have an even number of segments, but " + tVar.c() + " has " + tVar.u());
    }

    public static o.b t(d9.b1 b1Var, s0 s0Var) {
        o.b bVar = new o.b();
        d9.b1 b1Var2 = d9.b1.INCLUDE;
        bVar.f10300a = b1Var == b1Var2;
        bVar.f10301b = b1Var == b1Var2;
        bVar.f10302c = false;
        bVar.f10303d = s0Var;
        return bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6138a.equals(cVar.f6138a) && this.f6139b.equals(cVar.f6139b);
    }

    public int hashCode() {
        return (this.f6138a.hashCode() * 31) + this.f6139b.hashCode();
    }

    public t0 j(r1 r1Var, r rVar) {
        x.c(r1Var, "Provided options value must not be null.");
        x.c(rVar, "Provided EventListener must not be null.");
        return k(r1Var.b(), t(r1Var.c(), r1Var.d()), r1Var.a(), rVar);
    }

    public final t0 k(Executor executor, final o.b bVar, final Activity activity, final r rVar) {
        final g9.h hVar = new g9.h(executor, new r() { // from class: d9.n
            @Override // d9.r
            public final void a(Object obj, com.google.firebase.firestore.f fVar) {
                com.google.firebase.firestore.c.d(this.f7896a, rVar, (g9.y1) obj, fVar);
            }
        });
        final b1 b1VarL = l();
        return (t0) this.f6139b.s(new n9.t() { // from class: d9.o
            @Override // n9.t
            public final Object apply(Object obj) {
                return com.google.firebase.firestore.c.c(b1VarL, bVar, hVar, activity, (g9.q0) obj);
            }
        });
    }

    public final b1 l() {
        return b1.b(this.f6138a.s());
    }

    public Task m() {
        final List listSingletonList = Collections.singletonList(new k9.c(this.f6138a, k9.m.f14793c));
        return ((Task) this.f6139b.s(new n9.t() { // from class: d9.i
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).T(listSingletonList);
            }
        })).continueWith(p.f16963b, g0.x());
    }

    public Task o(t1 t1Var) {
        return t1Var == t1.CACHE ? ((Task) this.f6139b.s(new n9.t() { // from class: d9.l
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).E(this.f7885a.f6138a);
            }
        })).continueWith(p.f16963b, new Continuation() { // from class: d9.m
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return com.google.firebase.firestore.c.b(this.f7888a, task);
            }
        }) : s(t1Var);
    }

    public FirebaseFirestore p() {
        return this.f6139b;
    }

    public j9.k q() {
        return this.f6138a;
    }

    public String r() {
        return this.f6138a.s().c();
    }

    public final Task s(final t1 t1Var) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        o.b bVar = new o.b();
        bVar.f10300a = true;
        bVar.f10301b = true;
        bVar.f10302c = true;
        taskCompletionSource2.setResult(k(p.f16963b, bVar, null, new r() { // from class: d9.p
            @Override // d9.r
            public final void a(Object obj, com.google.firebase.firestore.f fVar) {
                com.google.firebase.firestore.c.i(taskCompletionSource, taskCompletionSource2, t1Var, (com.google.firebase.firestore.d) obj, fVar);
            }
        }));
        return taskCompletionSource.getTask();
    }

    public Task u(Object obj) {
        return v(obj, q1.f7920c);
    }

    public Task v(Object obj, q1 q1Var) {
        x.c(obj, "Provided data must not be null.");
        x.c(q1Var, "Provided options must not be null.");
        final List listSingletonList = Collections.singletonList((q1Var.b() ? this.f6139b.F().g(obj, q1Var.a()) : this.f6139b.F().l(obj)).a(this.f6138a, k9.m.f14793c));
        return ((Task) this.f6139b.s(new n9.t() { // from class: d9.j
            @Override // n9.t
            public final Object apply(Object obj2) {
                return ((g9.q0) obj2).T(listSingletonList);
            }
        })).continueWith(p.f16963b, g0.x());
    }

    public Task w(d9.t tVar, Object obj, Object... objArr) {
        return x(this.f6139b.F().n(g0.f(1, tVar, obj, objArr)));
    }

    public final Task x(g9.t1 t1Var) {
        final List listSingletonList = Collections.singletonList(t1Var.a(this.f6138a, k9.m.a(true)));
        return ((Task) this.f6139b.s(new n9.t() { // from class: d9.k
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).T(listSingletonList);
            }
        })).continueWith(p.f16963b, g0.x());
    }
}
