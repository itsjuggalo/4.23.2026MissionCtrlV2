package U3;

import F.k;
import U3.AbstractC0691d;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: U3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0692e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f4897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f4898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.messaging.c f4899c;

    public C0692e(Context context, com.google.firebase.messaging.c cVar, ExecutorService executorService) {
        this.f4897a = executorService;
        this.f4898b = context;
        this.f4899c = cVar;
    }

    public boolean a() {
        if (this.f4899c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        H hD = d();
        AbstractC0691d.a aVarE = AbstractC0691d.e(this.f4898b, this.f4899c);
        e(aVarE.f4884a, hD);
        c(aVarE);
        return true;
    }

    public final boolean b() {
        if (((KeyguardManager) this.f4898b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!W1.m.c()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f4898b.getSystemService("activity")).getRunningAppProcesses();
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

    public final void c(AbstractC0691d.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f4898b.getSystemService("notification")).notify(aVar.f4885b, aVar.f4886c, aVar.f4884a.c());
    }

    public final H d() {
        H hG = H.G(this.f4899c.p("gcm.n.image"));
        if (hG != null) {
            hG.M(this.f4897a);
        }
        return hG;
    }

    public final void e(k.e eVar, H h7) {
        if (h7 == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(h7.H(), 5L, TimeUnit.SECONDS);
            eVar.v(bitmap);
            eVar.I(new k.b().p(bitmap).o(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            h7.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e7) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e7.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            h7.close();
        }
    }
}
