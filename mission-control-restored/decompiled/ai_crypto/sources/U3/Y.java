package U3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class Y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f4833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseMessaging f4834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f4835d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new X1.b("firebase-iid-executor"));

    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Y f4836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f4837b;

        public a(Y y7) {
            this.f4836a = y7;
        }

        public void a() {
            if (Y.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            Y y7 = this.f4836a;
            if (y7 != null) {
                Context contextB = y7.b();
                this.f4837b = contextB;
                contextB.registerReceiver(this, intentFilter);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Y y7 = this.f4836a;
            if (y7 != null && y7.d()) {
                if (Y.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f4836a.f4834c.p(this.f4836a, 0L);
                Context context2 = this.f4837b;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f4836a = null;
            }
        }
    }

    public Y(FirebaseMessaging firebaseMessaging, long j7) {
        this.f4834c = firebaseMessaging;
        this.f4832a = j7;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f4833b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public Context b() {
        return this.f4834c.q();
    }

    public boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean e() throws IOException {
        try {
            if (this.f4834c.n() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e7) {
            if (!F.i(e7.getMessage())) {
                if (e7.getMessage() != null) {
                    throw e7;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e7.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (V.b().e(b())) {
            this.f4833b.acquire();
        }
        try {
            try {
                this.f4834c.Q(true);
            } catch (IOException e7) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e7.getMessage() + ". Won't retry the operation.");
                this.f4834c.Q(false);
                if (!V.b().e(b())) {
                    return;
                }
            }
            if (!this.f4834c.B()) {
                this.f4834c.Q(false);
                if (V.b().e(b())) {
                    this.f4833b.release();
                    return;
                }
                return;
            }
            if (V.b().d(b()) && !d()) {
                new a(this).a();
                if (V.b().e(b())) {
                    this.f4833b.release();
                    return;
                }
                return;
            }
            if (e()) {
                this.f4834c.Q(false);
            } else {
                this.f4834c.V(this.f4832a);
            }
            if (!V.b().e(b())) {
                return;
            }
            this.f4833b.release();
        } catch (Throwable th) {
            if (V.b().e(b())) {
                this.f4833b.release();
            }
            throw th;
        }
    }
}
