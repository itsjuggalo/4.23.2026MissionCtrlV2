package tf;

import xf.m2;
import ze.c;
import ze.q;
import ze.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f22025a = new o0();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f22027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f22028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f22029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f22030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f22031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f22032g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f22033h;

        static {
            int[] iArr = new int[ze.k.values().length];
            try {
                iArr[ze.k.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ze.k.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ze.k.ABSTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ze.k.SEALED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f22026a = iArr;
            int[] iArr2 = new int[fe.e0.values().length];
            try {
                iArr2[fe.e0.f9461b.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[fe.e0.f9463d.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[fe.e0.f9464e.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[fe.e0.f9462c.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f22027b = iArr2;
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
            f22028c = iArr3;
            int[] iArr4 = new int[c.EnumC0494c.values().length];
            try {
                iArr4[c.EnumC0494c.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[c.EnumC0494c.INTERFACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[c.EnumC0494c.ENUM_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr4[c.EnumC0494c.ENUM_ENTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[c.EnumC0494c.ANNOTATION_CLASS.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[c.EnumC0494c.OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr4[c.EnumC0494c.COMPANION_OBJECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            f22029d = iArr4;
            int[] iArr5 = new int[fe.f.values().length];
            try {
                iArr5[fe.f.f9473b.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[fe.f.f9474c.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[fe.f.f9475d.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr5[fe.f.f9476e.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr5[fe.f.f9477f.ordinal()] = 5;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr5[fe.f.f9478g.ordinal()] = 6;
            } catch (NoSuchFieldError unused27) {
            }
            f22030e = iArr5;
            int[] iArr6 = new int[s.c.values().length];
            try {
                iArr6[s.c.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr6[s.c.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr6[s.c.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused30) {
            }
            f22031f = iArr6;
            int[] iArr7 = new int[q.b.c.values().length];
            try {
                iArr7[q.b.c.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr7[q.b.c.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr7[q.b.c.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr7[q.b.c.STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused34) {
            }
            f22032g = iArr7;
            int[] iArr8 = new int[m2.values().length];
            try {
                iArr8[m2.f25016f.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr8[m2.f25017g.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr8[m2.f25015e.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            f22033h = iArr8;
        }
    }

    public final fe.f a(c.EnumC0494c enumC0494c) {
        switch (enumC0494c == null ? -1 : a.f22029d[enumC0494c.ordinal()]) {
            case 1:
                return fe.f.f9473b;
            case 2:
                return fe.f.f9474c;
            case 3:
                return fe.f.f9475d;
            case 4:
                return fe.f.f9476e;
            case 5:
                return fe.f.f9477f;
            case 6:
            case 7:
                return fe.f.f9478g;
            default:
                return fe.f.f9473b;
        }
    }

    public final fe.e0 b(ze.k kVar) {
        int i10 = kVar == null ? -1 : a.f22026a[kVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? fe.e0.f9461b : fe.e0.f9462c : fe.e0.f9464e : fe.e0.f9463d : fe.e0.f9461b;
    }

    public final m2 c(q.b.c projection) {
        kotlin.jvm.internal.t.f(projection, "projection");
        int i10 = a.f22032g[projection.ordinal()];
        if (i10 == 1) {
            return m2.f25016f;
        }
        if (i10 == 2) {
            return m2.f25017g;
        }
        if (i10 == 3) {
            return m2.f25015e;
        }
        if (i10 != 4) {
            throw new cd.o();
        }
        throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + projection);
    }

    public final m2 d(s.c variance) {
        kotlin.jvm.internal.t.f(variance, "variance");
        int i10 = a.f22031f[variance.ordinal()];
        if (i10 == 1) {
            return m2.f25016f;
        }
        if (i10 == 2) {
            return m2.f25017g;
        }
        if (i10 == 3) {
            return m2.f25015e;
        }
        throw new cd.o();
    }
}
