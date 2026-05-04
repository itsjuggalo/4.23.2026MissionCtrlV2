package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f8228e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long[] f8229f = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bh.e f8230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.o f8231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f8233d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public v(bh.e descriptor, pd.o readIfAbsent) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(readIfAbsent, "readIfAbsent");
        this.f8230a = descriptor;
        this.f8231b = readIfAbsent;
        int iL = descriptor.l();
        if (iL <= 64) {
            this.f8232c = iL != 64 ? (-1) << iL : 0L;
            this.f8233d = f8229f;
        } else {
            this.f8232c = 0L;
            this.f8233d = e(iL);
        }
    }

    public final void a(int i10) {
        if (i10 < 64) {
            this.f8232c |= 1 << i10;
        } else {
            b(i10);
        }
    }

    public final void b(int i10) {
        int i11 = (i10 >>> 6) - 1;
        long[] jArr = this.f8233d;
        jArr[i11] = jArr[i11] | (1 << (i10 & 63));
    }

    public final int c() {
        int length = this.f8233d.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            int i12 = i11 * 64;
            long j10 = this.f8233d[i10];
            while (j10 != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j10);
                j10 |= 1 << iNumberOfTrailingZeros;
                int i13 = iNumberOfTrailingZeros + i12;
                if (((Boolean) this.f8231b.invoke(this.f8230a, Integer.valueOf(i13))).booleanValue()) {
                    this.f8233d[i10] = j10;
                    return i13;
                }
            }
            this.f8233d[i10] = j10;
            i10 = i11;
        }
        return -1;
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iL = this.f8230a.l();
        do {
            long j10 = this.f8232c;
            if (j10 == -1) {
                if (iL > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j10);
            this.f8232c |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) this.f8231b.invoke(this.f8230a, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }

    public final long[] e(int i10) {
        long[] jArr = new long[(i10 - 1) >>> 6];
        if ((i10 & 63) != 0) {
            jArr[dd.n.F(jArr)] = (-1) << i10;
        }
        return jArr;
    }
}
