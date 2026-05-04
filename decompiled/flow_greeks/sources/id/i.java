package id;

import java.lang.reflect.Method;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12283a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12284b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f12285c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f12286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f12287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f12288c;

        public a(Method method, Method method2, Method method3) {
            this.f12286a = method;
            this.f12287b = method2;
            this.f12288c = method3;
        }
    }

    public final a a(id.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", null), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f12285c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f12284b;
            f12285c = aVar3;
            return aVar3;
        }
    }

    public final String b(id.a continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        t.f(continuation, "continuation");
        a aVarA = f12285c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA != f12284b && (method = aVarA.f12286a) != null && (objInvoke = method.invoke(continuation.getClass(), null)) != null && (method2 = aVarA.f12287b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = aVarA.f12288c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }
}
