package G0;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f2084a = new s(o.d().getWebkitToCompatConverter());
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f2085a = o.a();
    }

    public static p a() {
        try {
            return new q((WebViewProviderFactoryBoundaryInterface) w7.a.a(WebViewProviderFactoryBoundaryInterface.class, b()));
        } catch (ClassNotFoundException unused) {
            return new j();
        } catch (IllegalAccessException e8) {
            e = e8;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e9) {
            e = e9;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e10) {
            e = e10;
            throw new RuntimeException(e);
        }
    }

    public static InvocationHandler b() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, e()).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static s c() {
        return a.f2084a;
    }

    public static p d() {
        return b.f2085a;
    }

    public static ClassLoader e() {
        return Build.VERSION.SDK_INT >= 28 ? h.a() : f().getClass().getClassLoader();
    }

    public static Object f() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }
}
