package e3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: e3.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0537G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f6105a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f6106b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static R1.a f6107c;

    public static void a(Context context) {
        if (f6107c == null) {
            R1.a aVar = new R1.a(context);
            f6107c = aVar;
            synchronized (aVar.f2761a) {
                aVar.f2766g = true;
            }
        }
    }

    public static void b(Intent intent) {
        synchronized (f6106b) {
            try {
                if (f6107c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    f6107c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ComponentName c(Context context, Intent intent) {
        synchronized (f6106b) {
            try {
                a(context);
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!booleanExtra) {
                    f6107c.a(f6105a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
