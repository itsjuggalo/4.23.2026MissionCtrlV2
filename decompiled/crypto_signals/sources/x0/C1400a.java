package x0;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

/* JADX INFO: renamed from: x0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1400a extends k implements R4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1401b f11448b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1400a(C1401b c1401b, int i) {
        super(0);
        this.f11447a = i;
        this.f11448b = c1401b;
    }

    @Override // R4.a
    public final Object invoke() throws NoSuchMethodException, ClassNotFoundException {
        switch (this.f11447a) {
            case 0:
                Class<?> clsLoadClass = this.f11448b.f11449a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                j.d(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                return clsLoadClass;
            default:
                C1401b c1401b = this.f11448b;
                Class<?> clsLoadClass2 = c1401b.f11449a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                j.d(clsLoadClass2, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                boolean z6 = false;
                Method getWindowExtensionsMethod = clsLoadClass2.getDeclaredMethod("getWindowExtensions", new Class[0]);
                Class<?> clsLoadClass3 = c1401b.f11449a.loadClass("androidx.window.extensions.WindowExtensions");
                j.d(clsLoadClass3, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                j.d(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                if (getWindowExtensionsMethod.getReturnType().equals(clsLoadClass3) && Modifier.isPublic(getWindowExtensionsMethod.getModifiers())) {
                    z6 = true;
                }
                return Boolean.valueOf(z6);
        }
    }
}
