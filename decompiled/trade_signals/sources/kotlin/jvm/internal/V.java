package kotlin.jvm.internal;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import o5.InterfaceC2478f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class V {
    public static Map a(Object obj) {
        if ((obj instanceof C5.a) && !(obj instanceof C5.b)) {
            j(obj, "kotlin.collections.MutableMap");
        }
        return d(obj);
    }

    public static Set b(Object obj) {
        if ((obj instanceof C5.a) && !(obj instanceof C5.c)) {
            j(obj, "kotlin.collections.MutableSet");
        }
        return e(obj);
    }

    public static Object c(Object obj, int i8) {
        if (obj != null && !g(obj, i8)) {
            j(obj, "kotlin.jvm.functions.Function" + i8);
        }
        return obj;
    }

    public static Map d(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e8) {
            throw i(e8);
        }
    }

    public static Set e(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e8) {
            throw i(e8);
        }
    }

    public static int f(Object obj) {
        if (obj instanceof InterfaceC2300o) {
            return ((InterfaceC2300o) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof B5.k) {
            return 1;
        }
        if (obj instanceof B5.o) {
            return 2;
        }
        if (obj instanceof B5.p) {
            return 3;
        }
        if (obj instanceof B5.q) {
            return 4;
        }
        if (obj instanceof B5.r) {
            return 5;
        }
        if (obj instanceof B5.s) {
            return 6;
        }
        if (obj instanceof B5.t) {
            return 7;
        }
        if (obj instanceof B5.u) {
            return 8;
        }
        if (obj instanceof B5.v) {
            return 9;
        }
        if (obj instanceof B5.a) {
            return 10;
        }
        if (obj instanceof B5.b) {
            return 11;
        }
        if (obj instanceof B5.c) {
            return 12;
        }
        if (obj instanceof B5.d) {
            return 13;
        }
        if (obj instanceof B5.e) {
            return 14;
        }
        if (obj instanceof B5.f) {
            return 15;
        }
        if (obj instanceof B5.g) {
            return 16;
        }
        if (obj instanceof B5.h) {
            return 17;
        }
        if (obj instanceof B5.i) {
            return 18;
        }
        if (obj instanceof B5.j) {
            return 19;
        }
        if (obj instanceof B5.l) {
            return 20;
        }
        if (obj instanceof B5.m) {
            return 21;
        }
        return obj instanceof B5.n ? 22 : -1;
    }

    public static boolean g(Object obj, int i8) {
        return (obj instanceof InterfaceC2478f) && f(obj) == i8;
    }

    public static Throwable h(Throwable th) {
        return AbstractC2304t.l(th, V.class.getName());
    }

    public static ClassCastException i(ClassCastException classCastException) {
        throw ((ClassCastException) h(classCastException));
    }

    public static void j(Object obj, String str) {
        k((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void k(String str) {
        throw i(new ClassCastException(str));
    }
}
