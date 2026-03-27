package t1;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f9874h;
    public static PendingIntent i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f9875j = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f9878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f9879d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Messenger f9880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f9881g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q.k f9876a = new q.k();
    public final Messenger e = new Messenger(new e(this, Looper.getMainLooper()));

    public b(Context context) {
        this.f9877b = context;
        this.f9878c = new o(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f9879d = scheduledThreadPoolExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.tasks.Task a(android.os.Bundle r9) {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.b.a(android.os.Bundle):com.google.android.gms.tasks.Task");
    }

    public final void b(String str, Bundle bundle) {
        synchronized (this.f9876a) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f9876a.remove(str);
                if (taskCompletionSource != null) {
                    taskCompletionSource.setResult(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
