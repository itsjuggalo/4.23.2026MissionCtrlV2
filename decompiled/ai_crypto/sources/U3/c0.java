package U3;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f4874i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J f4876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F f4877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f4878d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f4880f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0 f4882h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f4879e = new C2736a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4881g = false;

    public c0(FirebaseMessaging firebaseMessaging, J j7, a0 a0Var, F f7, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f4878d = firebaseMessaging;
        this.f4876b = j7;
        this.f4882h = a0Var;
        this.f4877c = f7;
        this.f4875a = context;
        this.f4880f = scheduledExecutorService;
    }

    public static void c(Task task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e7) {
            e = e7;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e8) {
            Throwable cause = e8.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e8);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e9) {
            e = e9;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public static Task f(final FirebaseMessaging firebaseMessaging, final J j7, final F f7, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: U3.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c0.j(context, scheduledExecutorService, firebaseMessaging, j7, f7);
            }
        });
    }

    public static boolean h() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public static /* synthetic */ c0 j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, J j7, F f7) {
        return new c0(firebaseMessaging, j7, a0.b(context, scheduledExecutorService), f7, context, scheduledExecutorService);
    }

    public final void b(Z z7, TaskCompletionSource taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.f4879e) {
            try {
                String strE = z7.e();
                if (this.f4879e.containsKey(strE)) {
                    arrayDeque = (ArrayDeque) this.f4879e.get(strE);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f4879e.put(strE, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str) throws IOException {
        c(this.f4877c.n(this.f4878d.n(), str));
    }

    public final void e(String str) throws IOException {
        c(this.f4877c.o(this.f4878d.n(), str));
    }

    public boolean g() {
        return this.f4882h.c() != null;
    }

    public synchronized boolean i() {
        return this.f4881g;
    }

    public final void k(Z z7) {
        synchronized (this.f4879e) {
            try {
                String strE = z7.e();
                if (this.f4879e.containsKey(strE)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f4879e.get(strE);
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) arrayDeque.poll();
                    if (taskCompletionSource != null) {
                        taskCompletionSource.setResult(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f4879e.remove(strE);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(U3.Z r7) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.c0.l(U3.Z):boolean");
    }

    public void m(Runnable runnable, long j7) {
        this.f4880f.schedule(runnable, j7, TimeUnit.SECONDS);
    }

    public Task n(Z z7) {
        this.f4882h.a(z7);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b(z7, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public synchronized void o(boolean z7) {
        this.f4881g = z7;
    }

    public final void p() {
        if (i()) {
            return;
        }
        t(0L);
    }

    public void q() {
        if (g()) {
            p();
        }
    }

    public Task r(String str) {
        Task taskN = n(Z.f(str));
        q();
        return taskN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (h() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean s() {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            U3.a0 r0 = r2.f4882h     // Catch: java.lang.Throwable -> L17
            U3.Z r0 = r0.c()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1c
            boolean r0 = h()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L19
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r0 = move-exception
            goto L2e
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            r0 = 1
            return r0
        L1c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            boolean r1 = r2.l(r0)
            if (r1 != 0) goto L25
            r0 = 0
            return r0
        L25:
            U3.a0 r1 = r2.f4882h
            r1.e(r0)
            r2.k(r0)
            goto L0
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.c0.s():boolean");
    }

    public void t(long j7) {
        m(new d0(this, this.f4875a, this.f4876b, Math.min(Math.max(30L, 2 * j7), f4874i)), j7);
        o(true);
    }

    public Task u(String str) {
        Task taskN = n(Z.g(str));
        q();
        return taskN;
    }
}
