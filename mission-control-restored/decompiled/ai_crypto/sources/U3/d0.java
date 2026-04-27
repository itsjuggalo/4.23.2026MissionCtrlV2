package U3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class d0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f4887f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f4888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f4889h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J f4891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f4892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f4893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4894e;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d0 f4895a;

        public a(d0 d0Var) {
            this.f4895a = d0Var;
        }

        public void a() {
            if (d0.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            d0.this.f4890a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            try {
                d0 d0Var = this.f4895a;
                if (d0Var == null) {
                    return;
                }
                if (d0Var.i()) {
                    if (d0.j()) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    this.f4895a.f4893d.m(this.f4895a, 0L);
                    context.unregisterReceiver(this);
                    this.f4895a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public d0(c0 c0Var, Context context, J j7, long j8) {
        this.f4893d = c0Var;
        this.f4890a = context;
        this.f4894e = j8;
        this.f4891b = j7;
        this.f4892c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    public static boolean f(Context context) {
        boolean zBooleanValue;
        synchronized (f4887f) {
            try {
                Boolean bool = f4889h;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f4889h = boolValueOf;
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
        synchronized (f4887f) {
            try {
                Boolean bool = f4888g;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f4888g = boolValueOf;
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
            android.content.Context r0 = r2.f4890a     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: U3.d0.i():boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.f4890a)) {
            this.f4892c.acquire(com.google.firebase.messaging.a.f12217a);
        }
        try {
            try {
                try {
                    this.f4893d.o(true);
                } catch (Throwable th) {
                    if (h(this.f4890a)) {
                        try {
                            this.f4892c.release();
                        } catch (RuntimeException unused) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e7.getMessage());
                this.f4893d.o(false);
                if (!h(this.f4890a)) {
                    return;
                } else {
                    wakeLock = this.f4892c;
                }
            }
            if (!this.f4891b.g()) {
                this.f4893d.o(false);
                if (h(this.f4890a)) {
                    try {
                        this.f4892c.release();
                        return;
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (f(this.f4890a) && !i()) {
                new a(this).a();
                if (h(this.f4890a)) {
                    try {
                        this.f4892c.release();
                        return;
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (this.f4893d.s()) {
                this.f4893d.o(false);
            } else {
                this.f4893d.t(this.f4894e);
            }
            if (h(this.f4890a)) {
                wakeLock = this.f4892c;
                wakeLock.release();
            }
        } catch (RuntimeException unused4) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
