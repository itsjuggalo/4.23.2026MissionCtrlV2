package X5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: X5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0985a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0985a f9406a = new C0985a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0152a f9407b;

    /* JADX INFO: renamed from: X5.a$a, reason: collision with other inner class name */
    public static final class C0152a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f9408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f9409b;

        public C0152a(Method method, Method method2) {
            this.f9408a = method;
            this.f9409b = method2;
        }

        public final Method a() {
            return this.f9409b;
        }

        public final Method b() {
            return this.f9408a;
        }
    }

    public final C0152a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0152a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (NoSuchMethodException unused) {
            return new C0152a(null, null);
        }
    }

    public final C0152a b(Object obj) {
        C0152a c0152a = f9407b;
        if (c0152a != null) {
            return c0152a;
        }
        C0152a c0152aA = a(obj);
        f9407b = c0152aA;
        return c0152aA;
    }

    public final Method c(Object recordComponent) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(recordComponent, "recordComponent");
        Method methodA = b(recordComponent).a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(recordComponent, null);
        AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) objInvoke;
    }

    public final Class d(Object recordComponent) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(recordComponent, "recordComponent");
        Method methodB = b(recordComponent).b();
        if (methodB == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(recordComponent, null);
        AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) objInvoke;
    }
}
