package v5;

import android.content.Context;
import t5.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f23136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f23137b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f23136a;
        if (context2 != null && (bool = f23137b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f23137b = null;
        if (n.e()) {
            f23137b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f23137b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f23137b = Boolean.FALSE;
            }
        }
        f23136a = applicationContext;
        return f23137b.booleanValue();
    }
}
