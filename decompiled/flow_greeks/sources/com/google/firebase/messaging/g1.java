package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f6337f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f6338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f6339h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f6341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f6342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f1 f6343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6344e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g1 f6345a;

        public a(g1 g1Var) {
            this.f6345a = g1Var;
        }

        public void a() {
            if (g1.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            g1.this.f6340a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            try {
                g1 g1Var = this.f6345a;
                if (g1Var == null) {
                    return;
                }
                if (g1Var.i()) {
                    if (g1.j()) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    this.f6345a.f6343d.l(this.f6345a, 0L);
                    context.unregisterReceiver(this);
                    this.f6345a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public g1(f1 f1Var, Context context, l0 l0Var, long j10) {
        this.f6343d = f1Var;
        this.f6340a = context;
        this.f6344e = j10;
        this.f6341b = l0Var;
        this.f6342c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    public static boolean f(Context context) {
        boolean zBooleanValue;
        synchronized (f6337f) {
            try {
                Boolean bool = f6339h;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f6339h = boolValueOf;
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
        boolean z10 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z10 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z10;
    }

    public static boolean h(Context context) {
        boolean zBooleanValue;
        synchronized (f6337f) {
            try {
                Boolean bool = f6338g;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f6338g = boolValueOf;
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
            android.content.Context r0 = r2.f6340a     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.g1.i():boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        if (h(this.f6340a)) {
            this.f6342c.acquire(e.f6309a);
        }
        try {
            try {
                try {
                    this.f6343d.n(true);
                    if (!this.f6341b.g()) {
                        this.f6343d.n(false);
                        if (h(this.f6340a)) {
                            try {
                                this.f6342c.release();
                                return;
                            } catch (RuntimeException unused) {
                                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                                return;
                            }
                        }
                        return;
                    }
                    if (!f(this.f6340a) || i()) {
                        if (this.f6343d.r()) {
                            this.f6343d.n(false);
                        } else {
                            this.f6343d.s(this.f6344e);
                        }
                        if (h(this.f6340a)) {
                            this.f6342c.release();
                            return;
                        }
                        return;
                    }
                    new a(this).a();
                    if (h(this.f6340a)) {
                        try {
                            this.f6342c.release();
                        } catch (RuntimeException unused2) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                } catch (Throwable th) {
                    if (h(this.f6340a)) {
                        try {
                            this.f6342c.release();
                        } catch (RuntimeException unused3) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e10.getMessage());
                this.f6343d.n(false);
                if (h(this.f6340a)) {
                    this.f6342c.release();
                }
            }
        } catch (RuntimeException unused4) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
