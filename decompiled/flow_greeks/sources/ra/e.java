package ra;

import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import pa.q;
import ta.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qa.e f19457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f19458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f19459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f19460d = Collections.newSetFromMap(new ConcurrentHashMap());

    public e(qa.e eVar, a aVar, Executor executor) {
        this.f19457a = eVar;
        this.f19458b = aVar;
        this.f19459c = executor;
    }

    public static /* synthetic */ void a(e eVar, Task task, final f fVar, com.google.firebase.remoteconfig.internal.b bVar) {
        eVar.getClass();
        try {
            com.google.firebase.remoteconfig.internal.b bVar2 = (com.google.firebase.remoteconfig.internal.b) task.getResult();
            if (bVar2 != null) {
                final ta.e eVarB = eVar.f19458b.b(bVar2);
                eVar.f19459c.execute(new Runnable() { // from class: ra.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        fVar.a(eVarB);
                    }
                });
            }
        } catch (q e10) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e10);
        }
    }

    public void d(com.google.firebase.remoteconfig.internal.b bVar) {
        try {
            final ta.e eVarB = this.f19458b.b(bVar);
            for (final f fVar : this.f19460d) {
                this.f19459c.execute(new Runnable() { // from class: ra.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        fVar.a(eVarB);
                    }
                });
            }
        } catch (q e10) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e10);
        }
    }

    public void e(final f fVar) {
        this.f19460d.add(fVar);
        final Task taskE = this.f19457a.e();
        taskE.addOnSuccessListener(this.f19459c, new OnSuccessListener() { // from class: ra.c
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                e.a(this.f19452a, taskE, fVar, (com.google.firebase.remoteconfig.internal.b) obj);
            }
        });
    }
}
