package Y1;

import W1.m;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f5637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f5638b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f5637a;
        if (context2 != null && (bool = f5638b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f5638b = null;
        if (m.e()) {
            f5638b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f5638b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f5638b = Boolean.FALSE;
            }
        }
        f5637a = applicationContext;
        return f5638b.booleanValue();
    }
}
