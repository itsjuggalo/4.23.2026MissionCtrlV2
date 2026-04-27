package I1;

import G1.m;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f850b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f849a;
        if (context2 != null && (bool = f850b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f850b = null;
        if (m.e()) {
            f850b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f850b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f850b = Boolean.FALSE;
            }
        }
        f849a = applicationContext;
        return f850b.booleanValue();
    }
}
