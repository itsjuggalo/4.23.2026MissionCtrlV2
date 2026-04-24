package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f12250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12251b = new C2736a();

    public interface a {
        Task start();
    }

    public e(Executor executor) {
        this.f12250a = executor;
    }

    public synchronized Task b(final String str, a aVar) {
        Task task = (Task) this.f12251b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Making new request for: " + str);
        }
        Task taskContinueWithTask = aVar.start().continueWithTask(this.f12250a, new Continuation() { // from class: U3.T
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f4817a.c(str, task2);
            }
        });
        this.f12251b.put(str, taskContinueWithTask);
        return taskContinueWithTask;
    }

    public final /* synthetic */ Task c(String str, Task task) {
        synchronized (this) {
            this.f12251b.remove(str);
        }
        return task;
    }
}
