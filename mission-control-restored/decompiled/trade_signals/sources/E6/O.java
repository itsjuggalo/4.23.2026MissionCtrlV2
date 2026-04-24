package E6;

import I6.N0;
import R5.EnumC0849f;
import kotlin.jvm.internal.AbstractC2304t;
import l6.c;
import l6.q;
import l6.s;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f941a = new O();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f946e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f947f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f948g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f949h;

        static {
            int[] iArr = new int[l6.k.values().length];
            try {
                iArr[l6.k.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[l6.k.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[l6.k.ABSTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[l6.k.SEALED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f942a = iArr;
            int[] iArr2 = new int[R5.E.values().length];
            try {
                iArr2[R5.E.f7197b.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[R5.E.f7199d.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[R5.E.f7200e.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[R5.E.f7198c.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f943b = iArr2;
            int[] iArr3 = new int[l6.x.values().length];
            try {
                iArr3[l6.x.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[l6.x.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[l6.x.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[l6.x.PROTECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[l6.x.PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[l6.x.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            f944c = iArr3;
            int[] iArr4 = new int[c.EnumC0352c.values().length];
            try {
                iArr4[c.EnumC0352c.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[c.EnumC0352c.INTERFACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[c.EnumC0352c.ENUM_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr4[c.EnumC0352c.ENUM_ENTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[c.EnumC0352c.ANNOTATION_CLASS.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[c.EnumC0352c.OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr4[c.EnumC0352c.COMPANION_OBJECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            f945d = iArr4;
            int[] iArr5 = new int[EnumC0849f.values().length];
            try {
                iArr5[EnumC0849f.f7234b.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[EnumC0849f.f7235c.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[EnumC0849f.f7236d.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr5[EnumC0849f.f7237e.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr5[EnumC0849f.f7238f.ordinal()] = 5;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr5[EnumC0849f.f7239g.ordinal()] = 6;
            } catch (NoSuchFieldError unused27) {
            }
            f946e = iArr5;
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
            f947f = iArr6;
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
            f948g = iArr7;
            int[] iArr8 = new int[N0.values().length];
            try {
                iArr8[N0.f4371f.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr8[N0.f4372g.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr8[N0.f4370e.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            f949h = iArr8;
        }
    }

    public final EnumC0849f a(c.EnumC0352c enumC0352c) {
        switch (enumC0352c == null ? -1 : a.f945d[enumC0352c.ordinal()]) {
            case 1:
            default:
                return EnumC0849f.f7234b;
            case 2:
                return EnumC0849f.f7235c;
            case 3:
                return EnumC0849f.f7236d;
            case 4:
                return EnumC0849f.f7237e;
            case 5:
                return EnumC0849f.f7238f;
            case 6:
            case 7:
                return EnumC0849f.f7239g;
        }
    }

    public final R5.E b(l6.k kVar) {
        int i8 = kVar == null ? -1 : a.f942a[kVar.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R5.E.f7199d;
            }
            if (i8 == 3) {
                return R5.E.f7200e;
            }
            if (i8 == 4) {
                return R5.E.f7198c;
            }
        }
        return R5.E.f7197b;
    }

    public final N0 c(q.b.c projection) {
        AbstractC2304t.f(projection, "projection");
        int i8 = a.f948g[projection.ordinal()];
        if (i8 == 1) {
            return N0.f4371f;
        }
        if (i8 == 2) {
            return N0.f4372g;
        }
        if (i8 == 3) {
            return N0.f4370e;
        }
        if (i8 != 4) {
            throw new C2487o();
        }
        throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + projection);
    }

    public final N0 d(s.c variance) {
        AbstractC2304t.f(variance, "variance");
        int i8 = a.f947f[variance.ordinal()];
        if (i8 == 1) {
            return N0.f4371f;
        }
        if (i8 == 2) {
            return N0.f4372g;
        }
        if (i8 == 3) {
            return N0.f4370e;
        }
        throw new C2487o();
    }
}
