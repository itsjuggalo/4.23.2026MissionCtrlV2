package m9;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import rb.b;
import rb.k1;
import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends rb.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0.g f16290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y0.g f16291d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e9.a f16292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e9.a f16293b;

    static {
        y0.d dVar = rb.y0.f19747e;
        f16290c = y0.g.e("Authorization", dVar);
        f16291d = y0.g.e("x-firebase-appcheck", dVar);
    }

    public u(e9.a aVar, e9.a aVar2) {
        this.f16292a = aVar;
        this.f16293b = aVar2;
    }

    public static /* synthetic */ void b(Task task, b.a aVar, Task task2, Task task3) {
        rb.y0 y0Var = new rb.y0();
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            n9.v.a("FirestoreCallCredentials", "Successfully fetched auth token.", new Object[0]);
            if (str != null) {
                y0Var.p(f16290c, "Bearer " + str);
            }
        } else {
            Exception exception = task.getException();
            if (exception instanceof a7.d) {
                n9.v.a("FirestoreCallCredentials", "Firebase Auth API not available, not using authentication.", new Object[0]);
            } else {
                if (!(exception instanceof la.a)) {
                    n9.v.e("FirestoreCallCredentials", "Failed to get auth token: %s.", exception);
                    aVar.b(k1.f19600m.q(exception));
                    return;
                }
                n9.v.a("FirestoreCallCredentials", "No user signed in, not using authentication.", new Object[0]);
            }
        }
        if (task2.isSuccessful()) {
            String str2 = (String) task2.getResult();
            if (str2 != null && !str2.isEmpty()) {
                n9.v.a("FirestoreCallCredentials", "Successfully fetched AppCheck token.", new Object[0]);
                y0Var.p(f16291d, str2);
            }
        } else {
            Exception exception2 = task2.getException();
            if (!(exception2 instanceof a7.d)) {
                n9.v.e("FirestoreCallCredentials", "Failed to get AppCheck token: %s.", exception2);
                aVar.b(k1.f19600m.q(exception2));
                return;
            }
            n9.v.a("FirestoreCallCredentials", "Firebase AppCheck API not available.", new Object[0]);
        }
        aVar.a(y0Var);
    }

    @Override // rb.b
    public void a(b.AbstractC0342b abstractC0342b, Executor executor, final b.a aVar) {
        final Task taskA = this.f16292a.a();
        final Task taskA2 = this.f16293b.a();
        Tasks.whenAll((Task<?>[]) new Task[]{taskA, taskA2}).addOnCompleteListener(n9.p.f16963b, new OnCompleteListener() { // from class: m9.t
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.b(taskA, aVar, taskA2, task);
            }
        });
    }
}
