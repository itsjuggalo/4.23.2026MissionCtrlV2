package v0;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f15283a = new o(l.d().getWebkitToCompatConverter());
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f15284a = l.a();
    }

    public static m a() {
        try {
            return new n((WebViewProviderFactoryBoundaryInterface) S3.a.a(WebViewProviderFactoryBoundaryInterface.class, b()));
        } catch (ClassNotFoundException unused) {
            return new g();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static InvocationHandler b() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, e()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]);
    }

    public static o c() {
        return a.f15283a;
    }

    public static m d() {
        return b.f15284a;
    }

    public static ClassLoader e() {
        return Build.VERSION.SDK_INT >= 28 ? AbstractC1880e.a() : f().getClass().getClassLoader();
    }

    public static Object f() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }
}
