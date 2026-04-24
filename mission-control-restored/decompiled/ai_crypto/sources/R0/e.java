package R0;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f4641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O0.d f4642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final N0.a f4643c;

    public static final class a extends s implements Function0 {
        public a() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r5 = this;
                R0.e r0 = R0.e.this
                java.lang.Class r0 = R0.e.b(r0)
                java.lang.String r1 = "getBounds"
                r2 = 0
                java.lang.reflect.Method r1 = r0.getMethod(r1, r2)
                java.lang.String r3 = "getType"
                java.lang.reflect.Method r3 = r0.getMethod(r3, r2)
                java.lang.String r4 = "getState"
                java.lang.reflect.Method r0 = r0.getMethod(r4, r2)
                W0.a r2 = W0.a.f5359a
                java.lang.String r4 = "getBoundsMethod"
                kotlin.jvm.internal.r.e(r1, r4)
                java.lang.Class<android.graphics.Rect> r4 = android.graphics.Rect.class
                X5.c r4 = kotlin.jvm.internal.H.b(r4)
                boolean r4 = r2.b(r1, r4)
                if (r4 == 0) goto L60
                boolean r1 = r2.d(r1)
                if (r1 == 0) goto L60
                java.lang.String r1 = "getTypeMethod"
                kotlin.jvm.internal.r.e(r3, r1)
                java.lang.Class r1 = java.lang.Integer.TYPE
                X5.c r4 = kotlin.jvm.internal.H.b(r1)
                boolean r4 = r2.b(r3, r4)
                if (r4 == 0) goto L60
                boolean r3 = r2.d(r3)
                if (r3 == 0) goto L60
                java.lang.String r3 = "getStateMethod"
                kotlin.jvm.internal.r.e(r0, r3)
                X5.c r1 = kotlin.jvm.internal.H.b(r1)
                boolean r1 = r2.b(r0, r1)
                if (r1 == 0) goto L60
                boolean r0 = r2.d(r0)
                if (r0 == 0) goto L60
                r0 = 1
                goto L61
            L60:
                r0 = 0
            L61:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: R0.e.a.invoke():java.lang.Boolean");
        }
    }

    public static final class b extends s implements Function0 {
        public b() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r4 = this;
                R0.e r0 = R0.e.this
                O0.d r0 = R0.e.a(r0)
                java.lang.Class r0 = r0.b()
                if (r0 != 0) goto Lf
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                return r0
            Lf:
                R0.e r1 = R0.e.this
                java.lang.Class r1 = R0.e.d(r1)
                java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
                java.lang.Class[] r2 = new java.lang.Class[]{r2, r0}
                java.lang.String r3 = "addWindowLayoutInfoListener"
                java.lang.reflect.Method r2 = r1.getMethod(r3, r2)
                java.lang.String r3 = "removeWindowLayoutInfoListener"
                java.lang.Class[] r0 = new java.lang.Class[]{r0}
                java.lang.reflect.Method r0 = r1.getMethod(r3, r0)
                W0.a r1 = W0.a.f5359a
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
            throw new UnsupportedOperationException("Method not decompiled: R0.e.b.invoke():java.lang.Boolean");
        }
    }

    public static final class c extends s implements Function0 {
        public c() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r4 = this;
                R0.e r0 = R0.e.this
                java.lang.Class r0 = R0.e.d(r0)
                java.lang.Class<android.content.Context> r1 = android.content.Context.class
                java.lang.Class<androidx.window.extensions.core.util.function.Consumer> r2 = androidx.window.extensions.core.util.function.Consumer.class
                java.lang.Class[] r1 = new java.lang.Class[]{r1, r2}
                java.lang.String r3 = "addWindowLayoutInfoListener"
                java.lang.reflect.Method r1 = r0.getMethod(r3, r1)
                java.lang.String r3 = "removeWindowLayoutInfoListener"
                java.lang.Class[] r2 = new java.lang.Class[]{r2}
                java.lang.reflect.Method r0 = r0.getMethod(r3, r2)
                W0.a r2 = W0.a.f5359a
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
            throw new UnsupportedOperationException("Method not decompiled: R0.e.c.invoke():java.lang.Boolean");
        }
    }

    public static final class d extends s implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Method getWindowLayoutComponentMethod = e.this.f4643c.c().getMethod("getWindowLayoutComponent", null);
            Class clsH = e.this.h();
            W0.a aVar = W0.a.f5359a;
            r.e(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
            return Boolean.valueOf(aVar.d(getWindowLayoutComponentMethod) && aVar.c(getWindowLayoutComponentMethod, clsH));
        }
    }

    public e(ClassLoader loader, O0.d consumerAdapter) {
        r.f(loader, "loader");
        r.f(consumerAdapter, "consumerAdapter");
        this.f4641a = loader;
        this.f4642b = consumerAdapter;
        this.f4643c = new N0.a(loader);
    }

    public final boolean e() {
        if (!n()) {
            return false;
        }
        int iA = O0.e.f4019a.a();
        if (iA == 1) {
            return i();
        }
        if (2 > iA || iA > Integer.MAX_VALUE) {
            return false;
        }
        return j();
    }

    public final Class f() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f4641a.loadClass("androidx.window.extensions.layout.FoldingFeature");
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
        Class<?> clsLoadClass = this.f4641a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
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
        return W0.a.e("FoldingFeature class is not valid", new a());
    }

    public final boolean l() {
        return W0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new b());
    }

    public final boolean m() {
        return W0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new c());
    }

    public final boolean n() {
        return this.f4643c.f() && o() && k();
    }

    public final boolean o() {
        return W0.a.e("WindowExtensions#getWindowLayoutComponent is not valid", new d());
    }
}
