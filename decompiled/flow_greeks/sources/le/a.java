package le;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15591a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0279a f15592b;

    /* JADX INFO: renamed from: le.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0279a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f15593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f15594b;

        public C0279a(Method method, Method method2) {
            this.f15593a = method;
            this.f15594b = method2;
        }

        public final Method a() {
            return this.f15594b;
        }

        public final Method b() {
            return this.f15593a;
        }
    }

    public final C0279a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0279a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (NoSuchMethodException unused) {
            return new C0279a(null, null);
        }
    }

    public final C0279a b(Object obj) {
        C0279a c0279a = f15592b;
        if (c0279a != null) {
            return c0279a;
        }
        C0279a c0279aA = a(obj);
        f15592b = c0279aA;
        return c0279aA;
    }

    public final Method c(Object recordComponent) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.t.f(recordComponent, "recordComponent");
        Method methodA = b(recordComponent).a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(recordComponent, null);
        kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) objInvoke;
    }

    public final Class d(Object recordComponent) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.t.f(recordComponent, "recordComponent");
        Method methodB = b(recordComponent).b();
        if (methodB == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(recordComponent, null);
        kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) objInvoke;
    }
}
