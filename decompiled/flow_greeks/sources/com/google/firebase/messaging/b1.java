package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f6290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseMessaging f6291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f6292d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new u5.b("firebase-iid-executor"));

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b1 f6293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f6294b;

        public a(b1 b1Var) {
            this.f6293a = b1Var;
        }

        public void a() {
            if (b1.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            b1 b1Var = this.f6293a;
            if (b1Var != null) {
                Context contextB = b1Var.b();
                this.f6294b = contextB;
                contextB.registerReceiver(this, intentFilter);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b1 b1Var = this.f6293a;
            if (b1Var != null && b1Var.d()) {
                if (b1.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f6293a.f6291c.p(this.f6293a, 0L);
                Context context2 = this.f6294b;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f6293a = null;
            }
        }
    }

    public b1(FirebaseMessaging firebaseMessaging, long j10) {
        this.f6291c = firebaseMessaging;
        this.f6289a = j10;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f6290b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public Context b() {
        return this.f6291c.q();
    }

    public boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean e() throws IOException {
        try {
            if (this.f6291c.n() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e10) {
            if (!g0.i(e10.getMessage())) {
                if (e10.getMessage() != null) {
                    throw e10;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e10.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (x0.b().e(b())) {
            this.f6290b.acquire();
        }
        try {
            try {
                this.f6291c.F(true);
                if (!this.f6291c.B()) {
                    this.f6291c.F(false);
                    if (!x0.b().e(b())) {
                        return;
                    }
                } else if (!x0.b().d(b()) || d()) {
                    if (e()) {
                        this.f6291c.F(false);
                    } else {
                        this.f6291c.K(this.f6289a);
                    }
                    if (!x0.b().e(b())) {
                        return;
                    }
                } else {
                    new a(this).a();
                    if (!x0.b().e(b())) {
                        return;
                    }
                }
                this.f6290b.release();
            } catch (IOException e10) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e10.getMessage() + ". Won't retry the operation.");
                this.f6291c.F(false);
                if (x0.b().e(b())) {
                    this.f6290b.release();
                }
            }
        } catch (Throwable th) {
            if (x0.b().e(b())) {
                this.f6290b.release();
            }
            throw th;
        }
    }
}
