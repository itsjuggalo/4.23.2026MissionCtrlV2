package A0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import w0.C1899a;
import x0.C1915d;
import x0.C1916e;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f20a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1915d f21b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1899a f22c;

    public static final class a extends s implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Class clsF = e.this.f();
            boolean z4 = false;
            Method getBoundsMethod = clsF.getMethod("getBounds", new Class[0]);
            Method getTypeMethod = clsF.getMethod("getType", new Class[0]);
            Method getStateMethod = clsF.getMethod("getState", new Class[0]);
            F0.a aVar = F0.a.f430a;
            r.e(getBoundsMethod, "getBoundsMethod");
            if (aVar.c(getBoundsMethod, G.b(Rect.class)) && aVar.d(getBoundsMethod)) {
                r.e(getTypeMethod, "getTypeMethod");
                Class cls = Integer.TYPE;
                if (aVar.c(getTypeMethod, G.b(cls)) && aVar.d(getTypeMethod)) {
                    r.e(getStateMethod, "getStateMethod");
                    if (aVar.c(getStateMethod, G.b(cls)) && aVar.d(getStateMethod)) {
                        z4 = true;
                    }
                }
            }
            return Boolean.valueOf(z4);
        }
    }

    public static final class b extends s implements Function0 {
        public b() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r4 = this;
                A0.e r0 = A0.e.this
                x0.d r0 = A0.e.a(r0)
                java.lang.Class r0 = r0.b()
                if (r0 != 0) goto Lf
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                return r0
            Lf:
                A0.e r1 = A0.e.this
                java.lang.Class r1 = A0.e.d(r1)
                java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
                java.lang.Class[] r2 = new java.lang.Class[]{r2, r0}
                java.lang.String r3 = "addWindowLayoutInfoListener"
                java.lang.reflect.Method r2 = r1.getMethod(r3, r2)
                java.lang.String r3 = "removeWindowLayoutInfoListener"
                java.lang.Class[] r0 = new java.lang.Class[]{r0}
                java.lang.reflect.Method r0 = r1.getMethod(r3, r0)
                F0.a r1 = F0.a.f430a
                java.lang.String r3 = "addListenerMethod"
                kotlin.jvm.internal.r.e(r2, r3)
                boolean r2 = r1.d(r2)
                if (r2 == 0) goto L45
                java.lang.String r2 = "removeListenerMethod"
                kotlin.jvm.internal.r.e(r0, r2)
                boolean r0 = r1.d(r0)
                if (r0 == 0) goto L45
                r0 = 1
                goto L46
            L45:
                r0 = 0
            L46:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: A0.e.b.invoke():java.lang.Boolean");
        }
    }

    public static final class c extends s implements Function0 {
        public c() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r4 = this;
                A0.e r0 = A0.e.this
                java.lang.Class r0 = A0.e.d(r0)
                java.lang.Class<android.content.Context> r1 = android.content.Context.class
                java.lang.Class<androidx.window.extensions.core.util.function.Consumer> r2 = androidx.window.extensions.core.util.function.Consumer.class
                java.lang.Class[] r1 = new java.lang.Class[]{r1, r2}
                java.lang.String r3 = "addWindowLayoutInfoListener"
                java.lang.reflect.Method r1 = r0.getMethod(r3, r1)
                java.lang.String r3 = "removeWindowLayoutInfoListener"
                java.lang.Class[] r2 = new java.lang.Class[]{r2}
                java.lang.reflect.Method r0 = r0.getMethod(r3, r2)
                F0.a r2 = F0.a.f430a
                java.lang.String r3 = "addListenerMethod"
                kotlin.jvm.internal.r.e(r1, r3)
                boolean r1 = r2.d(r1)
                if (r1 == 0) goto L38
                java.lang.String r1 = "removeListenerMethod"
                kotlin.jvm.internal.r.e(r0, r1)
                boolean r0 = r2.d(r0)
                if (r0 == 0) goto L38
                r0 = 1
                goto L39
            L38:
                r0 = 0
            L39:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: A0.e.c.invoke():java.lang.Boolean");
        }
    }

    public static final class d extends s implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            boolean z4 = false;
            Method getWindowLayoutComponentMethod = e.this.f22c.c().getMethod("getWindowLayoutComponent", new Class[0]);
            Class clsH = e.this.h();
            F0.a aVar = F0.a.f430a;
            r.e(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
            if (aVar.d(getWindowLayoutComponentMethod) && aVar.b(getWindowLayoutComponentMethod, clsH)) {
                z4 = true;
            }
            return Boolean.valueOf(z4);
        }
    }

    public e(ClassLoader loader, C1915d consumerAdapter) {
        r.f(loader, "loader");
        r.f(consumerAdapter, "consumerAdapter");
        this.f20a = loader;
        this.f21b = consumerAdapter;
        this.f22c = new C1899a(loader);
    }

    public final boolean e() {
        if (!n()) {
            return false;
        }
        int iA = C1916e.f15704a.a();
        if (iA == 1) {
            return i();
        }
        if (2 > iA || iA > Integer.MAX_VALUE) {
            return false;
        }
        return j();
    }

    public final Class f() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f20a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        r.e(clsLoadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
        return clsLoadClass;
    }

    public final WindowLayoutComponent g() {
        if (!e()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final Class h() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f20a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        r.e(clsLoadClass, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
        return clsLoadClass;
    }

    public final boolean i() {
        return l();
    }

    public final boolean j() {
        return i() && m();
    }

    public final boolean k() {
        return F0.a.e("FoldingFeature class is not valid", new a());
    }

    public final boolean l() {
        return F0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new b());
    }

    public final boolean m() {
        return F0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new c());
    }

    public final boolean n() {
        return this.f22c.f() && o() && k();
    }

    public final boolean o() {
        return F0.a.e("WindowExtensions#getWindowLayoutComponent is not valid", new d());
    }
}
