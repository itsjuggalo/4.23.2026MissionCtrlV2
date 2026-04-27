package F5;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2296k;
import w5.AbstractC2926b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1916a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f1917b = AbstractC2926b.f24073a.b();

    public static final class a extends c implements Serializable {
        public a() {
        }

        @Override // F5.c
        public int b(int i8) {
            return c.f1917b.b(i8);
        }

        @Override // F5.c
        public int c() {
            return c.f1917b.c();
        }

        @Override // F5.c
        public int d(int i8) {
            return c.f1917b.d(i8);
        }

        @Override // F5.c
        public long e() {
            return c.f1917b.e();
        }

        @Override // F5.c
        public long f(long j8, long j9) {
            return c.f1917b.f(j8, j9);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public abstract int b(int i8);

    public abstract int c();

    public abstract int d(int i8);

    public abstract long e();

    public long f(long j8, long j9) {
        long jE;
        long j10;
        long jB;
        int iC;
        d.b(j8, j9);
        long j11 = j9 - j8;
        if (j11 > 0) {
            if (((-j11) & j11) == j11) {
                int i8 = (int) j11;
                int i9 = (int) (j11 >>> 32);
                if (i8 != 0) {
                    iC = b(d.c(i8));
                } else if (i9 == 1) {
                    iC = c();
                } else {
                    jB = (((long) b(d.c(i9))) << 32) + (((long) c()) & KeyboardMap.kValueMask);
                }
                jB = ((long) iC) & KeyboardMap.kValueMask;
            } else {
                do {
                    jE = e() >>> 1;
                    j10 = jE % j11;
                } while ((jE - j10) + (j11 - 1) < 0);
                jB = j10;
            }
            return j8 + jB;
        }
        while (true) {
            long jE2 = e();
            if (j8 <= jE2 && jE2 < j9) {
                return jE2;
            }
        }
    }
}
