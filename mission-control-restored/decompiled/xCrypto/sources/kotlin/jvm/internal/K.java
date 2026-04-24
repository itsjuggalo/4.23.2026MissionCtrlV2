package kotlin.jvm.internal;

import W2.InterfaceC0738f;
import j3.InterfaceC1564a;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class K {
    public static Map a(Object obj) {
        if (obj instanceof InterfaceC1564a) {
            h(obj, "kotlin.collections.MutableMap");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i4) {
        if (obj != null && !e(obj, i4)) {
            h(obj, "kotlin.jvm.functions.Function" + i4);
        }
        return obj;
    }

    public static Map c(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e4) {
            throw g(e4);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof m) {
            return ((m) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof i3.k) {
            return 1;
        }
        if (obj instanceof i3.o) {
            return 2;
        }
        if (obj instanceof i3.p) {
            return 3;
        }
        return obj instanceof i3.q ? 4 : -1;
    }

    public static boolean e(Object obj, int i4) {
        return (obj instanceof InterfaceC0738f) && d(obj) == i4;
    }

    public static Throwable f(Throwable th) {
        return r.m(th, K.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        i((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
