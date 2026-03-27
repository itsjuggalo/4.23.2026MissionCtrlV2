package X5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: X5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0986b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0986b f9410a = new C0986b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f9411b;

    /* JADX INFO: renamed from: X5.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f9412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f9413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f9414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f9415d;

        public a(Method method, Method method2, Method method3, Method method4) {
            this.f9412a = method;
            this.f9413b = method2;
            this.f9414c = method3;
            this.f9415d = method4;
        }

        public final Method a() {
            return this.f9413b;
        }

        public final Method b() {
            return this.f9415d;
        }

        public final Method c() {
            return this.f9414c;
        }

        public final Method d() {
            return this.f9412a;
        }
    }

    public final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    public final a b() {
        a aVar = f9411b;
        if (aVar != null) {
            return aVar;
        }
        a aVarA = a();
        f9411b = aVarA;
        return aVarA;
    }

    public final Class[] c(Class clazz) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(clazz, "clazz");
        Method methodA = b().a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(clazz, null);
        AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) objInvoke;
    }

    public final Object[] d(Class clazz) {
        AbstractC2304t.f(clazz, "clazz");
        Method methodB = b().b();
        if (methodB == null) {
            return null;
        }
        return (Object[]) methodB.invoke(clazz, null);
    }

    public final Boolean e(Class clazz) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(clazz, "clazz");
        Method methodC = b().c();
        if (methodC == null) {
            return null;
        }
        Object objInvoke = methodC.invoke(clazz, null);
        AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }

    public final Boolean f(Class clazz) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(clazz, "clazz");
        Method methodD = b().d();
        if (methodD == null) {
            return null;
        }
        Object objInvoke = methodD.invoke(clazz, null);
        AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }
}
