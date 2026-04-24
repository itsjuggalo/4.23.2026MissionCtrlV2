package com.google.firebase.messaging;

import H.i;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.firebase.messaging.AbstractC1433d;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l2.AbstractC2331o;

/* JADX INFO: renamed from: com.google.firebase.messaging.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1435f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f15722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f15723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final M f15724c;

    public C1435f(Context context, M m8, ExecutorService executorService) {
        this.f15722a = executorService;
        this.f15723b = context;
        this.f15724c = m8;
    }

    public boolean a() {
        if (this.f15724c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        I iD = d();
        AbstractC1433d.a aVarE = AbstractC1433d.e(this.f15723b, this.f15724c);
        e(aVarE.f15707a, iD);
        c(aVarE);
        return true;
    }

    public final boolean b() {
        if (((KeyguardManager) this.f15723b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!W1.l.c()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f15723b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public final void c(AbstractC1433d.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f15723b.getSystemService("notification")).notify(aVar.f15708b, aVar.f15709c, aVar.f15707a.d());
    }

    public final I d() {
        I iF = I.f(this.f15724c.p("gcm.n.image"));
        if (iF != null) {
            iF.B(this.f15722a);
        }
        return iF;
    }

    public final void e(i.e eVar, I i8) {
        if (i8 == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) AbstractC2331o.b(i8.n(), 5L, TimeUnit.SECONDS);
            eVar.w(bitmap);
            eVar.J(new i.b().p(bitmap).o(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            i8.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e8) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e8.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            i8.close();
        }
    }
}
