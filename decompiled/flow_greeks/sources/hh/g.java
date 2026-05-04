package hh;

import java.io.Serializable;
import java.util.Arrays;
import kg.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class g implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11478d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f11479e = new g(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f11480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f11481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f11482c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final g a(String str) {
            kotlin.jvm.internal.t.f(str, "<this>");
            g gVar = new g(v.a(str));
            gVar.A(str);
            return gVar;
        }

        public final g b(byte... data) {
            kotlin.jvm.internal.t.f(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.t.e(bArrCopyOf, "copyOf(this, size)");
            return new g(bArrCopyOf);
        }

        public a() {
        }
    }

    public g(byte[] data) {
        kotlin.jvm.internal.t.f(data, "data");
        this.f11480a = data;
    }

    public static final g c(String str) {
        return f11478d.a(str);
    }

    public static final g u(byte... bArr) {
        return f11478d.b(bArr);
    }

    public final void A(String str) {
        this.f11482c = str;
    }

    public final int B() {
        return l();
    }

    public final boolean E(g prefix) {
        kotlin.jvm.internal.t.f(prefix, "prefix");
        return v(0, prefix, 0, prefix.B());
    }

    public g G() {
        for (int i10 = 0; i10 < i().length; i10++) {
            byte b10 = i()[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrI = i();
                byte[] bArrCopyOf = Arrays.copyOf(bArrI, bArrI.length);
                kotlin.jvm.internal.t.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b11 = bArrCopyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new g(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] H() {
        byte[] bArrI = i();
        byte[] bArrCopyOf = Arrays.copyOf(bArrI, bArrI.length);
        kotlin.jvm.internal.t.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String K() {
        String strM = m();
        if (strM != null) {
            return strM;
        }
        String strB = v.b(q());
        A(strB);
        return strB;
    }

    public void L(d buffer, int i10, int i11) {
        kotlin.jvm.internal.t.f(buffer, "buffer");
        ih.b.c(this, buffer, i10, i11);
    }

    public String a() {
        return hh.a.b(i(), null, 1, null);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(g other) {
        kotlin.jvm.internal.t.f(other, "other");
        int iB = B();
        int iB2 = other.B();
        int iMin = Math.min(iB, iB2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iH = h(i10) & 255;
            int iH2 = other.h(i10) & 255;
            if (iH != iH2) {
                return iH < iH2 ? -1 : 1;
            }
        }
        if (iB == iB2) {
            return 0;
        }
        return iB < iB2 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.B() == i().length && gVar.w(0, i(), 0, i().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte h(int i10) {
        return s(i10);
    }

    public int hashCode() {
        int iK = k();
        if (iK != 0) {
            return iK;
        }
        int iHashCode = Arrays.hashCode(i());
        y(iHashCode);
        return iHashCode;
    }

    public final byte[] i() {
        return this.f11480a;
    }

    public final int k() {
        return this.f11481b;
    }

    public int l() {
        return i().length;
    }

    public final String m() {
        return this.f11482c;
    }

    public String o() {
        char[] cArr = new char[i().length * 2];
        int i10 = 0;
        for (byte b10 : i()) {
            int i11 = i10 + 1;
            cArr[i10] = ih.b.d()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = ih.b.d()[b10 & 15];
        }
        return z.s(cArr);
    }

    public byte[] q() {
        return i();
    }

    public byte s(int i10) {
        return i()[i10];
    }

    public String toString() {
        if (i().length == 0) {
            return "[size=0]";
        }
        int iB = ih.b.b(i(), 64);
        if (iB != -1) {
            String strK = K();
            String strSubstring = strK.substring(0, iB);
            kotlin.jvm.internal.t.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strF = z.F(z.F(z.F(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iB >= strK.length()) {
                return "[text=" + strF + ']';
            }
            return "[size=" + i().length + " text=" + strF + "…]";
        }
        if (i().length <= 64) {
            return "[hex=" + o() + ']';
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[size=");
        sb2.append(i().length);
        sb2.append(" hex=");
        int iC = b.c(this, 64);
        if (iC <= i().length) {
            if (iC < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            sb2.append((iC == i().length ? this : new g(dd.l.l(i(), 0, iC))).o());
            sb2.append("…]");
            return sb2.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + i().length + ')').toString());
    }

    public boolean v(int i10, g other, int i11, int i12) {
        kotlin.jvm.internal.t.f(other, "other");
        return other.w(i11, i(), i10, i12);
    }

    public boolean w(int i10, byte[] other, int i11, int i12) {
        kotlin.jvm.internal.t.f(other, "other");
        return i10 >= 0 && i10 <= i().length - i12 && i11 >= 0 && i11 <= other.length - i12 && b.a(i(), i10, other, i11, i12);
    }

    public final void y(int i10) {
        this.f11481b = i10;
    }
}
