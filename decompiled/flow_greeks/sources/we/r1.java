package we;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ge.h f24036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f24037b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24038a;

        static {
            int[] iArr = new int[k.values().length];
            try {
                iArr[k.f23993b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k.f23994c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f24038a = iArr;
        }
    }

    static {
        ef.c ENHANCED_NULLABILITY_ANNOTATION = oe.i0.f18002v;
        kotlin.jvm.internal.t.e(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        f24036a = new f(ENHANCED_NULLABILITY_ANNOTATION);
        ef.c ENHANCED_MUTABILITY_ANNOTATION = oe.i0.f18003w;
        kotlin.jvm.internal.t.e(ENHANCED_MUTABILITY_ANNOTATION, "ENHANCED_MUTABILITY_ANNOTATION");
        f24037b = new f(ENHANCED_MUTABILITY_ANNOTATION);
    }

    public static final ge.h e(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new ge.o(dd.a0.I0(list)) : (ge.h) dd.a0.v0(list);
        }
        throw new IllegalStateException("At least one Annotations object expected");
    }

    public static final fe.h f(fe.h hVar, h hVar2, o1 o1Var) {
        ee.d dVar = ee.d.f8701a;
        if (!p1.a(o1Var) || !(hVar instanceof fe.e)) {
            return null;
        }
        if (hVar2.e() == i.f23983a && o1Var == o1.f24024a) {
            fe.e eVar = (fe.e) hVar;
            if (dVar.c(eVar)) {
                return dVar.a(eVar);
            }
        }
        if (hVar2.e() == i.f23984b && o1Var == o1.f24025b) {
            fe.e eVar2 = (fe.e) hVar;
            if (dVar.d(eVar2)) {
                return dVar.b(eVar2);
            }
        }
        return null;
    }

    public static final ge.h g() {
        return f24036a;
    }

    public static final Boolean h(h hVar, o1 o1Var) {
        if (!p1.a(o1Var)) {
            return null;
        }
        k kVarF = hVar.f();
        int i10 = kVarF == null ? -1 : a.f24038a[kVarF.ordinal()];
        if (i10 == 1) {
            return Boolean.TRUE;
        }
        if (i10 != 2) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static final boolean i(xf.r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        return s1.c(yf.s.f25429a, r0Var);
    }
}
