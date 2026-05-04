package le;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15602a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f15603b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f15604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f15605b;

        public a(Method method, Method method2) {
            this.f15604a = method;
            this.f15605b = method2;
        }

        public final Method a() {
            return this.f15605b;
        }

        public final Method b() {
            return this.f15604a;
        }
    }

    public final a a(Member member) {
        kotlin.jvm.internal.t.f(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), f.j(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List b(Member member) throws IllegalAccessException, InvocationTargetException {
        Method methodA;
        kotlin.jvm.internal.t.f(member, "member");
        a aVarA = f15603b;
        if (aVarA == null) {
            synchronized (this) {
                aVarA = f15603b;
                if (aVarA == null) {
                    aVarA = f15602a.a(member);
                    f15603b = aVarA;
                }
            }
        }
        Method methodB = aVarA.b();
        if (methodB == null || (methodA = aVarA.a()) == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(member, null);
        kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = methodA.invoke(obj, null);
            kotlin.jvm.internal.t.d(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }
}
