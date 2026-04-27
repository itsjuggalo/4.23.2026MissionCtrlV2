package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f15744i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f15746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G f15747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f15748d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f15750f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g0 f15752h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f15749e = new C2882a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15751g = false;

    public i0(FirebaseMessaging firebaseMessaging, L l8, g0 g0Var, G g8, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f15748d = firebaseMessaging;
        this.f15746b = l8;
        this.f15752h = g0Var;
        this.f15747c = g8;
        this.f15745a = context;
        this.f15750f = scheduledExecutorService;
    }

    public static void c(AbstractC2328l abstractC2328l) throws IOException {
        try {
            AbstractC2331o.b(abstractC2328l, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e8) {
            e = e8;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e9) {
            Throwable cause = e9.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e9);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e10) {
            e = e10;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public static AbstractC2328l f(final FirebaseMessaging firebaseMessaging, final L l8, final G g8, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return AbstractC2331o.c(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.h0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return i0.j(context, scheduledExecutorService, firebaseMessaging, l8, g8);
            }
        });
    }

    public static boolean h() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public static /* synthetic */ i0 j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, L l8, G g8) {
        return new i0(firebaseMessaging, l8, g0.b(context, scheduledExecutorService), g8, context, scheduledExecutorService);
    }

    public final void b(f0 f0Var, C2329m c2329m) {
        ArrayDeque arrayDeque;
        synchronized (this.f15749e) {
            try {
                String strE = f0Var.e();
                if (this.f15749e.containsKey(strE)) {
                    arrayDeque = (ArrayDeque) this.f15749e.get(strE);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f15749e.put(strE, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(c2329m);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str) throws IOException {
        c(this.f15747c.n(this.f15748d.n(), str));
    }

    public final void e(String str) throws IOException {
        c(this.f15747c.o(this.f15748d.n(), str));
    }

    public boolean g() {
        return this.f15752h.c() != null;
    }

    public synchronized boolean i() {
        return this.f15751g;
    }

    public final void k(f0 f0Var) {
        synchronized (this.f15749e) {
            try {
                String strE = f0Var.e();
                if (this.f15749e.containsKey(strE)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f15749e.get(strE);
                    C2329m c2329m = (C2329m) arrayDeque.poll();
                    if (c2329m != null) {
                        c2329m.c(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f15749e.remove(strE);
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
    public boolean l(com.google.firebase.messaging.f0 r7) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.i0.l(com.google.firebase.messaging.f0):boolean");
    }

    public void m(Runnable runnable, long j8) {
        this.f15750f.schedule(runnable, j8, TimeUnit.SECONDS);
    }

    public AbstractC2328l n(f0 f0Var) {
        this.f15752h.a(f0Var);
        C2329m c2329m = new C2329m();
        b(f0Var, c2329m);
        return c2329m.a();
    }

    public synchronized void o(boolean z7) {
        this.f15751g = z7;
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

    public AbstractC2328l r(String str) {
        AbstractC2328l abstractC2328lN = n(f0.f(str));
        q();
        return abstractC2328lN;
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
            com.google.firebase.messaging.g0 r0 = r2.f15752h     // Catch: java.lang.Throwable -> L17
            com.google.firebase.messaging.f0 r0 = r0.c()     // Catch: java.lang.Throwable -> L17
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
            com.google.firebase.messaging.g0 r1 = r2.f15752h
            r1.e(r0)
            r2.k(r0)
            goto L0
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.i0.s():boolean");
    }

    public void t(long j8) {
        m(new j0(this, this.f15745a, this.f15746b, Math.min(Math.max(30L, 2 * j8), f15744i)), j8);
        o(true);
    }

    public AbstractC2328l u(String str) {
        AbstractC2328l abstractC2328lN = n(f0.g(str));
        q();
        return abstractC2328lN;
    }
}
