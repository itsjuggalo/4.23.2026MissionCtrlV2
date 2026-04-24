package X5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: X5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0987c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0987c f9416a = new C0987c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f9417b;

    /* JADX INFO: renamed from: X5.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f9418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f9419b;

        public a(Method method, Method method2) {
            this.f9418a = method;
            this.f9419b = method2;
        }

        public final Method a() {
            return this.f9419b;
        }

        public final Method b() {
            return this.f9418a;
        }
    }

    public final a a(Member member) {
        AbstractC2304t.f(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), AbstractC0990f.j(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List b(Member member) throws IllegalAccessException, InvocationTargetException {
        Method methodA;
        AbstractC2304t.f(member, "member");
        a aVarA = f9417b;
        if (aVarA == null) {
            synchronized (this) {
                aVarA = f9417b;
                if (aVarA == null) {
                    aVarA = f9416a.a(member);
                    f9417b = aVarA;
                }
            }
        }
        Method methodB = aVarA.b();
        if (methodB == null || (methodA = aVarA.a()) == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(member, null);
        AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = methodA.invoke(obj, null);
            AbstractC2304t.d(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }
}
