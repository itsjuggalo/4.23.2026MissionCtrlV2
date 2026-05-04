package kotlin.jvm.internal;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 {
    public static Map a(Object obj) {
        if ((obj instanceof qd.a) && !(obj instanceof qd.b)) {
            j(obj, "kotlin.collections.MutableMap");
        }
        return d(obj);
    }

    public static Set b(Object obj) {
        if ((obj instanceof qd.a) && !(obj instanceof qd.c)) {
            j(obj, "kotlin.collections.MutableSet");
        }
        return e(obj);
    }

    public static Object c(Object obj, int i10) {
        if (obj != null && !g(obj, i10)) {
            j(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Map d(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e10) {
            throw i(e10);
        }
    }

    public static Set e(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e10) {
            throw i(e10);
        }
    }

    public static int f(Object obj) {
        if (obj instanceof o) {
            return ((o) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof pd.k) {
            return 1;
        }
        if (obj instanceof pd.o) {
            return 2;
        }
        if (obj instanceof pd.p) {
            return 3;
        }
        if (obj instanceof pd.q) {
            return 4;
        }
        if (obj instanceof pd.r) {
            return 5;
        }
        if (obj instanceof pd.s) {
            return 6;
        }
        if (obj instanceof pd.t) {
            return 7;
        }
        if (obj instanceof pd.u) {
            return 8;
        }
        if (obj instanceof pd.v) {
            return 9;
        }
        if (obj instanceof pd.a) {
            return 10;
        }
        if (obj instanceof pd.b) {
            return 11;
        }
        if (obj instanceof pd.c) {
            return 12;
        }
        if (obj instanceof pd.d) {
            return 13;
        }
        if (obj instanceof pd.e) {
            return 14;
        }
        if (obj instanceof pd.f) {
            return 15;
        }
        if (obj instanceof pd.g) {
            return 16;
        }
        if (obj instanceof pd.h) {
            return 17;
        }
        if (obj instanceof pd.i) {
            return 18;
        }
        if (obj instanceof pd.j) {
            return 19;
        }
        if (obj instanceof pd.l) {
            return 20;
        }
        if (obj instanceof pd.m) {
            return 21;
        }
        return obj instanceof pd.n ? 22 : -1;
    }

    public static boolean g(Object obj, int i10) {
        return (obj instanceof cd.f) && f(obj) == i10;
    }

    public static Throwable h(Throwable th) {
        return t.l(th, t0.class.getName());
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
