package L0;

import M0.n;
import M0.o;
import M0.p;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f3645a = Uri.parse("*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f3646b = Uri.parse("");

    public static PackageInfo a() {
        if (Build.VERSION.SDK_INT >= 26) {
            return M0.d.a();
        }
        try {
            return c();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static p b() {
        return o.d();
    }

    public static PackageInfo c() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static boolean d() {
        if (n.f3754R.d()) {
            return b().getStatics().isMultiProcessEnabled();
        }
        throw n.a();
    }
}
