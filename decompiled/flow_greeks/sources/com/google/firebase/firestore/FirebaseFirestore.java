package com.google.firebase.firestore;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.f;
import com.google.firebase.firestore.g;
import com.google.firebase.firestore.l;
import com.revenuecat.purchases.common.Constants;
import d9.a2;
import d9.g1;
import d9.h1;
import d9.o0;
import d9.r;
import d9.t0;
import d9.v0;
import d9.w1;
import d9.x1;
import g9.b1;
import g9.k1;
import g9.q0;
import i9.e3;
import j9.p;
import j9.q;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import m9.i0;
import m9.y;
import n9.t;
import n9.v;
import n9.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseFirestore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j9.f f6121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e9.a f6123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e9.a f6124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a7.g f6125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x1 f6126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f6127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x8.a f6128j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i0 f6131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g1 f6132n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o0 f6130l = new o0(new t() { // from class: d9.a0
        @Override // n9.t
        public final Object apply(Object obj) {
            return this.f7843a.J((n9.g) obj);
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f6129k = new g.b().f();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void remove(String str);
    }

    public FirebaseFirestore(Context context, j9.f fVar, String str, e9.a aVar, e9.a aVar2, t tVar, a7.g gVar, a aVar3, i0 i0Var) {
        this.f6120b = (Context) x.b(context);
        this.f6121c = (j9.f) x.b((j9.f) x.b(fVar));
        this.f6126h = new x1(fVar);
        this.f6122d = (String) x.b(str);
        this.f6123e = (e9.a) x.b(aVar);
        this.f6124f = (e9.a) x.b(aVar2);
        this.f6119a = (t) x.b(tVar);
        this.f6125g = gVar;
        this.f6127i = aVar3;
        this.f6131m = i0Var;
    }

    public static FirebaseFirestore C(a7.g gVar, String str) {
        x.c(gVar, "Provided FirebaseApp must not be null.");
        x.c(str, "Provided database name must not be null.");
        h hVar = (h) gVar.k(h.class);
        x.c(hVar, "Firestore component is not present.");
        return hVar.b(str);
    }

    public static FirebaseFirestore K(Context context, a7.g gVar, fa.a aVar, fa.a aVar2, String str, a aVar3, i0 i0Var) {
        String strG = gVar.r().g();
        if (strG == null) {
            throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
        }
        return new FirebaseFirestore(context, j9.f.b(strG, str), gVar.q(), new e9.i(aVar), new e9.e(aVar2), new t() { // from class: d9.l0
            @Override // n9.t
            public final Object apply(Object obj) {
                return g9.j.h((com.google.firebase.firestore.g) obj);
            }
        }, gVar, aVar3, i0Var);
    }

    public static void P(boolean z10) {
        if (z10) {
            v.d(v.b.DEBUG);
        } else {
            v.d(v.b.WARN);
        }
    }

    public static /* synthetic */ void a(FirebaseFirestore firebaseFirestore, TaskCompletionSource taskCompletionSource) {
        firebaseFirestore.getClass();
        try {
            e3.t(firebaseFirestore.f6120b, firebaseFirestore.f6121c, firebaseFirestore.f6122d);
            taskCompletionSource.setResult(null);
        } catch (f e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ i b(FirebaseFirestore firebaseFirestore, Task task) {
        firebaseFirestore.getClass();
        b1 b1Var = (b1) task.getResult();
        if (b1Var != null) {
            return new i(b1Var, firebaseFirestore);
        }
        return null;
    }

    public static /* synthetic */ void c(g9.h hVar, q0 q0Var) {
        hVar.c();
        q0Var.L(hVar);
    }

    public static /* synthetic */ Task f(final FirebaseFirestore firebaseFirestore, Executor executor, final l.a aVar, final k1 k1Var) {
        firebaseFirestore.getClass();
        return Tasks.call(executor, new Callable() { // from class: d9.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FirebaseFirestore.j(this.f7856a, aVar, k1Var);
            }
        });
    }

    public static /* synthetic */ t0 g(final g9.h hVar, Activity activity, final q0 q0Var) {
        q0Var.z(hVar);
        return g9.d.c(activity, new t0() { // from class: d9.d0
            @Override // d9.t0
            public final void remove() {
                FirebaseFirestore.c(hVar, q0Var);
            }
        });
    }

    public static /* synthetic */ void h(Runnable runnable, Void r22, f fVar) {
        n9.b.d(fVar == null, "snapshots-in-sync listeners should never get errors.", new Object[0]);
        runnable.run();
    }

    public static /* synthetic */ Object j(FirebaseFirestore firebaseFirestore, l.a aVar, k1 k1Var) {
        firebaseFirestore.getClass();
        return aVar.a(new l(k1Var, firebaseFirestore));
    }

    @Keep
    public static void setClientLanguage(String str) {
        y.m(str);
    }

    public a7.g A() {
        return this.f6125g;
    }

    public j9.f B() {
        return this.f6121c;
    }

    public Task D(final String str) {
        return ((Task) this.f6130l.b(new t() { // from class: d9.e0
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).G(str);
            }
        })).continueWith(new Continuation() { // from class: d9.f0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FirebaseFirestore.b(this.f7865a, task);
            }
        });
    }

    public g1 E() {
        this.f6130l.c();
        if (this.f6132n == null && (this.f6129k.i() || (this.f6129k.f() instanceof h1))) {
            this.f6132n = new g1(this.f6130l);
        }
        return this.f6132n;
    }

    public x1 F() {
        return this.f6126h;
    }

    public v0 G(final InputStream inputStream) {
        final v0 v0Var = new v0();
        this.f6130l.f(new s0.a() { // from class: d9.z
            @Override // s0.a
            public final void accept(Object obj) {
                ((g9.q0) obj).K(inputStream, v0Var);
            }
        });
        return v0Var;
    }

    public v0 H(byte[] bArr) {
        return G(new ByteArrayInputStream(bArr));
    }

    public final g I(g gVar, x8.a aVar) {
        if (aVar == null) {
            return gVar;
        }
        if (!"firestore.googleapis.com".equals(gVar.h())) {
            v.e("FirebaseFirestore", "Host has been set in FirebaseFirestoreSettings and useEmulator, emulator host will be used.", new Object[0]);
        }
        return new g.b(gVar).g(aVar.a() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + aVar.b()).i(false).f();
    }

    public final q0 J(n9.g gVar) {
        q0 q0Var;
        synchronized (this.f6130l) {
            q0Var = new q0(this.f6120b, new g9.l(this.f6121c, this.f6122d, this.f6129k.h(), this.f6129k.j()), this.f6123e, this.f6124f, gVar, this.f6131m, (g9.j) this.f6119a.apply(this.f6129k));
        }
        return q0Var;
    }

    public Task L(w1 w1Var, l.a aVar) {
        x.c(aVar, "Provided transaction update function must not be null.");
        return M(w1Var, aVar, k1.g());
    }

    public final Task M(final w1 w1Var, final l.a aVar, final Executor executor) {
        this.f6130l.c();
        final t tVar = new t() { // from class: d9.m0
            @Override // n9.t
            public final Object apply(Object obj) {
                return FirebaseFirestore.f(this.f7889a, executor, aVar, (g9.k1) obj);
            }
        };
        return (Task) this.f6130l.b(new t() { // from class: d9.w
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).Q(w1Var, tVar);
            }
        });
    }

    public void N(g gVar) {
        x.c(gVar, "Provided settings must not be null.");
        synchronized (this.f6121c) {
            try {
                g gVarI = I(gVar, this.f6128j);
                if (this.f6130l.e() && !this.f6129k.equals(gVarI)) {
                    throw new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
                }
                this.f6129k = gVarI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Task O(String str) {
        this.f6130l.c();
        x.e(this.f6129k.i(), "Cannot enable indexes when persistence is disabled");
        final ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("indexes")) {
                JSONArray jSONArray = jSONObject.getJSONArray("indexes");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    String string = jSONObject2.getString("collectionGroup");
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("fields");
                    for (int i11 = 0; jSONArrayOptJSONArray != null && i11 < jSONArrayOptJSONArray.length(); i11++) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i11);
                        q qVarB = q.B(jSONObject3.getString("fieldPath"));
                        if ("CONTAINS".equals(jSONObject3.optString("arrayConfig"))) {
                            arrayList2.add(p.c.b(qVarB, p.c.a.CONTAINS));
                        } else if ("ASCENDING".equals(jSONObject3.optString("order"))) {
                            arrayList2.add(p.c.b(qVarB, p.c.a.ASCENDING));
                        } else {
                            arrayList2.add(p.c.b(qVarB, p.c.a.DESCENDING));
                        }
                    }
                    arrayList.add(p.b(-1, string, arrayList2, p.f14248a));
                }
            }
            return (Task) this.f6130l.b(new t() { // from class: d9.i0
                @Override // n9.t
                public final Object apply(Object obj) {
                    return ((g9.q0) obj).A(arrayList);
                }
            });
        } catch (JSONException e10) {
            throw new IllegalArgumentException("Failed to parse index configuration", e10);
        }
    }

    public Task Q() {
        this.f6127i.remove(B().h());
        return this.f6130l.g();
    }

    public void R(c cVar) {
        x.c(cVar, "Provided DocumentReference must not be null.");
        if (cVar.p() != this) {
            throw new IllegalArgumentException("Provided document reference is from a different Cloud Firestore instance.");
        }
    }

    public Task S() {
        return (Task) this.f6130l.b(new t() { // from class: d9.v
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).S();
            }
        });
    }

    public t0 o(Runnable runnable) {
        return q(n9.p.f16962a, runnable);
    }

    public final t0 p(Executor executor, final Activity activity, final Runnable runnable) {
        final g9.h hVar = new g9.h(executor, new r() { // from class: d9.x
            @Override // d9.r
            public final void a(Object obj, com.google.firebase.firestore.f fVar) {
                FirebaseFirestore.h(runnable, (Void) obj, fVar);
            }
        });
        return (t0) this.f6130l.b(new t() { // from class: d9.y
            @Override // n9.t
            public final Object apply(Object obj) {
                return FirebaseFirestore.g(hVar, activity, (g9.q0) obj);
            }
        });
    }

    public t0 q(Executor executor, Runnable runnable) {
        return p(executor, null, runnable);
    }

    public a2 r() {
        this.f6130l.c();
        return new a2(this);
    }

    public Object s(t tVar) {
        return this.f6130l.b(tVar);
    }

    public Task t() {
        return (Task) this.f6130l.d(new t() { // from class: d9.g0
            @Override // n9.t
            public final Object apply(Object obj) {
                return this.f7875a.u((Executor) obj);
            }
        }, new t() { // from class: d9.h0
            @Override // n9.t
            public final Object apply(Object obj) {
                return Tasks.forException(new com.google.firebase.firestore.f("Persistence cannot be cleared while the firestore instance is running.", f.a.FAILED_PRECONDITION));
            }
        });
    }

    public final Task u(Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: d9.b0
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseFirestore.a(this.f7849a, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public d9.f v(String str) {
        x.c(str, "Provided collection path must not be null.");
        this.f6130l.c();
        return new d9.f(j9.t.B(str), this);
    }

    public i w(String str) {
        x.c(str, "Provided collection ID must not be null.");
        if (str.contains("/")) {
            throw new IllegalArgumentException(String.format("Invalid collectionId '%s'. Collection IDs must not contain '/'.", str));
        }
        this.f6130l.c();
        return new i(new b1(j9.t.f14277b, str), this);
    }

    public Task x() {
        return (Task) this.f6130l.b(new t() { // from class: d9.k0
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).C();
            }
        });
    }

    public c y(String str) {
        x.c(str, "Provided document path must not be null.");
        this.f6130l.c();
        return c.n(j9.t.B(str), this);
    }

    public Task z() {
        return (Task) this.f6130l.b(new t() { // from class: d9.j0
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).D();
            }
        });
    }
}
