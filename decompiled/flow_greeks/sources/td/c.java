package td;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21894a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f21895b = kd.b.f14824a.b();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends c implements Serializable {
        public /* synthetic */ a(k kVar) {
            this();
        }

        @Override // td.c
        public int b(int i10) {
            return c.f21895b.b(i10);
        }

        @Override // td.c
        public int c() {
            return c.f21895b.c();
        }

        @Override // td.c
        public int d(int i10) {
            return c.f21895b.d(i10);
        }

        @Override // td.c
        public long e() {
            return c.f21895b.e();
        }

        @Override // td.c
        public long f(long j10, long j11) {
            return c.f21895b.f(j10, j11);
        }

        public a() {
        }
    }

    public abstract int b(int i10);

    public abstract int c();

    public abstract int d(int i10);

    public abstract long e();

    public long f(long j10, long j11) {
        long jE;
        long j12;
        long jB;
        int iC;
        d.b(j10, j11);
        long j13 = j11 - j10;
        if (j13 > 0) {
            if (((-j13) & j13) == j13) {
                int i10 = (int) j13;
                int i11 = (int) (j13 >>> 32);
                if (i10 != 0) {
                    iC = b(d.c(i10));
                } else if (i11 == 1) {
                    iC = c();
                } else {
                    jB = (((long) b(d.c(i11))) << 32) + (((long) c()) & KeyboardMap.kValueMask);
                }
                jB = ((long) iC) & KeyboardMap.kValueMask;
            } else {
                do {
                    jE = e() >>> 1;
                    j12 = jE % j13;
                } while ((jE - j12) + (j13 - 1) < 0);
                jB = j12;
            }
            return j10 + jB;
        }
        while (true) {
            long jE2 = e();
            if (j10 <= jE2 && jE2 < j11) {
                return jE2;
            }
        }
    }
}
