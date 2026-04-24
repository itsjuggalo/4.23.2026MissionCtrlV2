package F0;

import G0.n;
import G0.o;
import G0.p;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f1498a = Uri.parse("*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f1499b = Uri.parse("");

    public static PackageInfo a() {
        if (Build.VERSION.SDK_INT >= 26) {
            return G0.d.a();
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
        if (n.f2039R.d()) {
            return b().getStatics().isMultiProcessEnabled();
        }
        throw n.a();
    }
}
