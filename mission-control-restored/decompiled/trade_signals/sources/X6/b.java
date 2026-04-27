package X6;

import V6.A;
import V6.AbstractC0979e;
import java.io.Serializable;
import java.util.Comparator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2464B;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9452c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f9453d = new b(0, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator f9454e = new Comparator() { // from class: X6.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return b.b((b) obj, (b) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9456b;

    public static final class a {
        public a() {
        }

        public final b a(long j8, long j9) {
            return (j8 == 0 && j9 == 0) ? b() : new b(j8, j9);
        }

        public final b b() {
            return b.f9453d;
        }

        public final b c(String uuidString) {
            AbstractC2304t.f(uuidString, "uuidString");
            if (uuidString.length() != 36) {
                throw new IllegalArgumentException("Expected a 36-char string in the standard uuid format.".toString());
            }
            long jF = AbstractC0979e.f(uuidString, 0, 8, null, 4, null);
            d.c(uuidString, 8);
            long jF2 = AbstractC0979e.f(uuidString, 9, 13, null, 4, null);
            d.c(uuidString, 13);
            long jF3 = AbstractC0979e.f(uuidString, 14, 18, null, 4, null);
            d.c(uuidString, 18);
            long jF4 = AbstractC0979e.f(uuidString, 19, 23, null, 4, null);
            d.c(uuidString, 23);
            return a((jF << 32) | (jF2 << 16) | jF3, AbstractC0979e.f(uuidString, 24, 36, null, 4, null) | (jF4 << 48));
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public b(long j8, long j9) {
        this.f9455a = j8;
        this.f9456b = j9;
    }

    public static final int b(b a8, b b8) {
        long jB;
        long j8;
        AbstractC2304t.f(a8, "a");
        AbstractC2304t.f(b8, "b");
        long j9 = a8.f9455a;
        if (j9 != b8.f9455a) {
            jB = C2464B.b(j9);
            j8 = b8.f9455a;
        } else {
            jB = C2464B.b(a8.f9456b);
            j8 = b8.f9456b;
        }
        return Long.compare(jB ^ Long.MIN_VALUE, C2464B.b(j8) ^ Long.MIN_VALUE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f9455a == bVar.f9455a && this.f9456b == bVar.f9456b;
    }

    public int hashCode() {
        long j8 = this.f9455a ^ this.f9456b;
        return ((int) j8) ^ ((int) (j8 >> 32));
    }

    public String toString() {
        byte[] bArr = new byte[36];
        d.d(this.f9456b, bArr, 24, 6);
        bArr[23] = 45;
        d.d(this.f9456b >>> 48, bArr, 19, 2);
        bArr[18] = 45;
        d.d(this.f9455a, bArr, 14, 2);
        bArr[13] = 45;
        d.d(this.f9455a >>> 16, bArr, 9, 2);
        bArr[8] = 45;
        d.d(this.f9455a >>> 32, bArr, 0, 4);
        return A.t(bArr);
    }
}
