package kotlin.jvm.internal;

import E5.InterfaceC0461f;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class L {
    public static Map a(Object obj) {
        if (obj instanceof R5.a) {
            h(obj, "kotlin.collections.MutableMap");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i7) {
        if (obj != null && !e(obj, i7)) {
            h(obj, "kotlin.jvm.functions.Function" + i7);
        }
        return obj;
    }

    public static Map c(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e7) {
            throw g(e7);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof m) {
            return ((m) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Q5.k) {
            return 1;
        }
        if (obj instanceof Q5.o) {
            return 2;
        }
        if (obj instanceof Q5.p) {
            return 3;
        }
        return obj instanceof Q5.q ? 4 : -1;
    }

    public static boolean e(Object obj, int i7) {
        return (obj instanceof InterfaceC0461f) && d(obj) == i7;
    }

    public static Throwable f(Throwable th) {
        return r.l(th, L.class.getName());
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
