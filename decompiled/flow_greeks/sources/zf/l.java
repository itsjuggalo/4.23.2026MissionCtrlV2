package zf;

import dd.r;
import dd.t0;
import fe.h0;
import fe.y0;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;
import xf.r0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f26552a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f26553b = e.f26468a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f26554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r0 f26555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r0 f26556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y0 f26557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set f26558g;

    static {
        String str = String.format(b.f26456b.b(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        t.e(str, "format(...)");
        ef.f fVarO = ef.f.o(str);
        t.e(fVarO, "special(...)");
        f26554c = new a(fVarO);
        f26555d = d(k.f26540v, new String[0]);
        f26556e = d(k.f26549z0, new String[0]);
        f fVar = new f();
        f26557f = fVar;
        f26558g = t0.c(fVar);
    }

    public static final g a(h kind, boolean z10, String... formatParams) {
        t.f(kind, "kind");
        t.f(formatParams, "formatParams");
        return z10 ? new m(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)) : new g(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final g b(h kind, String... formatParams) {
        t.f(kind, "kind");
        t.f(formatParams, "formatParams");
        return a(kind, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final i d(k kind, String... formatParams) {
        t.f(kind, "kind");
        t.f(formatParams, "formatParams");
        return f26552a.g(kind, r.k(), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final boolean m(fe.m mVar) {
        if (mVar == null) {
            return false;
        }
        l lVar = f26552a;
        return lVar.n(mVar) || lVar.n(mVar.b()) || mVar == f26553b;
    }

    public static final boolean o(r0 r0Var) {
        if (r0Var == null) {
            return false;
        }
        u1 u1VarN0 = r0Var.N0();
        return (u1VarN0 instanceof j) && ((j) u1VarN0).f() == k.f26546y;
    }

    public final i c(k kind, u1 typeConstructor, String... formatParams) {
        t.f(kind, "kind");
        t.f(typeConstructor, "typeConstructor");
        t.f(formatParams, "formatParams");
        return f(kind, r.k(), typeConstructor, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final j e(k kind, String... formatParams) {
        t.f(kind, "kind");
        t.f(formatParams, "formatParams");
        return new j(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final i f(k kind, List arguments, u1 typeConstructor, String... formatParams) {
        t.f(kind, "kind");
        t.f(arguments, "arguments");
        t.f(typeConstructor, "typeConstructor");
        t.f(formatParams, "formatParams");
        return new i(typeConstructor, b(h.f26483h, typeConstructor.toString()), kind, arguments, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final i g(k kind, List arguments, String... formatParams) {
        t.f(kind, "kind");
        t.f(arguments, "arguments");
        t.f(formatParams, "formatParams");
        return f(kind, arguments, e(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final a h() {
        return f26554c;
    }

    public final h0 i() {
        return f26553b;
    }

    public final Set j() {
        return f26558g;
    }

    public final r0 k() {
        return f26556e;
    }

    public final r0 l() {
        return f26555d;
    }

    public final boolean n(fe.m mVar) {
        return mVar instanceof a;
    }

    public final String p(r0 type) {
        t.f(type, "type");
        cg.d.z(type);
        u1 u1VarN0 = type.N0();
        t.d(u1VarN0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((j) u1VarN0).g(0);
    }
}
