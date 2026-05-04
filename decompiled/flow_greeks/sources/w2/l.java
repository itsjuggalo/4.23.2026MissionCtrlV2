package w2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f23641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t2.d f23642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s2.d f23643c;

    public l(ClassLoader loader, t2.d consumerAdapter) {
        kotlin.jvm.internal.t.f(loader, "loader");
        kotlin.jvm.internal.t.f(consumerAdapter, "consumerAdapter");
        this.f23641a = loader;
        this.f23642b = consumerAdapter;
        this.f23643c = new s2.d(loader);
    }

    public static final boolean B(l lVar) throws NoSuchMethodException {
        Method method = lVar.k().getMethod("getDisplayFoldFeatures", null);
        Type genericReturnType = method.getGenericReturnType();
        kotlin.jvm.internal.t.d(genericReturnType, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
        kotlin.jvm.internal.t.d(type, "null cannot be cast to non-null type java.lang.Class<*>");
        Class cls = (Class) type;
        b3.a aVar = b3.a.f2934a;
        kotlin.jvm.internal.t.c(method);
        return aVar.d(method) && aVar.b(method, List.class) && kotlin.jvm.internal.t.b(cls, lVar.i());
    }

    public static final boolean E(l lVar) throws NoSuchMethodException, ClassNotFoundException {
        Method method = lVar.f23643c.c().getMethod("getWindowLayoutComponent", null);
        Class clsM = lVar.m();
        b3.a aVar = b3.a.f2934a;
        kotlin.jvm.internal.t.c(method);
        return aVar.d(method) && aVar.b(method, clsM);
    }

    public static final boolean r(l lVar) throws NoSuchMethodException, ClassNotFoundException {
        Class clsI = lVar.i();
        Method method = clsI.getMethod("getType", null);
        Class cls = Integer.TYPE;
        Method method2 = clsI.getMethod("hasProperty", cls);
        Method method3 = clsI.getMethod("hasProperties", int[].class);
        b3.a aVar = b3.a.f2934a;
        kotlin.jvm.internal.t.c(method);
        if (!aVar.d(method) || !aVar.b(method, cls)) {
            return false;
        }
        kotlin.jvm.internal.t.c(method2);
        if (!aVar.d(method2)) {
            return false;
        }
        Class cls2 = Boolean.TYPE;
        if (!aVar.b(method2, cls2)) {
            return false;
        }
        kotlin.jvm.internal.t.c(method3);
        return aVar.d(method3) && aVar.b(method3, cls2);
    }

    public static final boolean t(l lVar) throws NoSuchMethodException, ClassNotFoundException {
        Class clsJ = lVar.j();
        Method method = clsJ.getMethod("getBounds", null);
        Method method2 = clsJ.getMethod("getType", null);
        Method method3 = clsJ.getMethod("getState", null);
        b3.a aVar = b3.a.f2934a;
        kotlin.jvm.internal.t.c(method);
        if (!aVar.c(method, n0.b(Rect.class)) || !aVar.d(method)) {
            return false;
        }
        kotlin.jvm.internal.t.c(method2);
        Class cls = Integer.TYPE;
        if (!aVar.c(method2, n0.b(cls)) || !aVar.d(method2)) {
            return false;
        }
        kotlin.jvm.internal.t.c(method3);
        return aVar.c(method3, n0.b(cls)) && aVar.d(method3);
    }

    public static final boolean v(l lVar) throws NoSuchMethodException {
        Method method = lVar.m().getMethod("getSupportedWindowFeatures", null);
        b3.a aVar = b3.a.f2934a;
        kotlin.jvm.internal.t.c(method);
        return aVar.d(method) && aVar.b(method, lVar.k());
    }

    public static final boolean x(l lVar) throws NoSuchMethodException, ClassNotFoundException {
        Class clsB = lVar.f23642b.b();
        if (clsB == null) {
            return false;
        }
        Class clsM = lVar.m();
        Method method = clsM.getMethod("addWindowLayoutInfoListener", Activity.class, clsB);
        Method method2 = clsM.getMethod("removeWindowLayoutInfoListener", clsB);
        b3.a aVar = b3.a.f2934a;
        kotlin.jvm.internal.t.c(method);
        if (aVar.d(method)) {
            kotlin.jvm.internal.t.c(method2);
            if (aVar.d(method2)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean z(l lVar) throws NoSuchMethodException, ClassNotFoundException {
        Class clsM = lVar.m();
        Method method = clsM.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
        Method method2 = clsM.getMethod("removeWindowLayoutInfoListener", Consumer.class);
        b3.a aVar = b3.a.f2934a;
        kotlin.jvm.internal.t.c(method);
        if (!aVar.d(method)) {
            return false;
        }
        kotlin.jvm.internal.t.c(method2);
        return aVar.d(method2);
    }

    public final boolean A() {
        return b3.a.e("SupportedWindowFeatures is not valid", new Function0() { // from class: w2.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(l.B(this.f23636a));
            }
        });
    }

    public final boolean C() {
        return this.f23643c.h() && D() && s();
    }

    public final boolean D() {
        return b3.a.e("WindowExtensions#getWindowLayoutComponent is not valid", new Function0() { // from class: w2.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(l.E(this.f23634a));
            }
        });
    }

    public final boolean h() {
        int iA;
        if (C() && (iA = t2.e.f20647a.a()) >= 1) {
            return iA == 1 ? n() : iA < 5 ? o() : p();
        }
        return false;
    }

    public final Class i() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f23641a.loadClass("androidx.window.extensions.layout.DisplayFoldFeature");
        kotlin.jvm.internal.t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final Class j() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f23641a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        kotlin.jvm.internal.t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final Class k() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f23641a.loadClass("androidx.window.extensions.layout.SupportedWindowFeatures");
        kotlin.jvm.internal.t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final WindowLayoutComponent l() {
        if (!h()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final Class m() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f23641a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        kotlin.jvm.internal.t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final boolean n() {
        return w();
    }

    public final boolean o() {
        return n() && y();
    }

    public final boolean p() {
        return o() && q() && A() && u();
    }

    public final boolean q() {
        return b3.a.e("DisplayFoldFeature is not valid", new Function0() { // from class: w2.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(l.r(this.f23637a));
            }
        });
    }

    public final boolean s() {
        return b3.a.e("FoldingFeature class is not valid", new Function0() { // from class: w2.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(l.t(this.f23635a));
            }
        });
    }

    public final boolean u() {
        return b3.a.e("WindowLayoutComponent#getSupportedWindowFeatures is not valid", new Function0() { // from class: w2.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(l.v(this.f23638a));
            }
        });
    }

    public final boolean w() {
        return b3.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new Function0() { // from class: w2.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(l.x(this.f23639a));
            }
        });
    }

    public final boolean y() {
        return b3.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new Function0() { // from class: w2.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(l.z(this.f23640a));
            }
        });
    }
}
