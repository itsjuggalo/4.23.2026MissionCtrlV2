package i2;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: i2.a4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1771a4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1771a4 f15494c = new C1771a4(null, null, 100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f15495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15496b;

    public C1771a4(Boolean bool, Boolean bool2, int i7) {
        EnumMap enumMap = new EnumMap(Z3.class);
        this.f15495a = enumMap;
        enumMap.put(Z3.AD_STORAGE, h(null));
        enumMap.put(Z3.ANALYTICS_STORAGE, h(null));
        this.f15496b = i7;
    }

    public static C1771a4 a(X3 x32, X3 x33, int i7) {
        EnumMap enumMap = new EnumMap(Z3.class);
        enumMap.put(Z3.AD_STORAGE, x32);
        enumMap.put(Z3.ANALYTICS_STORAGE, x33);
        return new C1771a4(enumMap, -10);
    }

    public static String d(int i7) {
        return i7 != -30 ? i7 != -20 ? i7 != -10 ? i7 != 0 ? i7 != 30 ? i7 != 90 ? i7 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static C1771a4 e(Bundle bundle, int i7) {
        if (bundle == null) {
            return new C1771a4(null, null, i7);
        }
        EnumMap enumMap = new EnumMap(Z3.class);
        for (Z3 z32 : Y3.STORAGE.b()) {
            enumMap.put(z32, g(bundle.getString(z32.f15480a)));
        }
        return new C1771a4(enumMap, i7);
    }

    public static C1771a4 f(String str, int i7) {
        EnumMap enumMap = new EnumMap(Z3.class);
        Z3[] z3ArrA = Y3.STORAGE.a();
        for (int i8 = 0; i8 < z3ArrA.length; i8++) {
            String str2 = str == null ? "" : str;
            Z3 z32 = z3ArrA[i8];
            int i9 = i8 + 2;
            if (i9 < str2.length()) {
                enumMap.put(z32, j(str2.charAt(i9)));
            } else {
                enumMap.put(z32, X3.UNINITIALIZED);
            }
        }
        return new C1771a4(enumMap, i7);
    }

    public static X3 g(String str) {
        return str == null ? X3.UNINITIALIZED : str.equals("granted") ? X3.GRANTED : str.equals("denied") ? X3.DENIED : X3.UNINITIALIZED;
    }

    public static X3 h(Boolean bool) {
        return bool == null ? X3.UNINITIALIZED : bool.booleanValue() ? X3.GRANTED : X3.DENIED;
    }

    public static String i(X3 x32) {
        int iOrdinal = x32.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public static X3 j(char c7) {
        return c7 != '+' ? c7 != '0' ? c7 != '1' ? X3.UNINITIALIZED : X3.GRANTED : X3.DENIED : X3.POLICY;
    }

    public static char m(X3 x32) {
        if (x32 == null) {
            return '-';
        }
        int iOrdinal = x32.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean u(int i7, int i8) {
        int i9 = -30;
        if (i7 == -20) {
            if (i8 == -30) {
                return true;
            }
            i7 = -20;
        }
        if (i7 != -30) {
            i9 = i7;
        } else if (i8 == -20) {
            return true;
        }
        return i9 == i8 || i7 < i8;
    }

    public final int b() {
        return this.f15496b;
    }

    public final boolean c() {
        Iterator it = this.f15495a.values().iterator();
        while (it.hasNext()) {
            if (((X3) it.next()) != X3.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1771a4)) {
            return false;
        }
        C1771a4 c1771a4 = (C1771a4) obj;
        for (Z3 z32 : Y3.STORAGE.b()) {
            if (this.f15495a.get(z32) != c1771a4.f15495a.get(z32)) {
                return false;
            }
        }
        return this.f15496b == c1771a4.f15496b;
    }

    public final int hashCode() {
        Iterator it = this.f15495a.values().iterator();
        int iHashCode = this.f15496b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((X3) it.next()).hashCode();
        }
        return iHashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            i2.Y3 r1 = i2.Y3.STORAGE
            i2.Z3[] r1 = r1.a()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L3a
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f15495a
            java.lang.Object r4 = r5.get(r4)
            i2.X3 r4 = (i2.X3) r4
            r5 = 45
            if (r4 == 0) goto L34
            int r4 = r4.ordinal()
            if (r4 == 0) goto L34
            r6 = 1
            if (r4 == r6) goto L32
            r6 = 2
            if (r4 == r6) goto L2f
            r6 = 3
            if (r4 == r6) goto L32
            goto L34
        L2f:
            r5 = 48
            goto L34
        L32:
            r5 = 49
        L34:
            r0.append(r5)
            int r3 = r3 + 1
            goto Lf
        L3a:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C1771a4.k():java.lang.String");
    }

    public final String l() {
        StringBuilder sb = new StringBuilder("G1");
        for (Z3 z32 : Y3.STORAGE.a()) {
            sb.append(m((X3) this.f15495a.get(z32)));
        }
        return sb.toString();
    }

    public final Bundle n() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f15495a.entrySet()) {
            String strI = i((X3) entry.getValue());
            if (strI != null) {
                bundle.putString(((Z3) entry.getKey()).f15480a, strI);
            }
        }
        return bundle;
    }

    public final boolean o(Z3 z32) {
        return ((X3) this.f15495a.get(z32)) != X3.DENIED;
    }

    public final X3 p() {
        X3 x32 = (X3) this.f15495a.get(Z3.AD_STORAGE);
        return x32 == null ? X3.UNINITIALIZED : x32;
    }

    public final X3 q() {
        X3 x32 = (X3) this.f15495a.get(Z3.ANALYTICS_STORAGE);
        return x32 == null ? X3.UNINITIALIZED : x32;
    }

    public final boolean r(C1771a4 c1771a4) {
        EnumMap enumMap = this.f15495a;
        for (Z3 z32 : (Z3[]) enumMap.keySet().toArray(new Z3[0])) {
            X3 x32 = (X3) enumMap.get(z32);
            X3 x33 = (X3) c1771a4.f15495a.get(z32);
            X3 x34 = X3.DENIED;
            if (x32 == x34 && x33 != x34) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i2.C1771a4 s(i2.C1771a4 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<i2.Z3> r1 = i2.Z3.class
            r0.<init>(r1)
            i2.Y3 r1 = i2.Y3.STORAGE
            i2.Z3[] r1 = r1.b()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L4a
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f15495a
            java.lang.Object r5 = r5.get(r4)
            i2.X3 r5 = (i2.X3) r5
            java.util.EnumMap r6 = r9.f15495a
            java.lang.Object r6 = r6.get(r4)
            i2.X3 r6 = (i2.X3) r6
            if (r5 != 0) goto L26
            goto L33
        L26:
            if (r6 == 0) goto L42
            i2.X3 r7 = i2.X3.UNINITIALIZED
            if (r5 != r7) goto L2d
            goto L33
        L2d:
            if (r6 == r7) goto L42
            i2.X3 r7 = i2.X3.POLICY
            if (r5 != r7) goto L35
        L33:
            r5 = r6
            goto L42
        L35:
            if (r6 == r7) goto L42
            i2.X3 r7 = i2.X3.DENIED
            if (r5 == r7) goto L41
            if (r6 != r7) goto L3e
            goto L41
        L3e:
            i2.X3 r5 = i2.X3.GRANTED
            goto L42
        L41:
            r5 = r7
        L42:
            if (r5 == 0) goto L47
            r0.put(r4, r5)
        L47:
            int r3 = r3 + 1
            goto Lf
        L4a:
            i2.a4 r9 = new i2.a4
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C1771a4.s(i2.a4):i2.a4");
    }

    public final C1771a4 t(C1771a4 c1771a4) {
        EnumMap enumMap = new EnumMap(Z3.class);
        for (Z3 z32 : Y3.STORAGE.b()) {
            X3 x32 = (X3) this.f15495a.get(z32);
            if (x32 == X3.UNINITIALIZED) {
                x32 = (X3) c1771a4.f15495a.get(z32);
            }
            if (x32 != null) {
                enumMap.put(z32, x32);
            }
        }
        return new C1771a4(enumMap, this.f15496b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(d(this.f15496b));
        for (Z3 z32 : Y3.STORAGE.b()) {
            sb.append(com.amazon.a.a.o.b.f.f9989a);
            sb.append(z32.f15480a);
            sb.append(com.amazon.a.a.o.b.f.f9990b);
            X3 x32 = (X3) this.f15495a.get(z32);
            if (x32 == null) {
                x32 = X3.UNINITIALIZED;
            }
            sb.append(x32);
        }
        return sb.toString();
    }

    public C1771a4(EnumMap enumMap, int i7) {
        EnumMap enumMap2 = new EnumMap(Z3.class);
        this.f15495a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f15496b = i7;
    }
}
