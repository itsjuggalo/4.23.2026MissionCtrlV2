package oe;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 {
    public static final List a(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        String strB = name.b();
        kotlin.jvm.internal.t.e(strB, "asString(...)");
        return h0.c(strB) ? dd.r.o(b(name)) : h0.d(strB) ? f(name) : j.f18004a.b(name);
    }

    public static final ef.f b(ef.f methodName) {
        kotlin.jvm.internal.t.f(methodName, "methodName");
        ef.f fVarE = e(methodName, com.amazon.a.a.o.b.au, false, null, 12, null);
        return fVarE == null ? e(methodName, "is", false, null, 8, null) : fVarE;
    }

    public static final ef.f c(ef.f methodName, boolean z10) {
        kotlin.jvm.internal.t.f(methodName, "methodName");
        return e(methodName, "set", false, z10 ? "is" : null, 4, null);
    }

    public static final ef.f d(ef.f fVar, String str, boolean z10, String str2) {
        if (fVar.l()) {
            return null;
        }
        String strH = fVar.h();
        kotlin.jvm.internal.t.e(strH, "getIdentifier(...)");
        if (!kg.z.J(strH, str, false, 2, null) || strH.length() == str.length()) {
            return null;
        }
        char cCharAt = strH.charAt(str.length());
        if ('a' <= cCharAt && cCharAt < '{') {
            return null;
        }
        if (str2 != null) {
            return ef.f.k(str2 + kg.c0.y0(strH, str));
        }
        if (!z10) {
            return fVar;
        }
        String strC = fg.a.c(kg.c0.y0(strH, str), true);
        if (ef.f.m(strC)) {
            return ef.f.k(strC);
        }
        return null;
    }

    public static /* synthetic */ ef.f e(ef.f fVar, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z10, str2);
    }

    public static final List f(ef.f methodName) {
        kotlin.jvm.internal.t.f(methodName, "methodName");
        return dd.r.p(c(methodName, false), c(methodName, true));
    }
}
