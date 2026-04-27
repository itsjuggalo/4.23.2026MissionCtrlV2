package t;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f9796d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static V f9798g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f9800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f9795c = new Object();
    public static HashSet e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f9797f = new Object();

    public W(Context context) {
        this.f9799a = context;
        this.f9800b = (NotificationManager) context.getSystemService("notification");
    }

    public final void a(int i, String str) {
        this.f9800b.cancel(str, i);
    }

    public final void b(String str, int i, Notification notification) {
        Bundle bundle = notification.extras;
        NotificationManager notificationManager = this.f9800b;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            notificationManager.notify(str, i, notification);
            return;
        }
        S s6 = new S(this.f9799a.getPackageName(), i, str, notification);
        synchronized (f9797f) {
            try {
                if (f9798g == null) {
                    f9798g = new V(this.f9799a.getApplicationContext());
                }
                f9798g.f9792b.obtainMessage(0, s6).sendToTarget();
            } catch (Throwable th) {
                throw th;
            }
        }
        notificationManager.cancel(str, i);
    }
}
