package pa;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f18444n = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f18446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.c f18447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f18448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qa.e f18449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qa.e f18450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qa.e f18451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.c f18452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final qa.l f18453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.e f18454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ga.h f18455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final qa.m f18456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ra.e f18457m;

    public o(Context context, a7.g gVar, ga.h hVar, b7.c cVar, Executor executor, qa.e eVar, qa.e eVar2, qa.e eVar3, com.google.firebase.remoteconfig.internal.c cVar2, qa.l lVar, com.google.firebase.remoteconfig.internal.e eVar4, qa.m mVar, ra.e eVar5) {
        this.f18445a = context;
        this.f18446b = gVar;
        this.f18455k = hVar;
        this.f18447c = cVar;
        this.f18448d = executor;
        this.f18449e = eVar;
        this.f18450f = eVar2;
        this.f18451g = eVar3;
        this.f18452h = cVar2;
        this.f18453i = lVar;
        this.f18454j = eVar4;
        this.f18456l = mVar;
        this.f18457m = eVar5;
    }

    public static /* synthetic */ Void a(o oVar, u uVar) {
        oVar.f18454j.m(uVar);
        return null;
    }

    public static /* synthetic */ Void c(o oVar, e eVar) {
        oVar.f18454j.n(eVar.f18431a);
        return null;
    }

    public static /* synthetic */ s e(Task task, Task task2) {
        return (s) task.getResult();
    }

    public static /* synthetic */ Task h(final o oVar, Task task, Task task2, Task task3) {
        oVar.getClass();
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(Boolean.FALSE);
        }
        com.google.firebase.remoteconfig.internal.b bVar = (com.google.firebase.remoteconfig.internal.b) task.getResult();
        return (!task2.isSuccessful() || r(bVar, (com.google.firebase.remoteconfig.internal.b) task2.getResult())) ? oVar.f18450f.i(bVar).continueWith(oVar.f18448d, new Continuation() { // from class: pa.n
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                return Boolean.valueOf(this.f18443a.s(task4));
            }
        }) : Tasks.forResult(Boolean.FALSE);
    }

    public static o p(a7.g gVar) {
        return ((z) gVar.k(z.class)).g();
    }

    public static boolean r(com.google.firebase.remoteconfig.internal.b bVar, com.google.firebase.remoteconfig.internal.b bVar2) {
        return bVar2 == null || !bVar.h().equals(bVar2.h());
    }

    public static List z(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            HashMap map = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    public void A(JSONArray jSONArray) {
        if (this.f18447c == null) {
            return;
        }
        try {
            this.f18447c.m(z(jSONArray));
        } catch (b7.a e10) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e10);
        } catch (JSONException e11) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e11);
        }
    }

    public Task i() {
        final Task taskE = this.f18449e.e();
        final Task taskE2 = this.f18450f.e();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskE, taskE2}).continueWithTask(this.f18448d, new Continuation() { // from class: pa.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return o.h(this.f18433a, taskE, taskE2, task);
            }
        });
    }

    public d j(c cVar) {
        return this.f18456l.b(cVar);
    }

    public Task k() {
        Task taskE = this.f18450f.e();
        Task taskE2 = this.f18451g.e();
        Task taskE3 = this.f18449e.e();
        final Task taskCall = Tasks.call(this.f18448d, new Callable() { // from class: pa.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f18440a.o();
            }
        });
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskE, taskE2, taskE3, taskCall, this.f18455k.getId(), this.f18455k.a(false)}).continueWith(this.f18448d, new Continuation() { // from class: pa.k
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return o.e(taskCall, task);
            }
        });
    }

    public Task l() {
        return this.f18452h.i().onSuccessTask(p7.y.a(), new SuccessContinuation() { // from class: pa.m
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Tasks.forResult(null);
            }
        });
    }

    public Task m() {
        return l().onSuccessTask(this.f18448d, new SuccessContinuation() { // from class: pa.l
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f18442a.i();
            }
        });
    }

    public Map n() {
        return this.f18453i.d();
    }

    public s o() {
        return this.f18454j.d();
    }

    public ra.e q() {
        return this.f18457m;
    }

    public final boolean s(Task task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.f18449e.d();
        com.google.firebase.remoteconfig.internal.b bVar = (com.google.firebase.remoteconfig.internal.b) task.getResult();
        if (bVar == null) {
            Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            return true;
        }
        A(bVar.e());
        this.f18457m.d(bVar);
        return true;
    }

    public Task t(final u uVar) {
        return Tasks.call(this.f18448d, new Callable() { // from class: pa.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o.a(this.f18438a, uVar);
            }
        });
    }

    public void u(boolean z10) {
        this.f18456l.e(z10);
    }

    public Task v(final e eVar) {
        return Tasks.call(this.f18448d, new Callable() { // from class: pa.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o.c(this.f18436a, eVar);
            }
        });
    }

    public Task w(Map map) {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                map2.put((String) entry.getKey(), new String((byte[]) value));
            } else {
                map2.put((String) entry.getKey(), value.toString());
            }
        }
        return x(map2);
    }

    public final Task x(Map map) {
        try {
            return this.f18451g.i(com.google.firebase.remoteconfig.internal.b.l().b(map).a()).onSuccessTask(p7.y.a(), new SuccessContinuation() { // from class: pa.g
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    return Tasks.forResult(null);
                }
            });
        } catch (JSONException e10) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e10);
            return Tasks.forResult(null);
        }
    }

    public void y() {
        this.f18450f.e();
        this.f18451g.e();
        this.f18449e.e();
    }
}
