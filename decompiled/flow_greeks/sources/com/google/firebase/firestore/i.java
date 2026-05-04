package com.google.firebase.firestore;

import android.app.Activity;
import bb.b;
import bb.d0;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.e;
import com.google.firebase.firestore.f;
import d9.r;
import d9.r1;
import d9.s0;
import d9.t;
import d9.t0;
import d9.t1;
import g9.a1;
import g9.b1;
import g9.c1;
import g9.o;
import g9.p;
import g9.q;
import g9.q0;
import g9.y1;
import io.flutter.plugins.firebase.database.Constants;
import j9.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import n9.g0;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f6192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseFirestore f6193b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends ArrayList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.firestore.a f6194a;

        public a(com.google.firebase.firestore.a aVar) {
            this.f6194a = aVar;
            add(aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6196a;

        static {
            int[] iArr = new int[p.b.values().length];
            f6196a = iArr;
            try {
                iArr[p.b.NOT_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6196a[p.b.ARRAY_CONTAINS_ANY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6196a[p.b.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6196a[p.b.NOT_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        ASCENDING,
        DESCENDING
    }

    public i(b1 b1Var, FirebaseFirestore firebaseFirestore) {
        this.f6192a = (b1) x.b(b1Var);
        this.f6193b = (FirebaseFirestore) x.b(firebaseFirestore);
    }

    public static /* synthetic */ t0 a(i iVar, o.b bVar, final g9.h hVar, Activity activity, final q0 q0Var) {
        final c1 c1VarJ = q0Var.J(iVar.f6192a, bVar, hVar);
        return g9.d.c(activity, new t0() { // from class: d9.o1
            @Override // d9.t0
            public final void remove() {
                com.google.firebase.firestore.i.f(hVar, q0Var, c1VarJ);
            }
        });
    }

    public static /* synthetic */ k c(i iVar, Task task) {
        return new k(new i(iVar.f6192a, iVar.f6193b), (y1) task.getResult(), iVar.f6193b);
    }

    public static /* synthetic */ void d(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, t1 t1Var, k kVar, f fVar) {
        if (fVar != null) {
            taskCompletionSource.setException(fVar);
            return;
        }
        try {
            ((t0) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (kVar.g().b() && t1Var == t1.SERVER) {
                taskCompletionSource.setException(new f("Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to SERVER to retrieve the cached documents.)", f.a.UNAVAILABLE));
            } else {
                taskCompletionSource.setResult(kVar);
            }
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw n9.b.b(e10, "Failed to register a listener for a query result", new Object[0]);
        } catch (ExecutionException e11) {
            throw n9.b.b(e11, "Failed to register a listener for a query result", new Object[0]);
        }
    }

    public static /* synthetic */ void e(i iVar, r rVar, y1 y1Var, f fVar) {
        iVar.getClass();
        if (fVar != null) {
            rVar.a(null, fVar);
        } else {
            n9.b.d(y1Var != null, "Got event without value or error set", new Object[0]);
            rVar.a(new k(iVar, y1Var, iVar.f6193b), null);
        }
    }

    public static /* synthetic */ void f(g9.h hVar, q0 q0Var, c1 c1Var) {
        hVar.c();
        q0Var.O(c1Var);
    }

    public static o.b r(d9.b1 b1Var, s0 s0Var) {
        o.b bVar = new o.b();
        d9.b1 b1Var2 = d9.b1.INCLUDE;
        bVar.f10300a = b1Var == b1Var2;
        bVar.f10301b = b1Var == b1Var2;
        bVar.f10302c = false;
        bVar.f10303d = s0Var;
        return bVar;
    }

    public i A(Object... objArr) {
        return new i(this.f6192a.B(j(Constants.START_AFTER, objArr, false)), this.f6193b);
    }

    public i B(Object... objArr) {
        return new i(this.f6192a.B(j(Constants.START_AT, objArr, true)), this.f6193b);
    }

    public final void C(Object obj, p.b bVar) {
        if (!(obj instanceof List) || ((List) obj).size() == 0) {
            throw new IllegalArgumentException("Invalid Query. A non-empty array is required for '" + bVar.toString() + "' filters.");
        }
    }

    public final void D() {
        if (this.f6192a.l().equals(b1.a.LIMIT_TO_LAST) && this.f6192a.h().isEmpty()) {
            throw new IllegalStateException("limitToLast() queries require specifying at least one orderBy() clause");
        }
    }

    public final void E(b1 b1Var, p pVar) {
        p.b bVarG = pVar.g();
        p.b bVarN = n(b1Var.i(), k(bVarG));
        if (bVarN != null) {
            if (bVarN == bVarG) {
                throw new IllegalArgumentException("Invalid Query. You cannot use more than one '" + bVarG.toString() + "' filter.");
            }
            throw new IllegalArgumentException("Invalid Query. You cannot use '" + bVarG.toString() + "' filters with '" + bVarN.toString() + "' filters.");
        }
    }

    public final void F(q qVar) {
        b1 b1VarE = this.f6192a;
        for (p pVar : qVar.c()) {
            E(b1VarE, pVar);
            b1VarE = b1VarE.e(pVar);
        }
    }

    public i G(e eVar) {
        q qVarZ = z(eVar);
        if (qVarZ.b().isEmpty()) {
            return this;
        }
        F(qVarZ);
        return new i(this.f6192a.e(qVarZ), this.f6193b);
    }

    public i H(t tVar, Object obj) {
        return G(e.b(tVar, obj));
    }

    public i I(t tVar, List list) {
        return G(e.c(tVar, list));
    }

    public i J(t tVar, Object obj) {
        return G(e.d(tVar, obj));
    }

    public i K(t tVar, Object obj) {
        return G(e.e(tVar, obj));
    }

    public i L(t tVar, Object obj) {
        return G(e.f(tVar, obj));
    }

    public i M(t tVar, List list) {
        return G(e.g(tVar, list));
    }

    public i N(t tVar, Object obj) {
        return G(e.h(tVar, obj));
    }

    public i O(t tVar, Object obj) {
        return G(e.i(tVar, obj));
    }

    public i P(t tVar, Object obj) {
        return G(e.j(tVar, obj));
    }

    public i Q(t tVar, List list) {
        return G(e.k(tVar, list));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f6192a.equals(iVar.f6192a) && this.f6193b.equals(iVar.f6193b);
    }

    public t0 g(r1 r1Var, r rVar) {
        x.c(r1Var, "Provided options value must not be null.");
        x.c(rVar, "Provided EventListener must not be null.");
        return h(r1Var.b(), r(r1Var.c(), r1Var.d()), r1Var.a(), rVar);
    }

    public final t0 h(Executor executor, final o.b bVar, final Activity activity, final r rVar) {
        D();
        final g9.h hVar = new g9.h(executor, new r() { // from class: d9.l1
            @Override // d9.r
            public final void a(Object obj, com.google.firebase.firestore.f fVar) {
                com.google.firebase.firestore.i.e(this.f7886a, rVar, (g9.y1) obj, fVar);
            }
        });
        return (t0) this.f6193b.s(new n9.t() { // from class: d9.m1
            @Override // n9.t
            public final Object apply(Object obj) {
                return com.google.firebase.firestore.i.a(this.f7892a, bVar, hVar, activity, (g9.q0) obj);
            }
        });
    }

    public int hashCode() {
        return (this.f6192a.hashCode() * 31) + this.f6193b.hashCode();
    }

    public d9.c i(com.google.firebase.firestore.a aVar, com.google.firebase.firestore.a... aVarArr) {
        a aVar2 = new a(aVar);
        aVar2.addAll(Arrays.asList(aVarArr));
        return new d9.c(this, aVar2);
    }

    public final g9.i j(String str, Object[] objArr, boolean z10) {
        List listH = this.f6192a.h();
        if (objArr.length > listH.size()) {
            throw new IllegalArgumentException("Too many arguments provided to " + str + "(). The number of arguments must be less than or equal to the number of orderBy() clauses.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (!((a1) listH.get(i10)).c().equals(j9.q.f14256b)) {
                arrayList.add(this.f6193b.F().h(obj));
            } else {
                if (!(obj instanceof String)) {
                    throw new IllegalArgumentException("Invalid query. Expected a string for document ID in " + str + "(), but got " + obj + ".");
                }
                String str2 = (String) obj;
                if (!this.f6192a.q() && str2.contains("/")) {
                    throw new IllegalArgumentException("Invalid query. When querying a collection and ordering by FieldPath.documentId(), the value passed to " + str + "() must be a plain document ID, but '" + str2 + "' contains a slash.");
                }
                j9.t tVar = (j9.t) this.f6192a.n().a(j9.t.B(str2));
                if (!j9.k.v(tVar)) {
                    throw new IllegalArgumentException("Invalid query. When querying a collection group and ordering by FieldPath.documentId(), the value passed to " + str + "() must result in a valid document path, but '" + tVar + "' is not because it contains an odd number of segments.");
                }
                arrayList.add(y.H(this.f6193b.B(), j9.k.k(tVar)));
            }
        }
        return new g9.i(arrayList, z10);
    }

    public final List k(p.b bVar) {
        int i10 = b.f6196a[bVar.ordinal()];
        return i10 != 1 ? (i10 == 2 || i10 == 3) ? Arrays.asList(p.b.NOT_IN) : i10 != 4 ? new ArrayList() : Arrays.asList(p.b.ARRAY_CONTAINS_ANY, p.b.IN, p.b.NOT_IN, p.b.NOT_EQUAL) : Arrays.asList(p.b.NOT_EQUAL, p.b.NOT_IN);
    }

    public i l(Object... objArr) {
        return new i(this.f6192a.d(j(Constants.END_AT, objArr, true)), this.f6193b);
    }

    public i m(Object... objArr) {
        return new i(this.f6192a.d(j(Constants.END_BEFORE, objArr, false)), this.f6193b);
    }

    public final p.b n(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (p pVar : ((q) it.next()).c()) {
                if (list2.contains(pVar.g())) {
                    return pVar.g();
                }
            }
        }
        return null;
    }

    public Task o(t1 t1Var) {
        D();
        return t1Var == t1.CACHE ? ((Task) this.f6193b.s(new n9.t() { // from class: d9.j1
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).F(this.f7882a.f6192a);
            }
        })).continueWith(n9.p.f16963b, new Continuation() { // from class: d9.k1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return com.google.firebase.firestore.i.c(this.f7884a, task);
            }
        }) : q(t1Var);
    }

    public FirebaseFirestore p() {
        return this.f6193b;
    }

    public final Task q(final t1 t1Var) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        o.b bVar = new o.b();
        bVar.f10300a = true;
        bVar.f10301b = true;
        bVar.f10302c = true;
        taskCompletionSource2.setResult(h(n9.p.f16963b, bVar, null, new r() { // from class: d9.n1
            @Override // d9.r
            public final void a(Object obj, com.google.firebase.firestore.f fVar) {
                com.google.firebase.firestore.i.d(taskCompletionSource, taskCompletionSource2, t1Var, (com.google.firebase.firestore.k) obj, fVar);
            }
        }));
        return taskCompletionSource.getTask();
    }

    public i s(long j10) {
        if (j10 > 0) {
            return new i(this.f6192a.s(j10), this.f6193b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limit (" + j10 + ") is invalid. Limit must be positive.");
    }

    public i t(long j10) {
        if (j10 > 0) {
            return new i(this.f6192a.t(j10), this.f6193b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limitToLast (" + j10 + ") is invalid. Limit must be positive.");
    }

    public i u(t tVar, c cVar) {
        x.c(tVar, "Provided field path must not be null.");
        return v(tVar.c(), cVar);
    }

    public final i v(j9.q qVar, c cVar) {
        x.c(cVar, "Provided direction must not be null.");
        if (this.f6192a.o() != null) {
            throw new IllegalArgumentException("Invalid query. You must not call Query.startAt() or Query.startAfter() before calling Query.orderBy().");
        }
        if (this.f6192a.g() == null) {
            return new i(this.f6192a.A(a1.d(cVar == c.ASCENDING ? a1.a.ASCENDING : a1.a.DESCENDING, qVar)), this.f6193b);
        }
        throw new IllegalArgumentException("Invalid query. You must not call Query.endAt() or Query.endBefore() before calling Query.orderBy().");
    }

    public final q w(e.a aVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = aVar.m().iterator();
        while (it.hasNext()) {
            q qVarZ = z((e) it.next());
            if (!qVarZ.b().isEmpty()) {
                arrayList.add(qVarZ);
            }
        }
        return arrayList.size() == 1 ? (q) arrayList.get(0) : new g9.k(arrayList, aVar.n());
    }

    public final d0 x(Object obj) {
        if (!(obj instanceof String)) {
            if (obj instanceof com.google.firebase.firestore.c) {
                return y.H(p().B(), ((com.google.firebase.firestore.c) obj).q());
            }
            throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid String or DocumentReference, but it was of type: " + g0.w(obj));
        }
        String str = (String) obj;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid document ID, but it was an empty string.");
        }
        if (!this.f6192a.q() && str.contains("/")) {
            throw new IllegalArgumentException("Invalid query. When querying a collection by FieldPath.documentId() you must provide a plain document ID, but '" + str + "' contains a '/' character.");
        }
        j9.t tVar = (j9.t) this.f6192a.n().a(j9.t.B(str));
        if (j9.k.v(tVar)) {
            return y.H(p().B(), j9.k.k(tVar));
        }
        throw new IllegalArgumentException("Invalid query. When querying a collection group by FieldPath.documentId(), the value provided must result in a valid document path, but '" + tVar + "' is not because it has an odd number of segments (" + tVar.u() + ").");
    }

    public final p y(e.b bVar) {
        d0 d0VarI;
        t tVarM = bVar.m();
        p.b bVarN = bVar.n();
        Object objO = bVar.o();
        x.c(tVarM, "Provided field path must not be null.");
        x.c(bVarN, "Provided op must not be null.");
        if (!tVarM.c().G()) {
            p.b bVar2 = p.b.IN;
            if (bVarN == bVar2 || bVarN == p.b.NOT_IN || bVarN == p.b.ARRAY_CONTAINS_ANY) {
                C(objO, bVarN);
            }
            d0VarI = this.f6193b.F().i(objO, bVarN == bVar2 || bVarN == p.b.NOT_IN);
        } else {
            if (bVarN == p.b.ARRAY_CONTAINS || bVarN == p.b.ARRAY_CONTAINS_ANY) {
                throw new IllegalArgumentException("Invalid query. You can't perform '" + bVarN.toString() + "' queries on FieldPath.documentId().");
            }
            if (bVarN == p.b.IN || bVarN == p.b.NOT_IN) {
                C(objO, bVarN);
                b.C0055b c0055bJ0 = bb.b.j0();
                Iterator it = ((List) objO).iterator();
                while (it.hasNext()) {
                    c0055bJ0.y(x(it.next()));
                }
                d0VarI = (d0) d0.y0().y(c0055bJ0).n();
            } else {
                d0VarI = x(objO);
            }
        }
        return p.e(tVarM.c(), bVarN, d0VarI);
    }

    public final q z(e eVar) {
        boolean z10 = eVar instanceof e.b;
        n9.b.d(z10 || (eVar instanceof e.a), "Parsing is only supported for Filter.UnaryFilter and Filter.CompositeFilter.", new Object[0]);
        return z10 ? y((e.b) eVar) : w((e.a) eVar);
    }
}
