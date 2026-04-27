package N0;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f3942a;

    /* JADX INFO: renamed from: N0.a$a, reason: collision with other inner class name */
    public static final class C0055a extends s implements Function0 {
        public C0055a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class invoke() throws ClassNotFoundException {
            Class<?> clsLoadClass = a.this.f3942a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
            r.e(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            return clsLoadClass;
        }
    }

    public static final class b extends s implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Method getWindowExtensionsMethod = a.this.d().getDeclaredMethod("getWindowExtensions", null);
            Class clsC = a.this.c();
            W0.a aVar = W0.a.f5359a;
            r.e(getWindowExtensionsMethod, "getWindowExtensionsMethod");
            return Boolean.valueOf(aVar.c(getWindowExtensionsMethod, clsC) && aVar.d(getWindowExtensionsMethod));
        }
    }

    public a(ClassLoader loader) {
        r.f(loader, "loader");
        this.f3942a = loader;
    }

    public final Class c() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f3942a.loadClass("androidx.window.extensions.WindowExtensions");
        r.e(clsLoadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return clsLoadClass;
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f3942a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        r.e(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return clsLoadClass;
    }

    public final boolean e() {
        return W0.a.f5359a.a(new C0055a());
    }

    public final boolean f() {
        return e() && W0.a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new b());
    }
}
