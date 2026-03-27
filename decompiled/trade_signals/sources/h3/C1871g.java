package h3;

import o3.InterfaceC2461d;

/* JADX INFO: renamed from: h3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1871g extends AbstractC1870f {

    /* JADX INFO: renamed from: h3.g$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18452a;

        static {
            int[] iArr = new int[c3.l.values().length];
            f18452a = iArr;
            try {
                iArr[c3.l.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18452a[c3.l.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18452a[c3.l.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18452a[c3.l.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18452a[c3.l.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void I(InterfaceC1857A interfaceC1857A) {
        this.f18437d = interfaceC1857A;
    }

    public void J(InterfaceC1857A interfaceC1857A) {
        this.f18436c = interfaceC1857A;
    }

    public synchronized void K(G2.f fVar) {
        this.f18445l = fVar;
    }

    public synchronized void L(c3.l lVar) {
        InterfaceC2461d.a aVar;
        try {
            b();
            int i8 = a.f18452a[lVar.ordinal()];
            if (i8 == 1) {
                aVar = InterfaceC2461d.a.DEBUG;
            } else if (i8 == 2) {
                aVar = InterfaceC2461d.a.INFO;
            } else if (i8 == 3) {
                aVar = InterfaceC2461d.a.WARN;
            } else if (i8 == 4) {
                aVar = InterfaceC2461d.a.ERROR;
            } else {
                if (i8 != 5) {
                    throw new IllegalArgumentException("Unknown log level: " + lVar);
                }
                aVar = InterfaceC2461d.a.NONE;
            }
            this.f18442i = aVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void M(long j8) {
        b();
        if (j8 < 1048576) {
            throw new c3.d("The minimum cache size must be at least 1MB");
        }
        if (j8 > 104857600) {
            throw new c3.d("Firebase Database currently doesn't support a cache size larger than 100MB");
        }
        this.f18444k = j8;
    }

    public synchronized void N(boolean z7) {
        b();
        this.f18443j = z7;
    }

    public synchronized void O(String str) {
        b();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.f18439f = str;
    }
}
