package Y1;

import W1.l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f9528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f9529b;

    public static synchronized boolean a(Context context) {
        Boolean boolValueOf;
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f9528a;
        if (context2 != null && (bool = f9529b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f9529b = null;
        if (!l.e()) {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f9529b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                boolValueOf = Boolean.FALSE;
                f9529b = boolValueOf;
            }
            f9528a = applicationContext;
            return f9529b.booleanValue();
        }
        boolValueOf = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        f9529b = boolValueOf;
        f9528a = applicationContext;
        return f9529b.booleanValue();
    }
}
