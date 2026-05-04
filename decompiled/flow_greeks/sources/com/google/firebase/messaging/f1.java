package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f6320i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f6322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f6323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f6324d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f6326f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d1 f6328h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f6325e = new w.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6327g = false;

    public f1(FirebaseMessaging firebaseMessaging, l0 l0Var, d1 d1Var, g0 g0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f6324d = firebaseMessaging;
        this.f6322b = l0Var;
        this.f6328h = d1Var;
        this.f6323c = g0Var;
        this.f6321a = context;
        this.f6326f = scheduledExecutorService;
    }

    public static /* synthetic */ f1 a(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, l0 l0Var, g0 g0Var) {
        return new f1(firebaseMessaging, l0Var, d1.b(context, scheduledExecutorService), g0Var, context, scheduledExecutorService);
    }

    public static void c(Task task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e10) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e10);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e11);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static Task f(final FirebaseMessaging firebaseMessaging, final l0 l0Var, final g0 g0Var, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.e1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f1.a(context, scheduledExecutorService, firebaseMessaging, l0Var, g0Var);
            }
        });
    }

    public static boolean h() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public final void b(c1 c1Var, TaskCompletionSource taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.f6325e) {
            try {
                String strE = c1Var.e();
                if (this.f6325e.containsKey(strE)) {
                    arrayDeque = (ArrayDeque) this.f6325e.get(strE);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f6325e.put(strE, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str) throws IOException {
        c(this.f6323c.m(this.f6324d.n(), str));
    }

    public final void e(String str) throws IOException {
        c(this.f6323c.n(this.f6324d.n(), str));
    }

    public boolean g() {
        return this.f6328h.c() != null;
    }

    public synchronized boolean i() {
        return this.f6327g;
    }

    public final void j(c1 c1Var) {
        synchronized (this.f6325e) {
            try {
                String strE = c1Var.e();
                if (this.f6325e.containsKey(strE)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f6325e.get(strE);
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) arrayDeque.poll();
                    if (taskCompletionSource != null) {
                        taskCompletionSource.setResult(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f6325e.remove(strE);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean k(c1 c1Var) throws IOException {
        try {
            String strB = c1Var.b();
            int iHashCode = strB.hashCode();
            if (iHashCode != 83) {
                if (iHashCode == 85 && strB.equals("U")) {
                    e(c1Var.c());
                    if (!h()) {
                        return true;
                    }
                    Log.d("FirebaseMessaging", "Unsubscribe from topic: " + c1Var.c() + " succeeded.");
                    return true;
                }
            } else if (strB.equals("S")) {
                d(c1Var.c());
                if (!h()) {
                    return true;
                }
                Log.d("FirebaseMessaging", "Subscribe to topic: " + c1Var.c() + " succeeded.");
                return true;
            }
            if (!h()) {
                return true;
            }
            Log.d("FirebaseMessaging", "Unknown topic operation" + c1Var + ".");
            return true;
        } catch (IOException e10) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e10.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e10.getMessage()) && !"TOO_MANY_SUBSCRIBERS".equals(e10.getMessage())) {
                if (e10.getMessage() != null) {
                    throw e10;
                }
                Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            }
            Log.e("FirebaseMessaging", "Topic operation failed: " + e10.getMessage() + ". Will retry Topic operation.");
            return false;
        }
    }

    public void l(Runnable runnable, long j10) {
        this.f6326f.schedule(runnable, j10, TimeUnit.SECONDS);
    }

    public Task m(c1 c1Var) {
        this.f6328h.a(c1Var);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b(c1Var, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public synchronized void n(boolean z10) {
        this.f6327g = z10;
    }

    public final void o() {
        if (i()) {
            return;
        }
        s(0L);
    }

    public void p() {
        if (g()) {
            o();
        }
    }

    public Task q(String str) {
        Task taskM = m(c1.f(str));
        p();
        return taskM;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
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
    public boolean r() {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            com.google.firebase.messaging.d1 r0 = r2.f6328h     // Catch: java.lang.Throwable -> L17
            com.google.firebase.messaging.c1 r0 = r0.c()     // Catch: java.lang.Throwable -> L17
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
            r0 = 1
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            return r0
        L1c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            boolean r1 = r2.k(r0)
            if (r1 != 0) goto L25
            r0 = 0
            return r0
        L25:
            com.google.firebase.messaging.d1 r1 = r2.f6328h
            r1.e(r0)
            r2.j(r0)
            goto L0
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.f1.r():boolean");
    }

    public void s(long j10) {
        l(new g1(this, this.f6321a, this.f6322b, Math.min(Math.max(30L, 2 * j10), f6320i)), j10);
        n(true);
    }

    public Task t(String str) {
        Task taskM = m(c1.g(str));
        p();
        return taskM;
    }
}
