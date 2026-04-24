package L0;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f4965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final I0.d f4966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H0.b f4967c;

    public static final class a extends AbstractC2306v implements Function0 {
        public a() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r6 = this;
                L0.e r0 = L0.e.this
                java.lang.Class r0 = L0.e.b(r0)
                java.lang.String r1 = "getType"
                r2 = 0
                java.lang.reflect.Method r1 = r0.getMethod(r1, r2)
                java.lang.Class r2 = java.lang.Integer.TYPE
                java.lang.Class[] r3 = new java.lang.Class[]{r2}
                java.lang.String r4 = "hasProperty"
                java.lang.reflect.Method r3 = r0.getMethod(r4, r3)
                java.lang.Class<int[]> r4 = int[].class
                java.lang.Class[] r4 = new java.lang.Class[]{r4}
                java.lang.String r5 = "hasProperties"
                java.lang.reflect.Method r0 = r0.getMethod(r5, r4)
                Q0.a r4 = Q0.a.f6645a
                kotlin.jvm.internal.AbstractC2304t.c(r1)
                boolean r5 = r4.d(r1)
                if (r5 == 0) goto L58
                boolean r1 = r4.c(r1, r2)
                if (r1 == 0) goto L58
                kotlin.jvm.internal.AbstractC2304t.c(r3)
                boolean r1 = r4.d(r3)
                if (r1 == 0) goto L58
                java.lang.Class r1 = java.lang.Boolean.TYPE
                boolean r2 = r4.c(r3, r1)
                if (r2 == 0) goto L58
                kotlin.jvm.internal.AbstractC2304t.c(r0)
                boolean r2 = r4.d(r0)
                if (r2 == 0) goto L58
                boolean r0 = r4.c(r0, r1)
                if (r0 == 0) goto L58
                r0 = 1
                goto L59
            L58:
                r0 = 0
            L59:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: L0.e.a.invoke():java.lang.Boolean");
        }
    }

    public static final class b extends AbstractC2306v implements Function0 {
        public b() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r5 = this;
                L0.e r0 = L0.e.this
                java.lang.Class r0 = L0.e.c(r0)
                java.lang.String r1 = "getBounds"
                r2 = 0
                java.lang.reflect.Method r1 = r0.getMethod(r1, r2)
                java.lang.String r3 = "getType"
                java.lang.reflect.Method r3 = r0.getMethod(r3, r2)
                java.lang.String r4 = "getState"
                java.lang.reflect.Method r0 = r0.getMethod(r4, r2)
                Q0.a r2 = Q0.a.f6645a
                kotlin.jvm.internal.AbstractC2304t.c(r1)
                java.lang.Class<android.graphics.Rect> r4 = android.graphics.Rect.class
                I5.d r4 = kotlin.jvm.internal.O.b(r4)
                boolean r4 = r2.b(r1, r4)
                if (r4 == 0) goto L5a
                boolean r1 = r2.d(r1)
                if (r1 == 0) goto L5a
                kotlin.jvm.internal.AbstractC2304t.c(r3)
                java.lang.Class r1 = java.lang.Integer.TYPE
                I5.d r4 = kotlin.jvm.internal.O.b(r1)
                boolean r4 = r2.b(r3, r4)
                if (r4 == 0) goto L5a
                boolean r3 = r2.d(r3)
                if (r3 == 0) goto L5a
                kotlin.jvm.internal.AbstractC2304t.c(r0)
                I5.d r1 = kotlin.jvm.internal.O.b(r1)
                boolean r1 = r2.b(r0, r1)
                if (r1 == 0) goto L5a
                boolean r0 = r2.d(r0)
                if (r0 == 0) goto L5a
                r0 = 1
                goto L5b
            L5a:
                r0 = 0
            L5b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: L0.e.b.invoke():java.lang.Boolean");
        }
    }

    public static final class c extends AbstractC2306v implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException {
            Method method = e.this.l().getMethod("getSupportedWindowFeatures", null);
            Q0.a aVar = Q0.a.f6645a;
            AbstractC2304t.c(method);
            return Boolean.valueOf(aVar.d(method) && aVar.c(method, e.this.j()));
        }
    }

    public static final class d extends AbstractC2306v implements Function0 {
        public d() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r4 = this;
                L0.e r0 = L0.e.this
                I0.d r0 = L0.e.a(r0)
                java.lang.Class r0 = r0.b()
                if (r0 != 0) goto Lf
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                return r0
            Lf:
                L0.e r1 = L0.e.this
                java.lang.Class r1 = L0.e.f(r1)
                java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
                java.lang.Class[] r2 = new java.lang.Class[]{r2, r0}
                java.lang.String r3 = "addWindowLayoutInfoListener"
                java.lang.reflect.Method r2 = r1.getMethod(r3, r2)
                java.lang.String r3 = "removeWindowLayoutInfoListener"
                java.lang.Class[] r0 = new java.lang.Class[]{r0}
                java.lang.reflect.Method r0 = r1.getMethod(r3, r0)
                Q0.a r1 = Q0.a.f6645a
                kotlin.jvm.internal.AbstractC2304t.c(r2)
                boolean r2 = r1.d(r2)
                if (r2 == 0) goto L41
                kotlin.jvm.internal.AbstractC2304t.c(r0)
                boolean r0 = r1.d(r0)
                if (r0 == 0) goto L41
                r0 = 1
                goto L42
            L41:
                r0 = 0
            L42:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: L0.e.d.invoke():java.lang.Boolean");
        }
    }

    /* JADX INFO: renamed from: L0.e$e, reason: collision with other inner class name */
    public static final class C0069e extends AbstractC2306v implements Function0 {
        public C0069e() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
            /*
                r4 = this;
                L0.e r0 = L0.e.this
                java.lang.Class r0 = L0.e.f(r0)
                java.lang.Class<android.content.Context> r1 = android.content.Context.class
                java.lang.Class<androidx.window.extensions.core.util.function.Consumer> r2 = androidx.window.extensions.core.util.function.Consumer.class
                java.lang.Class[] r1 = new java.lang.Class[]{r1, r2}
                java.lang.String r2 = "addWindowLayoutInfoListener"
                java.lang.reflect.Method r1 = r0.getMethod(r2, r1)
                java.lang.Class<androidx.window.extensions.core.util.function.Consumer> r2 = androidx.window.extensions.core.util.function.Consumer.class
                java.lang.Class[] r2 = new java.lang.Class[]{r2}
                java.lang.String r3 = "removeWindowLayoutInfoListener"
                java.lang.reflect.Method r0 = r0.getMethod(r3, r2)
                Q0.a r2 = Q0.a.f6645a
                kotlin.jvm.internal.AbstractC2304t.c(r1)
                boolean r1 = r2.d(r1)
                if (r1 == 0) goto L36
                kotlin.jvm.internal.AbstractC2304t.c(r0)
                boolean r0 = r2.d(r0)
                if (r0 == 0) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: L0.e.C0069e.invoke():java.lang.Boolean");
        }
    }

    public static final class f extends AbstractC2306v implements Function0 {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException {
            Method method = e.this.j().getMethod("getDisplayFoldFeatures", null);
            Type genericReturnType = method.getGenericReturnType();
            AbstractC2304t.d(genericReturnType, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            boolean z7 = false;
            Type type = ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
            AbstractC2304t.d(type, "null cannot be cast to non-null type java.lang.Class<*>");
            Class cls = (Class) type;
            Q0.a aVar = Q0.a.f6645a;
            AbstractC2304t.c(method);
            if (aVar.d(method) && aVar.c(method, List.class) && AbstractC2304t.b(cls, e.this.h())) {
                z7 = true;
            }
            return Boolean.valueOf(z7);
        }
    }

    public static final class g extends AbstractC2306v implements Function0 {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Method method = e.this.f4967c.c().getMethod("getWindowLayoutComponent", null);
            Class clsL = e.this.l();
            Q0.a aVar = Q0.a.f6645a;
            AbstractC2304t.c(method);
            return Boolean.valueOf(aVar.d(method) && aVar.c(method, clsL));
        }
    }

    public e(ClassLoader loader, I0.d consumerAdapter) {
        AbstractC2304t.f(loader, "loader");
        AbstractC2304t.f(consumerAdapter, "consumerAdapter");
        this.f4965a = loader;
        this.f4966b = consumerAdapter;
        this.f4967c = new H0.b(loader);
    }

    public final boolean g() {
        int iA;
        if (v() && (iA = I0.e.f4033a.a()) >= 1) {
            return iA == 1 ? m() : iA < 5 ? n() : o();
        }
        return false;
    }

    public final Class h() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f4965a.loadClass("androidx.window.extensions.layout.DisplayFoldFeature");
        AbstractC2304t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final Class i() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f4965a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        AbstractC2304t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final Class j() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f4965a.loadClass("androidx.window.extensions.layout.SupportedWindowFeatures");
        AbstractC2304t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final WindowLayoutComponent k() {
        if (!g()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final Class l() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f4965a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        AbstractC2304t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }

    public final boolean m() {
        return s();
    }

    public final boolean n() {
        return m() && t();
    }

    public final boolean o() {
        return n() && p() && u() && r();
    }

    public final boolean p() {
        return Q0.a.e("DisplayFoldFeature is not valid", new a());
    }

    public final boolean q() {
        return Q0.a.e("FoldingFeature class is not valid", new b());
    }

    public final boolean r() {
        return Q0.a.e("WindowLayoutComponent#getSupportedWindowFeatures is not valid", new c());
    }

    public final boolean s() {
        return Q0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new d());
    }

    public final boolean t() {
        return Q0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new C0069e());
    }

    public final boolean u() {
        return Q0.a.e("SupportedWindowFeatures is not valid", new f());
    }

    public final boolean v() {
        return this.f4967c.f() && w() && q();
    }

    public final boolean w() {
        return Q0.a.e("WindowExtensions#getWindowLayoutComponent is not valid", new g());
    }
}
