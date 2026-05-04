package oe;

import oe.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef.c f17936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.c f17937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ef.c f17938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ef.c f17939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ef.c[] f17941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k0 f17942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c0 f17943h;

    static {
        ef.c cVar = new ef.c("org.jspecify.nullness");
        f17936a = cVar;
        ef.c cVar2 = new ef.c("org.jspecify.annotations");
        f17937b = cVar2;
        ef.c cVar3 = new ef.c("io.reactivex.rxjava3.annotations");
        f17938c = cVar3;
        ef.c cVar4 = new ef.c("org.checkerframework.checker.nullness.compatqual");
        f17939d = cVar4;
        String strA = cVar3.a();
        f17940e = strA;
        f17941f = new ef.c[]{new ef.c(strA + ".Nullable"), new ef.c(strA + ".NonNull")};
        ef.c cVar5 = new ef.c("org.jetbrains.annotations");
        c0.a aVar = c0.f17953d;
        cd.q qVarA = cd.w.a(cVar5, aVar.a());
        cd.q qVarA2 = cd.w.a(new ef.c("androidx.annotation"), aVar.a());
        cd.q qVarA3 = cd.w.a(new ef.c("android.support.annotation"), aVar.a());
        cd.q qVarA4 = cd.w.a(new ef.c("android.annotation"), aVar.a());
        cd.q qVarA5 = cd.w.a(new ef.c("com.android.annotations"), aVar.a());
        cd.q qVarA6 = cd.w.a(new ef.c("org.eclipse.jdt.annotation"), aVar.a());
        cd.q qVarA7 = cd.w.a(new ef.c("org.checkerframework.checker.nullness.qual"), aVar.a());
        cd.q qVarA8 = cd.w.a(cVar4, aVar.a());
        cd.q qVarA9 = cd.w.a(new ef.c("javax.annotation"), aVar.a());
        cd.q qVarA10 = cd.w.a(new ef.c("edu.umd.cs.findbugs.annotations"), aVar.a());
        cd.q qVarA11 = cd.w.a(new ef.c("io.reactivex.annotations"), aVar.a());
        ef.c cVar6 = new ef.c("androidx.annotation.RecentlyNullable");
        o0 o0Var = o0.f18047d;
        cd.q qVarA12 = cd.w.a(cVar6, new c0(o0Var, null, null, 4, null));
        cd.q qVarA13 = cd.w.a(new ef.c("androidx.annotation.RecentlyNonNull"), new c0(o0Var, null, null, 4, null));
        cd.q qVarA14 = cd.w.a(new ef.c("lombok"), aVar.a());
        cd.i iVar = new cd.i(2, 1);
        o0 o0Var2 = o0.f18048e;
        f17942g = new m0(dd.o0.l(qVarA, qVarA2, qVarA3, qVarA4, qVarA5, qVarA6, qVarA7, qVarA8, qVarA9, qVarA10, qVarA11, qVarA12, qVarA13, qVarA14, cd.w.a(cVar, new c0(o0Var, iVar, o0Var2)), cd.w.a(cVar2, new c0(o0Var, new cd.i(2, 1), o0Var2)), cd.w.a(cVar3, new c0(o0Var, new cd.i(1, 8), o0Var2))));
        f17943h = new c0(o0Var, null, null, 4, null);
    }

    public static final g0 a(cd.i configuredKotlinVersion) {
        kotlin.jvm.internal.t.f(configuredKotlinVersion, "configuredKotlinVersion");
        c0 c0Var = f17943h;
        o0 o0VarC = (c0Var.d() == null || c0Var.d().compareTo(configuredKotlinVersion) > 0) ? c0Var.c() : c0Var.b();
        return new g0(o0VarC, c(o0VarC), null, 4, null);
    }

    public static /* synthetic */ g0 b(cd.i iVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = cd.i.f3854f;
        }
        return a(iVar);
    }

    public static final o0 c(o0 globalReportLevel) {
        kotlin.jvm.internal.t.f(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == o0.f18047d) {
            return null;
        }
        return globalReportLevel;
    }

    public static final o0 d(ef.c annotationFqName) {
        kotlin.jvm.internal.t.f(annotationFqName, "annotationFqName");
        return h(annotationFqName, k0.f18035a.a(), null, 4, null);
    }

    public static final ef.c e() {
        return f17937b;
    }

    public static final ef.c[] f() {
        return f17941f;
    }

    public static final o0 g(ef.c annotation, k0 configuredReportLevels, cd.i configuredKotlinVersion) {
        kotlin.jvm.internal.t.f(annotation, "annotation");
        kotlin.jvm.internal.t.f(configuredReportLevels, "configuredReportLevels");
        kotlin.jvm.internal.t.f(configuredKotlinVersion, "configuredKotlinVersion");
        o0 o0Var = (o0) configuredReportLevels.a(annotation);
        if (o0Var != null) {
            return o0Var;
        }
        c0 c0Var = (c0) f17942g.a(annotation);
        return c0Var == null ? o0.f18046c : (c0Var.d() == null || c0Var.d().compareTo(configuredKotlinVersion) > 0) ? c0Var.c() : c0Var.b();
    }

    public static /* synthetic */ o0 h(ef.c cVar, k0 k0Var, cd.i iVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            iVar = new cd.i(1, 7, 20);
        }
        return g(cVar, k0Var, iVar);
    }
}
