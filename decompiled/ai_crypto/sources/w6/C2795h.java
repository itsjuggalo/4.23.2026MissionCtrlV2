package w6;

import F5.AbstractC0551i;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: w6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2795h implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f25106d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2795h f25107e = new C2795h(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f25109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f25110c;

    /* JADX INFO: renamed from: w6.h$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final C2795h a(String str) {
            kotlin.jvm.internal.r.f(str, "<this>");
            byte[] bArrA = AbstractC2788a.a(str);
            if (bArrA != null) {
                return new C2795h(bArrA);
            }
            return null;
        }

        public final C2795h b(String str) {
            kotlin.jvm.internal.r.f(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = i7 * 2;
                bArr[i7] = (byte) ((x6.b.e(str.charAt(i8)) << 4) + x6.b.e(str.charAt(i8 + 1)));
            }
            return new C2795h(bArr);
        }

        public final C2795h c(String str) {
            kotlin.jvm.internal.r.f(str, "<this>");
            C2795h c2795h = new C2795h(c0.a(str));
            c2795h.E(str);
            return c2795h;
        }

        public final C2795h d(byte... data) {
            kotlin.jvm.internal.r.f(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, size)");
            return new C2795h(bArrCopyOf);
        }

        public a() {
        }
    }

    public C2795h(byte[] data) {
        kotlin.jvm.internal.r.f(data, "data");
        this.f25108a = data;
    }

    public static final C2795h A(byte... bArr) {
        return f25106d.d(bArr);
    }

    public static /* synthetic */ C2795h K(C2795h c2795h, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = AbstractC2789b.c();
        }
        return c2795h.J(i7, i8);
    }

    public static final C2795h c(String str) {
        return f25106d.a(str);
    }

    public static final C2795h h(String str) {
        return f25106d.b(str);
    }

    public static final C2795h j(String str) {
        return f25106d.c(str);
    }

    public static /* synthetic */ int t(C2795h c2795h, C2795h c2795h2, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return c2795h.r(c2795h2, i7);
    }

    public static /* synthetic */ int y(C2795h c2795h, C2795h c2795h2, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i8 & 2) != 0) {
            i7 = AbstractC2789b.c();
        }
        return c2795h.w(c2795h2, i7);
    }

    public boolean B(int i7, C2795h other, int i8, int i9) {
        kotlin.jvm.internal.r.f(other, "other");
        return other.C(i8, m(), i7, i9);
    }

    public boolean C(int i7, byte[] other, int i8, int i9) {
        kotlin.jvm.internal.r.f(other, "other");
        return i7 >= 0 && i7 <= m().length - i9 && i8 >= 0 && i8 <= other.length - i9 && AbstractC2789b.a(m(), i7, other, i8, i9);
    }

    public final void D(int i7) {
        this.f25109b = i7;
    }

    public final void E(String str) {
        this.f25110c = str;
    }

    public final C2795h F() {
        return i("SHA-1");
    }

    public final C2795h G() {
        return i("SHA-256");
    }

    public final int H() {
        return o();
    }

    public final boolean I(C2795h prefix) {
        kotlin.jvm.internal.r.f(prefix, "prefix");
        return B(0, prefix, 0, prefix.H());
    }

    public C2795h J(int i7, int i8) {
        int iD = AbstractC2789b.d(this, i8);
        if (i7 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (iD <= m().length) {
            if (iD - i7 >= 0) {
                return (i7 == 0 && iD == m().length) ? this : new C2795h(AbstractC0551i.h(m(), i7, iD));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + m().length + ')').toString());
    }

    public C2795h L() {
        for (int i7 = 0; i7 < m().length; i7++) {
            byte b7 = m()[i7];
            if (b7 >= 65 && b7 <= 90) {
                byte[] bArrM = m();
                byte[] bArrCopyOf = Arrays.copyOf(bArrM, bArrM.length);
                kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i7] = (byte) (b7 + 32);
                for (int i8 = i7 + 1; i8 < bArrCopyOf.length; i8++) {
                    byte b8 = bArrCopyOf[i8];
                    if (b8 >= 65 && b8 <= 90) {
                        bArrCopyOf[i8] = (byte) (b8 + 32);
                    }
                }
                return new C2795h(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] M() {
        byte[] bArrM = m();
        byte[] bArrCopyOf = Arrays.copyOf(bArrM, bArrM.length);
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String N() {
        String strP = p();
        if (strP != null) {
            return strP;
        }
        String strC = c0.c(u());
        E(strC);
        return strC;
    }

    public void O(C2792e buffer, int i7, int i8) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        x6.b.d(this, buffer, i7, i8);
    }

    public String a() {
        return AbstractC2788a.c(m(), null, 1, null);
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
    public int compareTo(w6.C2795h r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.r.f(r10, r0)
            int r0 = r9.H()
            int r1 = r10.H()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.l(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.l(r4)
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
        throw new UnsupportedOperationException("Method not decompiled: w6.C2795h.compareTo(w6.h):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2795h) {
            C2795h c2795h = (C2795h) obj;
            if (c2795h.H() == m().length && c2795h.C(0, m(), 0, m().length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iN = n();
        if (iN != 0) {
            return iN;
        }
        int iHashCode = Arrays.hashCode(m());
        D(iHashCode);
        return iHashCode;
    }

    public C2795h i(String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.r.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.f25108a, 0, H());
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.r.e(digestBytes, "digestBytes");
        return new C2795h(digestBytes);
    }

    public final boolean k(C2795h suffix) {
        kotlin.jvm.internal.r.f(suffix, "suffix");
        return B(H() - suffix.H(), suffix, 0, suffix.H());
    }

    public final byte l(int i7) {
        return v(i7);
    }

    public final byte[] m() {
        return this.f25108a;
    }

    public final int n() {
        return this.f25109b;
    }

    public int o() {
        return m().length;
    }

    public final String p() {
        return this.f25110c;
    }

    public String q() {
        char[] cArr = new char[m().length * 2];
        int i7 = 0;
        for (byte b7 : m()) {
            int i8 = i7 + 1;
            cArr[i7] = x6.b.f()[(b7 >> 4) & 15];
            i7 += 2;
            cArr[i8] = x6.b.f()[b7 & 15];
        }
        return Z5.t.m(cArr);
    }

    public final int r(C2795h other, int i7) {
        kotlin.jvm.internal.r.f(other, "other");
        return s(other.u(), i7);
    }

    public int s(byte[] other, int i7) {
        kotlin.jvm.internal.r.f(other, "other");
        int length = m().length - other.length;
        int iMax = Math.max(i7, 0);
        if (iMax <= length) {
            while (!AbstractC2789b.a(m(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    public String toString() {
        String str;
        if (m().length == 0) {
            str = "[size=0]";
        } else {
            int iC = x6.b.c(m(), 64);
            if (iC != -1) {
                String strN = N();
                String strSubstring = strN.substring(0, iC);
                kotlin.jvm.internal.r.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strW = Z5.t.w(Z5.t.w(Z5.t.w(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (iC >= strN.length()) {
                    return "[text=" + strW + ']';
                }
                return "[size=" + m().length + " text=" + strW + "…]";
            }
            if (m().length > 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(m().length);
                sb.append(" hex=");
                int iD = AbstractC2789b.d(this, 64);
                if (iD <= m().length) {
                    if (iD < 0) {
                        throw new IllegalArgumentException("endIndex < beginIndex");
                    }
                    sb.append((iD == m().length ? this : new C2795h(AbstractC0551i.h(m(), 0, iD))).q());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException(("endIndex > length(" + m().length + ')').toString());
            }
            str = "[hex=" + q() + ']';
        }
        return str;
    }

    public byte[] u() {
        return m();
    }

    public byte v(int i7) {
        return m()[i7];
    }

    public final int w(C2795h other, int i7) {
        kotlin.jvm.internal.r.f(other, "other");
        return x(other.u(), i7);
    }

    public int x(byte[] other, int i7) {
        kotlin.jvm.internal.r.f(other, "other");
        for (int iMin = Math.min(AbstractC2789b.d(this, i7), m().length - other.length); -1 < iMin; iMin--) {
            if (AbstractC2789b.a(m(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public final C2795h z() {
        return i("MD5");
    }
}
