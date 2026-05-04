package g9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Executor f10264g = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m9.q f10265a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.firebase.firestore.f f10269e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f10266b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10267c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set f10270f = new HashSet();

    public k1(m9.q qVar) {
        this.f10265a = qVar;
    }

    public static /* synthetic */ Task a(k1 k1Var, Task task) throws com.google.firebase.firestore.f {
        k1Var.getClass();
        if (task.isSuccessful()) {
            Iterator it = ((List) task.getResult()).iterator();
            while (it.hasNext()) {
                k1Var.k((j9.r) it.next());
            }
        }
        return task;
    }

    public static /* synthetic */ Task b(Task task) {
        return task.isSuccessful() ? Tasks.forResult(null) : Tasks.forException(task.getException());
    }

    public static Executor d() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor g() {
        return f10264g;
    }

    public Task c() {
        f();
        com.google.firebase.firestore.f fVar = this.f10269e;
        if (fVar != null) {
            return Tasks.forException(fVar);
        }
        HashSet<j9.k> hashSet = new HashSet(this.f10266b.keySet());
        Iterator it = this.f10267c.iterator();
        while (it.hasNext()) {
            hashSet.remove(((k9.f) it.next()).g());
        }
        for (j9.k kVar : hashSet) {
            this.f10267c.add(new k9.q(kVar, i(kVar)));
        }
        this.f10268d = true;
        return this.f10265a.d(this.f10267c).continueWithTask(n9.p.f16963b, new Continuation() { // from class: g9.j1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return k1.b(task);
            }
        });
    }

    public void e(j9.k kVar) {
        n(Collections.singletonList(new k9.c(kVar, i(kVar))));
        this.f10270f.add(kVar);
    }

    public final void f() {
        n9.b.d(!this.f10268d, "A transaction object cannot be used after its update callback has been invoked.", new Object[0]);
    }

    public Task h(List list) {
        f();
        return this.f10267c.size() != 0 ? Tasks.forException(new com.google.firebase.firestore.f("Firestore transactions require all reads to be executed before all writes.", f.a.INVALID_ARGUMENT)) : this.f10265a.k(list).continueWithTask(n9.p.f16963b, new Continuation() { // from class: g9.i1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return k1.a(this.f10234a, task);
            }
        });
    }

    public final k9.m i(j9.k kVar) {
        j9.v vVar = (j9.v) this.f10266b.get(kVar);
        return (this.f10270f.contains(kVar) || vVar == null) ? k9.m.f14793c : vVar.equals(j9.v.f14278b) ? k9.m.a(false) : k9.m.f(vVar);
    }

    public final k9.m j(j9.k kVar) throws com.google.firebase.firestore.f {
        j9.v vVar = (j9.v) this.f10266b.get(kVar);
        if (this.f10270f.contains(kVar) || vVar == null) {
            return k9.m.a(true);
        }
        if (vVar.equals(j9.v.f14278b)) {
            throw new com.google.firebase.firestore.f("Can't update a document that doesn't exist.", f.a.INVALID_ARGUMENT);
        }
        return k9.m.f(vVar);
    }

    public final void k(j9.r rVar) throws com.google.firebase.firestore.f {
        j9.v vVarK;
        if (rVar.b()) {
            vVarK = rVar.k();
        } else {
            if (!rVar.i()) {
                throw n9.b.a("Unexpected document type in transaction: " + rVar, new Object[0]);
            }
            vVarK = j9.v.f14278b;
        }
        if (!this.f10266b.containsKey(rVar.getKey())) {
            this.f10266b.put(rVar.getKey(), vVarK);
        } else if (!((j9.v) this.f10266b.get(rVar.getKey())).equals(rVar.k())) {
            throw new com.google.firebase.firestore.f("Document version changed between two reads.", f.a.ABORTED);
        }
    }

    public void l(j9.k kVar, s1 s1Var) {
        n(Collections.singletonList(s1Var.a(kVar, i(kVar))));
        this.f10270f.add(kVar);
    }

    public void m(j9.k kVar, t1 t1Var) {
        try {
            n(Collections.singletonList(t1Var.a(kVar, j(kVar))));
        } catch (com.google.firebase.firestore.f e10) {
            this.f10269e = e10;
        }
        this.f10270f.add(kVar);
    }

    public final void n(List list) {
        f();
        this.f10267c.addAll(list);
    }
}
