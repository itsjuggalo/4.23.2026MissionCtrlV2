package t3;

/* JADX INFO: loaded from: classes3.dex */
public enum N {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14957a;

        static {
            int[] iArr = new int[N.values().length];
            try {
                iArr[N.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[N.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[N.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[N.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14957a = iArr;
        }
    }

    public final void c(i3.o oVar, Object obj, Z2.e eVar) throws Throwable {
        int i4 = a.f14957a[ordinal()];
        if (i4 == 1) {
            z3.a.d(oVar, obj, eVar, null, 4, null);
            return;
        }
        if (i4 == 2) {
            Z2.g.a(oVar, obj, eVar);
        } else if (i4 == 3) {
            z3.b.a(oVar, obj, eVar);
        } else if (i4 != 4) {
            throw new W2.m();
        }
    }

    public final boolean g() {
        return this == LAZY;
    }
}
