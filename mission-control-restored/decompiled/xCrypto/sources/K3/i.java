package K3;

import J3.E;
import L3.a0;
import W2.C0739g;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.J;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H3.e f1361a = E.a("kotlinx.serialization.json.JsonUnquotedLiteral", G3.a.D(J.f13414a));

    public static final w a(Boolean bool) {
        return bool == null ? s.INSTANCE : new o(bool, false, null, 4, null);
    }

    public static final w b(Number number) {
        return number == null ? s.INSTANCE : new o(number, false, null, 4, null);
    }

    public static final w c(String str) {
        return str == null ? s.INSTANCE : new o(str, true, null, 4, null);
    }

    public static final Void d(h hVar, String str) {
        throw new IllegalArgumentException("Element " + G.b(hVar.getClass()) + " is not a " + str);
    }

    public static final Boolean e(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return a0.d(wVar.f());
    }

    public static final String f(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        if (wVar instanceof s) {
            return null;
        }
        return wVar.f();
    }

    public static final double g(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return Double.parseDouble(wVar.f());
    }

    public static final Double h(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return r3.v.j(wVar.f());
    }

    public static final float i(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return Float.parseFloat(wVar.f());
    }

    public static final Float j(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return r3.v.k(wVar.f());
    }

    public static final int k(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return Integer.parseInt(wVar.f());
    }

    public static final Integer l(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return r3.w.m(wVar.f());
    }

    public static final b m(h hVar) {
        kotlin.jvm.internal.r.f(hVar, "<this>");
        b bVar = hVar instanceof b ? (b) hVar : null;
        if (bVar != null) {
            return bVar;
        }
        d(hVar, "JsonArray");
        throw new C0739g();
    }

    public static final u n(h hVar) {
        kotlin.jvm.internal.r.f(hVar, "<this>");
        u uVar = hVar instanceof u ? (u) hVar : null;
        if (uVar != null) {
            return uVar;
        }
        d(hVar, "JsonObject");
        throw new C0739g();
    }

    public static final w o(h hVar) {
        kotlin.jvm.internal.r.f(hVar, "<this>");
        w wVar = hVar instanceof w ? (w) hVar : null;
        if (wVar != null) {
            return wVar;
        }
        d(hVar, "JsonPrimitive");
        throw new C0739g();
    }

    public static final H3.e p() {
        return f1361a;
    }

    public static final long q(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return Long.parseLong(wVar.f());
    }

    public static final Long r(w wVar) {
        kotlin.jvm.internal.r.f(wVar, "<this>");
        return r3.w.o(wVar.f());
    }
}
