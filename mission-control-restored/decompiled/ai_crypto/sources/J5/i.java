package J5;

import java.lang.reflect.Method;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f3331a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3332b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f3333c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f3334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f3335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f3336c;

        public a(Method method, Method method2, Method method3) {
            this.f3334a = method;
            this.f3335b = method2;
            this.f3336c = method3;
        }
    }

    public final a a(J5.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", null), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f3333c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f3332b;
            f3333c = aVar3;
            return aVar3;
        }
    }

    public final String b(J5.a continuation) {
        r.f(continuation, "continuation");
        a aVarA = f3333c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA == f3332b) {
            return null;
        }
        Method method = aVarA.f3334a;
        Object objInvoke = method != null ? method.invoke(continuation.getClass(), null) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarA.f3335b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarA.f3336c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
