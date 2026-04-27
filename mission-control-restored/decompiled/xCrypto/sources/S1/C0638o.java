package S1;

import java.util.EnumMap;

/* JADX INFO: renamed from: S1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0638o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f4814a;

    public C0638o() {
        this.f4814a = new EnumMap(Z3.class);
    }

    public static C0638o d(String str) {
        EnumMap enumMap = new EnumMap(Z3.class);
        if (str.length() >= Z3.values().length) {
            int i4 = 0;
            if (str.charAt(0) == '1') {
                Z3[] z3ArrValues = Z3.values();
                int length = z3ArrValues.length;
                int i5 = 1;
                while (i4 < length) {
                    enumMap.put(z3ArrValues[i4], EnumC0630n.a(str.charAt(i5)));
                    i4++;
                    i5++;
                }
                return new C0638o(enumMap);
            }
        }
        return new C0638o();
    }

    public final EnumC0630n a(Z3 z32) {
        EnumC0630n enumC0630n = (EnumC0630n) this.f4814a.get(z32);
        return enumC0630n == null ? EnumC0630n.UNSET : enumC0630n;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(S1.Z3 r3, int r4) {
        /*
            r2 = this;
            S1.n r0 = S1.EnumC0630n.UNSET
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
            S1.n r0 = S1.EnumC0630n.INITIALIZATION
            goto L20
        L18:
            S1.n r0 = S1.EnumC0630n.MANIFEST
            goto L20
        L1b:
            S1.n r0 = S1.EnumC0630n.API
            goto L20
        L1e:
            S1.n r0 = S1.EnumC0630n.TCF
        L20:
            java.util.EnumMap r4 = r2.f4814a
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0638o.b(S1.Z3, int):void");
    }

    public final void c(Z3 z32, EnumC0630n enumC0630n) {
        this.f4814a.put(z32, enumC0630n);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (Z3 z32 : Z3.values()) {
            EnumC0630n enumC0630n = (EnumC0630n) this.f4814a.get(z32);
            if (enumC0630n == null) {
                enumC0630n = EnumC0630n.UNSET;
            }
            sb.append(enumC0630n.c());
        }
        return sb.toString();
    }

    public C0638o(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(Z3.class);
        this.f4814a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
