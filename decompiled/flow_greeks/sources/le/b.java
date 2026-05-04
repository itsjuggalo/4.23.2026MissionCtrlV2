package le;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f15595a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f15596b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f15597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f15598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f15599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f15600d;

        public a(Method method, Method method2, Method method3, Method method4) {
            this.f15597a = method;
            this.f15598b = method2;
            this.f15599c = method3;
            this.f15600d = method4;
        }

        public final Method a() {
            return this.f15598b;
        }

        public final Method b() {
            return this.f15600d;
        }

        public final Method c() {
            return this.f15599c;
        }

        public final Method d() {
            return this.f15597a;
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
        a aVar = f15596b;
        if (aVar != null) {
            return aVar;
        }
        a aVarA = a();
        f15596b = aVarA;
        return aVarA;
    }

    public final Class[] c(Class clazz) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.t.f(clazz, "clazz");
        Method methodA = b().a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(clazz, null);
        kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) objInvoke;
    }

    public final Object[] d(Class clazz) {
        kotlin.jvm.internal.t.f(clazz, "clazz");
        Method methodB = b().b();
        if (methodB == null) {
            return null;
        }
        return (Object[]) methodB.invoke(clazz, null);
    }

    public final Boolean e(Class clazz) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.t.f(clazz, "clazz");
        Method methodC = b().c();
        if (methodC == null) {
            return null;
        }
        Object objInvoke = methodC.invoke(clazz, null);
        kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }

    public final Boolean f(Class clazz) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.t.f(clazz, "clazz");
        Method methodD = b().d();
        if (methodD == null) {
            return null;
        }
        Object objInvoke = methodD.invoke(clazz, null);
        kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }
}
