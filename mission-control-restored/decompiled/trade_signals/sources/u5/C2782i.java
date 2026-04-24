package u5;

import java.lang.reflect.Method;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2782i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2782i f23521a = new C2782i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23522b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f23523c;

    /* JADX INFO: renamed from: u5.i$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f23524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f23525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f23526c;

        public a(Method method, Method method2, Method method3) {
            this.f23524a = method;
            this.f23525b = method2;
            this.f23526c = method3;
        }
    }

    public final a a(AbstractC2774a abstractC2774a) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), abstractC2774a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), abstractC2774a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f23523c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f23522b;
            f23523c = aVar2;
            return aVar2;
        }
    }

    public final String b(AbstractC2774a continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        AbstractC2304t.f(continuation, "continuation");
        a aVarA = f23523c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA == f23522b || (method = aVarA.f23524a) == null || (objInvoke = method.invoke(continuation.getClass(), null)) == null || (method2 = aVarA.f23525b) == null || (objInvoke2 = method2.invoke(objInvoke, null)) == null) {
            return null;
        }
        Method method3 = aVarA.f23526c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
