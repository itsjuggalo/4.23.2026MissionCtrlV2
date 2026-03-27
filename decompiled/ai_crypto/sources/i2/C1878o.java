package i2;

import java.util.EnumMap;

/* JADX INFO: renamed from: i2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1878o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f15973a;

    public C1878o() {
        this.f15973a = new EnumMap(Z3.class);
    }

    public static C1878o d(String str) {
        EnumMap enumMap = new EnumMap(Z3.class);
        if (str.length() >= Z3.values().length) {
            int i7 = 0;
            if (str.charAt(0) == '1') {
                Z3[] z3ArrValues = Z3.values();
                int length = z3ArrValues.length;
                int i8 = 1;
                while (i7 < length) {
                    enumMap.put(z3ArrValues[i7], EnumC1870n.a(str.charAt(i8)));
                    i7++;
                    i8++;
                }
                return new C1878o(enumMap);
            }
        }
        return new C1878o();
    }

    public final EnumC1870n a(Z3 z32) {
        EnumC1870n enumC1870n = (EnumC1870n) this.f15973a.get(z32);
        return enumC1870n == null ? EnumC1870n.UNSET : enumC1870n;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(i2.Z3 r3, int r4) {
        /*
            r2 = this;
            i2.n r0 = i2.EnumC1870n.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            i2.n r0 = i2.EnumC1870n.INITIALIZATION
            goto L20
        L18:
            i2.n r0 = i2.EnumC1870n.MANIFEST
            goto L20
        L1b:
            i2.n r0 = i2.EnumC1870n.API
            goto L20
        L1e:
            i2.n r0 = i2.EnumC1870n.TCF
        L20:
            java.util.EnumMap r4 = r2.f15973a
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C1878o.b(i2.Z3, int):void");
    }

    public final void c(Z3 z32, EnumC1870n enumC1870n) {
        this.f15973a.put(z32, enumC1870n);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (Z3 z32 : Z3.values()) {
            EnumC1870n enumC1870n = (EnumC1870n) this.f15973a.get(z32);
            if (enumC1870n == null) {
                enumC1870n = EnumC1870n.UNSET;
            }
            sb.append(enumC1870n.b());
        }
        return sb.toString();
    }

    public C1878o(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(Z3.class);
        this.f15973a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
