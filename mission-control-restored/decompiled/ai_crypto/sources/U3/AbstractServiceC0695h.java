package U3;

import U3.h0;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: U3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractServiceC0695h extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Binder f4911b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4913d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f4910a = AbstractC0701n.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4912c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4914e = 0;

    /* JADX INFO: renamed from: U3.h$a */
    public class a implements h0.a {
        public a() {
        }

        @Override // U3.h0.a
        public Task a(Intent intent) {
            return AbstractServiceC0695h.this.j(intent);
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            f0.c(intent);
        }
        synchronized (this.f4912c) {
            try {
                int i7 = this.f4914e - 1;
                this.f4914e = i7;
                if (i7 == 0) {
                    k(this.f4913d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Intent e(Intent intent);

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    public final /* synthetic */ void h(Intent intent, Task task) {
        d(intent);
    }

    public final /* synthetic */ void i(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            f(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    public final Task j(final Intent intent) {
        if (g(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f4910a.execute(new Runnable() { // from class: U3.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f4906a.i(intent, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public boolean k(int i7) {
        return stopSelfResult(i7);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f4911b == null) {
                this.f4911b = new h0(new a());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f4911b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f4910a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i7, int i8) {
        synchronized (this.f4912c) {
            this.f4913d = i8;
            this.f4914e++;
        }
        Intent intentE = e(intent);
        if (intentE == null) {
            d(intent);
            return 2;
        }
        Task taskJ = j(intentE);
        if (taskJ.isComplete()) {
            d(intent);
            return 2;
        }
        taskJ.addOnCompleteListener(new B0.k(), new OnCompleteListener() { // from class: U3.f
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f4901a.h(intent, task);
            }
        });
        return 3;
    }
}
