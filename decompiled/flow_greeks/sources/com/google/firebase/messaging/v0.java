package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f6438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f6439b = new w.a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        Task start();
    }

    public v0(Executor executor) {
        this.f6438a = executor;
    }

    public static /* synthetic */ Task a(v0 v0Var, String str, Task task) {
        synchronized (v0Var) {
            v0Var.f6439b.remove(str);
        }
        return task;
    }

    public synchronized Task b(final String str, a aVar) {
        Task task = (Task) this.f6439b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Making new request for: " + str);
        }
        Task taskContinueWithTask = aVar.start().continueWithTask(this.f6438a, new Continuation() { // from class: com.google.firebase.messaging.u0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return v0.a(this.f6434a, str, task2);
            }
        });
        this.f6439b.put(str, taskContinueWithTask);
        return taskContinueWithTask;
    }
}
