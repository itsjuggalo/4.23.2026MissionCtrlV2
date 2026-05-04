package bg;

import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3356a;

        static {
            int[] iArr = new int[m2.values().length];
            try {
                iArr[m2.f25015e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[m2.f25016f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[m2.f25017g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3356a = iArr;
        }
    }

    public static final t a(m2 m2Var) {
        kotlin.jvm.internal.t.f(m2Var, "<this>");
        int i10 = a.f3356a[m2Var.ordinal()];
        if (i10 == 1) {
            return t.f3359d;
        }
        if (i10 == 2) {
            return t.f3357b;
        }
        if (i10 == 3) {
            return t.f3358c;
        }
        throw new cd.o();
    }
}
