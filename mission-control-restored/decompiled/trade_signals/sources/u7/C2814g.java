package u7;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;

/* JADX INFO: renamed from: u7.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2814g implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f23648d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2814g f23649e = new C2814g(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f23650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f23651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f23652c;

    /* JADX INFO: renamed from: u7.g$a */
    public static final class a {
        public a() {
        }

        public final C2814g a(String str) {
            AbstractC2304t.f(str, "<this>");
            C2814g c2814g = new C2814g(Y.a(str));
            c2814g.Q(str);
            return c2814g;
        }

        public final C2814g b(byte... data) {
            AbstractC2304t.f(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            AbstractC2304t.e(bArrCopyOf, "copyOf(this, size)");
            return new C2814g(bArrCopyOf);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C2814g(byte[] data) {
        AbstractC2304t.f(data, "data");
        this.f23650a = data;
    }

    public static /* synthetic */ int B(C2814g c2814g, C2814g c2814g2, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return c2814g.t(c2814g2, i8);
    }

    public static /* synthetic */ int L(C2814g c2814g, C2814g c2814g2, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i9 & 2) != 0) {
            i8 = AbstractC2809b.c();
        }
        return c2814g.J(c2814g2, i8);
    }

    public static final C2814g M(byte... bArr) {
        return f23648d.b(bArr);
    }

    public static /* synthetic */ C2814g U(C2814g c2814g, int i8, int i9, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = AbstractC2809b.c();
        }
        return c2814g.T(i8, i9);
    }

    public static final C2814g g(String str) {
        return f23648d.a(str);
    }

    public byte[] H() {
        return l();
    }

    public byte I(int i8) {
        return l()[i8];
    }

    public final int J(C2814g other, int i8) {
        AbstractC2304t.f(other, "other");
        return K(other.H(), i8);
    }

    public int K(byte[] other, int i8) {
        AbstractC2304t.f(other, "other");
        for (int iMin = Math.min(AbstractC2809b.d(this, i8), l().length - other.length); -1 < iMin; iMin--) {
            if (AbstractC2809b.a(l(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean N(int i8, C2814g other, int i9, int i10) {
        AbstractC2304t.f(other, "other");
        return other.O(i9, l(), i8, i10);
    }

    public boolean O(int i8, byte[] other, int i9, int i10) {
        AbstractC2304t.f(other, "other");
        return i8 >= 0 && i8 <= l().length - i10 && i9 >= 0 && i9 <= other.length - i10 && AbstractC2809b.a(l(), i8, other, i9, i10);
    }

    public final void P(int i8) {
        this.f23651b = i8;
    }

    public final void Q(String str) {
        this.f23652c = str;
    }

    public final int R() {
        return n();
    }

    public final boolean S(C2814g prefix) {
        AbstractC2304t.f(prefix, "prefix");
        return N(0, prefix, 0, prefix.R());
    }

    public C2814g T(int i8, int i9) {
        int iD = AbstractC2809b.d(this, i9);
        if (i8 < 0) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (iD <= l().length) {
            if (iD - i8 >= 0) {
                return (i8 == 0 && iD == l().length) ? this : new C2814g(AbstractC2590l.l(l(), i8, iD));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + l().length + ')').toString());
    }

    public C2814g V() {
        for (int i8 = 0; i8 < l().length; i8++) {
            byte b8 = l()[i8];
            if (b8 >= 65 && b8 <= 90) {
                byte[] bArrL = l();
                byte[] bArrCopyOf = Arrays.copyOf(bArrL, bArrL.length);
                AbstractC2304t.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i8] = (byte) (b8 + 32);
                for (int i9 = i8 + 1; i9 < bArrCopyOf.length; i9++) {
                    byte b9 = bArrCopyOf[i9];
                    if (b9 >= 65 && b9 <= 90) {
                        bArrCopyOf[i9] = (byte) (b9 + 32);
                    }
                }
                return new C2814g(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] W() {
        byte[] bArrL = l();
        byte[] bArrCopyOf = Arrays.copyOf(bArrL, bArrL.length);
        AbstractC2304t.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String X() {
        String strQ = q();
        if (strQ != null) {
            return strQ;
        }
        String strC = Y.c(H());
        Q(strC);
        return strC;
    }

    public void Y(C2811d buffer, int i8, int i9) {
        AbstractC2304t.f(buffer, "buffer");
        v7.b.c(this, buffer, i8, i9);
    }

    public String a() {
        return AbstractC2808a.b(l(), null, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(u7.C2814g r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.AbstractC2304t.f(r10, r0)
            int r0 = r9.R()
            int r1 = r10.R()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.k(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.k(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.C2814g.compareTo(u7.g):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2814g) {
            C2814g c2814g = (C2814g) obj;
            if (c2814g.R() == l().length && c2814g.O(0, l(), 0, l().length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iM = m();
        if (iM != 0) {
            return iM;
        }
        int iHashCode = Arrays.hashCode(l());
        P(iHashCode);
        return iHashCode;
    }

    public final boolean i(C2814g suffix) {
        AbstractC2304t.f(suffix, "suffix");
        return N(R() - suffix.R(), suffix, 0, suffix.R());
    }

    public final byte k(int i8) {
        return I(i8);
    }

    public final byte[] l() {
        return this.f23650a;
    }

    public final int m() {
        return this.f23651b;
    }

    public int n() {
        return l().length;
    }

    public final String q() {
        return this.f23652c;
    }

    public String r() {
        char[] cArr = new char[l().length * 2];
        int i8 = 0;
        for (byte b8 : l()) {
            int i9 = i8 + 1;
            cArr[i8] = v7.b.d()[(b8 >> 4) & 15];
            i8 += 2;
            cArr[i9] = v7.b.d()[b8 & 15];
        }
        return V6.A.r(cArr);
    }

    public final int t(C2814g other, int i8) {
        AbstractC2304t.f(other, "other");
        return w(other.H(), i8);
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (l().length != 0) {
            int iB = v7.b.b(l(), 64);
            if (iB != -1) {
                String strX = X();
                String strSubstring = strX.substring(0, iB);
                AbstractC2304t.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strE = V6.A.E(V6.A.E(V6.A.E(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (iB >= strX.length()) {
                    sb = new StringBuilder();
                    sb.append("[text=");
                    sb.append(strE);
                    sb.append(']');
                    return sb.toString();
                }
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(l().length);
                sb.append(" text=");
                sb.append(strE);
            } else if (l().length <= 64) {
                str = "[hex=" + r() + ']';
            } else {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(l().length);
                sb.append(" hex=");
                int iD = AbstractC2809b.d(this, 64);
                if (iD > l().length) {
                    throw new IllegalArgumentException(("endIndex > length(" + l().length + ')').toString());
                }
                if (iD < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                sb.append((iD == l().length ? this : new C2814g(AbstractC2590l.l(l(), 0, iD))).r());
            }
            sb.append("…]");
            return sb.toString();
        }
        str = "[size=0]";
        return str;
    }

    public int w(byte[] other, int i8) {
        AbstractC2304t.f(other, "other");
        int length = l().length - other.length;
        int iMax = Math.max(i8, 0);
        if (iMax <= length) {
            while (!AbstractC2809b.a(l(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }
}
