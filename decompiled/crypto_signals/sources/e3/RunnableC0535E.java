package e3;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: renamed from: e3.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0535E implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f6096f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Boolean f6097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Boolean f6098l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0556p f6100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f6101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0533C f6102d;
    public final long e;

    public RunnableC0535E(C0533C c0533c, Context context, C0556p c0556p, long j4) {
        this.f6102d = c0533c;
        this.f6099a = context;
        this.e = j4;
        this.f6100b = c0556p;
        this.f6101c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean a(Context context) {
        boolean zBooleanValue;
        synchronized (f6096f) {
            try {
                Boolean bool = f6098l;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f6098l = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static boolean b(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z6 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z6 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return z6;
    }

    public static boolean c(Context context) {
        boolean zBooleanValue;
        synchronized (f6096f) {
            try {
                Boolean bool = f6097k;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f6097k = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean d() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.f6099a     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: e3.RunnableC0535E.d():boolean");
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        C0533C c0533c = this.f6102d;
        Context context = this.f6099a;
        boolean zC = c(context);
        PowerManager.WakeLock wakeLock = this.f6101c;
        if (zC) {
            wakeLock.acquire(AbstractC0546f.f6136a);
        }
        try {
            try {
                try {
                    c0533c.e(true);
                    if (!this.f6100b.d()) {
                        c0533c.e(false);
                        if (!c(context)) {
                            return;
                        }
                    } else if (!a(context) || d()) {
                        if (c0533c.g()) {
                            c0533c.e(false);
                        } else {
                            c0533c.h(this.e);
                        }
                        if (!c(context)) {
                            return;
                        }
                    } else {
                        new C0534D(this, this).a();
                        if (!c(context)) {
                            return;
                        }
                    }
                    wakeLock.release();
                } catch (IOException e) {
                    Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e.getMessage());
                    c0533c.e(false);
                    if (c(context)) {
                        wakeLock.release();
                    }
                }
            } catch (Throwable th) {
                if (c(context)) {
                    try {
                        wakeLock.release();
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
                throw th;
            }
        } catch (RuntimeException unused2) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
