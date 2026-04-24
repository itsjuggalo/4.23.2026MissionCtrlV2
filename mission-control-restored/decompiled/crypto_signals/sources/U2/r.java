package U2;

import K2.J;
import K2.K;
import com.google.protobuf.AbstractC0472l;
import java.security.SecureRandom;
import java.util.Iterator;
import s3.D;
import u4.j0;
import u4.k0;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2.c f3169a;

    static {
        new SecureRandom();
        f3169a = new C2.c(13);
    }

    public static Object a(Iterator it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static int b(byte[] bArr, byte[] bArr2) {
        int iMin = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < iMin; i++) {
            int i6 = bArr[i] & 255;
            int i7 = bArr2[i] & 255;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
        }
        return Integer.compare(bArr.length, bArr2.length);
    }

    public static int c(AbstractC0472l abstractC0472l, AbstractC0472l abstractC0472l2) {
        int iMin = Math.min(abstractC0472l.size(), abstractC0472l2.size());
        for (int i = 0; i < iMin; i++) {
            int iC = abstractC0472l.c(i) & 255;
            int iC2 = abstractC0472l2.c(i) & 255;
            if (iC < iC2) {
                return -1;
            }
            if (iC > iC2) {
                return 1;
            }
        }
        return Integer.compare(abstractC0472l.size(), abstractC0472l2.size());
    }

    public static int d(double d4, long j4) {
        if (Double.isNaN(d4) || d4 < -9.223372036854776E18d) {
            return -1;
        }
        if (d4 >= 9.223372036854776E18d) {
            return 1;
        }
        int iCompare = Long.compare((long) d4, j4);
        return iCompare != 0 ? iCompare : D.J(d4, j4);
    }

    public static int e(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        int iMin = Math.min(str.length(), str2.length());
        for (int i = 0; i < iMin; i++) {
            char cCharAt = str.charAt(i);
            char cCharAt2 = str2.charAt(i);
            if (cCharAt != cCharAt2) {
                return Character.isSurrogate(cCharAt) == Character.isSurrogate(cCharAt2) ? Character.compare(cCharAt, cCharAt2) : Character.isSurrogate(cCharAt) ? 1 : -1;
            }
        }
        return Integer.compare(str.length(), str2.length());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(java.util.Iterator r6, java.util.Iterator r7, java.util.Comparator r8, U2.h r9, U2.h r10) {
        /*
            java.lang.Object r0 = a(r6)
            java.lang.Object r1 = a(r7)
        L8:
            if (r0 != 0) goto Le
            if (r1 == 0) goto Ld
            goto Le
        Ld:
            return
        Le:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L20
            if (r1 == 0) goto L20
            int r4 = r8.compare(r0, r1)
            if (r4 >= 0) goto L1b
            goto L26
        L1b:
            if (r4 <= 0) goto L1e
            goto L23
        L1e:
            r3 = r2
            goto L26
        L20:
            if (r0 == 0) goto L23
            goto L26
        L23:
            r5 = r3
            r3 = r2
            r2 = r5
        L26:
            if (r2 == 0) goto L30
            r9.accept(r1)
            java.lang.Object r1 = a(r7)
            goto L8
        L30:
            if (r3 == 0) goto L3a
            r10.accept(r0)
            java.lang.Object r0 = a(r6)
            goto L8
        L3a:
            java.lang.Object r0 = a(r6)
            java.lang.Object r1 = a(r7)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: U2.r.f(java.util.Iterator, java.util.Iterator, java.util.Comparator, U2.h, U2.h):void");
    }

    public static K g(j0 j0Var) {
        j0Var.getClass();
        k0 k0Var = new k0(j0Var);
        return new K(k0Var.getMessage(), (J) J.f849q.get(j0Var.f10446a.f10431a, J.UNKNOWN), k0Var);
    }

    public static StringBuilder h(int i, CharSequence charSequence, String str) {
        StringBuilder sb = new StringBuilder();
        if (i != 0) {
            sb.append(charSequence);
            for (int i6 = 1; i6 < i; i6++) {
                sb.append((CharSequence) str);
                sb.append(charSequence);
            }
        }
        return sb;
    }

    public static String i(AbstractC0472l abstractC0472l) {
        int size = abstractC0472l.size();
        StringBuilder sb = new StringBuilder(size * 2);
        for (int i = 0; i < size; i++) {
            byte bC = abstractC0472l.c(i);
            sb.append(Character.forDigit((bC & 255) >>> 4, 16));
            sb.append(Character.forDigit(bC & 15, 16));
        }
        return sb.toString();
    }
}
