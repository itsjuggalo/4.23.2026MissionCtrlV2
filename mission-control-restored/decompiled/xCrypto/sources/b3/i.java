package b3;

import java.lang.reflect.Method;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f8285a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8286b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f8287c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f8288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f8289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f8290c;

        public a(Method method, Method method2, Method method3) {
            this.f8288a = method;
            this.f8289b = method2;
            this.f8290c = method3;
        }
    }

    public final a a(AbstractC0863a abstractC0863a) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), abstractC0863a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), abstractC0863a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f8287c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f8286b;
            f8287c = aVar2;
            return aVar2;
        }
    }

    public final String b(AbstractC0863a continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        r.f(continuation, "continuation");
        a aVarA = f8287c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA != f8286b && (method = aVarA.f8288a) != null && (objInvoke = method.invoke(continuation.getClass(), new Object[0])) != null && (method2 = aVarA.f8289b) != null && (objInvoke2 = method2.invoke(objInvoke, new Object[0])) != null) {
            Method method3 = aVarA.f8290c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }
}
