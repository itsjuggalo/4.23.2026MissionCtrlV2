package J3;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import r5.AbstractC2586b;
import r5.Z;
import r5.l0;

/* JADX INFO: renamed from: J3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0605u extends AbstractC2586b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Z.g f3286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Z.g f3287d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B3.a f3288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B3.a f3289b;

    static {
        Z.d dVar = r5.Z.f22587e;
        f3286c = Z.g.e("Authorization", dVar);
        f3287d = Z.g.e("x-firebase-appcheck", dVar);
    }

    public C0605u(B3.a aVar, B3.a aVar2) {
        this.f3288a = aVar;
        this.f3289b = aVar2;
    }

    public static /* synthetic */ void c(Task task, AbstractC2586b.a aVar, Task task2, Task task3) {
        r5.Z z7 = new r5.Z();
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            K3.x.a("FirestoreCallCredentials", "Successfully fetched auth token.", new Object[0]);
            if (str != null) {
                z7.p(f3286c, "Bearer " + str);
            }
        } else {
            Exception exception = task.getException();
            if (exception instanceof Q2.d) {
                K3.x.a("FirestoreCallCredentials", "Firebase Auth API not available, not using authentication.", new Object[0]);
            } else {
                if (!(exception instanceof T3.a)) {
                    K3.x.e("FirestoreCallCredentials", "Failed to get auth token: %s.", exception);
                    aVar.b(l0.f22713m.p(exception));
                    return;
                }
                K3.x.a("FirestoreCallCredentials", "No user signed in, not using authentication.", new Object[0]);
            }
        }
        if (task2.isSuccessful()) {
            String str2 = (String) task2.getResult();
            if (str2 != null && !str2.isEmpty()) {
                K3.x.a("FirestoreCallCredentials", "Successfully fetched AppCheck token.", new Object[0]);
                z7.p(f3287d, str2);
            }
        } else {
            Exception exception2 = task2.getException();
            if (!(exception2 instanceof Q2.d)) {
                K3.x.e("FirestoreCallCredentials", "Failed to get AppCheck token: %s.", exception2);
                aVar.b(l0.f22713m.p(exception2));
                return;
            }
            K3.x.a("FirestoreCallCredentials", "Firebase AppCheck API not available.", new Object[0]);
        }
        aVar.a(z7);
    }

    @Override // r5.AbstractC2586b
    public void a(AbstractC2586b.AbstractC0350b abstractC0350b, Executor executor, final AbstractC2586b.a aVar) {
        final Task taskA = this.f3288a.a();
        final Task taskA2 = this.f3289b.a();
        Tasks.whenAll((Task<?>[]) new Task[]{taskA, taskA2}).addOnCompleteListener(K3.p.f3451b, new OnCompleteListener() { // from class: J3.t
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                C0605u.c(taskA, aVar, taskA2, task);
            }
        });
    }
}
