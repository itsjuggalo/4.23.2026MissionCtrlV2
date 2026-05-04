package tf;

import fe.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f22044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f22045c;

        static {
            int[] iArr = new int[ze.j.values().length];
            try {
                iArr[ze.j.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ze.j.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ze.j.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ze.j.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f22043a = iArr;
            int[] iArr2 = new int[b.a.values().length];
            try {
                iArr2[b.a.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[b.a.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[b.a.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[b.a.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f22044b = iArr2;
            int[] iArr3 = new int[ze.x.values().length];
            try {
                iArr3[ze.x.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ze.x.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ze.x.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ze.x.PROTECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ze.x.PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ze.x.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            f22045c = iArr3;
        }
    }

    public static final fe.u a(o0 o0Var, ze.x xVar) {
        kotlin.jvm.internal.t.f(o0Var, "<this>");
        switch (xVar == null ? -1 : a.f22045c[xVar.ordinal()]) {
            case 1:
                fe.u INTERNAL = fe.t.f9510d;
                kotlin.jvm.internal.t.e(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                fe.u PRIVATE = fe.t.f9507a;
                kotlin.jvm.internal.t.e(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                fe.u PRIVATE_TO_THIS = fe.t.f9508b;
                kotlin.jvm.internal.t.e(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                fe.u PROTECTED = fe.t.f9509c;
                kotlin.jvm.internal.t.e(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                fe.u PUBLIC = fe.t.f9511e;
                kotlin.jvm.internal.t.e(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                fe.u LOCAL = fe.t.f9512f;
                kotlin.jvm.internal.t.e(LOCAL, "LOCAL");
                return LOCAL;
            default:
                fe.u PRIVATE2 = fe.t.f9507a;
                kotlin.jvm.internal.t.e(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }

    public static final b.a b(o0 o0Var, ze.j jVar) {
        kotlin.jvm.internal.t.f(o0Var, "<this>");
        int i10 = jVar == null ? -1 : a.f22043a[jVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? b.a.DECLARATION : b.a.SYNTHESIZED : b.a.DELEGATION : b.a.FAKE_OVERRIDE : b.a.DECLARATION;
    }
}
