package N1;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class J0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final J0 f1267c = new J0(100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f1268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1269b;

    public J0(int i) {
        EnumMap enumMap = new EnumMap(I0.class);
        this.f1268a = enumMap;
        I0 i02 = I0.AD_STORAGE;
        G0 g02 = G0.UNINITIALIZED;
        enumMap.put(i02, g02);
        enumMap.put(I0.ANALYTICS_STORAGE, g02);
        this.f1269b = i;
    }

    public static String a(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static J0 b(int i, Bundle bundle) {
        if (bundle == null) {
            return new J0(i);
        }
        EnumMap enumMap = new EnumMap(I0.class);
        for (I0 i02 : H0.STORAGE.f1257a) {
            enumMap.put(i02, d(bundle.getString(i02.f1263a)));
        }
        return new J0(enumMap, i);
    }

    public static J0 c(int i, String str) {
        EnumMap enumMap = new EnumMap(I0.class);
        H0 h02 = H0.STORAGE;
        int i6 = 0;
        while (true) {
            I0[] i0Arr = h02.f1257a;
            if (i6 >= i0Arr.length) {
                return new J0(enumMap, i);
            }
            String str2 = str == null ? "" : str;
            I0 i02 = i0Arr[i6];
            int i7 = i6 + 2;
            if (i7 < str2.length()) {
                enumMap.put(i02, e(str2.charAt(i7)));
            } else {
                enumMap.put(i02, G0.UNINITIALIZED);
            }
            i6++;
        }
    }

    public static G0 d(String str) {
        G0 g02 = G0.UNINITIALIZED;
        return str == null ? g02 : str.equals("granted") ? G0.GRANTED : str.equals("denied") ? G0.DENIED : g02;
    }

    public static G0 e(char c6) {
        return c6 != '+' ? c6 != '0' ? c6 != '1' ? G0.UNINITIALIZED : G0.GRANTED : G0.DENIED : G0.POLICY;
    }

    public static char h(G0 g02) {
        if (g02 == null) {
            return '-';
        }
        int iOrdinal = g02.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean l(int i, int i6) {
        int i7 = -30;
        if (i == -20) {
            if (i6 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i7 = i;
        } else if (i6 == -20) {
            return true;
        }
        return i7 == i6 || i < i6;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof J0)) {
            return false;
        }
        J0 j02 = (J0) obj;
        for (I0 i02 : H0.STORAGE.f1257a) {
            if (this.f1268a.get(i02) != j02.f1268a.get(i02)) {
                return false;
            }
        }
        return this.f1269b == j02.f1269b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            N1.H0 r1 = N1.H0.STORAGE
            N1.I0[] r1 = r1.f1257a
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L38
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f1268a
            java.lang.Object r4 = r5.get(r4)
            N1.G0 r4 = (N1.G0) r4
            r5 = 45
            if (r4 == 0) goto L32
            int r4 = r4.ordinal()
            if (r4 == 0) goto L32
            r6 = 1
            if (r4 == r6) goto L30
            r6 = 2
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L30
            goto L32
        L2d:
            r5 = 48
            goto L32
        L30:
            r5 = 49
        L32:
            r0.append(r5)
            int r3 = r3 + 1
            goto Ld
        L38:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.J0.f():java.lang.String");
    }

    public final String g() {
        StringBuilder sb = new StringBuilder("G1");
        for (I0 i02 : H0.STORAGE.f1257a) {
            sb.append(h((G0) this.f1268a.get(i02)));
        }
        return sb.toString();
    }

    public final int hashCode() {
        Iterator it = this.f1268a.values().iterator();
        int iHashCode = this.f1269b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((G0) it.next()).hashCode();
        }
        return iHashCode;
    }

    public final boolean i(I0 i02) {
        return ((G0) this.f1268a.get(i02)) != G0.DENIED;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N1.J0 j(N1.J0 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<N1.I0> r1 = N1.I0.class
            r0.<init>(r1)
            N1.H0 r1 = N1.H0.STORAGE
            N1.I0[] r1 = r1.f1257a
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L48
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f1268a
            java.lang.Object r5 = r5.get(r4)
            N1.G0 r5 = (N1.G0) r5
            java.util.EnumMap r6 = r9.f1268a
            java.lang.Object r6 = r6.get(r4)
            N1.G0 r6 = (N1.G0) r6
            if (r5 != 0) goto L24
            goto L31
        L24:
            if (r6 == 0) goto L40
            N1.G0 r7 = N1.G0.UNINITIALIZED
            if (r5 != r7) goto L2b
            goto L31
        L2b:
            if (r6 == r7) goto L40
            N1.G0 r7 = N1.G0.POLICY
            if (r5 != r7) goto L33
        L31:
            r5 = r6
            goto L40
        L33:
            if (r6 == r7) goto L40
            N1.G0 r7 = N1.G0.DENIED
            if (r5 == r7) goto L3f
            if (r6 != r7) goto L3c
            goto L3f
        L3c:
            N1.G0 r5 = N1.G0.GRANTED
            goto L40
        L3f:
            r5 = r7
        L40:
            if (r5 == 0) goto L45
            r0.put(r4, r5)
        L45:
            int r3 = r3 + 1
            goto Ld
        L48:
            N1.J0 r9 = new N1.J0
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.J0.j(N1.J0):N1.J0");
    }

    public final J0 k(J0 j02) {
        EnumMap enumMap = new EnumMap(I0.class);
        for (I0 i02 : H0.STORAGE.f1257a) {
            G0 g02 = (G0) this.f1268a.get(i02);
            if (g02 == G0.UNINITIALIZED) {
                g02 = (G0) j02.f1268a.get(i02);
            }
            if (g02 != null) {
                enumMap.put(i02, g02);
            }
        }
        return new J0(enumMap, this.f1269b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(a(this.f1269b));
        for (I0 i02 : H0.STORAGE.f1257a) {
            sb.append(",");
            sb.append(i02.f1263a);
            sb.append("=");
            G0 g02 = (G0) this.f1268a.get(i02);
            if (g02 == null) {
                g02 = G0.UNINITIALIZED;
            }
            sb.append(g02);
        }
        return sb.toString();
    }

    public J0(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(I0.class);
        this.f1268a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f1269b = i;
    }
}
