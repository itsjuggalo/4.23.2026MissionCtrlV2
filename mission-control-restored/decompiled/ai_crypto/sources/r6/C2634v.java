package r6;

import F5.AbstractC0552j;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: r6.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2634v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f22935e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long[] f22936f = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6.e f22937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q5.o f22938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f22940d;

    /* JADX INFO: renamed from: r6.v$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public C2634v(p6.e descriptor, Q5.o readIfAbsent) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(readIfAbsent, "readIfAbsent");
        this.f22937a = descriptor;
        this.f22938b = readIfAbsent;
        int iF = descriptor.f();
        if (iF <= 64) {
            this.f22939c = iF != 64 ? (-1) << iF : 0L;
            this.f22940d = f22936f;
        } else {
            this.f22939c = 0L;
            this.f22940d = e(iF);
        }
    }

    public final void a(int i7) {
        if (i7 < 64) {
            this.f22939c |= 1 << i7;
        } else {
            b(i7);
        }
    }

    public final void b(int i7) {
        int i8 = (i7 >>> 6) - 1;
        long[] jArr = this.f22940d;
        jArr[i8] = jArr[i8] | (1 << (i7 & 63));
    }

    public final int c() {
        int length = this.f22940d.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 1;
            int i9 = i8 * 64;
            long j7 = this.f22940d[i7];
            while (j7 != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j7);
                j7 |= 1 << iNumberOfTrailingZeros;
                int i10 = iNumberOfTrailingZeros + i9;
                if (((Boolean) this.f22938b.invoke(this.f22937a, Integer.valueOf(i10))).booleanValue()) {
                    this.f22940d[i7] = j7;
                    return i10;
                }
            }
            this.f22940d[i7] = j7;
            i7 = i8;
        }
        return -1;
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iF = this.f22937a.f();
        do {
            long j7 = this.f22939c;
            if (j7 == -1) {
                if (iF > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j7);
            this.f22939c |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) this.f22938b.invoke(this.f22937a, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }

    public final long[] e(int i7) {
        long[] jArr = new long[(i7 - 1) >>> 6];
        if ((i7 & 63) != 0) {
            jArr[AbstractC0552j.w(jArr)] = (-1) << i7;
        }
        return jArr;
    }
}
