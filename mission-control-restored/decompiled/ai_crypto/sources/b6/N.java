package b6;

/* JADX INFO: loaded from: classes2.dex */
public enum N {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9015a;

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
            f9015a = iArr;
        }
    }

    public final void b(Q5.o oVar, Object obj, H5.d dVar) throws Throwable {
        int i7 = a.f9015a[ordinal()];
        if (i7 == 1) {
            h6.a.d(oVar, obj, dVar, null, 4, null);
            return;
        }
        if (i7 == 2) {
            H5.f.a(oVar, obj, dVar);
        } else if (i7 == 3) {
            h6.b.a(oVar, obj, dVar);
        } else if (i7 != 4) {
            throw new E5.m();
        }
    }

    public final boolean c() {
        return this == LAZY;
    }
}
