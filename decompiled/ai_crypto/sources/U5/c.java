package U5;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5206a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f5207b = L5.b.f3702a.b();

    public static final class a extends c implements Serializable {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        @Override // U5.c
        public int b(int i7) {
            return c.f5207b.b(i7);
        }

        @Override // U5.c
        public int c() {
            return c.f5207b.c();
        }

        @Override // U5.c
        public int d(int i7) {
            return c.f5207b.d(i7);
        }

        @Override // U5.c
        public long e() {
            return c.f5207b.e();
        }

        @Override // U5.c
        public long f(long j7, long j8) {
            return c.f5207b.f(j7, j8);
        }

        public a() {
        }
    }

    public abstract int b(int i7);

    public abstract int c();

    public abstract int d(int i7);

    public abstract long e();

    public long f(long j7, long j8) {
        long jE;
        long j9;
        long jB;
        int iC;
        d.b(j7, j8);
        long j10 = j8 - j7;
        if (j10 > 0) {
            if (((-j10) & j10) == j10) {
                int i7 = (int) j10;
                int i8 = (int) (j10 >>> 32);
                if (i7 != 0) {
                    iC = b(d.c(i7));
                } else if (i8 == 1) {
                    iC = c();
                } else {
                    jB = (((long) b(d.c(i8))) << 32) + (((long) c()) & 4294967295L);
                }
                jB = ((long) iC) & 4294967295L;
            } else {
                do {
                    jE = e() >>> 1;
                    j9 = jE % j10;
                } while ((jE - j9) + (j10 - 1) < 0);
                jB = j9;
            }
            return j7 + jB;
        }
        while (true) {
            long jE2 = e();
            if (j7 <= jE2 && jE2 < j8) {
                return jE2;
            }
        }
    }
}
