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

/* JADX INFO: loaded from: classes.dex */
public class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f15717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseMessaging f15718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f15719d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new X1.a("firebase-iid-executor"));

    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e0 f15720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f15721b;

        public a(e0 e0Var) {
            this.f15720a = e0Var;
        }

        public void a() {
            if (e0.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            e0 e0Var = this.f15720a;
            if (e0Var != null) {
                Context contextB = e0Var.b();
                this.f15721b = contextB;
                contextB.registerReceiver(this, intentFilter);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e0 e0Var = this.f15720a;
            if (e0Var != null && e0Var.d()) {
                if (e0.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f15720a.f15718c.p(this.f15720a, 0L);
                Context context2 = this.f15721b;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f15720a = null;
            }
        }
    }

    public e0(FirebaseMessaging firebaseMessaging, long j8) {
        this.f15718c = firebaseMessaging;
        this.f15716a = j8;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f15717b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public Context b() {
        return this.f15718c.q();
    }

    public boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean e() throws IOException {
        String str;
        try {
            if (this.f15718c.n() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e8) {
            if (G.i(e8.getMessage())) {
                str = "Token retrieval failed: " + e8.getMessage() + ". Will retry token retrieval";
            } else {
                if (e8.getMessage() != null) {
                    throw e8;
                }
                str = "Token retrieval failed without exception message. Will retry token retrieval";
            }
            Log.w("FirebaseMessaging", str);
            return false;
        } catch (SecurityException unused) {
            str = "Token retrieval failed with SecurityException. Will retry token retrieval";
            Log.w("FirebaseMessaging", str);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a0.b().e(b())) {
            this.f15717b.acquire();
        }
        try {
            try {
                this.f15718c.Q(true);
            } catch (IOException e8) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e8.getMessage() + ". Won't retry the operation.");
                this.f15718c.Q(false);
                if (!a0.b().e(b())) {
                    return;
                }
            }
            if (!this.f15718c.B()) {
                this.f15718c.Q(false);
                if (a0.b().e(b())) {
                    this.f15717b.release();
                    return;
                }
                return;
            }
            if (a0.b().d(b()) && !d()) {
                new a(this).a();
                if (a0.b().e(b())) {
                    this.f15717b.release();
                    return;
                }
                return;
            }
            if (e()) {
                this.f15718c.Q(false);
            } else {
                this.f15718c.V(this.f15716a);
            }
            if (!a0.b().e(b())) {
                return;
            }
            this.f15717b.release();
        } catch (Throwable th) {
            if (a0.b().e(b())) {
                this.f15717b.release();
            }
            throw th;
        }
    }
}
