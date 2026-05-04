package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import d9.q1;
import g9.k1;
import g9.t1;
import j9.r;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import n9.p;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f6208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseFirestore f6209b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        Object a(l lVar);
    }

    public l(k1 k1Var, FirebaseFirestore firebaseFirestore) {
        this.f6208a = (k1) x.b(k1Var);
        this.f6209b = (FirebaseFirestore) x.b(firebaseFirestore);
    }

    public static /* synthetic */ d a(l lVar, Task task) throws Exception {
        lVar.getClass();
        if (!task.isSuccessful()) {
            throw task.getException();
        }
        List list = (List) task.getResult();
        if (list.size() != 1) {
            throw n9.b.a("Mismatch in docs returned from document lookup.", new Object[0]);
        }
        r rVar = (r) list.get(0);
        if (rVar.b()) {
            return d.b(lVar.f6209b, rVar, false, false);
        }
        if (rVar.i()) {
            return d.c(lVar.f6209b, rVar.getKey(), false);
        }
        throw n9.b.a("BatchGetDocumentsRequest returned unexpected document type: " + r.class.getCanonicalName(), new Object[0]);
    }

    public l b(c cVar) {
        this.f6209b.R(cVar);
        this.f6208a.e(cVar.q());
        return this;
    }

    public d c(c cVar) throws f {
        this.f6209b.R(cVar);
        try {
            return (d) Tasks.await(d(cVar));
        } catch (InterruptedException e10) {
            throw new RuntimeException(e10);
        } catch (ExecutionException e11) {
            if (e11.getCause() instanceof f) {
                throw ((f) e11.getCause());
            }
            throw new RuntimeException(e11.getCause());
        }
    }

    public final Task d(c cVar) {
        return this.f6208a.h(Collections.singletonList(cVar.q())).continueWith(p.f16963b, new Continuation() { // from class: d9.v1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return com.google.firebase.firestore.l.a(this.f7958a, task);
            }
        });
    }

    public l e(c cVar, Object obj) {
        return f(cVar, obj, q1.f7920c);
    }

    public l f(c cVar, Object obj, q1 q1Var) {
        this.f6209b.R(cVar);
        x.c(obj, "Provided data must not be null.");
        x.c(q1Var, "Provided options must not be null.");
        this.f6208a.l(cVar.q(), q1Var.b() ? this.f6209b.F().g(obj, q1Var.a()) : this.f6209b.F().l(obj));
        return this;
    }

    public final l g(c cVar, t1 t1Var) {
        this.f6209b.R(cVar);
        this.f6208a.m(cVar.q(), t1Var);
        return this;
    }

    public l h(c cVar, Map map) {
        return g(cVar, this.f6209b.F().o(map));
    }
}
