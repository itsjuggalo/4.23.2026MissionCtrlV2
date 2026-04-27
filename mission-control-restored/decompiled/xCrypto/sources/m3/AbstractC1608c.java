package m3;

import d3.AbstractC1218b;
import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: m3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1608c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13542a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1608c f13543b = AbstractC1218b.f11431a.b();

    /* JADX INFO: renamed from: m3.c$a */
    public static final class a extends AbstractC1608c implements Serializable {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        @Override // m3.AbstractC1608c
        public int b(int i4) {
            return AbstractC1608c.f13543b.b(i4);
        }

        @Override // m3.AbstractC1608c
        public int c() {
            return AbstractC1608c.f13543b.c();
        }

        @Override // m3.AbstractC1608c
        public int d(int i4) {
            return AbstractC1608c.f13543b.d(i4);
        }

        @Override // m3.AbstractC1608c
        public long e() {
            return AbstractC1608c.f13543b.e();
        }

        @Override // m3.AbstractC1608c
        public long f(long j4, long j5) {
            return AbstractC1608c.f13543b.f(j4, j5);
        }

        public a() {
        }
    }

    public abstract int b(int i4);

    public abstract int c();

    public abstract int d(int i4);

    public abstract long e();

    public long f(long j4, long j5) {
        long jE;
        long j6;
        long jB;
        int iC;
        AbstractC1609d.b(j4, j5);
        long j7 = j5 - j4;
        if (j7 > 0) {
            if (((-j7) & j7) == j7) {
                int i4 = (int) j7;
                int i5 = (int) (j7 >>> 32);
                if (i4 != 0) {
                    iC = b(AbstractC1609d.c(i4));
                } else if (i5 == 1) {
                    iC = c();
                } else {
                    jB = (((long) b(AbstractC1609d.c(i5))) << 32) + (((long) c()) & KeyboardMap.kValueMask);
                }
                jB = ((long) iC) & KeyboardMap.kValueMask;
            } else {
                do {
                    jE = e() >>> 1;
                    j6 = jE % j7;
                } while ((jE - j6) + (j7 - 1) < 0);
                jB = j6;
            }
            return j4 + jB;
        }
        while (true) {
            long jE2 = e();
            if (j4 <= jE2 && jE2 < j5) {
                return jE2;
            }
        }
    }
}
