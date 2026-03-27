package J3;

import X2.AbstractC0765l;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: J3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0348v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f978e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long[] f979f = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H3.e f980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.o f981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f983d;

    /* JADX INFO: renamed from: J3.v$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public C0348v(H3.e descriptor, i3.o readIfAbsent) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(readIfAbsent, "readIfAbsent");
        this.f980a = descriptor;
        this.f981b = readIfAbsent;
        int iF = descriptor.f();
        if (iF <= 64) {
            this.f982c = iF != 64 ? (-1) << iF : 0L;
            this.f983d = f979f;
        } else {
            this.f982c = 0L;
            this.f983d = e(iF);
        }
    }

    public final void a(int i4) {
        if (i4 < 64) {
            this.f982c |= 1 << i4;
        } else {
            b(i4);
        }
    }

    public final void b(int i4) {
        int i5 = (i4 >>> 6) - 1;
        long[] jArr = this.f983d;
        jArr[i5] = jArr[i5] | (1 << (i4 & 63));
    }

    public final int c() {
        int length = this.f983d.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            int i6 = i5 * 64;
            long j4 = this.f983d[i4];
            while (j4 != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j4);
                j4 |= 1 << iNumberOfTrailingZeros;
                int i7 = iNumberOfTrailingZeros + i6;
                if (((Boolean) this.f981b.invoke(this.f980a, Integer.valueOf(i7))).booleanValue()) {
                    this.f983d[i4] = j4;
                    return i7;
                }
            }
            this.f983d[i4] = j4;
            i4 = i5;
        }
        return -1;
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iF = this.f980a.f();
        do {
            long j4 = this.f982c;
            if (j4 == -1) {
                if (iF > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j4);
            this.f982c |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) this.f981b.invoke(this.f980a, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }

    public final long[] e(int i4) {
        long[] jArr = new long[(i4 - 1) >>> 6];
        if ((i4 & 63) != 0) {
            jArr[AbstractC0765l.x(jArr)] = (-1) << i4;
        }
        return jArr;
    }
}
