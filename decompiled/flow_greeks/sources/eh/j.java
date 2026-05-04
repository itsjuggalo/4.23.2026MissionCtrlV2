package eh;

import fh.w0;
import fh.z0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bh.e f9023a = dh.g0.a("kotlinx.serialization.json.JsonUnquotedLiteral", ah.a.D(s0.f14953a));

    public static final e0 a(Boolean bool) {
        return bool == null ? z.INSTANCE : new v(bool, false, null, 4, null);
    }

    public static final e0 b(Number number) {
        return number == null ? z.INSTANCE : new v(number, false, null, 4, null);
    }

    public static final e0 c(String str) {
        return str == null ? z.INSTANCE : new v(str, true, null, 4, null);
    }

    public static final Void d(i iVar, String str) {
        throw new IllegalArgumentException("Element " + n0.b(iVar.getClass()) + " is not a " + str);
    }

    public static final Boolean e(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        return z0.d(e0Var.a());
    }

    public static final String f(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        if (e0Var instanceof z) {
            return null;
        }
        return e0Var.a();
    }

    public static final double g(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        return Double.parseDouble(e0Var.a());
    }

    public static final Double h(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        return kg.x.l(e0Var.a());
    }

    public static final float i(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        return Float.parseFloat(e0Var.a());
    }

    public static final Float j(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        return kg.x.m(e0Var.a());
    }

    public static final int k(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        try {
            long jM = new w0(e0Var.a()).m();
            if (-2147483648L <= jM && jM <= 2147483647L) {
                return (int) jM;
            }
            throw new NumberFormatException(e0Var.a() + " is not an Int");
        } catch (fh.y e10) {
            throw new NumberFormatException(e10.getMessage());
        }
    }

    public static final Integer l(e0 e0Var) {
        Long lValueOf;
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        try {
            lValueOf = Long.valueOf(new w0(e0Var.a()).m());
        } catch (fh.y unused) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            long jLongValue = lValueOf.longValue();
            if (-2147483648L <= jLongValue && jLongValue <= 2147483647L) {
                return Integer.valueOf((int) jLongValue);
            }
        }
        return null;
    }

    public static final c m(i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        c cVar = iVar instanceof c ? (c) iVar : null;
        if (cVar != null) {
            return cVar;
        }
        d(iVar, "JsonArray");
        throw new cd.h();
    }

    public static final c0 n(i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        c0 c0Var = iVar instanceof c0 ? (c0) iVar : null;
        if (c0Var != null) {
            return c0Var;
        }
        d(iVar, "JsonObject");
        throw new cd.h();
    }

    public static final e0 o(i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        e0 e0Var = iVar instanceof e0 ? (e0) iVar : null;
        if (e0Var != null) {
            return e0Var;
        }
        d(iVar, "JsonPrimitive");
        throw new cd.h();
    }

    public static final bh.e p() {
        return f9023a;
    }

    public static final long q(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        try {
            return new w0(e0Var.a()).m();
        } catch (fh.y e10) {
            throw new NumberFormatException(e10.getMessage());
        }
    }

    public static final Long r(e0 e0Var) {
        kotlin.jvm.internal.t.f(e0Var, "<this>");
        try {
            return Long.valueOf(new w0(e0Var.a()).m());
        } catch (fh.y unused) {
            return null;
        }
    }
}
