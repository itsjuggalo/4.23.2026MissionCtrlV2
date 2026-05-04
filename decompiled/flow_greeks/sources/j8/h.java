package j8;

import q8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14005a;

        static {
            int[] iArr = new int[e8.l.values().length];
            f14005a = iArr;
            try {
                iArr[e8.l.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14005a[e8.l.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14005a[e8.l.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14005a[e8.l.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14005a[e8.l.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void H(b0 b0Var) {
        this.f13982d = b0Var;
    }

    public void I(b0 b0Var) {
        this.f13981c = b0Var;
    }

    public synchronized void J(a7.g gVar) {
        this.f13990l = gVar;
    }

    public synchronized void K(e8.l lVar) {
        try {
            b();
            int i10 = a.f14005a[lVar.ordinal()];
            if (i10 == 1) {
                this.f13987i = d.a.DEBUG;
            } else if (i10 == 2) {
                this.f13987i = d.a.INFO;
            } else if (i10 == 3) {
                this.f13987i = d.a.WARN;
            } else if (i10 == 4) {
                this.f13987i = d.a.ERROR;
            } else {
                if (i10 != 5) {
                    throw new IllegalArgumentException("Unknown log level: " + lVar);
                }
                this.f13987i = d.a.NONE;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void L(long j10) {
        b();
        if (j10 < 1048576) {
            throw new e8.d("The minimum cache size must be at least 1MB");
        }
        if (j10 > 104857600) {
            throw new e8.d("Firebase Database currently doesn't support a cache size larger than 100MB");
        }
        this.f13989k = j10;
    }

    public synchronized void M(boolean z10) {
        b();
        this.f13988j = z10;
    }

    public synchronized void N(String str) {
        b();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.f13984f = str;
    }
}
