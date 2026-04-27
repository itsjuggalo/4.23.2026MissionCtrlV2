package H0;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f3562a;

    public static final class a extends AbstractC2306v implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class invoke() throws ClassNotFoundException {
            Class<?> clsLoadClass = b.this.f3562a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
            AbstractC2304t.e(clsLoadClass, "loadClass(...)");
            return clsLoadClass;
        }
    }

    /* JADX INFO: renamed from: H0.b$b, reason: collision with other inner class name */
    public static final class C0043b extends AbstractC2306v implements Function0 {
        public C0043b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Method declaredMethod = b.this.d().getDeclaredMethod("getWindowExtensions", null);
            Class clsC = b.this.c();
            Q0.a aVar = Q0.a.f6645a;
            AbstractC2304t.c(declaredMethod);
            return Boolean.valueOf(aVar.c(declaredMethod, clsC) && aVar.d(declaredMethod));
        }
    }

    public b(ClassLoader loader) {
        AbstractC2304t.f(loader, "loader");
        this.f3562a = loader;
    }

    public final Class c() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f3562a.loadClass("androidx.window.extensions.WindowExtensions");
        AbstractC2304t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f3562a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        AbstractC2304t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final boolean e() {
        return Q0.a.f6645a.a(new a());
    }

    public final boolean f() {
        return e() && Q0.a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new C0043b());
    }
}
