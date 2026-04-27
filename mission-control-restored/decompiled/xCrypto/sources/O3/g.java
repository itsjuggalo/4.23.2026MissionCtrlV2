package O3;

import X2.AbstractC0763j;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC1585j;
import r3.x;

/* JADX INFO: loaded from: classes3.dex */
public class g implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3330d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f3331e = new g(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f3333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f3334c;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final g a(String str) {
            kotlin.jvm.internal.r.f(str, "<this>");
            g gVar = new g(v.a(str));
            gVar.u(str);
            return gVar;
        }

        public final g b(byte... data) {
            kotlin.jvm.internal.r.f(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, size)");
            return new g(bArrCopyOf);
        }

        public a() {
        }
    }

    public g(byte[] data) {
        kotlin.jvm.internal.r.f(data, "data");
        this.f3332a = data;
    }

    public static final g g(String str) {
        return f3330d.a(str);
    }

    public static final g q(byte... bArr) {
        return f3330d.b(bArr);
    }

    public void A(d buffer, int i4, int i5) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        P3.b.c(this, buffer, i4, i5);
    }

    public String a() {
        return O3.a.b(i(), null, 1, null);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(g other) {
        kotlin.jvm.internal.r.f(other, "other");
        int iV = v();
        int iV2 = other.v();
        int iMin = Math.min(iV, iV2);
        for (int i4 = 0; i4 < iMin; i4++) {
            int iH = h(i4) & 255;
            int iH2 = other.h(i4) & 255;
            if (iH != iH2) {
                return iH < iH2 ? -1 : 1;
            }
        }
        if (iV == iV2) {
            return 0;
        }
        return iV < iV2 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.v() == i().length && gVar.s(0, i(), 0, i().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte h(int i4) {
        return p(i4);
    }

    public int hashCode() {
        int iK = k();
        if (iK != 0) {
            return iK;
        }
        int iHashCode = Arrays.hashCode(i());
        t(iHashCode);
        return iHashCode;
    }

    public final byte[] i() {
        return this.f3332a;
    }

    public final int k() {
        return this.f3333b;
    }

    public int l() {
        return i().length;
    }

    public final String m() {
        return this.f3334c;
    }

    public String n() {
        char[] cArr = new char[i().length * 2];
        int i4 = 0;
        for (byte b4 : i()) {
            int i5 = i4 + 1;
            cArr[i4] = P3.b.d()[(b4 >> 4) & 15];
            i4 += 2;
            cArr[i5] = P3.b.d()[b4 & 15];
        }
        return x.q(cArr);
    }

    public byte[] o() {
        return i();
    }

    public byte p(int i4) {
        return i()[i4];
    }

    public boolean r(int i4, g other, int i5, int i6) {
        kotlin.jvm.internal.r.f(other, "other");
        return other.s(i5, i(), i4, i6);
    }

    public boolean s(int i4, byte[] other, int i5, int i6) {
        kotlin.jvm.internal.r.f(other, "other");
        return i4 >= 0 && i4 <= i().length - i6 && i5 >= 0 && i5 <= other.length - i6 && b.a(i(), i4, other, i5, i6);
    }

    public final void t(int i4) {
        this.f3333b = i4;
    }

    public String toString() {
        if (i().length == 0) {
            return "[size=0]";
        }
        int iB = P3.b.b(i(), 64);
        if (iB != -1) {
            String strZ = z();
            String strSubstring = strZ.substring(0, iB);
            kotlin.jvm.internal.r.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strA = x.A(x.A(x.A(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iB >= strZ.length()) {
                return "[text=" + strA + ']';
            }
            return "[size=" + i().length + " text=" + strA + "…]";
        }
        if (i().length <= 64) {
            return "[hex=" + n() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(i().length);
        sb.append(" hex=");
        int iC = b.c(this, 64);
        if (iC <= i().length) {
            if (iC < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            sb.append((iC == i().length ? this : new g(AbstractC0763j.h(i(), 0, iC))).n());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + i().length + ')').toString());
    }

    public final void u(String str) {
        this.f3334c = str;
    }

    public final int v() {
        return l();
    }

    public final boolean w(g prefix) {
        kotlin.jvm.internal.r.f(prefix, "prefix");
        return r(0, prefix, 0, prefix.v());
    }

    public g x() {
        for (int i4 = 0; i4 < i().length; i4++) {
            byte b4 = i()[i4];
            if (b4 >= 65 && b4 <= 90) {
                byte[] bArrI = i();
                byte[] bArrCopyOf = Arrays.copyOf(bArrI, bArrI.length);
                kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i4] = (byte) (b4 + 32);
                for (int i5 = i4 + 1; i5 < bArrCopyOf.length; i5++) {
                    byte b5 = bArrCopyOf[i5];
                    if (b5 >= 65 && b5 <= 90) {
                        bArrCopyOf[i5] = (byte) (b5 + 32);
                    }
                }
                return new g(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] y() {
        byte[] bArrI = i();
        byte[] bArrCopyOf = Arrays.copyOf(bArrI, bArrI.length);
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String z() {
        String strM = m();
        if (strM != null) {
            return strM;
        }
        String strB = v.b(o());
        u(strB);
        return strB;
    }
}
