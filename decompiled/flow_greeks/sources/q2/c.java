package q2;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.WeakHashMap;
import r2.k;
import r2.l;
import r2.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f18779a = Uri.parse("*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f18780b = Uri.parse("");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f18781c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap f18782d = new WeakHashMap();

    public static PackageInfo a() {
        if (Build.VERSION.SDK_INT >= 26) {
            return r2.c.a();
        }
        try {
            return c();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static m b() {
        return l.d();
    }

    public static PackageInfo c() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static boolean d() {
        if (k.S.c()) {
            return b().getStatics().isMultiProcessEnabled();
        }
        throw k.a();
    }
}
