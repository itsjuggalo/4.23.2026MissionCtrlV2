package w0;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: renamed from: w0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1899a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f15549a;

    /* JADX INFO: renamed from: w0.a$a, reason: collision with other inner class name */
    public static final class C0251a extends s implements Function0 {
        public C0251a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class invoke() throws ClassNotFoundException {
            Class<?> clsLoadClass = C1899a.this.f15549a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
            r.e(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            return clsLoadClass;
        }
    }

    /* JADX INFO: renamed from: w0.a$b */
    public static final class b extends s implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            boolean z4 = false;
            Method getWindowExtensionsMethod = C1899a.this.d().getDeclaredMethod("getWindowExtensions", new Class[0]);
            Class clsC = C1899a.this.c();
            F0.a aVar = F0.a.f430a;
            r.e(getWindowExtensionsMethod, "getWindowExtensionsMethod");
            if (aVar.b(getWindowExtensionsMethod, clsC) && aVar.d(getWindowExtensionsMethod)) {
                z4 = true;
            }
            return Boolean.valueOf(z4);
        }
    }

    public C1899a(ClassLoader loader) {
        r.f(loader, "loader");
        this.f15549a = loader;
    }

    public final Class c() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f15549a.loadClass("androidx.window.extensions.WindowExtensions");
        r.e(clsLoadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return clsLoadClass;
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f15549a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        r.e(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return clsLoadClass;
    }

    public final boolean e() {
        return F0.a.f430a.a(new C0251a());
    }

    public final boolean f() {
        return e() && F0.a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new b());
    }
}
