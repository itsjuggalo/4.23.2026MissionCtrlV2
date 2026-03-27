package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l2.AbstractC2328l;
import l2.C2329m;
import l2.InterfaceC2322f;

/* JADX INFO: loaded from: classes.dex */
public class q0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f15784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f15785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f15786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n0 f15787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15788f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f15789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2329m f15790b = new C2329m();

        public a(Intent intent) {
            this.f15789a = intent;
        }

        public void c(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15778a.f();
                }
            }, 20L, TimeUnit.SECONDS);
            e().b(scheduledExecutorService, new InterfaceC2322f() { // from class: com.google.firebase.messaging.p0
                @Override // l2.InterfaceC2322f
                public final void a(AbstractC2328l abstractC2328l) {
                    scheduledFutureSchedule.cancel(false);
                }
            });
        }

        public void d() {
            this.f15790b.e(null);
        }

        public AbstractC2328l e() {
            return this.f15790b.a();
        }

        public final /* synthetic */ void f() {
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + this.f15789a.getAction() + " finishing.");
            d();
        }
    }

    public q0(Context context, String str) {
        this(context, str, a());
    }

    public static ScheduledThreadPoolExecutor a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new X1.a("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    public final void b() {
        while (!this.f15786d.isEmpty()) {
            ((a) this.f15786d.poll()).d();
        }
    }

    public final synchronized void c() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f15786d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                n0 n0Var = this.f15787e;
                if (n0Var == null || !n0Var.isBinderAlive()) {
                    e();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f15787e.c((a) this.f15786d.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized AbstractC2328l d(Intent intent) {
        a aVar;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            aVar = new a(intent);
            aVar.c(this.f15785c);
            this.f15786d.add(aVar);
            c();
        } catch (Throwable th) {
            throw th;
        }
        return aVar.e();
    }

    public final void e() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.f15788f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f15788f) {
            return;
        }
        this.f15788f = true;
        try {
            if (V1.a.b().a(this.f15783a, this.f15784b, this, 65)) {
                return;
            } else {
                Log.e("FirebaseMessaging", "binding to the service failed");
            }
        } catch (SecurityException e8) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e8);
        }
        this.f15788f = false;
        b();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f15788f = false;
            if (iBinder instanceof n0) {
                this.f15787e = (n0) iBinder;
                c();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            b();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        c();
    }

    public q0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f15786d = new ArrayDeque();
        this.f15788f = false;
        Context applicationContext = context.getApplicationContext();
        this.f15783a = applicationContext;
        this.f15784b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f15785c = scheduledExecutorService;
    }
}
