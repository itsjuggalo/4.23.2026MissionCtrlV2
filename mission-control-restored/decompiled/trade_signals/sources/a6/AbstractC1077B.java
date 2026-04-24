package a6;

import a6.C;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2481i;
import o5.C2489q;

/* JADX INFO: renamed from: a6.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1077B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q6.c f9994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q6.c f9995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q6.c f9996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q6.c f9997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q6.c[] f9999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final K f10000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C f10001h;

    static {
        q6.c cVar = new q6.c("org.jspecify.nullness");
        f9994a = cVar;
        q6.c cVar2 = new q6.c("org.jspecify.annotations");
        f9995b = cVar2;
        q6.c cVar3 = new q6.c("io.reactivex.rxjava3.annotations");
        f9996c = cVar3;
        q6.c cVar4 = new q6.c("org.checkerframework.checker.nullness.compatqual");
        f9997d = cVar4;
        String strA = cVar3.a();
        f9998e = strA;
        f9999f = new q6.c[]{new q6.c(strA + ".Nullable"), new q6.c(strA + ".NonNull")};
        q6.c cVar5 = new q6.c("org.jetbrains.annotations");
        C.a aVar = C.f10002d;
        C2489q c2489qA = o5.w.a(cVar5, aVar.a());
        C2489q c2489qA2 = o5.w.a(new q6.c("androidx.annotation"), aVar.a());
        C2489q c2489qA3 = o5.w.a(new q6.c("android.support.annotation"), aVar.a());
        C2489q c2489qA4 = o5.w.a(new q6.c("android.annotation"), aVar.a());
        C2489q c2489qA5 = o5.w.a(new q6.c("com.android.annotations"), aVar.a());
        C2489q c2489qA6 = o5.w.a(new q6.c("org.eclipse.jdt.annotation"), aVar.a());
        C2489q c2489qA7 = o5.w.a(new q6.c("org.checkerframework.checker.nullness.qual"), aVar.a());
        C2489q c2489qA8 = o5.w.a(cVar4, aVar.a());
        C2489q c2489qA9 = o5.w.a(new q6.c("javax.annotation"), aVar.a());
        C2489q c2489qA10 = o5.w.a(new q6.c("edu.umd.cs.findbugs.annotations"), aVar.a());
        C2489q c2489qA11 = o5.w.a(new q6.c("io.reactivex.annotations"), aVar.a());
        q6.c cVar6 = new q6.c("androidx.annotation.RecentlyNullable");
        O o8 = O.f10082d;
        C2489q c2489qA12 = o5.w.a(cVar6, new C(o8, null, null, 4, null));
        C2489q c2489qA13 = o5.w.a(new q6.c("androidx.annotation.RecentlyNonNull"), new C(o8, null, null, 4, null));
        C2489q c2489qA14 = o5.w.a(new q6.c("lombok"), aVar.a());
        C2481i c2481i = new C2481i(2, 1);
        O o9 = O.f10083e;
        f10000g = new M(p5.M.k(c2489qA, c2489qA2, c2489qA3, c2489qA4, c2489qA5, c2489qA6, c2489qA7, c2489qA8, c2489qA9, c2489qA10, c2489qA11, c2489qA12, c2489qA13, c2489qA14, o5.w.a(cVar, new C(o8, c2481i, o9)), o5.w.a(cVar2, new C(o8, new C2481i(2, 1), o9)), o5.w.a(cVar3, new C(o8, new C2481i(1, 8), o9))));
        f10001h = new C(o8, null, null, 4, null);
    }

    public static final G a(C2481i configuredKotlinVersion) {
        AbstractC2304t.f(configuredKotlinVersion, "configuredKotlinVersion");
        C c8 = f10001h;
        O oC = (c8.d() == null || c8.d().compareTo(configuredKotlinVersion) > 0) ? c8.c() : c8.b();
        return new G(oC, c(oC), null, 4, null);
    }

    public static /* synthetic */ G b(C2481i c2481i, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            c2481i = C2481i.f21967f;
        }
        return a(c2481i);
    }

    public static final O c(O globalReportLevel) {
        AbstractC2304t.f(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == O.f10082d) {
            return null;
        }
        return globalReportLevel;
    }

    public static final O d(q6.c annotationFqName) {
        AbstractC2304t.f(annotationFqName, "annotationFqName");
        return h(annotationFqName, K.f10073a.a(), null, 4, null);
    }

    public static final q6.c e() {
        return f9995b;
    }

    public static final q6.c[] f() {
        return f9999f;
    }

    public static final O g(q6.c annotation, K configuredReportLevels, C2481i configuredKotlinVersion) {
        AbstractC2304t.f(annotation, "annotation");
        AbstractC2304t.f(configuredReportLevels, "configuredReportLevels");
        AbstractC2304t.f(configuredKotlinVersion, "configuredKotlinVersion");
        O o8 = (O) configuredReportLevels.a(annotation);
        if (o8 != null) {
            return o8;
        }
        C c8 = (C) f10000g.a(annotation);
        return c8 == null ? O.f10081c : (c8.d() == null || c8.d().compareTo(configuredKotlinVersion) > 0) ? c8.c() : c8.b();
    }

    public static /* synthetic */ O h(q6.c cVar, K k8, C2481i c2481i, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            c2481i = new C2481i(1, 7, 20);
        }
        return g(cVar, k8, c2481i);
    }
}
