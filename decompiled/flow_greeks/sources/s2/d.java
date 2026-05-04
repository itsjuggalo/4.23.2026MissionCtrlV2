package s2;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f19961a;

    public d(ClassLoader loader) {
        t.f(loader, "loader");
        this.f19961a = loader;
    }

    public static final Class f(d dVar) throws ClassNotFoundException {
        Class<?> clsLoadClass = dVar.f19961a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public static final boolean g(d dVar) throws NoSuchMethodException, ClassNotFoundException {
        Method declaredMethod = dVar.d().getDeclaredMethod("getWindowExtensions", null);
        Class clsC = dVar.c();
        b3.a aVar = b3.a.f2934a;
        t.c(declaredMethod);
        return aVar.b(declaredMethod, clsC) && aVar.d(declaredMethod);
    }

    public final Class c() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f19961a.loadClass("androidx.window.extensions.WindowExtensions");
        t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f19961a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final boolean e() {
        return b3.a.f2934a.a(new Function0() { // from class: s2.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.f(this.f19960a);
            }
        });
    }

    public final boolean h() {
        return e() && b3.a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new Function0() { // from class: s2.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(d.g(this.f19959a));
            }
        });
    }
}
