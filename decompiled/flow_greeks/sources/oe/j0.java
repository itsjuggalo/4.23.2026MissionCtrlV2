package oe;

import ce.o;
import dd.v0;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef.c f18010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.c f18011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ef.c f18012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ef.c f18013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ef.c f18014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ef.c f18015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ef.c f18016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ef.c f18017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ef.c f18018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ef.c f18019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ef.c f18020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ef.c f18021l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ef.c f18022m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ef.c f18023n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ef.c f18024o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ef.c f18025p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Set f18026q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Set f18027r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Set f18028s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set f18029t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Set f18030u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Set f18031v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Set f18032w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Map f18033x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ef.c f18034y;

    static {
        ef.c cVar = new ef.c("org.jspecify.nullness.Nullable");
        f18010a = cVar;
        ef.c cVar2 = new ef.c("org.jspecify.nullness.NullMarked");
        f18011b = cVar2;
        ef.c cVar3 = new ef.c("org.jspecify.nullness.NullnessUnspecified");
        f18012c = cVar3;
        ef.c cVar4 = new ef.c("org.jspecify.annotations.NonNull");
        f18013d = cVar4;
        ef.c cVar5 = new ef.c("org.jspecify.annotations.Nullable");
        f18014e = cVar5;
        ef.c cVar6 = new ef.c("org.jspecify.annotations.NullMarked");
        f18015f = cVar6;
        ef.c cVar7 = new ef.c("org.jspecify.annotations.NullnessUnspecified");
        f18016g = cVar7;
        ef.c cVar8 = new ef.c("org.jspecify.annotations.NullUnmarked");
        f18017h = cVar8;
        f18018i = new ef.c("javax.annotation.meta.TypeQualifier");
        f18019j = new ef.c("javax.annotation.meta.TypeQualifierNickname");
        f18020k = new ef.c("javax.annotation.meta.TypeQualifierDefault");
        ef.c cVar9 = new ef.c("javax.annotation.Nonnull");
        f18021l = cVar9;
        ef.c cVar10 = new ef.c("javax.annotation.Nullable");
        f18022m = cVar10;
        ef.c cVar11 = new ef.c("javax.annotation.CheckForNull");
        f18023n = cVar11;
        f18024o = new ef.c("javax.annotation.ParametersAreNonnullByDefault");
        f18025p = new ef.c("javax.annotation.ParametersAreNullableByDefault");
        f18026q = dd.u0.h(cVar9, cVar11);
        Set setH = dd.u0.h(i0.f17992l, cVar4, new ef.c("android.annotation.NonNull"), new ef.c("androidx.annotation.NonNull"), new ef.c("androidx.annotation.RecentlyNonNull"), new ef.c("androidx.annotation.NonNull"), new ef.c("com.android.annotations.NonNull"), new ef.c("org.checkerframework.checker.nullness.compatqual.NonNullDecl"), new ef.c("org.checkerframework.checker.nullness.qual.NonNull"), new ef.c("edu.umd.cs.findbugs.annotations.NonNull"), new ef.c("io.reactivex.annotations.NonNull"), new ef.c("io.reactivex.rxjava3.annotations.NonNull"), new ef.c("org.eclipse.jdt.annotation.NonNull"), new ef.c("lombok.NonNull"));
        f18027r = setH;
        Set setH2 = dd.u0.h(i0.f17993m, cVar, cVar5, cVar10, cVar11, new ef.c("android.annotation.Nullable"), new ef.c("androidx.annotation.Nullable"), new ef.c("androidx.annotation.RecentlyNullable"), new ef.c("androidx.annotation.Nullable"), new ef.c("com.android.annotations.Nullable"), new ef.c("org.checkerframework.checker.nullness.compatqual.NullableDecl"), new ef.c("org.checkerframework.checker.nullness.qual.Nullable"), new ef.c("edu.umd.cs.findbugs.annotations.Nullable"), new ef.c("edu.umd.cs.findbugs.annotations.PossiblyNull"), new ef.c("edu.umd.cs.findbugs.annotations.CheckForNull"), new ef.c("io.reactivex.annotations.Nullable"), new ef.c("io.reactivex.rxjava3.annotations.Nullable"), new ef.c("org.eclipse.jdt.annotation.Nullable"));
        f18028s = setH2;
        f18029t = dd.u0.h(cVar3, cVar7);
        f18030u = v0.m(v0.m(v0.m(v0.m(v0.l(v0.l(new LinkedHashSet(), setH), setH2), cVar9), cVar2), cVar6), cVar8);
        f18031v = dd.u0.h(i0.f17995o, i0.f17996p);
        f18032w = dd.u0.h(i0.f17994n, i0.f17997q);
        f18033x = dd.o0.l(cd.w.a(i0.f17984d, o.a.H), cd.w.a(i0.f17986f, o.a.L), cd.w.a(i0.f17988h, o.a.f4021y), cd.w.a(i0.f17989i, o.a.P));
        f18034y = new ef.c("kotlin.annotations.jvm.UnderMigration");
    }

    public static final Set a() {
        return f18026q;
    }

    public static final Set b() {
        return f18029t;
    }

    public static final ef.c c() {
        return f18021l;
    }

    public static final ef.c d() {
        return f18024o;
    }

    public static final ef.c e() {
        return f18025p;
    }

    public static final ef.c f() {
        return f18018i;
    }

    public static final ef.c g() {
        return f18020k;
    }

    public static final ef.c h() {
        return f18019j;
    }

    public static final ef.c i() {
        return f18015f;
    }

    public static final ef.c j() {
        return f18017h;
    }

    public static final ef.c k() {
        return f18011b;
    }

    public static final Set l() {
        return f18032w;
    }

    public static final Set m() {
        return f18027r;
    }

    public static final Set n() {
        return f18028s;
    }

    public static final Set o() {
        return f18031v;
    }

    public static final ef.c p() {
        return f18034y;
    }
}
