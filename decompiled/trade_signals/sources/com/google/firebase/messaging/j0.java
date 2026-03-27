package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class j0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f15755f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f15756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f15757h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f15759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f15760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0 f15761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f15762e;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j0 f15763a;

        public a(j0 j0Var) {
            this.f15763a = j0Var;
        }

        public void a() {
            if (j0.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            j0.this.f15758a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            try {
                j0 j0Var = this.f15763a;
                if (j0Var == null) {
                    return;
                }
                if (j0Var.i()) {
                    if (j0.j()) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    this.f15763a.f15761d.m(this.f15763a, 0L);
                    context.unregisterReceiver(this);
                    this.f15763a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j0(i0 i0Var, Context context, L l8, long j8) {
        this.f15761d = i0Var;
        this.f15758a = context;
        this.f15762e = j8;
        this.f15759b = l8;
        this.f15760c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    public static boolean f(Context context) {
        boolean zBooleanValue;
        synchronized (f15755f) {
            try {
                Boolean bool = f15757h;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f15757h = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z7 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z7 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z7;
    }

    public static boolean h(Context context) {
        boolean zBooleanValue;
        synchronized (f15755f) {
            try {
                Boolean bool = f15756g;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f15756g = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static boolean j() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean i() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.f15758a     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L12
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L12
            goto L15
        L12:
            r0 = move-exception
            goto L22
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1f
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            monitor-exit(r2)
            return r0
        L22:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.j0.i():boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.f15758a)) {
            this.f15760c.acquire(AbstractC1434e.f15715a);
        }
        try {
            try {
                try {
                    this.f15761d.o(true);
                } catch (Throwable th) {
                    if (h(this.f15758a)) {
                        try {
                            this.f15760c.release();
                        } catch (RuntimeException unused) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e8.getMessage());
                this.f15761d.o(false);
                if (!h(this.f15758a)) {
                    return;
                } else {
                    wakeLock = this.f15760c;
                }
            }
            if (!this.f15759b.g()) {
                this.f15761d.o(false);
                if (h(this.f15758a)) {
                    try {
                        this.f15760c.release();
                        return;
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (f(this.f15758a) && !i()) {
                new a(this).a();
                if (h(this.f15758a)) {
                    try {
                        this.f15760c.release();
                        return;
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (this.f15761d.s()) {
                this.f15761d.o(false);
            } else {
                this.f15761d.t(this.f15762e);
            }
            if (h(this.f15758a)) {
                wakeLock = this.f15760c;
                wakeLock.release();
            }
        } catch (RuntimeException unused4) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
