package xe;

import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f24869k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i0 f24870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final i0 f24871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final i0 f24872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final i0 f24873o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final i0 f24874p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final i0 f24875q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final i0 f24876r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final i0 f24877s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final i0 f24878t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f24879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f24884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i0 f24886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i0 f24887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f24888j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24889a;

        static {
            int[] iArr = new int[m2.values().length];
            try {
                iArr[m2.f25016f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[m2.f25015e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f24889a = iArr;
        }
    }

    static {
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        i0 i0Var = new i0(z10, z11, z12, z13, z14, null, false, null, null, z15, 1023, null);
        f24870l = i0Var;
        i0 i0Var2 = new i0(false, false, z15, false, false, null, false, null, null, true, 511, null);
        f24871m = i0Var2;
        f24872n = new i0(false, true, false, false, false, null, false, null, null, false, 1021, null);
        f24873o = new i0(z10, z11, z12, z13, z14, i0Var, false, null, null, z15, 988, null);
        f24874p = new i0(false, false, z15, false, false, i0Var2, false, null, null, true, 476, null);
        kotlin.jvm.internal.k kVar = null;
        boolean z16 = false;
        i0 i0Var3 = null;
        i0 i0Var4 = null;
        f24875q = new i0(z10, true, z12, z13, z14, i0Var, z16, i0Var3, i0Var4, z15, 988, kVar);
        boolean z17 = false;
        boolean z18 = true;
        f24876r = new i0(z10, z17, z12, z18, z14, i0Var, z16, i0Var3, i0Var4, z15, 983, kVar);
        f24877s = new i0(z10, z17, z12, z18, z14, i0Var, z16, i0Var3, i0Var4, z15, 919, kVar);
        f24878t = new i0(z10, z17, true, false, z14, i0Var, z16, i0Var3, i0Var4, z15, 984, kVar);
    }

    public i0(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, i0 i0Var, boolean z15, i0 i0Var2, i0 i0Var3, boolean z16) {
        this.f24879a = z10;
        this.f24880b = z11;
        this.f24881c = z12;
        this.f24882d = z13;
        this.f24883e = z14;
        this.f24884f = i0Var;
        this.f24885g = z15;
        this.f24886h = i0Var2;
        this.f24887i = i0Var3;
        this.f24888j = z16;
    }

    public final boolean a() {
        return this.f24885g;
    }

    public final boolean b() {
        return this.f24888j;
    }

    public final boolean c() {
        return this.f24880b;
    }

    public final boolean d() {
        return this.f24879a;
    }

    public final boolean e() {
        return this.f24881c;
    }

    public final i0 f(m2 effectiveVariance, boolean z10) {
        kotlin.jvm.internal.t.f(effectiveVariance, "effectiveVariance");
        if (!z10 || !this.f24881c) {
            int i10 = b.f24889a[effectiveVariance.ordinal()];
            if (i10 == 1) {
                i0 i0Var = this.f24886h;
                if (i0Var != null) {
                    return i0Var;
                }
            } else if (i10 != 2) {
                i0 i0Var2 = this.f24884f;
                if (i0Var2 != null) {
                    return i0Var2;
                }
            } else {
                i0 i0Var3 = this.f24887i;
                if (i0Var3 != null) {
                    return i0Var3;
                }
            }
        }
        return this;
    }

    public final i0 g() {
        return new i0(this.f24879a, true, this.f24881c, this.f24882d, this.f24883e, this.f24884f, this.f24885g, this.f24886h, this.f24887i, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ i0(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, i0 i0Var, boolean z15, i0 i0Var2, i0 i0Var3, boolean z16, int i10, kotlin.jvm.internal.k kVar) {
        z10 = (i10 & 1) != 0 ? true : z10;
        z11 = (i10 & 2) != 0 ? true : z11;
        z12 = (i10 & 4) != 0 ? false : z12;
        z13 = (i10 & 8) != 0 ? false : z13;
        z14 = (i10 & 16) != 0 ? false : z14;
        i0Var = (i10 & 32) != 0 ? null : i0Var;
        this(z10, z11, z12, z13, z14, i0Var, (i10 & 64) != 0 ? true : z15, (i10 & 128) != 0 ? i0Var : i0Var2, (i10 & 256) != 0 ? i0Var : i0Var3, (i10 & 512) != 0 ? false : z16);
    }
}
