package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.d;
import h0.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f6316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0 f6318c;

    public f(Context context, m0 m0Var, ExecutorService executorService) {
        this.f6316a = executorService;
        this.f6317b = context;
        this.f6318c = m0Var;
    }

    public boolean a() {
        if (this.f6318c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        i0 i0VarD = d();
        d.a aVarE = d.e(this.f6317b, this.f6318c);
        e(aVarE.f6301a, i0VarD);
        c(aVarE);
        return true;
    }

    public final boolean b() {
        if (((KeyguardManager) this.f6317b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!t5.n.c()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f6317b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == iMyPid) {
                    if (next.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void c(d.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f6317b.getSystemService("notification")).notify(aVar.f6302b, aVar.f6303c, aVar.f6301a.d());
    }

    public final i0 d() {
        i0 i0VarO = i0.o(this.f6318c.p("gcm.n.image"));
        if (i0VarO != null) {
            i0VarO.C(this.f6316a);
        }
        return i0VarO;
    }

    public final void e(i.e eVar, i0 i0Var) {
        if (i0Var == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(i0Var.u(), 5L, TimeUnit.SECONDS);
            eVar.w(bitmap);
            eVar.J(new i.b().p(bitmap).o(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            i0Var.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e10) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e10.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            i0Var.close();
        }
    }
}
