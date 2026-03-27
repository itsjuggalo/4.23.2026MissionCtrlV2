package u0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.WeakHashMap;
import v0.AbstractC1878c;
import v0.k;
import v0.l;
import v0.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f15091a = Uri.parse("*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f15092b = Uri.parse("");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f15093c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap f15094d = new WeakHashMap();

    public static PackageInfo a() {
        if (Build.VERSION.SDK_INT >= 26) {
            return AbstractC1878c.a();
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
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
    }

    public static boolean d() {
        if (k.f15227S.c()) {
            return b().getStatics().isMultiProcessEnabled();
        }
        throw k.a();
    }
}
