package o7;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: o7.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2529v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f22213e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long[] f22214f = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m7.e f22215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.o f22216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f22218d;

    /* JADX INFO: renamed from: o7.v$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C2529v(m7.e descriptor, B5.o readIfAbsent) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(readIfAbsent, "readIfAbsent");
        this.f22215a = descriptor;
        this.f22216b = readIfAbsent;
        int iE = descriptor.e();
        if (iE <= 64) {
            this.f22217c = iE != 64 ? (-1) << iE : 0L;
            this.f22218d = f22214f;
        } else {
            this.f22217c = 0L;
            this.f22218d = e(iE);
        }
    }

    public final void a(int i8) {
        if (i8 < 64) {
            this.f22217c |= 1 << i8;
        } else {
            b(i8);
        }
    }

    public final void b(int i8) {
        int i9 = (i8 >>> 6) - 1;
        long[] jArr = this.f22218d;
        jArr[i9] = jArr[i9] | (1 << (i8 & 63));
    }

    public final int c() {
        int length = this.f22218d.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            int i10 = i9 * 64;
            long j8 = this.f22218d[i8];
            while (j8 != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j8);
                j8 |= 1 << iNumberOfTrailingZeros;
                int i11 = iNumberOfTrailingZeros + i10;
                if (((Boolean) this.f22216b.invoke(this.f22215a, Integer.valueOf(i11))).booleanValue()) {
                    this.f22218d[i8] = j8;
                    return i11;
                }
            }
            this.f22218d[i8] = j8;
            i8 = i9;
        }
        return -1;
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iE = this.f22215a.e();
        do {
            long j8 = this.f22217c;
            if (j8 == -1) {
                if (iE > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j8);
            this.f22217c |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) this.f22216b.invoke(this.f22215a, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }

    public final long[] e(int i8) {
        long[] jArr = new long[(i8 - 1) >>> 6];
        if ((i8 & 63) != 0) {
            jArr[AbstractC2592n.F(jArr)] = (-1) << i8;
        }
        return jArr;
    }
}
